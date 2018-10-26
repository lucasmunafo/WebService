package com.gA.gaAcademy.lm.webservices.webServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@DeleteMapping("/topic/{id}")
	public ResponseEntity<?> deleteFisicTopic(@PathVariable int id) {
		int idTopicABorrar = topicService.deleteFisicTopic(id);
		String a ="El topic: " + idTopicABorrar + " fue borrado exitosamente";
		return new ResponseEntity<String>(a, HttpStatus.OK);
	}
	
	@DeleteMapping("/topic/logic/{id}")
	public ResponseEntity<?> deleteLogicTopic(@PathVariable int id) {
		int fueBorrado = topicService.deleteLogicTopic(id);
		if(fueBorrado>0) {
			String a ="El topic ID: " + fueBorrado + " fue borrado exitosamente";
			return new ResponseEntity<String>(a, HttpStatus.OK);
		}
		String b ="El topic ID: " + fueBorrado + " no se pudo eliminar";
		return new ResponseEntity<String>(b, HttpStatus.OK);
		
	}
	
	
	
}
