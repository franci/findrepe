/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softenido.cafecore.profile;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;


/*              
 *                   -------------
 *       +---------->| unlocked  |
 *       |           -------------
 *       |                 |
 *       |                 v
 *       |           -------------
 *       |     +---->|  locking  |
 *       |     |     -------------
 *       |     |           |<------------------+
 *       |     |           v                   | 
 *       |     |     -------------      -------------
 *       |     +-----|  locked   |----->|  waiting  |
 *       |           -------------      -------------
 *       |                 |  
 *       |                 v  
 *       |           -------------
 *       |           | unlocking |
 *       |           -------------
 *       |                 |
 *       +-----------------+
 * 
 */
class NullDebugLock extends DebugLock
{
    @Override
    public boolean locking(Object object)
    {
        return true;
    }

    @Override
    public boolean locked(Object object)
    {
        return true;
    }

    @Override
    public boolean waiting(Object object)
    {
        return true;
    }

    @Override
    public boolean unlocking(Object object)
    {
        return true;
    }

    @Override
    public boolean unlocked(Object object)
    {
        return true;
    }
}

class RealDebugLock extends DebugLock
{
    static final int ST_UNLOCKED=0;
    static final int ST_LOCKING=1;
    static final int ST_LOCKED=2;
    static final int ST_WAITING=3;
    static final int ST_UNLOCKING=4;
    static final int MAX_STACK_ITEMS = 4;

    static enum Status
    {
        UNLOCKED(ST_UNLOCKED), LOCKING(ST_LOCKING), LOCKED(ST_LOCKED), WAITING(ST_WAITING), UNLOCKING(ST_UNLOCKING);
        final int value;
        private Status(int value)
        {
            this.value = value;
        }
        static final String[] NAMES={"UNLOCKED", "LOCKING", "LOCKED", "WAITING", "UNLOCKING"};    
        @Override
        public String toString()
        {
            return NAMES[value];
        }
    }

    static final boolean[][] ALLOWED= //[from][to]
    {   
        //  UNLOCKED,   LOCKING,    LOCKED,     WAITING,    UNLOCKING,  
        {   false,      true,       false,      false,      false},  //UNLOCKED
        {   false,      false,      true,       false,      false},  //LOCKING
        {   false,      true,       false,      true,       true},   //LOCKED
        {   false,      false,      true,       false,      false},  //WAITING
        {   true,       false,      true,       false,      false},  //UNLOCKING
    };
    static boolean verifySequence(Status from, Status to)
    {
        return ALLOWED[from.value][to.value];
    }
    
    static class Key
    {
        final Thread thread;
        final Object object;
        public Key(Thread thread, Object object)
        {
            this.thread = thread;
            this.object = object;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (!object.equals(key.object)) return false;
            if (!thread.equals(key.thread)) return false;

            return true;
        }

        @Override
        public int hashCode()
        {
            int result = thread.hashCode();
            result = 31 * result + object.hashCode();
            return result;
        }
    }
    static class Data
    {
        final Status status;
        final int level;
        final long time;
        final StackTraceElement[] stack;

        public Data(Status status)
        {
            this.status = status;
            this.level  = 0;
            this.time = System.nanoTime();
            this.stack = (status==Status.LOCKING||status==Status.LOCKED)?new Exception().getStackTrace():null;
        }
        public Data(Status status, Data old)
        {
            switch(status)
            {
                case LOCKING:
                    this.level  = old.level+1;
                    this.status = status;
                    break;
                case UNLOCKED:
                    this.level  = old.level-1;
                    this.status = (this.level==0)?Status.UNLOCKED:Status.LOCKED;
                    break;
                default:
                    this.level  = old.level;
                    this.status = status;
                    break;
            }
            this.time = System.nanoTime();
            this.stack = (status==Status.LOCKING||status==Status.LOCKED)?new Exception().getStackTrace():null;
            if(this.level<0)
            {
                Logger.getLogger(DebugLock.class.getName()).log(Level.SEVERE,"level<0");
            }
        }
    }

