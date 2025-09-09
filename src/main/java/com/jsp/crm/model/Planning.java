package com.jsp.crm.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Planning {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
    private String plannedQty;
    private String routeCardNo;
    private String processedQty;
    private String size;
    private String okQty;
    private String notOkQty;
    private String processedBy;
    private String remarks;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPlannedQty() {
		return plannedQty;
	}
	public void setPlannedQty(String plannedQty) {
		this.plannedQty = plannedQty;
	}
	public String getRouteCardNo() {
		return routeCardNo;
	}
	public void setRouteCardNo(String routeCardNo) {
		this.routeCardNo = routeCardNo;
	}
	public String getProcessedQty() {
		return processedQty;
	}
	public void setProcessedQty(String processedQty) {
		this.processedQty = processedQty;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getOkQty() {
		return okQty;
	}
	public void setOkQty(String okQty) {
		this.okQty = okQty;
	}
	public String getNotOkQty() {
		return notOkQty;
	}
	public void setNotOkQty(String notOkQty) {
		this.notOkQty = notOkQty;
	}
	public String getProcessedBy() {
		return processedBy;
	}
	public void setProcessedBy(String processedBy) {
		this.processedBy = processedBy;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	  
	}


