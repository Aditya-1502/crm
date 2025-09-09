package com.jsp.crm.repository;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.crm.model.Coating;
import com.jsp.crm.model.Order;


public interface CoatingRepository extends JpaRepository<Coating, Long>{

	List<Coating> findByDate(LocalDate now);

	


	Coating findByRouteCardNo(String routeCardNo);
}
