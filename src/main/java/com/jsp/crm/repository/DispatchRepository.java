package com.jsp.crm.repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.crm.model.Dispatch;
import com.jsp.crm.model.Mixing;



public interface DispatchRepository extends JpaRepository<Dispatch, Long>{

	List<Dispatch> findByDate(LocalDate now);

	Dispatch findByRouteCardNo(String routeCardNo);
	
}
