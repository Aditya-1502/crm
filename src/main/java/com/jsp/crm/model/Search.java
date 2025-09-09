package com.jsp.crm.model;

import java.sql.Date;
import java.time.LocalDate;

public class Search {
	private String routeCardNo;
    private LocalDate date;
    private String componentName;
    private String customerNo;
    private String customerName;
    private String enquiryNo;
    private String quotationNo;
    private String purchaseOrder;
    private String formulationNo;
    private String workOrderNo;
    private String toolDieNo;
    public String getRouteCardNo() {
		return routeCardNo;
	}
	public void setRouteCardNo(String routeCardNo) {
		this.routeCardNo = routeCardNo;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEnquiryNo() {
		return enquiryNo;
	}
	public void setEnquiryNo(String enquiryNo) {
		this.enquiryNo = enquiryNo;
	}
	public String getQuotationNo() {
		return quotationNo;
	}
	public void setQuotationNo(String quotationNo) {
		this.quotationNo = quotationNo;
	}
	public String getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(String purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	public String getFormulationNo() {
		return formulationNo;
	}
	public void setFormulationNo(String formulationNo) {
		this.formulationNo = formulationNo;
	}
	public String getWorkOrderNo() {
		return workOrderNo;
	}
	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}
	public String getToolDieNo() {
		return toolDieNo;
	}
	public void setToolDieNo(String toolDieNo) {
		this.toolDieNo = toolDieNo;
	}
	public String getResponsiblePerson() {
		return responsiblePerson;
	}
	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}
	public String getToolMaker() {
		return toolMaker;
	}
	public void setToolMaker(String toolMaker) {
		this.toolMaker = toolMaker;
	}
	private String responsiblePerson;
    private String toolMaker;  
}
