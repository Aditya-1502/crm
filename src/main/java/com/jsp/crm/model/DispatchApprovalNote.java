package com.jsp.crm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class DispatchApprovalNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String danNo;
    private String dateOfInspection;
    private String routeCardNo;
    private String finalInspectionReportNo;

    private String srNo;
    private String productCode;
    private String quantity;

    private String inspectedQty;
    private String okQty;
    private String rejectedQty;
    private String inspectedBy;

    private boolean dimensionVariation;
    private boolean colourMismatch;
    private boolean physicalDamage;
    private boolean stainsDust;
    private boolean structuralDamage;
    private boolean curingProblem;
    private boolean sizeDeformation;
    private boolean twistKink;
    private boolean hardnessVariation;

    private String approvalStatus;

    private String qcSignature;
    private String reviewedBy;
    private String reviewDate;
    private String responsiblePerson;
    private String responsibleSignature;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDanNo() {
		return danNo;
	}
	public void setDanNo(String danNo) {
		this.danNo = danNo;
	}
	public String getDateOfInspection() {
		return dateOfInspection;
	}
	public void setDateOfInspection(String dateOfInspection) {
		this.dateOfInspection = dateOfInspection;
	}
	public String getRouteCardNo() {
		return routeCardNo;
	}
	public void setRouteCardNo(String routeCardNo) {
		this.routeCardNo = routeCardNo;
	}
	public String getFinalInspectionReportNo() {
		return finalInspectionReportNo;
	}
	public void setFinalInspectionReportNo(String finalInspectionReportNo) {
		this.finalInspectionReportNo = finalInspectionReportNo;
	}
	public String getSrNo() {
		return srNo;
	}
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getInspectedQty() {
		return inspectedQty;
	}
	public void setInspectedQty(String inspectedQty) {
		this.inspectedQty = inspectedQty;
	}
	public String getOkQty() {
		return okQty;
	}
	public void setOkQty(String okQty) {
		this.okQty = okQty;
	}
	public String getRejectedQty() {
		return rejectedQty;
	}
	public void setRejectedQty(String rejectedQty) {
		this.rejectedQty = rejectedQty;
	}
	public String getInspectedBy() {
		return inspectedBy;
	}
	public void setInspectedBy(String inspectedBy) {
		this.inspectedBy = inspectedBy;
	}
	public boolean isDimensionVariation() {
		return dimensionVariation;
	}
	public void setDimensionVariation(boolean dimensionVariation) {
		this.dimensionVariation = dimensionVariation;
	}
	public boolean isColourMismatch() {
		return colourMismatch;
	}
	public void setColourMismatch(boolean colourMismatch) {
		this.colourMismatch = colourMismatch;
	}
	public boolean isPhysicalDamage() {
		return physicalDamage;
	}
	public void setPhysicalDamage(boolean physicalDamage) {
		this.physicalDamage = physicalDamage;
	}
	public boolean isStainsDust() {
		return stainsDust;
	}
	public void setStainsDust(boolean stainsDust) {
		this.stainsDust = stainsDust;
	}
	public boolean isStructuralDamage() {
		return structuralDamage;
	}
	public void setStructuralDamage(boolean structuralDamage) {
		this.structuralDamage = structuralDamage;
	}
	public boolean isCuringProblem() {
		return curingProblem;
	}
	public void setCuringProblem(boolean curingProblem) {
		this.curingProblem = curingProblem;
	}
	public boolean isSizeDeformation() {
		return sizeDeformation;
	}
	public void setSizeDeformation(boolean sizeDeformation) {
		this.sizeDeformation = sizeDeformation;
	}
	public boolean isTwistKink() {
		return twistKink;
	}
	public void setTwistKink(boolean twistKink) {
		this.twistKink = twistKink;
	}
	public boolean isHardnessVariation() {
		return hardnessVariation;
	}
	public void setHardnessVariation(boolean hardnessVariation) {
		this.hardnessVariation = hardnessVariation;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public String getQcSignature() {
		return qcSignature;
	}
	public void setQcSignature(String qcSignature) {
		this.qcSignature = qcSignature;
	}
	public String getReviewedBy() {
		return reviewedBy;
	}
	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getResponsiblePerson() {
		return responsiblePerson;
	}
	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}
	public String getResponsibleSignature() {
		return responsibleSignature;
	}
	public void setResponsibleSignature(String responsibleSignature) {
		this.responsibleSignature = responsibleSignature;
	}

    
}