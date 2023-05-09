package com.masai.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.CurrentUserSession;

@Repository
public interface SessionDao extends JpaRepository<CurrentUserSession, Long> {

	
	public  CurrentUserSession  findByUuid(String uuid);
}
