package com.gA.gaAcademy.lm.webservices.webServices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gA.gaAcademy.lm.webservices.webServices.entity.Reply;
import com.gA.gaAcademy.lm.webservices.webServices.entity.Topic;

@Repository
public interface ReplyRepository extends JpaRepository<Reply,Integer>{

	Topic findByTitle (String title);

	Optional<Topic> findByTopic(Topic topic);
	
}
