package com.jsp.crm.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Sheeting {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	    
		private String routeCardNo;
	    private String batchNo;
	    private String batchWeight;
	    private String balanceWeight;

	    private String productionPerHour;
	    private String setupTime;
	    private String toolDieNo;
	    private String curingTemp;

	    private Date date;
	    private String sheetingStartTime;
	    private String sheetingEndTime;
	    private String plannedQty;
	    private String processedQty;
	    private String okQty;
	    private String notOkQty;
	    private String operatorName;
	    private String sheetingRemark;

	    private String receivedQty;
	    private String postProcessedQty;
	    private String temperature;
	    private String postStartTime;
	    private String postEndTime;
	    private String duration;
	    private String postRemarks;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getRouteCardNo() {
			return routeCardNo;
		}
		public void setRouteCardNo(String routeCardNo) {
			this.routeCardNo = routeCardNo;
		}
		public String getBatchNo() {
			return batchNo;
		}
		public void setBatchNo(String batchNo) {
			this.batchNo = batchNo;
		}
		public String getBatchWeight() {
			return batchWeight;
		}
		public void setBatchWeight(String batchWeight) {
			this.batchWeight = batchWeight;
		}
		public String getBalanceWeight() {
			return balanceWeight;
		}
		public void setBalanceWeight(String balanceWeight) {
			this.balanceWeight = balanceWeight;
		}
		public String getProductionPerHour() {
			return productionPerHour;
		}
		public void setProductionPerHour(String productionPerHour) {
			this.productionPerHour = productionPerHour;
		}
		public String getSetupTime() {
			return setupTime;
		}
		public void setSetupTime(String setupTime) {
			this.setupTime = setupTime;
		}
		public String getToolDieNo() {
			return toolDieNo;
		}
		public void setToolDieNo(String toolDieNo) {
			this.toolDieNo = toolDieNo;
		}
		public String getCuringTemp() {
			return curingTemp;
		}
		public void setCuringTemp(String curingTemp) {
			this.curingTemp = curingTemp;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public String getSheetingStartTime() {
			return sheetingStartTime;
		}
		public void setSheetingStartTime(String sheetingStartTime) {
			this.sheetingStartTime = sheetingStartTime;
		}
		public String getSheetingEndTime() {
			return sheetingEndTime;
		}
		public void setSheetingEndTime(String sheetingEndTime) {
			this.sheetingEndTime = sheetingEndTime;
		}
		public String getPlannedQty() {
			return plannedQty;
		}
		public void setPlannedQty(String plannedQty) {
			this.plannedQty = plannedQty;
		}
		public String getProcessedQty() {
			return processedQty;
		}
		public void setProcessedQty(String processedQty) {
			this.processedQty = processedQty;
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
		public String getOperatorName() {
			return operatorName;
		}
		public void setOperatorName(String operatorName) {
			this.operatorName = operatorName;
		}
		public String getSheetingRemark() {
			return sheetingRemark;
		}
		public void setSheetingRemark(String sheetingRemark) {
			this.sheetingRemark = sheetingRemark;
		}
		public String getReceivedQty() {
			return receivedQty;
		}
		public void setReceivedQty(String receivedQty) {
			this.receivedQty = receivedQty;
		}
		public String getPostProcessedQty() {
			return postProcessedQty;
		}
		public void setPostProcessedQty(String postProcessedQty) {
			this.postProcessedQty = postProcessedQty;
		}
		public String getTemperature() {
			return temperature;
		}
		public void setTemperature(String temperature) {
			this.temperature = temperature;
		}
		public String getPostStartTime() {
			return postStartTime;
		}
		public void setPostStartTime(String postStartTime) {
			this.postStartTime = postStartTime;
		}
		public String getPostEndTime() {
			return postEndTime;
		}
		public void setPostEndTime(String postEndTime) {
			this.postEndTime = postEndTime;
		}
		public String getDuration() {
			return duration;
		}
		public void setDuration(String duration) {
			this.duration = duration;
		}
		public String getPostRemarks() {
			return postRemarks;
		}
		public void setPostRemarks(String postRemarks) {
			this.postRemarks = postRemarks;
		}
	 
	}


