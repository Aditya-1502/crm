package com.jsp.crm.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Jointing {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	   
		private String batchNo;
	    private String batchWeight;
	    private String routeCardNo;
	    private String balanceWeight;

	    private String productionPerHour;
	    private String weightPerMeter;
	    private String toolDieNo;
	    private String noOfCavity;
	    private String setupTime;           // previously might have been different
	    private String clampPressure;
	    private String cycleTime;
	    private String curingTemp;

	    private String viewDrawing;         // used to store image URL/path

	    private Date date;
	    private String joiningStartTime;
	    private String joiningEndTime;
	    private String plannedQuantity;
	    private String processedQuantity;
	    private String okQuantity;
	    private String notOkQuantity;
	    private String operatorName;
	    private String joiningRemarks;

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
		public String getRouteCardNo() {
			return routeCardNo;
		}
		public void setRouteCardNo(String routeCardNo) {
			this.routeCardNo = routeCardNo;
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
		public String getWeightPerMeter() {
			return weightPerMeter;
		}
		public void setWeightPerMeter(String weightPerMeter) {
			this.weightPerMeter = weightPerMeter;
		}
		public String getToolDieNo() {
			return toolDieNo;
		}
		public void setToolDieNo(String toolDieNo) {
			this.toolDieNo = toolDieNo;
		}
		public String getNoOfCavity() {
			return noOfCavity;
		}
		public void setNoOfCavity(String noOfCavity) {
			this.noOfCavity = noOfCavity;
		}
		public String getSetupTime() {
			return setupTime;
		}
		public void setSetupTime(String setupTime) {
			this.setupTime = setupTime;
		}
		public String getClampPressure() {
			return clampPressure;
		}
		public void setClampPressure(String clampPressure) {
			this.clampPressure = clampPressure;
		}
		public String getCycleTime() {
			return cycleTime;
		}
		public void setCycleTime(String cycleTime) {
			this.cycleTime = cycleTime;
		}
		public String getCuringTemp() {
			return curingTemp;
		}
		public void setCuringTemp(String curingTemp) {
			this.curingTemp = curingTemp;
		}
		public String getViewDrawing() {
			return viewDrawing;
		}
		public void setViewDrawing(String viewDrawing) {
			this.viewDrawing = viewDrawing;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public String getJoiningStartTime() {
			return joiningStartTime;
		}
		public void setJoiningStartTime(String joiningStartTime) {
			this.joiningStartTime = joiningStartTime;
		}
		public String getJoiningEndTime() {
			return joiningEndTime;
		}
		public void setJoiningEndTime(String joiningEndTime) {
			this.joiningEndTime = joiningEndTime;
		}
		public String getPlannedQuantity() {
			return plannedQuantity;
		}
		public void setPlannedQuantity(String plannedQuantity) {
			this.plannedQuantity = plannedQuantity;
		}
		public String getProcessedQuantity() {
			return processedQuantity;
		}
		public void setProcessedQuantity(String processedQuantity) {
			this.processedQuantity = processedQuantity;
		}
		public String getOkQuantity() {
			return okQuantity;
		}
		public void setOkQuantity(String okQuantity) {
			this.okQuantity = okQuantity;
		}
		public String getNotOkQuantity() {
			return notOkQuantity;
		}
		public void setNotOkQuantity(String notOkQuantity) {
			this.notOkQuantity = notOkQuantity;
		}
		public String getOperatorName() {
			return operatorName;
		}
		public void setOperatorName(String operatorName) {
			this.operatorName = operatorName;
		}
		public String getJoiningRemarks() {
			return joiningRemarks;
		}
		public void setJoiningRemarks(String joiningRemarks) {
			this.joiningRemarks = joiningRemarks;
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