package com.jsp.crm.model;

import java.sql.Date;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class FinalInspectionHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private String reportNo;
    private String workOrderNo;
    private String routeCardNo;
    private String componentPartName;
    private String colour;
    private String rubber;
    private String quantity;
    private String hardness;
    private String testedBy;
    private String approvedBy;

    @OneToMany(mappedBy = "header", cascade = CascadeType.ALL)
    private List<FinalInspectionRow> inspectionRows;

    // ✅ GETTERS and SETTERS
    public List<FinalInspectionRow> getInspectionRows() {
        return inspectionRows;
    }

    public void setInspectionRows(List<FinalInspectionRow> inspectionRows) {
        this.inspectionRows = inspectionRows;
        if (inspectionRows != null) {
            for (FinalInspectionRow row : inspectionRows) {
                row.setHeader(this); // set parent
            }
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getReportNo() { return reportNo; }
    public void setReportNo(String reportNo) { this.reportNo = reportNo; }

    public String getWorkOrderNo() { return workOrderNo; }
    public void setWorkOrderNo(String workOrderNo) { this.workOrderNo = workOrderNo; }

    public String getRouteCardNo() { return routeCardNo; }
    public void setRouteCardNo(String routeCardNo) { this.routeCardNo = routeCardNo; }

    public String getComponentPartName() { return componentPartName; }
    public void setComponentPartName(String componentPartName) { this.componentPartName = componentPartName; }

    public String getColour() { return colour; }
    public void setColour(String colour) { this.colour = colour; }

    public String getRubber() { return rubber; }
    public void setRubber(String rubber) { this.rubber = rubber; }

    public String getQuantity() { return quantity; }
    public void setQuantity(String quantity) { this.quantity = quantity; }

    public String getHardness() { return hardness; }
    public void setHardness(String hardness) { this.hardness = hardness; }

    public String getTestedBy() { return testedBy; }
    public void setTestedBy(String testedBy) { this.testedBy = testedBy; }

    public String getApprovedBy() { return approvedBy; }
    public void setApprovedBy(String approvedBy) { this.approvedBy = approvedBy; }
}