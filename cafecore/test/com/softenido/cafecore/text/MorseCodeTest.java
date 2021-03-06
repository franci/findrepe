/*
 * MorseCodeTest.java
 *
 * Copyright (c) 2013  Francisco Gómez Carrasco
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Report bugs or new features to: flikxxi@gmail.com
 */
package com.softenido.cafecore.text;

import com.softenido.cafecore.util.ArrayUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author franci
 */
public class MorseCodeTest
{
    
    public MorseCodeTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of _pattern method, of class MorseCode.
     */
    @Test
    public void test_pattern_String()
    {
        long[] e = {0, 100, 0};
        long[] ee = {0, 100, 300, 100, 0};
        long[] sos= { 0, 100, 100, 100, 100, 100, 300, 300, 100, 300, 100, 300, 300, 100, 100, 100, 100, 100, 0 };
        long[] hw = { 0, 100, 100, 100, 100, 100, 100, 100, 300, 100, 300, 100, 100, 300, 100, 100, 100, 100, 300, 100, 100, 300, 100, 100, 100, 100, 300, 300, 100, 300, 100, 300, 700, 100, 100, 300, 100, 300, 300, 300, 100, 300, 100, 300, 300, 100, 100, 300, 100, 100, 300, 100, 100, 300, 100, 100, 100, 100, 300, 300, 100, 100, 100, 100, 0 };
        long[] v  = { 0, 100, 100, 300, 300, 100, 300, 100, 100, 100, 300, 300, 100, 300, 100, 300, 300, 100, 100, 100, 100, 300, 0 };
        long[] abc= { 0, 100, 100, 300, 300, 300, 100, 100, 100, 100, 100, 100, 300, 300, 100, 100, 100, 300, 100, 100, 700, 300, 100, 100, 100, 100, 100, 300, 300, 300, 100, 100, 100, 300, 100, 300, 300, 300, 100, 300, 100, 100, 100, 100, 700, 100, 100, 300, 100, 300, 100, 100, 300, 300, 100, 300, 100, 100, 100, 300, 700, 300, 100, 300, 300, 300, 100, 100, 700, 300, 100, 300, 100, 300, 100, 300, 100, 300, 300, 100, 100, 300, 100, 300, 100, 300, 100, 300, 300, 100, 100, 100, 100, 300, 100, 300, 100, 300, 300, 100, 100, 100, 100, 100, 100, 300, 100, 300, 300, 100, 100, 100, 100, 100, 100, 100, 100, 300, 300, 100, 100, 100, 100, 100, 100, 100, 100, 100, 300, 300, 100, 100, 100, 100, 100, 100, 100, 100, 300, 300, 100, 300, 100, 100, 100, 100, 100, 100, 300, 300, 100, 300, 100, 300, 100, 100, 100, 100, 300, 300, 100, 300, 100, 300, 100, 300, 100, 100, 300, 100, 100, 300, 100, 100, 100, 300, 100, 100, 100, 300, 0 };
        long[] txt= { 0, 100, 100, 300, 300, 100, 300, 100, 100, 100, 300, 300, 100, 300, 100, 300, 300, 100, 100, 100, 100, 300, 700, 100, 100, 300, 300, 300, 100, 100, 100, 100, 100, 100, 300, 300, 100, 100, 100, 300, 100, 100, 300, 300, 100, 100, 100, 100, 300, 100, 300, 100, 100, 100, 100, 300, 100, 100, 300, 300, 100, 300, 100, 100, 300, 100, 100, 100, 100, 100, 100, 100, 300, 100, 100, 100, 300, 100, 100, 300, 100, 300, 100, 300, 300, 300, 100, 100, 100, 300, 300, 100, 100, 300, 100, 100, 100, 100, 300, 300, 100, 300, 300, 300, 100, 100, 300, 300, 100, 300, 100, 300, 300, 100, 100, 300, 100, 300, 100, 100, 300, 300, 100, 300, 100, 100, 100, 300, 300, 100, 100, 300, 100, 100, 300, 100, 100, 100, 100, 100, 300, 300, 300, 100, 100, 100, 100, 300, 300, 100, 100, 100, 100, 100, 100, 300, 300, 100, 100, 300, 100, 300, 300, 300, 100, 100, 100, 100, 100, 300, 300, 300, 100, 100, 100, 300, 100, 300, 300, 300, 100, 300, 100, 100, 100, 100, 700, 300, 100, 300, 100, 300, 100, 300, 100, 300, 300, 100, 100, 300, 100, 300, 100, 300, 100, 300, 300, 100, 100, 100, 100, 300, 100, 300, 100, 300, 300, 100, 100, 100, 100, 100, 100, 300, 100, 300, 300, 100, 100, 100, 100, 100, 100, 100, 100, 300, 300, 100, 100, 100, 100, 100, 100, 100, 100, 100, 300, 300, 100, 100, 100, 100, 100, 100, 100, 100, 300, 300, 100, 300, 100, 100, 100, 100, 100, 100, 300, 300, 100, 300, 100, 300, 100, 100, 100, 100, 300, 300, 100, 300, 100, 300, 100, 300, 100, 100, 700, 100, 100, 300, 100, 300, 100, 300, 100, 300, 700, 100, 100, 100, 100, 300, 100, 300, 100, 300, 300, 100, 100, 100, 100, 300, 100, 300, 100, 300, 700, 100, 100, 100, 100, 100, 100, 300, 100, 300, 300, 100, 100, 100, 100, 100, 100, 300, 100, 300, 300, 100, 100, 100, 100, 100, 100, 300, 100, 300, 700, 100, 100, 100, 100, 100, 100, 100, 100, 300, 300, 100, 100, 100, 100, 100, 100, 100, 100, 300, 300, 100, 100, 100, 100, 100, 100, 100, 100, 300, 300, 100, 100, 100, 100, 100, 100, 100, 100, 300, 700, 100, 100, 100, 100, 100, 100, 100, 100, 100, 300, 100, 100, 100, 100, 100, 100, 100, 100, 100, 300, 100, 100, 100, 100, 100, 100, 100, 100, 100, 300, 100, 100, 100, 100, 100, 100, 100, 100, 100, 300, 100, 100, 100, 100, 100, 100, 100, 100, 100, 700, 300, 100, 100, 100, 100, 100, 100, 100, 100, 300, 300, 100, 100, 100, 100, 100, 100, 100, 100, 300, 300, 100, 100, 100, 100, 100, 100, 100, 100, 300, 300, 100, 100, 100, 100, 100, 100, 100, 100, 300, 300, 100, 100, 100, 100, 100, 100, 100, 100, 300, 300, 100, 100, 100, 100, 100, 100, 100, 100, 700, 300, 100, 300, 100, 100, 100, 100, 100, 100, 300, 300, 100, 300, 100, 100, 100, 100, 100, 100, 300, 300, 100, 300, 100, 100, 100, 100, 100, 100, 300, 300, 100, 300, 100, 100, 100, 100, 100, 100, 300, 300, 100, 300, 100, 100, 100, 100, 100, 100, 300, 300, 100, 300, 100, 100, 100, 100, 100, 100, 300, 300, 100, 300, 100, 100, 100, 100, 100, 100, 700, 300, 100, 300, 100, 300, 100, 100, 100, 100, 300, 300, 100, 300, 100, 300, 100, 100, 100, 100, 300, 300, 100, 300, 100, 300, 100, 100, 100, 100, 300, 300, 100, 300, 100, 300, 100, 100, 100, 100, 300, 300, 100, 300, 100, 300, 100, 100, 100, 100, 300, 300, 100, 300, 100, 300, 100, 100, 100, 100, 300, 300, 100, 300, 100, 300, 100, 100, 100, 100, 300, 300, 100, 300, 100, 300, 100, 100, 100, 100, 700, 300, 100, 300, 100, 300, 100, 300, 100, 100, 300, 300, 100, 300, 100, 300, 100, 300, 100, 100, 300, 300, 100, 300, 100, 300, 100, 300, 100, 100, 300, 300, 100, 300, 100, 300, 100, 300, 100, 100, 300, 300, 100, 300, 100, 300, 100, 300, 100, 100, 300, 300, 100, 300, 100, 300, 100, 300, 100, 100, 300, 300, 100, 300, 100, 300, 100, 300, 100, 100, 300, 300, 100, 300, 100, 300, 100, 300, 100, 100, 300, 300, 100, 300, 100, 300, 100, 300, 100, 100, 0 };
        
        
        
        MorseCode mc = new MorseCode();
        
        assertArrayEquals(e, mc.pattern("e"));
        assertArrayEquals(ee, mc.pattern("EE"));
        assertArrayEquals(sos, mc.pattern("SOS"));
        assertArrayEquals(hw, mc.pattern("hello world"));
        assertArrayEquals(v, mc.pattern("aeiou"));
        assertArrayEquals(abc, mc.pattern("abc xyz pq mn 0123456789."));
        assertArrayEquals(txt, mc.pattern("aeiou abcdefghijklmnopqrstuvwxyz 0123456789 1 22 333 4444 55555 666666 7777777 88888888 999999999"));
        

        assertArrayEquals(e, mc.encode("e"));
        assertArrayEquals(ee, mc.encode("EE"));
        assertArrayEquals(sos, mc.encode("SOS"));
        assertArrayEquals(hw, mc.encode("hello world"));
        assertArrayEquals(v, mc.encode("aeiou"));
        assertArrayEquals(abc, mc.encode("abc xyz pq mn 0123456789."));
        assertArrayEquals(txt, mc.encode("aeiou abcdefghijklmnopqrstuvwxyz 0123456789 1 22 333 4444 55555 666666 7777777 88888888 999999999"));
        
    }
}
