package in.nic.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import in.nic.demo.services.BasicServices;

@Controller
public class BasicControllers {

	@Autowired
	private BasicServices basicServices;

	@PostMapping("/addData")
	@ResponseBody
	public String addData(@RequestBody String rawData) {
		return basicServices.addData(rawData);
	}

	
	@GetMapping("/processData")
	@ResponseBody
	public String processData() throws JsonMappingException, JsonProcessingException {
		return basicServices.processData();
	}
	
}
