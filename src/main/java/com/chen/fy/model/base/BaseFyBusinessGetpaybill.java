package com.chen.fy.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseFyBusinessGetpaybill<M extends BaseFyBusinessGetpaybill<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	public void setCustomerName(java.lang.String customerName) {
		set("customer_name", customerName);
	}
	
	public java.lang.String getCustomerName() {
		return getStr("customer_name");
	}

	public void setInvoicePeriod(java.lang.String invoicePeriod) {
		set("invoice_period", invoicePeriod);
	}
	
	public java.lang.String getInvoicePeriod() {
		return getStr("invoice_period");
	}

	public void setInvoiceAccount(java.math.BigDecimal invoiceAccount) {
		set("invoice_account", invoiceAccount);
	}
	
	public java.math.BigDecimal getInvoiceAccount() {
		return get("invoice_account");
	}

	public void setBillPeriod(java.lang.String billPeriod) {
		set("bill_period", billPeriod);
	}
	
	public java.lang.String getBillPeriod() {
		return getStr("bill_period");
	}

	public void setBillTool(java.lang.String billTool) {
		set("bill_tool", billTool);
	}
	
	public java.lang.String getBillTool() {
		return getStr("bill_tool");
	}

	public void setBillAccount(java.math.BigDecimal billAccount) {
		set("bill_account", billAccount);
	}
	
	public java.math.BigDecimal getBillAccount() {
		return get("bill_account");
	}

	public void setUnbillAccount(java.math.BigDecimal unbillAccount) {
		set("unbill_account", unbillAccount);
	}
	
	public java.math.BigDecimal getUnbillAccount() {
		return get("unbill_account");
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

}
