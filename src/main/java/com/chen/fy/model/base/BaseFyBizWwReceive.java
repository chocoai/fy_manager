package com.chen.fy.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseFyBizWwReceive<M extends BaseFyBizWwReceive<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	public void setCategoryId(java.lang.Integer categoryId) {
		set("category_id", categoryId);
	}
	
	public java.lang.Integer getCategoryId() {
		return getInt("category_id");
	}

	public void setPlanerId(java.lang.Integer planerId) {
		set("planer_id", planerId);
	}
	
	public java.lang.Integer getPlanerId() {
		return getInt("planer_id");
	}

	public void setExecuStatus(java.lang.String execuStatus) {
		set("execu_status", execuStatus);
	}
	
	public java.lang.String getExecuStatus() {
		return getStr("execu_status");
	}

	public void setUrgentStatus(java.lang.String urgentStatus) {
		set("urgent_status", urgentStatus);
	}
	
	public java.lang.String getUrgentStatus() {
		return getStr("urgent_status");
	}

	public void setOrderDate(java.util.Date orderDate) {
		set("order_date", orderDate);
	}
	
	public java.util.Date getOrderDate() {
		return get("order_date");
	}

	public void setDeliveryDate(java.util.Date deliveryDate) {
		set("delivery_date", deliveryDate);
	}
	
	public java.util.Date getDeliveryDate() {
		return get("delivery_date");
	}

	public void setWorkOrderNo(java.lang.String workOrderNo) {
		set("work_order_no", workOrderNo);
	}
	
	public java.lang.String getWorkOrderNo() {
		return getStr("work_order_no");
	}

	public void setDeliveryNo(java.lang.String deliveryNo) {
		set("delivery_no", deliveryNo);
	}
	
	public java.lang.String getDeliveryNo() {
		return getStr("delivery_no");
	}

	public void setCommodityName(java.lang.String commodityName) {
		set("commodity_name", commodityName);
	}
	
	public java.lang.String getCommodityName() {
		return getStr("commodity_name");
	}

	public void setCommoditySpec(java.lang.String commoditySpec) {
		set("commodity_spec", commoditySpec);
	}
	
	public java.lang.String getCommoditySpec() {
		return getStr("commodity_spec");
	}

	public void setMapNo(java.lang.Integer mapNo) {
		set("map_no", mapNo);
	}
	
	public java.lang.Integer getMapNo() {
		return getInt("map_no");
	}

	public void setTechnology(java.lang.String technology) {
		set("technology", technology);
	}
	
	public java.lang.String getTechnology() {
		return getStr("technology");
	}

	public void setMachiningRequire(java.lang.String machiningRequire) {
		set("machining_require", machiningRequire);
	}
	
	public java.lang.String getMachiningRequire() {
		return getStr("machining_require");
	}

	public void setQuantity(java.math.BigDecimal quantity) {
		set("quantity", quantity);
	}
	
	public java.math.BigDecimal getQuantity() {
		return get("quantity");
	}

	public void setUnit(java.lang.Integer unit) {
		set("unit", unit);
	}
	
	public java.lang.Integer getUnit() {
		return getInt("unit");
	}

	public void setDistributeTime(java.util.Date distributeTime) {
		set("distribute_time", distributeTime);
	}
	
	public java.util.Date getDistributeTime() {
		return get("distribute_time");
	}

	public void setHandlStatus(java.lang.String handlStatus) {
		set("handl_status", handlStatus);
	}
	
	public java.lang.String getHandlStatus() {
		return getStr("handl_status");
	}

	public void setCategoryTmp(java.lang.String categoryTmp) {
		set("category_tmp", categoryTmp);
	}
	
	public java.lang.String getCategoryTmp() {
		return getStr("category_tmp");
	}

	public void setPlanTmp(java.lang.String planTmp) {
		set("plan_tmp", planTmp);
	}
	
	public java.lang.String getPlanTmp() {
		return getStr("plan_tmp");
	}

	public void setUnitTmp(java.lang.String unitTmp) {
		set("unit_tmp", unitTmp);
	}
	
	public java.lang.String getUnitTmp() {
		return getStr("unit_tmp");
	}

	public void setOrderId(java.lang.Integer orderId) {
		set("order_id", orderId);
	}
	
	public java.lang.Integer getOrderId() {
		return getInt("order_id");
	}

	public void setParentId(java.lang.Integer parentId) {
		set("parent_id", parentId);
	}
	
	public java.lang.Integer getParentId() {
		return getInt("parent_id");
	}

	public void setIsReceive(java.lang.Boolean isReceive) {
		set("is_receive", isReceive);
	}
	
	public java.lang.Boolean getIsReceive() {
		return get("is_receive");
	}

}
