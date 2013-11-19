package com.inertia.solutions.scheduling.task.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.inertia.solutions.scheduling.task.FixedScheduler;

@Component("fixedRateSchedulerImpl")
public class FixedRateSchedulerImpl implements FixedScheduler {
	private final static Logger log = Logger.getLogger(FixedRateSchedulerImpl.class);	

	@Override
	@Scheduled(initialDelay=2000, fixedRate=2000)
	public void runSchedule() {
		log.info("Fixed Rate 2 Second Schedule Execution: " + new Date());
	}

}
