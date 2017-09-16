
package com.chcit.shop.model;

import java.io.Serializable;
import java.util.Date;
import java.sql.*;

import java.math.*;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.PrePersist;
import javax.persistence.TableGenerator;

import javax.persistence.Table;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import com.chcit.shop.po.BasicObj;


/** S_Cart
	AD_CLIENT_ID    NUMBER(10)
	AD_ORG_ID    NUMBER(10)
	CREATED    DATE
	CREATEDBY    NUMBER(10)
	UPDATED    DATE
	UPDATEDBY    NUMBER(10)
	DESCRIPTION    VARCHAR2(500)
	ISACTIVE    CHAR(1)
	S_CART_ID    NUMBER(10)
	EAI_PRODUCT_ID    NUMBER(10)
	QTY    NUMBER
	AD_USER_ID    NUMBER(10)
	SEQNO    NUMBER(10)
*/
@Entity
@Table(name="S_Cart")
public class SCart extends BasicObj implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long ad_client_id;
	private Long ad_org_id;
	private Date created;
	private Long createdby;
	private Date updated;
	private Long updatedby;
	private String description;
	private String isactive;
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator="customer_gen")
    @TableGenerator(name = "customer_gen",
                       table="ad_sequence",
                       pkColumnName="AD_Sequence_ID",
                       pkColumnValue ="1009034",
                       valueColumnName="CurrentNextSys",
                       allocationSize=1
    )
	private Long s_cart_id;
	private Long eai_product_id;
	private BigDecimal qty;
	private Long ad_user_id;
	private Long seqno;

	public void setAd_client_id(Long ad_client_id){
		this.ad_client_id=ad_client_id;
	}
	public Long getAd_client_id(){
		return ad_client_id;
	}
	public void setAd_org_id(Long ad_org_id){
		this.ad_org_id=ad_org_id;
	}
	public Long getAd_org_id(){
		return ad_org_id;
	}
	public void setCreated(Date created){
		this.created=created;
	}
	public Date getCreated(){
		return created;
	}
	public void setCreatedby(Long createdby){
		this.createdby=createdby;
	}
	public Long getCreatedby(){
		return createdby;
	}
	public void setUpdated(Date updated){
		this.updated=updated;
	}
	public Date getUpdated(){
		return updated;
	}
	public void setUpdatedby(Long updatedby){
		this.updatedby=updatedby;
	}
	public Long getUpdatedby(){
		return updatedby;
	}
	public void setDescription(String description){
		this.description=description;
	}
	public String getDescription(){
		return description;
	}
	public void setIsactive(String isactive){
		this.isactive=isactive;
	}
	public String getIsactive(){
		return isactive;
	}
	public void setS_cart_id(Long s_cart_id){
		this.s_cart_id=s_cart_id;
	}
	public Long getS_cart_id(){
		return s_cart_id;
	}
	public void setEai_product_id(Long eai_product_id){
		this.eai_product_id=eai_product_id;
	}
	public Long getEai_product_id(){
		return eai_product_id;
	}
	public void setQty(BigDecimal qty){
		this.qty=qty;
	}
	public BigDecimal getQty(){
		return qty;
	}
	public void setAd_user_id(Long ad_user_id){
		this.ad_user_id=ad_user_id;
	}
	public Long getAd_user_id(){
		return ad_user_id;
	}
	public void setSeqno(Long seqno){
		this.seqno=seqno;
	}
	public Long getSeqno(){
		return seqno;
	}
	@PrePersist
	public  void beforeSave() {
		BasicObj.validate(this);
	}
	@Override
	public void getFileds() {
		// TODO Auto-generated method stub
		System.out.println("getFileds");
		
	}
	
 
	
}

