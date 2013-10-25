package com.inertia.solutions.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan({"com.inertia.solutions.spring.aop"})
@EnableAspectJAutoProxy
public class SpringConfiguration {

}
