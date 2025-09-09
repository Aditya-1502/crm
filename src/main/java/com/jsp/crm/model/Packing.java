package com.jsp.crm.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Packing {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	 private String routeCardNo;
	    private Date date;
	    private String packedQty;
	    private String packNo;
	    private String packedBy;
	    private String remarks;
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
		public String getPackedQty() {
			return packedQty;
		}
		public void setPackedQty(String packedQty) {
			this.packedQty = packedQty;
		}
		public String getPackNo() {
			return packNo;
		}
		public void setPackNo(String packNo) {
			this.packNo = packNo;
		}
		public String getPackedBy() {
			return packedBy;
		}
		public void setPackedBy(String packedBy) {
			this.packedBy = packedBy;
		}
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}    
}
