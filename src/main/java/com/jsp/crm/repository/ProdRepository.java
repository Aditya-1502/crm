package com.jsp.crm.repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.crm.model.Order;
import com.jsp.crm.model.Production;
import com.jsp.crm.model.Search;


public interface ProdRepository extends JpaRepository<Production, Long>,JpaSpecificationExecutor<Production>{

	List<Production> findByDate(LocalDate now);

	
	
	Production findByRouteCardNo(String routeCardNo);

}
