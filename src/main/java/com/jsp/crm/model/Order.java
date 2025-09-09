package com.jsp.crm.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String routeCardNo;
	private Date date;
	private String componentName;
	private String customerName;
	private String customerNo;
	private String enquiryNo;
	private String quotationNo;
	private String purchaseOrder;
	private String formulationNo;

	private String method;
	private String material;
	private String toolDieNo;
	private Double weightPerMeter;
	private Double temperature;
	private Long extruderRpm;
	private Long conveyorRpm;
	private Long noOfCavity;

	private Long plannedQty;
	private String workOrderNo;
	private String coating;

	private String toolStatus;
	private String responsiblePerson;
	private String toolMaker;
	private Date eta;
//    private String drawingImage;
	@Transient
	private MultipartFile imageFile; // use this for receiving file

	private String imageUrl;// This will store the uploaded image URL

	public Order( String routeCardNo) {
		// TODO Auto-generated constructor stub
		this.routeCardNo = routeCardNo;
	}
	public Order() {}

	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
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

	public String getToolDieNo() {
		return toolDieNo;
	}

	public void setToolDieNo(String toolDieNo) {
		this.toolDieNo = toolDieNo;
	}

	public Double getWeightPerMeter() {
		return weightPerMeter;
	}

	public void setWeightPerMeter(Double weightPerMeter) {
		this.weightPerMeter = weightPerMeter;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Long getExtruderRpm() {
		return extruderRpm;
	}

	public void setExtruderRpm(Long extruderRpm) {
		this.extruderRpm = extruderRpm;
	}

	public Long getConveyorRpm() {
		return conveyorRpm;
	}

	public void setConveyorRpm(Long conveyorRpm) {
		this.conveyorRpm = conveyorRpm;
	}

	public Long getNoOfCavity() {
		return noOfCavity;
	}

	public void setNoOfCavity(Long noOfCavity) {
		this.noOfCavity = noOfCavity;
	}

	public Long getPlannedQty() {
		return plannedQty;
	}

	public void setPlannedQty(Long plannedQty) {
		this.plannedQty = plannedQty;
	}

	public String getWorkOrderNo() {
		return workOrderNo;
	}

	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}

	public String getCoating() {
		return coating;
	}

	public void setCoating(String coating) {
		this.coating = coating;
	}

	public String getToolStatus() {
		return toolStatus;
	}

	public void setToolStatus(String toolStatus) {
		this.toolStatus = toolStatus;
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

	public Date getEta() {
		return eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}
}