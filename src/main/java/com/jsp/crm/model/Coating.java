package com.jsp.crm.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String batchNo;
    private Long batchWeight;
    private String routeCardNo;
    private Long balanceWeight;

    private Long productionPerHour;
    private Long weightPerMeter;
    private String toolDieNo;
    private Long noOfCavity;
    private String setupTime; // renamed from `time`
    private Long clampPressure;
    private Long cycleTime;
    private Long curingTemp;

    private String viewDrawing; // This is used for image path (optional)

    private Date date;
    private String coatingStartTime;
    private String coatingEndTime;
    private Long planned_qty;
    private Long processed_qty;
    private Long ok_qty;
    private Long not_ok_qty;
    private String operator_name;
    private String coating_remarks;

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
	public Long getBatchWeight() {
		return batchWeight;
	}
	public void setBatchWeight(Long batchWeight) {
		this.batchWeight = batchWeight;
	}
	public String getRouteCardNo() {
		return routeCardNo;
	}
	public void setRouteCardNo(String routeCardNo) {
		this.routeCardNo = routeCardNo;
	}
	public Long getBalanceWeight() {
		return balanceWeight;
	}
	public void setBalanceWeight(Long balanceWeight) {
		this.balanceWeight = balanceWeight;
	}
	public Long getProductionPerHour() {
		return productionPerHour;
	}
	public void setProductionPerHour(Long productionPerHour) {
		this.productionPerHour = productionPerHour;
	}
	public Long getWeightPerMeter() {
		return weightPerMeter;
	}
	public void setWeightPerMeter(Long weightPerMeter) {
		this.weightPerMeter = weightPerMeter;
	}
	public String getToolDieNo() {
		return toolDieNo;
	}
	public void setToolDieNo(String toolDieNo) {
		this.toolDieNo = toolDieNo;
	}
	public Long getNoOfCavity() {
		return noOfCavity;
	}
	public void setNoOfCavity(Long noOfCavity) {
		this.noOfCavity = noOfCavity;
	}
	public String getSetupTime() {
		return setupTime;
	}
	public void setSetupTime(String setupTime) {
		this.setupTime = setupTime;
	}
	public Long getClampPressure() {
		return clampPressure;
	}
	public void setClampPressure(Long clampPressure) {
		this.clampPressure = clampPressure;
	}
	public Long getCycleTime() {
		return cycleTime;
	}
	public void setCycleTime(Long cycleTime) {
		this.cycleTime = cycleTime;
	}
	public Long getCuringTemp() {
		return curingTemp;
	}
	public void setCuringTemp(Long curingTemp) {
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
	public String getCoatingStartTime() {
		return coatingStartTime;
	}
	public void setCoatingStartTime(String coatingStartTime) {
		this.coatingStartTime = coatingStartTime;
	}
	public String getCoatingEndTime() {
		return coatingEndTime;
	}
	public void setCoatingEndTime(String coatingEndTime) {
		this.coatingEndTime = coatingEndTime;
	}
	public Long getPlanned_qty() {
		return planned_qty;
	}
	public void setPlanned_qty(Long planned_qty) {
		this.planned_qty = planned_qty;
	}
	public Long getProcessed_qty() {
		return processed_qty;
	}
	public void setProcessed_qty(Long processed_qty) {
		this.processed_qty = processed_qty;
	}
	public Long getOk_qty() {
		return ok_qty;
	}
	public void setOk_qty(Long ok_qty) {
		this.ok_qty = ok_qty;
	}
	public Long getNot_ok_qty() {
		return not_ok_qty;
	}
	public void setNot_ok_qty(Long not_ok_qty) {
		this.not_ok_qty = not_ok_qty;
	}
	public String getOperator_name() {
		return operator_name;
	}
	public void setOperator_name(String operator_name) {
		this.operator_name = operator_name;
	}
	public String getCoating_remarks() {
		return coating_remarks;
	}
	public void setCoating_remarks(String coating_remarks) {
		this.coating_remarks = coating_remarks;
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

