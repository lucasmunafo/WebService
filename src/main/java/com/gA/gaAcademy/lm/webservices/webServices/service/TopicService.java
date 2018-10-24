package com.gA.gaAcademy.lm.webservices.webServices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gA.gaAcademy.lm.webservices.webServices.entity.Topic;
import com.gA.gaAcademy.lm.webservices.webServices.repository.TopicRepository;

@Service
public class TopicService {

	
	@Autowired
	TopicRepository topicRepository;
	
	public Topic createTopic(Topic inputTopic) {
		Topic t = topicRepository.save(inputTopic);
		return t;
	}
	
	
	public Topic getTopic(int id) {
		Topic t = topicRepository.getOne(id);
		return t;
	}
	
	
	

}
