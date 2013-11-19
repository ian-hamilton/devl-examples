package com.inertia.solutions.scheduling.task.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.inertia.solutions.scheduling.task.FixedScheduler;

@Component("configurationBasedScheduler")
public class ConfigurationBasedSchedulerImpl implements FixedScheduler {
	private static final Logger log = Logger.getLogger(ConfigurationBasedSchedulerImpl.class);
	
	@Override
	public void runSchedule() {
		log.info("Configuration Schedule 15 seconds Execution: " + new Date());
	}

}
