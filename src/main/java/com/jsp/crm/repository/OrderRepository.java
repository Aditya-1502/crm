package com.jsp.crm.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.crm.model.Order;
import com.jsp.crm.model.Search;

public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findByDate(LocalDate now);
	
	@Query("SELECT o FROM Order o WHERE " +
		       "(:#{#dto.routeCardNo} IS NULL OR o.routeCardNo LIKE %:#{#dto.routeCardNo}%) AND " +
		       "(:#{#dto.customerNo} IS NULL OR o.customerNo LIKE %:#{#dto.customerNo}%) AND " +
		       "(:#{#dto.customerName} IS NULL OR o.customerName LIKE %:#{#dto.customerName}%) AND " +
		       "(:#{#dto.componentName} IS NULL OR o.componentName LIKE %:#{#dto.componentName}%) AND " +
		       "(:#{#dto.enquiryNo} IS NULL OR o.enquiryNo LIKE %:#{#dto.enquiryNo}%) AND " +
		       "(:#{#dto.quotationNo} IS NULL OR o.quotationNo LIKE %:#{#dto.quotationNo}%) AND " +
		       "(:#{#dto.purchaseOrder} IS NULL OR o.purchaseOrder LIKE %:#{#dto.purchaseOrder}%) AND " +
		       "(:#{#dto.formulationNo} IS NULL OR o.formulationNo LIKE %:#{#dto.formulationNo}%) AND " +
		       "(:#{#dto.workOrderNo} IS NULL OR o.workOrderNo LIKE %:#{#dto.workOrderNo}%) AND " +
		       "(:#{#dto.toolDieNo} IS NULL OR o.toolDieNo LIKE %:#{#dto.toolDieNo}%) AND " +
		       "(:#{#dto.responsiblePerson} IS NULL OR o.responsiblePerson LIKE %:#{#dto.responsiblePerson}%) AND " +
		       "(:#{#dto.toolMaker} IS NULL OR o.toolMaker LIKE %:#{#dto.toolMaker}%)")
		List<Order> searchOrders(@Param("dto") Search dto);

	
	Order findByRouteCardNo(String routeCardNo);

	Order findTopByOrderByIdDesc();

	

	

}
