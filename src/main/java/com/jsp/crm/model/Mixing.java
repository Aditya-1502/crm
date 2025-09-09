package com.jsp.crm.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mixing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String routeCardNo;
private Date date;
private String batchNo;
private Long hardness;
private Long sheetThickness;
private String lotNo;
private String formulationNo;
private Long batchWeight;
private String colour;
private String mixingBy;
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
public String getBatchNo() {
	return batchNo;
}
public void setBatchNo(String batchNo) {
	this.batchNo = batchNo;
}
public Long getHardness() {
	return hardness;
}
public void setHardness(Long hardness) {
	this.hardness = hardness;
}
public Long getSheetThickness() {
	return sheetThickness;
}
public void setSheetThickness(Long sheetThickness) {
	this.sheetThickness = sheetThickness;
}
public String getLotNo() {
	return lotNo;
}
public void setLotNo(String lotNo) {
	this.lotNo = lotNo;
}
public String getFormulationNo() {
	return formulationNo;
}
public void setFormulationNo(String formulationNo) {
	this.formulationNo = formulationNo;
}
public Long getBatchWeight() {
	return batchWeight;
}
public void setBatchWeight(Long batchWeight) {
	this.batchWeight = batchWeight;
}
public String getColour() {
	return colour;
}
public void setColour(String colour) {
	this.colour = colour;
}
public String getMixingBy() {
	return mixingBy;
}
public void setMixingBy(String mixingBy) {
	this.mixingBy = mixingBy;
}

}
