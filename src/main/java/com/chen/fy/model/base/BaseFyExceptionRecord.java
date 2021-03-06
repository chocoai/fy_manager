package com.chen.fy.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseFyExceptionRecord<M extends BaseFyExceptionRecord<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	public void setSupplierId(java.lang.Integer supplierId) {
		set("supplier_id", supplierId);
	}
	
	public java.lang.Integer getSupplierId() {
		return getInt("supplier_id");
	}

	public void setCheckTime(java.util.Date checkTime) {
		set("check_time", checkTime);
	}
	
	public java.util.Date getCheckTime() {
		return get("check_time");
	}

	public void setExceptionReson(java.lang.String exceptionReson) {
		set("exception_reson", exceptionReson);
	}
	
	public java.lang.String getExceptionReson() {
		return getStr("exception_reson");
	}

	public void setCheckRemark(java.lang.String checkRemark) {
		set("check_remark", checkRemark);
	}
	
	public java.lang.String getCheckRemark() {
		return getStr("check_remark");
	}

	public void setSupplierName(java.lang.String supplierName) {
		set("supplier_name", supplierName);
	}
	
	public java.lang.String getSupplierName() {
		return getStr("supplier_name");
	}

	public void setOrderId(java.lang.Integer orderId) {
		set("order_id", orderId);
	}
	
	public java.lang.Integer getOrderId() {
		return getInt("order_id");
	}

	public void setExceptionQuantity(java.lang.Integer exceptionQuantity) {
		set("exception_quantity", exceptionQuantity);
	}
	
	public java.lang.Integer getExceptionQuantity() {
		return getInt("exception_quantity");
	}

}
