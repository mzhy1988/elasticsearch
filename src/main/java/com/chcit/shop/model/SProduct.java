
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


/** S_Product
	AD_CLIENT_ID    NUMBER(10)
	AD_ORG_ID    NUMBER(10)
	CREATED    DATE
	CREATEDBY    NUMBER(10)
	UPDATED    DATE
	UPDATEDBY    NUMBER(10)
	ISACTIVE    CHAR(1)
	S_PRODUCT_ID    NUMBER(10)
	S_BRAND_ID    NUMBER(10)
	S_CLASSIFICATION_ID    NUMBER(10)
	SEOKEY    VARCHAR2(200)
	NAME    VARCHAR2(200)
	ISHASIMAGE    CHAR(1)
	ISSHELVED    CHAR(1)
	STATUSUPDATEDDATE    DATE
	ISGROUPPRODUCT    CHAR(1)
	SALEPRICE    NUMBER
	SEQNO    NUMBER(10)
	DESCRIPTION    VARCHAR2(255)
	SALEINIT    NUMBER
	STORAGETYPE    VARCHAR2(50)
	VALUE    VARCHAR2(200)
	INTEGRAL    NUMBER
	PRODUCTSTYLE    VARCHAR2(20)
	MANUFACTURER    VARCHAR2(200)
	L_BUNDLE_QTY    NUMBER
	UOM    VARCHAR2(20)
	OTCTYPE    VARCHAR2(20)
	CERTIFICATENO    VARCHAR2(50)
	PRODUCTNAME    VARCHAR2(100)
	M_BUNDLE_QTY    NUMBER
	S_BUNDLE_QTY    NUMBER
	MEDICINENAME    VARCHAR2(200)
	ISOTC    CHAR(1)
	PRODUCTSPEC    VARCHAR2(200)
	PRODUCTCODE    VARCHAR2(50)
	EAI_PRODUCT_ID    NUMBER(10)
	SAFETYQTY    NUMBER
	PRODUCTAREA    VARCHAR2(200)
	MEMBERPRICE    NUMBER
	BUSINESSSCOPE    VARCHAR2(60)
	ISINSURANCE    CHAR(1)
	INSURANCETYPE    VARCHAR2(10)
	ISBASICMEDICINE    CHAR(1)
	LOT    VARCHAR2(50)
	QTYONLINE    NUMBER(10)
	INSTRUCTION    CLOB
	ISNEEDSYNC    CHAR(1)
	AD_SERVER_ID    NUMBER
	RETAILUOM    VARCHAR2(50)
	UOMRATIO    NUMBER
	SOURCE_SERVER_ID    NUMBER
	RETURNABLE    CHAR(1)
 */
