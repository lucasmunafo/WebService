package com.gA.gaAcademy.lm.webservices.webServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gA.gaAcademy.lm.webservices.webServices.entity.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic,Integer>{

	
	
}
