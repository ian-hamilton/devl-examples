/**
 * 
 */
package com.inertia.solutions.cxf.ws.example.provision.main;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author ian
 *
 */
public class ContextLoaderTest {
	
    
	@Test
	public void testContextLoad(){
		GenericXmlApplicationContext springContext = new GenericXmlApplicationContext();
		//springContext.load("classpath:/WEB-INF/beans.xml");
        //GuidServiceImpl impl = (GuidServiceImpl) springContext.getBean("guidBean");
	}

}
