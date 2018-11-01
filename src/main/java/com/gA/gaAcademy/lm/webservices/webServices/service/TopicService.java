package com.gA.gaAcademy.lm.webservices.webServices.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

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
	
	
	public Topic getTopicById(int id) {
		return topicRepository.findById(id).get();
	}
	
	
	
	public List<Topic> getTopic(){
		List<Topic> t = topicRepository.findAll();
		return t;
	}

//REPLY
	
	
	
	public Reply createReply(int id,Reply inputReply) {
		//Topic t = getTopicById(id);
		//int idForReply = t.getId();
		//inputReply.setParentId(idForReply);
		//t.addReply(inputReply);
		inputReply.setDatePost(new Date());
		return replyRepository.save(inputReply);	
	}
	public List<Reply> getReplies(int id){
		return topicRepository.findById(id).get().getReplyList();
	}
	
	public Topic getReplys(int id) throws NoSuchElementException{
		return replyRepository.findByTopic(topicRepository.findById(id).get()).get();
	}

	public void deleteAllReplies(int id) {
		Topic t = topicRepository.findById(id).get();
		t.deleteListOfReplies();
		topicRepository.save(t);
	}
	
	public Reply updateReplyById(int id, Reply reply) throws NoSuchElementException{
		Reply toUpdate = replyRepository.findById(id).get();
		if(reply.getDescription()!= null) {
			toUpdate.setDescription(reply.getDescription());
		}
		replyRepository.save(toUpdate);
		return toUpdate;
	}

	public Topic updateTopic(int id, Topic updatedTopic) {
		Topic oldTopic =  getTopicById(id);
		if(updatedTopic.getAuthor()>0)
			oldTopic.setAuthor(updatedTopic.getAuthor());
		if(updatedTopic.getTitle()!=null) 
			oldTopic.setTitle(updatedTopic.getTitle());
		if(updatedTopic.getDescription()!=null)
			oldTopic.setDescription(updatedTopic.getDescription());
		return createTopic(oldTopic);
	}


	public int deleteFisicTopic(int id) {
		topicRepository.deleteById(id);
		return id;
	}


	public int deleteLogicTopic(int id) {
		int toReturn = 0;
		Topic t = topicRepository.findById(id).get();
		if (!t.isDeleted()) {
			t.delete();
			toReturn = t.getId();
			topicRepository.save(t);
		}
			return toReturn;
	}
	

}
