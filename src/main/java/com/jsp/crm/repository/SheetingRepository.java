package com.jsp.crm.repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jsp.crm.model.Sheeting;

public interface SheetingRepository extends JpaRepository<Sheeting, Long>{

	List<Sheeting> findByDate(LocalDate date);


	Sheeting findByRouteCardNo(String routeCardNo);

}
