package com.inertia.solutions.threading.random.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class SleepRandomizerImplTest {

	SleepRandomizerImpl randomizerUnderTest = new SleepRandomizerImpl();
	
	@Test
	public void testRandomizer() throws Exception {
		Long result = randomizerUnderTest.randomize();
		assertTrue(result < 10000);
		assertTrue(result > 1000);
	}

}
