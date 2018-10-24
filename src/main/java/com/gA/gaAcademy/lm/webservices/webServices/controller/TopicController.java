package com.gA.gaAcademy.lm.webservices.webServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gA.gaAcademy.lm.webservices.webServices.entity.Topic;
import com.gA.gaAcademy.lm.webservices.webServices.service.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	TopicService topicService;

	@PostMapping("/topic")
	public Topic createTopic(@RequestBody Topic inputTopic) {
		Topic returnTopic = topicService.createTopic(inputTopic);
		return returnTopic;
	}
	
	
	@GetMapping("/topic")
	public Topic getTopic(@RequestParam int id) {
		Topic returnTopic = topicService.getTopic(id);
		return returnTopic;
	} 
	
}
