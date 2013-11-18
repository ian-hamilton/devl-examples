package com.inertia.solutions.threading;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@ComponentScan({"com.inertia.solutions.threading"})
@EnableAsync
public class SpringConfiguration {
	
	@Bean(name="executor")
	public ThreadPoolTaskExecutor createTaskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(5);
		taskExecutor.setMaxPoolSize(10);
		taskExecutor.setQueueCapacity(25);
		taskExecutor.setAwaitTerminationSeconds(30);
		return taskExecutor;
	}

}
