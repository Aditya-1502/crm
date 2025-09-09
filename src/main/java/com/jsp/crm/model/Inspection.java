package com.jsp.crm.model;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Inspection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	
	private Date date;
    private String routeCardNo;
    private String receivedQty;
    private String inspectionQty;
    private String notOkQty;
    private String okQty;
    private String reportNo;
    private String inspectedBy;
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
	public String getRouteCardNo() {
		return routeCardNo;
	}
	public void setRouteCardNo(String routeCardNo) {
		this.routeCardNo = routeCardNo;
	}
	public String getReceivedQty() {
		return receivedQty;
	}
	public void setReceivedQty(String receivedQty) {
		this.receivedQty = receivedQty;
	}
	public String getInspectionQty() {
		return inspectionQty;
	}
	public void setInspectionQty(String inspectionQty) {
		this.inspectionQty = inspectionQty;
	}
	public String getNotOkQty() {
		return notOkQty;
	}
	public void setNotOkQty(String notOkQty) {
		this.notOkQty = notOkQty;
	}
	public String getOkQty() {
		return okQty;
	}
	public void setOkQty(String okQty) {
		this.okQty = okQty;
	}
	public String getReportNo() {
		return reportNo;
	}
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}
	public String getInspectedBy() {
		return inspectedBy;
	}
	public void setInspectedBy(String inspectedBy) {
		this.inspectedBy = inspectedBy;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
