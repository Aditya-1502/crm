package com.jsp.crm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FinalInspectionRow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rowNo;
    private String characteristic;
    private String specification;
    private String obs1;
    private String obs2;
    private String obs3;
    private String obs4;
    private String obs5;
    private String obs6;
    private String obs7;
    private String obs8;
    private String obs9;
    private String obs10;
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "header_id")
    private FinalInspectionHeader header;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	public String getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getObs1() {
		return obs1;
	}

	public void setObs1(String obs1) {
		this.obs1 = obs1;
	}

	public String getObs2() {
		return obs2;
	}

	public void setObs2(String obs2) {
		this.obs2 = obs2;
	}

	public String getObs3() {
		return obs3;
	}

	public void setObs3(String obs3) {
		this.obs3 = obs3;
	}

	public String getObs4() {
		return obs4;
	}

	public void setObs4(String obs4) {
		this.obs4 = obs4;
	}

	public String getObs5() {
		return obs5;
	}

	public void setObs5(String obs5) {
		this.obs5 = obs5;
	}

	public String getObs6() {
		return obs6;
	}

	public void setObs6(String obs6) {
		this.obs6 = obs6;
	}

	public String getObs7() {
		return obs7;
	}

	public void setObs7(String obs7) {
		this.obs7 = obs7;
	}

	public String getObs8() {
		return obs8;
	}

	public void setObs8(String obs8) {
		this.obs8 = obs8;
	}

	public String getObs9() {
		return obs9;
	}

	public void setObs9(String obs9) {
		this.obs9 = obs9;
	}

	public String getObs10() {
		return obs10;
	}

	public void setObs10(String obs10) {
		this.obs10 = obs10;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public FinalInspectionHeader getHeader() {
		return header;
	}

	public void setHeader(FinalInspectionHeader header) {
		this.header = header;
	}

    // Getters and setters
}
