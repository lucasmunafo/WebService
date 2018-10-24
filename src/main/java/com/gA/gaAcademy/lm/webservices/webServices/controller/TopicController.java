package com.gA.gaAcademy.lm.webservices.webServices.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gA.gaAcademy.lm.webservices.webServices.entity.Reply;
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
	
	
	@GetMapping("/topic/{id}")
	public Optional<Topic> getTopics(@PathVariable int id) {
		return topicService.getTopics(id);
		
	} 
	
	@GetMapping("/topic")
	public List<Topic> getTopic(){
		return topicService.getTopic();
	}
	
	@PostMapping("/topic/{id}/reply")
	public Reply createReply(@PathVariable int id,@RequestBody Reply inputReply) {
		return topicService.createReply(id,inputReply);
		
	}
	
	
}
