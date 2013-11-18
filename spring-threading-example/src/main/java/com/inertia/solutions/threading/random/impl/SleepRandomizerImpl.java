package com.inertia.solutions.threading.random.impl;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.inertia.solutions.threading.random.SleepRandomizer;

@Component
public class SleepRandomizerImpl implements SleepRandomizer {

	private static final Integer MIN = new Integer(1000);
	private static final Integer MAX = new Integer(10000);
	
	@Override
	public Long randomize() {
		Random random = new Random();
		return new Long(random.nextInt((MAX-MIN) + 1) + MIN);
	}

}