@Entity
@Table(name="S_Product")
public class SProduct implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long ad_client_id;
	private Long ad_org_id;
	private Date created;
	private Long createdby;
	private Date updated;
	private Long updatedby;
	private String isactive;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator="customer_gen")
	@TableGenerator(name = "customer_gen",
			table="ad_sequence",
			pkColumnName="AD_Sequence_ID",
			pkColumnValue ="1009727",
			valueColumnName="CurrentNextSys",
			allocationSize=1
	)
	private Long s_product_id;
	private Long s_brand_id;
	private Long s_classification_id;
	private String seokey;
	private String name;
	private String ishasimage;
	private String isshelved;
	private Date statusupdateddate;
	private String isgroupproduct;
	private BigDecimal saleprice;
	private Long seqno;
	private String description;
	private BigDecimal saleinit;
	private String storagetype;
	private String value;
	private BigDecimal integral;
	private String productstyle;
	private String manufacturer;
	private BigDecimal l_bundle_qty;
	private String uom;
	private String otctype;
	private String certificateno;
	private String productname;
	private BigDecimal m_bundle_qty;
	private BigDecimal s_bundle_qty;
	private String medicinename;
	private String isotc;
	private String productspec;
	private String productcode;
	private Long eai_product_id;
	private BigDecimal safetyqty;
	private String productarea;
	private BigDecimal memberprice;
	private String businessscope;
	private String isinsurance;
	private String insurancetype;
	private String isbasicmedicine;
	private String lot;
	private Long qtyonline;
	private String instruction;
	private String isneedsync;
	private BigDecimal ad_server_id;
	private String retailuom;
	private BigDecimal uomratio;
	private BigDecimal source_server_id;
	private String returnable;

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
	public void setIsactive(String isactive){
		this.isactive=isactive;
	}
	public String getIsactive(){
		return isactive;
	}
	public void setS_product_id(Long s_product_id){
		this.s_product_id=s_product_id;
	}
	public Long getS_product_id(){
		return s_product_id;
	}
	public void setS_brand_id(Long s_brand_id){
		this.s_brand_id=s_brand_id;
	}
	public Long getS_brand_id(){
		return s_brand_id;
	}
	public void setS_classification_id(Long s_classification_id){
		this.s_classification_id=s_classification_id;
	}
	public Long getS_classification_id(){
		return s_classification_id;
	}
	public void setSeokey(String seokey){
		this.seokey=seokey;
	}
	public String getSeokey(){
		return seokey;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setIshasimage(String ishasimage){
		this.ishasimage=ishasimage;
	}
	public String getIshasimage(){
		return ishasimage;
	}
	public void setIsshelved(String isshelved){
		this.isshelved=isshelved;
	}
	public String getIsshelved(){
		return isshelved;
	}
	public void setStatusupdateddate(Date statusupdateddate){
		this.statusupdateddate=statusupdateddate;
	}
	public Date getStatusupdateddate(){
		return statusupdateddate;
	}
	public void setIsgroupproduct(String isgroupproduct){
		this.isgroupproduct=isgroupproduct;
	}
	public String getIsgroupproduct(){
		return isgroupproduct;
	}
	public void setSaleprice(BigDecimal saleprice){
		this.saleprice=saleprice;
	}
	public BigDecimal getSaleprice(){
		return saleprice;
	}
	public void setSeqno(Long seqno){
		this.seqno=seqno;
	}
	public Long getSeqno(){
		return seqno;
	}
	public void setDescription(String description){
		this.description=description;
	}
	public String getDescription(){
		return description;
	}
	public void setSaleinit(BigDecimal saleinit){
		this.saleinit=saleinit;
	}
	public BigDecimal getSaleinit(){
		return saleinit;
	}
	public void setStoragetype(String storagetype){
		this.storagetype=storagetype;
	}
	public String getStoragetype(){
		return storagetype;
	}
	public void setValue(String value){
		this.value=value;
	}
	public String getValue(){
		return value;
	}
	public void setIntegral(BigDecimal integral){
		this.integral=integral;
	}
	public BigDecimal getIntegral(){
		return integral;
	}
	public void setProductstyle(String productstyle){
		this.productstyle=productstyle;
	}
	public String getProductstyle(){
		return productstyle;
	}
	public void setManufacturer(String manufacturer){
		this.manufacturer=manufacturer;
	}
	public String getManufacturer(){
		return manufacturer;
	}
	public void setL_bundle_qty(BigDecimal l_bundle_qty){
		this.l_bundle_qty=l_bundle_qty;
	}
	public BigDecimal getL_bundle_qty(){
		return l_bundle_qty;
	}
	public void setUom(String uom){
		this.uom=uom;
	}
	public String getUom(){
		return uom;
	}
	public void setOtctype(String otctype){
		this.otctype=otctype;
	}
	public String getOtctype(){
		return otctype;
	}
	public void setCertificateno(String certificateno){
		this.certificateno=certificateno;
	}
	public String getCertificateno(){
		return certificateno;
	}
	public void setProductname(String productname){
		this.productname=productname;
	}
	public String getProductname(){
		return productname;
	}
	public void setM_bundle_qty(BigDecimal m_bundle_qty){
		this.m_bundle_qty=m_bundle_qty;
	}
	public BigDecimal getM_bundle_qty(){
		return m_bundle_qty;
	}
	public void setS_bundle_qty(BigDecimal s_bundle_qty){
		this.s_bundle_qty=s_bundle_qty;
	}
	public BigDecimal getS_bundle_qty(){
		return s_bundle_qty;
	}
	public void setMedicinename(String medicinename){
		this.medicinename=medicinename;
	}
	public String getMedicinename(){
		return medicinename;
	}
	public void setIsotc(String isotc){
		this.isotc=isotc;
	}
	public String getIsotc(){
		return isotc;
	}
	public void setProductspec(String productspec){
		this.productspec=productspec;
	}
	public String getProductspec(){
		return productspec;
	}
	public void setProductcode(String productcode){
		this.productcode=productcode;
	}
	public String getProductcode(){
		return productcode;
	}
	public void setEai_product_id(Long eai_product_id){
		this.eai_product_id=eai_product_id;
	}
	public Long getEai_product_id(){
		return eai_product_id;
	}
	public void setSafetyqty(BigDecimal safetyqty){
		this.safetyqty=safetyqty;
	}
	public BigDecimal getSafetyqty(){
		return safetyqty;
	}
	public void setProductarea(String productarea){
		this.productarea=productarea;
	}
	public String getProductarea(){
		return productarea;
	}
	public void setMemberprice(BigDecimal memberprice){
		this.memberprice=memberprice;
	}
	public BigDecimal getMemberprice(){
		return memberprice;
	}
	public void setBusinessscope(String businessscope){
		this.businessscope=businessscope;
	}
	public String getBusinessscope(){
		return businessscope;
	}
	public void setIsinsurance(String isinsurance){
		this.isinsurance=isinsurance;
	}
	public String getIsinsurance(){
		return isinsurance;
	}
	public void setInsurancetype(String insurancetype){
		this.insurancetype=insurancetype;
	}
	public String getInsurancetype(){
		return insurancetype;
	}
	public void setIsbasicmedicine(String isbasicmedicine){
		this.isbasicmedicine=isbasicmedicine;
	}
	public String getIsbasicmedicine(){
		return isbasicmedicine;
	}
	public void setLot(String lot){
		this.lot=lot;
	}
	public String getLot(){
		return lot;
	}
	public void setQtyonline(Long qtyonline){
		this.qtyonline=qtyonline;
	}
	public Long getQtyonline(){
		return qtyonline;
	}
	public void setInstruction(String instruction){
		this.instruction=instruction;
	}
	public String getInstruction(){
		return instruction;
	}
	public void setIsneedsync(String isneedsync){
		this.isneedsync=isneedsync;
	}
	public String getIsneedsync(){
		return isneedsync;
	}
	public void setAd_server_id(BigDecimal ad_server_id){
		this.ad_server_id=ad_server_id;
	}
	public BigDecimal getAd_server_id(){
		return ad_server_id;
	}
	public void setRetailuom(String retailuom){
		this.retailuom=retailuom;
	}
	public String getRetailuom(){
		return retailuom;
	}
	public void setUomratio(BigDecimal uomratio){
		this.uomratio=uomratio;
	}
	public BigDecimal getUomratio(){
		return uomratio;
	}
	public void setSource_server_id(BigDecimal source_server_id){
		this.source_server_id=source_server_id;
	}
	public BigDecimal getSource_server_id(){
		return source_server_id;
	}
	public void setReturnable(String returnable){
		this.returnable=returnable;
	}
	public String getReturnable(){
		return returnable;
	}


}