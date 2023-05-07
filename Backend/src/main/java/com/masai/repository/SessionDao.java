package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.CurrentUserSession;


public interface SessionDao extends JpaRepository<CurrentUserSession, Long> {

	
	public  CurrentUserSession  findByUuid(String uuid);
}
