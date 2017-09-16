package com.chcit.shop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "chcit", type = "product", shards = 1, replicas = 0)
public class ProductDoc {
	@Id
	private String productId;
	@Version
	private Long version;
	private String manufacturer;
	private String medicineName;
	private String productSpec;
	private String productStyle;
	private String certificateNo;
	private String productCode;
	private String uomName;
	private String direction;
	private String memberPrice;
	private String qtyMsg;
	private String saleUnit;
	private String isOTC;
	private String insuranceType;
	private String nearValDate;
	private String L_Bundle_Qty;
	private String M_Bundle_Qty;
	private String productClass;
	private String productClassId;
	private String productBrand;
	private String productBrandId;
	private String productStyleId;
	private String isShelved;
	private String largeClassId;
	private String middleClassId;
	//管控
	private String orgId;
	private String saleArea;
	private String scopeBusiness;
	//排序
	private String time;
	private String salePrice;
	private String productName;
	private String saleQty;
	private Integer total;//总数
	//检索
	private String value;
	
	public ProductDoc(){
		
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getProductSpec() {
		return productSpec;
	}
	public void setProductSpec(String productSpec) {
		this.productSpec = productSpec;
	}
	public String getProductStyle() {
		return productStyle;
	}
	public void setProductStyle(String productStyle) {
		this.productStyle = productStyle;
	}
	public String getCertificateNo() {
		return certificateNo;
	}
	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getUomName() {
		return uomName;
	}
	public void setUomName(String uomName) {
		this.uomName = uomName;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getMemberPrice() {
		return memberPrice;
	}
	public void setMemberPrice(String memberPrice) {
		this.memberPrice = memberPrice;
	}
	public String getQtyMsg() {
		return qtyMsg;
	}
	public void setQtyMsg(String qtyMsg) {
		this.qtyMsg = qtyMsg;
	}
	public String getSaleUnit() {
		return saleUnit;
	}
	public void setSaleUnit(String saleUnit) {
		this.saleUnit = saleUnit;
	}
	public String getIsOTC() {
		return isOTC;
	}
	public void setIsOTC(String isOTC) {
		this.isOTC = isOTC;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public String getNearValDate() {
		return nearValDate;
	}
	public void setNearValDate(String nearValDate) {
		this.nearValDate = nearValDate;
	}
	public String getL_Bundle_Qty() {
		return L_Bundle_Qty;
	}
	public void setL_Bundle_Qty(String bundle_Qty) {
		L_Bundle_Qty = bundle_Qty;
	}
	public String getM_Bundle_Qty() {
		return M_Bundle_Qty;
	}
	public void setM_Bundle_Qty(String bundle_Qty) {
		M_Bundle_Qty = bundle_Qty;
	}
	public String getProductClass() {
		return productClass;
	}
	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}
	public String getProductClassId() {
		return productClassId;
	}
	public void setProductClassId(String productClassId) {
		this.productClassId = productClassId;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getProductBrandId() {
		return productBrandId;
	}
	public void setProductBrandId(String productBrandId) {
		this.productBrandId = productBrandId;
	}
	public String getProductStyleId() {
		return productStyleId;
	}
	public void setProductStyleId(String productStyleId) {
		this.productStyleId = productStyleId;
	}
	public String getIsShelved() {
		return isShelved;
	}
	public void setIsShelved(String isShelved) {
		this.isShelved = isShelved;
	}
	public String getLargeClassId() {
		return largeClassId;
	}
	public void setLargeClassId(String largeClassId) {
		this.largeClassId = largeClassId;
	}
	public String getMiddleClassId() {
		return middleClassId;
	}
	public void setMiddleClassId(String middleClassId) {
		this.middleClassId = middleClassId;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getSaleArea() {
		return saleArea;
	}
	public void setSaleArea(String saleArea) {
		this.saleArea = saleArea;
	}
	public String getScopeBusiness() {
		return scopeBusiness;
	}
	public void setScopeBusiness(String scopeBusiness) {
		this.scopeBusiness = scopeBusiness;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSaleQty() {
		return saleQty;
	}
	public void setSaleQty(String saleQty) {
		this.saleQty = saleQty;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
