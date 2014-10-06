/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softenido.cafecore.text;

import com.softenido.cafecore.util.ArrayUtils;
import com.softenido.cafecore.util.Arrays6;
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
public class MorseCodeConverterTest
{
    
    public MorseCodeConverterTest()
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

    @Test
    public void testSomeMethod()
    {
        long[] e = new long[]{0, 100, 0};
        long[] ee = new long[]{0, 100, 300, 100, 0};
        long[] sos= new long[]{ 0, 100, 100, 100, 100, 100, 300, 300, 100, 300, 100, 300, 300, 100, 100, 100, 100, 100, 0 };
        long[] hw = new long[]{ 0, 100, 100, 100, 100, 100, 100, 100, 300, 100, 300, 100, 100, 300, 100, 100, 100, 100, 300, 100, 100, 300, 100, 100, 100, 100, 300, 300, 100, 300, 100, 300, 700, 100, 100, 300, 100, 300, 300, 300, 100, 300, 100, 300, 300, 100, 100, 300, 100, 100, 300, 100, 100, 300, 100, 100, 100, 100, 300, 300, 100, 100, 100, 100, 0 };
        long[] v  = new long[]{ 0, 100, 100, 300, 300, 100, 300, 100, 100, 100, 300, 300, 100, 300, 100, 300, 300, 100, 100, 100, 100, 300, 0 };
        long[] abc= new long[]{ 0, 100, 100, 300, 300, 300, 100, 100, 100, 100, 100, 100, 300, 300, 100, 100, 100, 300, 100, 100, 700, 300, 100, 100, 100, 100, 100, 300, 300, 300, 100, 100, 100, 300, 100, 300, 300, 300, 100, 300, 100, 100, 100, 100, 700, 100, 100, 300, 100, 300, 100, 100, 300, 300, 100, 300, 100, 100, 100, 300, 700, 300, 100, 300, 300, 300, 100, 100, 700, 300, 100, 300, 100, 300, 100, 300, 100, 300, 300, 100, 100, 300, 100, 300, 100, 300, 100, 300, 300, 100, 100, 100, 100, 300, 100, 300, 100, 300, 300, 100, 100, 100, 100, 100, 100, 300, 100, 300, 300, 100, 100, 100, 100, 100, 100, 100, 100, 300, 300, 100, 100, 100, 100, 100, 100, 100, 100, 100, 300, 300, 100, 100, 100, 100, 100, 100, 100, 100, 300, 300, 100, 300, 100, 100, 100, 100, 100, 100, 300, 300, 100, 300, 100, 300, 100, 100, 100, 100, 300, 300, 100, 300, 100, 300, 100, 300, 100, 100, 300, 100, 100, 300, 100, 100, 100, 300, 100, 100, 100, 300, 0 };
                
        assertArrayEquals(e, MorseCodeConverter.pattern("e"));
        assertArrayEquals(ee, MorseCodeConverter.pattern("EE"));
        assertArrayEquals(sos, MorseCodeConverter.pattern("SOS"));
        assertArrayEquals(hw, MorseCodeConverter.pattern("hello world"));
        assertArrayEquals(v, MorseCodeConverter.pattern("aeiou"));
        assertArrayEquals(abc, MorseCodeConverter.pattern("abc xyz pq mn 0123456789."));
    }
}
