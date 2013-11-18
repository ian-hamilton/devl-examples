package com.inertia.solutions.threading.task.impl;

import java.util.Date;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import com.inertia.solutions.threading.bean.ThreadResultBean;
import com.inertia.solutions.threading.random.SleepRandomizer;
import com.inertia.solutions.threading.task.LoggingTask;

@Component
public class ThreadingTaskImpl implements LoggingTask {
	private static final Logger log = Logger.getLogger(ThreadingTaskImpl.class);

	@Autowired
	SleepRandomizer sleepRandomizer;
	
	@Override
	@Async
	public Future<ThreadResultBean> executeLogging(Integer taskCount) throws InterruptedException {		
		ThreadResultBean bean = new ThreadResultBean();
		bean.setDateBeforeExecution(new Date());
		bean.setTaskCountId(taskCount);
		bean.setThreadId(Thread.currentThread().getId());	
		bean.setSleepTime(sleepRandomizer.randomize());
		log.info("Before Execution: " + bean.toString());
		
		Thread.sleep(bean.getSleepTime());
		
		bean.setDateAfterExecution(new Date());
		return new AsyncResult<ThreadResultBean>(bean);
	}


}