    static final Data DATA_UNLOCKED = new Data(Status.UNLOCKED);
    
    private final Object lock = new Object();

    private final HashMap<Key,Data> locks = new HashMap<Key,Data>();
    
    private Key getKey(Object object)
    {
        return new Key(Thread.currentThread(), object);
    }
    private Data getData(Key k)
    {
        Data data = locks.get(k);
        return data!=null?data:DATA_UNLOCKED;
    }
    private boolean goStatus(Object object, Status status)
    {
        synchronized(lock)
        {
            boolean ret=true;
            Key k = getKey(object);
            Data old = getData(k);
            Data cur = new Data(status,old);

            if(!verifySequence(old.status,cur.status))
            {
                printall(object, "Wrong status sequence "+old.status+">>"+status);
                ret=false;
            }
            else if(!verifyTimeOut(old,cur))
            {
                printall(object, "Too much time locking "+((cur.time-old.time)/1000000)+"ms");
            }

            verifyTimeOut(old, cur);

            if(cur.status==Status.UNLOCKED && cur.level==0)
            {
                locks.remove(k);
            }
            else
            {
                locks.put(k,cur);
            }
            return ret;
        }
    }
    final static long MAX_TIME = 24680L*1000000L;//24680ms
    private boolean verifyTimeOut(Data old, Data cur)
    {
        if(old.status==Status.LOCKING&&cur.status==Status.LOCKED)
        {
            long dif = (cur.time-old.time);
            return (dif<=RealDebugLock.MAX_TIME);
        }
        return true;
    }

    public final boolean locking(Object object)
    {
        return goStatus(object, Status.LOCKING);
    }
    public final boolean locked(Object object)
    {
        return goStatus(object, Status.LOCKED);
    }
    public final boolean waiting(Object object)
    {
        return goStatus(object, Status.WAITING);
    }
    public final boolean unlocking(Object object)
    {
        return goStatus(object, Status.UNLOCKING);
    }
    public final boolean unlocked(Object object)
    {
        return goStatus(object, Status.UNLOCKED);
    }
    
    private void printall(Object object, String msg)
    {
        int i=0;
        StringBuilder sb = new StringBuilder(msg).append("\n");
        for(Entry<Key,Data> item : locks.entrySet())
        {
            Key k = item.getKey();
            Data d = item.getValue();

            if(k.object!=object)
                continue;

            sb.append("[").append(++i).append("]")
              .append("thread=").append(k.thread).append(" ")
              .append("object=").append(k.object).append(" ")
              .append("status=").append(d.status).append(" ")
              .append("level=").append(d.level).append("\n");
            if(d.stack!=null)
            {
                String tcn = this.getClass().getName();
                sb.append("stack=\n");
                int n=0;
                for(StackTraceElement s:d.stack)
                {
                    String scn=s.getClassName();
                    if(n>MAX_STACK_ITEMS||scn.contains(tcn))
                        continue;
                    sb.append(s).append("\n");
                    n++;
                }
            }
        }


        // pintar sólo aquellos que intervengan en el objeto bloqueado
        //

        Logger.getLogger(DebugLock.class.getName()).log(Level.SEVERE, sb.toString());
    }
}

/**
 *
 * @author franci
 */
public abstract class DebugLock
{
    public abstract boolean locking(Object object);
    public abstract boolean locked(Object object);
    public abstract boolean waiting(Object object);
    public abstract boolean unlocking(Object object);
    public abstract boolean unlocked(Object object);
    
    static volatile boolean debug=false;
    public static void setDebug(boolean debug)
    {
        DebugLock.debug = debug;
    }
    
    final static DebugLock nullInstance = new NullDebugLock();
    final static DebugLock realInstance = new RealDebugLock();
    public static DebugLock getInstance()
    {
        return debug?realInstance:nullInstance;
    }
    
}
