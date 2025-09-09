package com.jsp.crm.repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jsp.crm.model.Packing;
import com.jsp.crm.model.Planning;

public interface PackingRepository extends JpaRepository<Packing, Long>{

	List<Packing> findByDate(LocalDate now);

	Packing  findByRouteCardNo(String routeCardNo);
}
