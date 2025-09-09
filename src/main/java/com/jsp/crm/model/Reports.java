package com.jsp.crm.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Reports {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
	    private Date startDate;
	    private Date endDate;
	    private String customerName;
	    private String customerNo;
	    private String componentName;
	    private String responsiblePerson;
	    private String toolMaker;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
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
		public String getComponentName() {
			return componentName;
		}
		public void setComponentName(String componentName) {
			this.componentName = componentName;
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
}
