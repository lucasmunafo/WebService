package com.gA.gaAcademy.lm.webservices.webServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public Topic getTopicById(@PathVariable int id) {
		return topicService.getTopicById(id);
		
	} 
	
	@GetMapping("/topic")
	public List<Topic> getTopic(){
		return topicService.getTopic();
	}
	
	@PostMapping("/topic/{id}/reply")
	public Reply createReply(@PathVariable int id,@RequestBody Reply inputReply) {
		return topicService.createReply(id,inputReply);
	}
	
	@PutMapping("/topic/{id}")
	public Topic editTopic(@PathVariable int id, @RequestBody Topic updatedTopic) {
		return topicService.updateTopic(id,updatedTopic);
	}
	
	
	
}
