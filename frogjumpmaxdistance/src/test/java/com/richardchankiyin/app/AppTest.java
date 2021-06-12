package com.richardchankiyin.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void checkMovingDirection()
    {
        App app = new App();
        int[] arr = new int[]{1,3,3,2};
        assertTrue(1 == app.checkMovingDirection(arr, 0));
        assertTrue(1 == app.checkMovingDirection(arr, 1));
        assertTrue(0 == app.checkMovingDirection(arr, 2));
        assertTrue(-1 == app.checkMovingDirection(arr, 3));
        assertTrue(-1 == app.checkMovingDirection(arr, 4));
    }
    
    @Test
    public void checkPeaks() {
    	App app = new App();
        assertTrue((8-1) == app.calculateDiffBtwTwoPeaks(new Peak(1,2), new Peak(5,8), 10));
        assertTrue((10-1) == app.calculateDiffBtwTwoPeaks(new Peak(1,2), null, 10));
        assertTrue((8-0) == app.calculateDiffBtwTwoPeaks(null, new Peak(5,8), 10));
    }
    
    @Test
    public void testSolutions() {
    	App app = new App();
    	assertTrue(1==app.solution(new int[]{1,1}));
    	assertTrue(3==app.solution(new int[]{1,5,5,2,6}));
    	assertTrue(4==app.solution(new int[]{10,9,6,7,8}));
    	assertTrue(4==app.solution(new int[]{10,10,10,10,10}));
    }
}
