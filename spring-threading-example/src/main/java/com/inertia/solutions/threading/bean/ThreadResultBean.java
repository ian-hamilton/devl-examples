package com.inertia.solutions.threading.bean;

import java.util.Date;

public class ThreadResultBean {

	private Integer taskCountId;
	
	private Long threadId;
	
	private Date dateBeforeExecution;
	
	private Date dateAfterExecution;
	
	private Long sleepTime;

	public Integer getTaskCountId() {
		return taskCountId;
	}

	public void setTaskCountId(Integer taskCountId) {
		this.taskCountId = taskCountId;
	}

	public Long getThreadId() {
		return threadId;
	}

	public void setThreadId(Long threadId) {
		this.threadId = threadId;
	}

	public Date getDateBeforeExecution() {
		return dateBeforeExecution;
	}

	public void setDateBeforeExecution(Date dateBeforeExecution) {
		this.dateBeforeExecution = dateBeforeExecution;
	}

	public Date getDateAfterExecution() {
		return dateAfterExecution;
	}

	public void setDateAfterExecution(Date dateAfterExecution) {
		this.dateAfterExecution = dateAfterExecution;
	}

	public Long getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(Long sleepTime) {
		this.sleepTime = sleepTime;
	}

	@Override
	public String toString() {
		return "ThreadResultBean [taskCountId=" + taskCountId + ", threadId="
				+ threadId + ", dateBeforeExecution=" + dateBeforeExecution
				+ ", dateAfterExecution=" + dateAfterExecution + ", sleepTime="
				+ sleepTime + "]";
	}
	
}
