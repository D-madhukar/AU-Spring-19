package com.accolite.bowlingproblem;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by : Madhukar Domakonda
 * Unit test for simple App.
 */
public class TestApp{
	@Test
	public void testForNoScore() {
		assertEquals(0, App.getBowlingScore(new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
	}
	@Test
	public void testForAllTens() {
		assertEquals(300, App.getBowlingScore(new int[] {10,10,10,10,10,10,10,10,10,10,10,10}));
	}
	@Test(expected=PointsException.class)
	public void testForInvalidPoints() {
		App.getBowlingScore(new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,-1,-1});
	}
	@Test(expected=PointsException.class)
	public void testForMinInputs() {
		App.getBowlingScore(new int[] {1,2,3,4});
	}
	@Test
	public void testForLastFrameWithoutStrike() {
		assertEquals(41, App.getBowlingScore(new int[] {0,0,0,1,0,0,0,6,10,0,5,0,0,0,3,5,0,6,0}));
	}
}
