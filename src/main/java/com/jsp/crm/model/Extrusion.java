package com.jsp.crm.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Extrusion {

	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String routeCardNo;

		private Date date;
		private String componentName;
		private String customerNo;
		private String method;
		private String enquiryNo;
		private String material;
		private String quotationNo;
		private String toolDieNo;

		private String batchNo;
		private String batchWeight;
		private String balanceWeight;

		private String extruderRPM;
		private String dcOvenTemp;
		private String weightPerMeter;
		private String productionPerHour;
		private String conveyorRPM;
		private String setupToolDieNo;
		private String noOfCavity;
		private String time;
		private String clampPressure;
		private String cycleTime;
		private String curingTemp;
		private String machine;

		private Date extrusionDate;
		private String startTime;
		private String endTime;
		private String plannedQty;
		private String processedQty;
		private String okQty;
		private String notOkQty;
		private String operatorName;
		private String jointing;
		private String remark;

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
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
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
		public String getMethod() {
			return method;
		}
		public void setMethod(String method) {
			this.method = method;
		}
		public String getEnquiryNo() {
			return enquiryNo;
		}
		public void setEnquiryNo(String enquiryNo) {
			this.enquiryNo = enquiryNo;
		}
		public String getMaterial() {
			return material;
		}
		public void setMaterial(String material) {
			this.material = material;
		}
		public String getQuotationNo() {
			return quotationNo;
		}
		public void setQuotationNo(String quotationNo) {
			this.quotationNo = quotationNo;
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
		public String getBalanceWeight() {
			return balanceWeight;
		}
		public void setBalanceWeight(String balanceWeight) {
			this.balanceWeight = balanceWeight;
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
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
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
		public String getMachine() {
			return machine;
		}
		public void setMachine(String machine) {
			this.machine = machine;
		}
		public Date getExtrusionDate() {
			return extrusionDate;
		}
		public void setExtrusionDate(Date extrusionDate) {
			this.extrusionDate = extrusionDate;
		}
		public String getStartTime() {
			return startTime;
		}
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}
		public String getEndTime() {
			return endTime;
		}
		public void setEndTime(String endTime) {
			this.endTime = endTime;
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
		public String getJointing() {
			return jointing;
		}
		public void setJointing(String jointing) {
			this.jointing = jointing;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
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


