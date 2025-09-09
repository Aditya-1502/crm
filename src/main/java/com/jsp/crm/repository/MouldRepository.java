package com.jsp.crm.repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jsp.crm.model.Moulding;
import com.jsp.crm.model.Production;

public interface MouldRepository  extends JpaRepository<Moulding, Long>{

	List<Moulding> findByDate(LocalDate now);

	Moulding findByRouteCardNo(String routeCardNo);

}
