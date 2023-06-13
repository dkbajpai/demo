package in.nic.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import in.nic.demo.services.BasicServices;

@Configuration
@EnableScheduling
public class SpringConfig {

	@Autowired
	private BasicServices basicServices;

	@Scheduled(fixedDelay = 5000)
	public void scheduleFixedDelayTask() throws JsonMappingException, JsonProcessingException {
		System.out.println("Fixed delay task - " + System.currentTimeMillis() / 1000);
		basicServices.processData();
	}
}
