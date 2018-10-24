package com.gA.gaAcademy.lm.webservices.webServices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gA.gaAcademy.lm.webservices.webServices.entity.Reply;
import com.gA.gaAcademy.lm.webservices.webServices.entity.Topic;
import com.gA.gaAcademy.lm.webservices.webServices.repository.ReplyRepository;
import com.gA.gaAcademy.lm.webservices.webServices.repository.TopicRepository;

@Service
public class TopicService {

	
	@Autowired
	TopicRepository topicRepository;
	@Autowired
	ReplyRepository replyRepository;
	
	public Topic createTopic(Topic inputTopic) {
		Topic t = topicRepository.save(inputTopic);
		return t;
	}
	
	
	public Optional<Topic> getTopics(int id) {
		return topicRepository.findById(id);
	}
	
	
	
	public List<Topic> getTopic(){
		List<Topic> t = topicRepository.findAll();
		return t;
	}


	public Reply createReply(int id,Reply inputReply) {
		Optional<Topic> t = topicRepository.findById(id);
		Reply r = replyRepository.save(inputReply);
		return null;
	}
	

}
