package com.inertia.solutions.scheduling.task.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.inertia.solutions.scheduling.task.FixedScheduler;

@Component("cronSchedulerImpl")
public class CronSchedulerImpl implements FixedScheduler {
	private static final Logger log = Logger.getLogger(CronSchedulerImpl.class);
	
	@Override
	@Scheduled(cron="*/5 * * * * *")
	public void runSchedule() {
		log.info("Cron Schedule 5 seconds Execution: " + new Date());
	}

}
