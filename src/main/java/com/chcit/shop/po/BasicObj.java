package com.chcit.shop.po;

import java.util.Date;

import javax.persistence.PrePersist;

public abstract class BasicObj {
	private Long ad_client_id;
	private Long ad_org_id;
	private Date created;
	private Long createdby;
	private Date updated;
	private Long updatedby;
	private Long ad_user_id;
	
	public abstract void  getFileds();
	
	public Long getAd_client_id() {
		return ad_client_id;
	}
	public void setAd_client_id(Long ad_client_id) {
		this.ad_client_id = ad_client_id;
	}
	public Long getAd_org_id() {
		return ad_org_id;
	}
	public void setAd_org_id(Long ad_org_id) {
		this.ad_org_id = ad_org_id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Long getCreatedby() {
		return createdby;
	}
	public void setCreatedby(Long createdby) {
		this.createdby = createdby;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Long getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(Long updatedby) {
		this.updatedby = updatedby;
	}
	public Long getAd_user_id() {
		return ad_user_id;
	}
	public void setAd_user_id(Long ad_user_id) {
		this.ad_user_id = ad_user_id;
	}
	
	public static void validate(BasicObj obj) {
		obj.setAd_client_id(Long.valueOf(0));
		obj.setAd_org_id(Long.valueOf(0));
		obj.setCreated(new Date());
		obj.setCreatedby(Long.valueOf(0));
		obj.setUpdated(new Date());
		obj.setUpdatedby(Long.valueOf(0));
		obj.setAd_user_id(Long.valueOf(0));
	}
}
