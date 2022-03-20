package com.h2soft.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
//@RunWith 스프링 테스트 를 하기 위해 
//@ContextConfiguration 의존성 주입된 정보 경로 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {
	
	@Setter(onMethod_ = @Autowired)
	private Restaurant restaurant;
	
	@Test
	public void testExit() {
		
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("=====================");
		log.info(restaurant.getChef());
	}
	
}
