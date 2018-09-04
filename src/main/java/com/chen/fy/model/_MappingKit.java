package com.chen.fy.model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * Generated by JFinal, do not modify this file.
 * <pre>
 * Example:
 * public void configPlugin(Plugins me) {
 *     ActiveRecordPlugin arp = new ActiveRecordPlugin(...);
 *     _MappingKit.mapping(arp);
 *     me.add(arp);
 * }
 * </pre>
 */
public class _MappingKit {
	
	public static void mapping(ActiveRecordPlugin arp) {
		arp.addMapping("account", "id", Account.class);
		arp.addMapping("auth_code", "id", AuthCode.class);
		arp.addMapping("col_permision", "id", ColPermision.class);
		arp.addMapping("column_permission", "id", ColumnPermission.class);
		arp.addMapping("fy_advisory_cost", "id", FyAdvisoryCost.class);
		arp.addMapping("fy_base_category", "id", Category.class);
		arp.addMapping("fy_base_customer", "id", Customer.class);
		arp.addMapping("fy_base_department", "id", Department.class);
		arp.addMapping("fy_base_fyfile", "id", Fyfile.class);
		arp.addMapping("fy_base_person", "id", Person.class);
		arp.addMapping("fy_base_supplier", "id", Supplier.class);
		arp.addMapping("fy_base_tax_rate", "id", TaxRate.class);
		arp.addMapping("fy_base_unit", "id", Unit.class);
		arp.addMapping("fy_biz_ww_receive", "id", FyBizWwReceive.class);
		arp.addMapping("fy_business_assist", "id", FyBusinessAssist.class);
		arp.addMapping("fy_business_bill", "id", FyBusinessBill.class);
		arp.addMapping("fy_business_distribute", "id", FyBusinessDistribute.class);
		arp.addMapping("fy_business_getpay", "id", FyBusinessGetpay.class);
		arp.addMapping("fy_business_getpaybill", "id", FyBusinessGetpaybill.class);
		arp.addMapping("fy_business_in_warehouse", "id", FyBusinessInWarehouse.class);
		arp.addMapping("fy_business_order", "id", FyBusinessOrder.class);
		arp.addMapping("fy_business_out_warehouse", "id", FyBusinessOutWarehouse.class);
		arp.addMapping("fy_business_pay", "id", FyBusinessPay.class);
		arp.addMapping("fy_business_paybill", "id", FyBusinessPaybill.class);
		arp.addMapping("fy_business_produce", "id", FyBusinessProduce.class);
		arp.addMapping("fy_business_purchase", "id", FyBusinessPurchase.class);
		arp.addMapping("fy_business_ready", "id", FyBusinessReady.class);
		arp.addMapping("fy_business_sum_paybill", "id", FyBusinessSumPaybill.class);
		arp.addMapping("fy_business_warehouse", "id", FyBusinessWarehouse.class);
		arp.addMapping("fy_complaint", "id", FyComplaint.class);
		arp.addMapping("fy_pay_sum", "id", FyPaySum.class);
		arp.addMapping("fy_ready_purchase", "id", FyReadyPurchase.class);
		arp.addMapping("fy_supplier_category", "id", FySupplierCategory.class);
		arp.addMapping("fy_upload_getpay", "id", FyUploadGetpay.class);
		arp.addMapping("order_upload_log", "id", OrderUploadLog.class);
		arp.addMapping("permission", "id", Permission.class);
		arp.addMapping("role", "id", Role.class);
		// Composite Primary Key order: column_id,roleId
		arp.addMapping("role_col", "column_id,roleId", RoleCol.class);
		// Composite Primary Key order: permissionId,roleId
		arp.addMapping("role_permission", "permissionId,roleId", RolePermission.class);
		arp.addMapping("session", "id", Session.class);
		arp.addMapping("task_run_log", "id", TaskRunLog.class);
	}
}

