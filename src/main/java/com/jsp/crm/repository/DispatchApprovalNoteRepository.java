package com.jsp.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.crm.model.DispatchApprovalNote;
import com.jsp.crm.model.Mixing;

public interface DispatchApprovalNoteRepository extends JpaRepository<DispatchApprovalNote, Integer> {

	
	DispatchApprovalNote findByRouteCardNo(String routeCardNo);
}
