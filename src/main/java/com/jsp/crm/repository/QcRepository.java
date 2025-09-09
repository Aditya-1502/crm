package com.jsp.crm.repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jsp.crm.model.QcSupervisor;

public interface QcRepository extends JpaRepository<QcSupervisor, Long>{

	List<QcSupervisor> findByDate(LocalDate now);

	QcSupervisor findByRouteCardNo(String routeCardNo);
}
