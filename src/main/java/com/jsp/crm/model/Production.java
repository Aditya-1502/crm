package com.jsp.crm.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Production {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	private	String routeCardNo;
	private Date date;
	private	String componentName;
	private	Long customerNo;
	private	String method;
	private	String enquiryNo;
	private String material;
	private String quotationNo;
	private	String toolDieNo;
	private	String batchNo;
	private	Long batchWeight;
	private	Long extruderRPM;
	private	Long dcOvenTemp;
	private	Long weightPerMeter;
	private Long productionPerHour;
	private	Long conveyorRPM;
	private Long setupToolDieNo;
	private	Long noOfCavity;
	private	String time;
	private Long clampPressure;
	private Long cycleTime;
	private Long curingTemp;
    private String Machine;
    private String purchaseOrder;
    private String formulationNo;
    private String workOrderNo;
    private Long balanceWeight;
    private String man;
    private Long plannedQty;
    private String colour;
    private Long hardness;
    private String lastSupply;
    private String itemCode;
    private String issuedBy;
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
	public Long getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(Long customerNo) {
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
	public Long getBatchWeight() {
		return batchWeight;
	}
	public void setBatchWeight(Long batchWeight) {
		this.batchWeight = batchWeight;
	}
	public Long getExtruderRPM() {
		return extruderRPM;
	}
	public void setExtruderRPM(Long extruderRPM) {
		this.extruderRPM = extruderRPM;
	}
	public Long getDcOvenTemp() {
		return dcOvenTemp;
	}
	public void setDcOvenTemp(Long dcOvenTemp) {
		this.dcOvenTemp = dcOvenTemp;
	}
	public Long getWeightPerMeter() {
		return weightPerMeter;
	}
	public void setWeightPerMeter(Long weightPerMeter) {
		this.weightPerMeter = weightPerMeter;
	}
	public Long getProductionPerHour() {
		return productionPerHour;
	}
	public void setProductionPerHour(Long productionPerHour) {
		this.productionPerHour = productionPerHour;
	}
	public Long getConveyorRPM() {
		return conveyorRPM;
	}
	public void setConveyorRPM(Long conveyorRPM) {
		this.conveyorRPM = conveyorRPM;
	}
	public Long getSetupToolDieNo() {
		return setupToolDieNo;
	}
	public void setSetupToolDieNo(Long setupToolDieNo) {
		this.setupToolDieNo = setupToolDieNo;
	}
	public Long getNoOfCavity() {
		return noOfCavity;
	}
	public void setNoOfCavity(Long noOfCavity) {
		this.noOfCavity = noOfCavity;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	public String getMachine() {
		return Machine;
	}
	public void setMachine(String machine) {
		Machine = machine;
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
	public Long getBalanceWeight() {
		return balanceWeight;
	}
	public void setBalanceWeight(Long balanceWeight) {
		this.balanceWeight = balanceWeight;
	}
	public String getMan() {
		return man;
	}
	public void setMan(String man) {
		this.man = man;
	}
	public Long getPlannedQty() {
		return plannedQty;
	}
	public void setPlannedQty(Long plannedQty) {
		this.plannedQty = plannedQty;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public Long getHardness() {
		return hardness;
	}
	public void setHardness(Long hardness) {
		this.hardness = hardness;
	}
	public String getLastSupply() {
		return lastSupply;
	}
	public void setLastSupply(String lastSupply) {
		this.lastSupply = lastSupply;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getIssuedBy() {
		return issuedBy;
	}
	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

    
}
