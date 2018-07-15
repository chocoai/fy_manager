package com.chen.fy.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseSupplier<M extends BaseSupplier<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}
	
	public java.lang.String getName() {
		return getStr("name");
	}

	public void setCode(java.lang.String code) {
		set("code", code);
	}
	
	public java.lang.String getCode() {
		return getStr("code");
	}

	public void setAddress(java.lang.String address) {
		set("address", address);
	}
	
	public java.lang.String getAddress() {
		return getStr("address");
	}

	public void setPhone(java.lang.String phone) {
		set("phone", phone);
	}
	
	public java.lang.String getPhone() {
		return getStr("phone");
	}

	public void setBankAccount(java.lang.String bankAccount) {
		set("bank_account", bankAccount);
	}
	
	public java.lang.String getBankAccount() {
		return getStr("bank_account");
	}

	public void setBankNo(java.lang.String bankNo) {
		set("bank_no", bankNo);
	}
	
	public java.lang.String getBankNo() {
		return getStr("bank_no");
	}

	public void setSettlementType(java.lang.String settlementType) {
		set("settlement_type", settlementType);
	}
	
	public java.lang.String getSettlementType() {
		return getStr("settlement_type");
	}

	public void setSettlementCycle(java.lang.String settlementCycle) {
		set("settlement_cycle", settlementCycle);
	}
	
	public java.lang.String getSettlementCycle() {
		return getStr("settlement_cycle");
	}

	public void setContactPerson(java.lang.String contactPerson) {
		set("contact_person", contactPerson);
	}
	
	public java.lang.String getContactPerson() {
		return getStr("contact_person");
	}

	public void setContactType(java.lang.String contactType) {
		set("contact_type", contactType);
	}
	
	public java.lang.String getContactType() {
		return getStr("contact_type");
	}

	public void setAnnex(java.lang.String annex) {
		set("annex", annex);
	}
	
	public java.lang.String getAnnex() {
		return getStr("annex");
	}

}
