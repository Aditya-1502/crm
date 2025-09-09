package com.jsp.crm.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class QcSupervisor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

	  
	private String componentName;
	private String routeCardNo;
	private String formulationNo;
	private String orderDate;
	private String machine;
	private String method;
	private String material;
	private String workOrderNo;
	
	private String toolDieNo;

	private String batchNo;
	private String batchWeight;

	private String extruderRPM;
	private String dcOvenTemp;
	private String weightPerMeter;
	private String productionPerHour;
	private String conveyorRPM;
	private String setupToolDieNo;
	private String noOfCavity;

	private Date date;
	private String methodStartTime;
	private String methodEndTime;
	private String plannedQty;
	private String processedQty;
	private String okQty;
	private String notOkQty;
	private String operatorName;

	private String postReceivedQty;
	private String postProcessedQty;
	private String postTemperature;
	private String postStartTime;
	private String postEndTime;
	private String postDuration;
	private String postRemarks;

	public String getPostRemarks() {
		return postRemarks;
	}

	public void setPostRemarks(String postRemarks) {
		this.postRemarks = postRemarks;
	}

	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getRouteCardNo() {
		return routeCardNo;
	}

	public void setRouteCardNo(String routeCardNo) {
		this.routeCardNo = routeCardNo;
	}

	public String getFormulationNo() {
		return formulationNo;
	}

	public void setFormulationNo(String formulationNo) {
		this.formulationNo = formulationNo;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getMachine() {
		return machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
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

	public String getExtruderRPM() {
		return extruderRPM;
	}

	public void setExtruderRPM(String extruderRPM) {
		this.extruderRPM = extruderRPM;
	}

	public String getDcOvenTemp() {
		return dcOvenTemp;
	}

	public void setDcOvenTemp(String dcOvenTemp) {
		this.dcOvenTemp = dcOvenTemp;
	}

	public String getWeightPerMeter() {
		return weightPerMeter;
	}

	public void setWeightPerMeter(String weightPerMeter) {
		this.weightPerMeter = weightPerMeter;
	}

	public String getProductionPerHour() {
		return productionPerHour;
	}

	public void setProductionPerHour(String productionPerHour) {
		this.productionPerHour = productionPerHour;
	}

	public String getConveyorRPM() {
		return conveyorRPM;
	}

	public void setConveyorRPM(String conveyorRPM) {
		this.conveyorRPM = conveyorRPM;
	}

	public String getSetupToolDieNo() {
		return setupToolDieNo;
	}

	public void setSetupToolDieNo(String setupToolDieNo) {
		this.setupToolDieNo = setupToolDieNo;
	}

	public String getNoOfCavity() {
		return noOfCavity;
	}

	public void setNoOfCavity(String noOfCavity) {
		this.noOfCavity = noOfCavity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMethodStartTime() {
		return methodStartTime;
	}

	public void setMethodStartTime(String methodStartTime) {
		this.methodStartTime = methodStartTime;
	}

	public String getMethodEndTime() {
		return methodEndTime;
	}

	public void setMethodEndTime(String methodEndTime) {
		this.methodEndTime = methodEndTime;
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

	public String getPostReceivedQty() {
		return postReceivedQty;
	}

	public void setPostReceivedQty(String postReceivedQty) {
		this.postReceivedQty = postReceivedQty;
	}

	public String getPostProcessedQty() {
		return postProcessedQty;
	}

	public void setPostProcessedQty(String postProcessedQty) {
		this.postProcessedQty = postProcessedQty;
	}

	public String getPostTemperature() {
		return postTemperature;
	}

	public void setPostTemperature(String postTemperature) {
		this.postTemperature = postTemperature;
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

	public String getPostDuration() {
		return postDuration;
	}

	public void setPostDuration(String postDuration) {
		this.postDuration = postDuration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	    
	}


