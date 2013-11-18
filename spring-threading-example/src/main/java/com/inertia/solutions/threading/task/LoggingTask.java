package com.inertia.solutions.threading.task;

import java.util.concurrent.Future;

import com.inertia.solutions.threading.bean.ThreadResultBean;


public interface LoggingTask {

	Future<ThreadResultBean> executeLogging(Integer threadCount) throws InterruptedException;
	
}
