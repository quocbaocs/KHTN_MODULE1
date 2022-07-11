package com.coding.mvc.controller;

public interface DataBinding {
	//Map<String, Object> getDataBinders();
	
	
	/**
	 * @return {
	 * "dataname", type of data,
	 * }
	 */
	
	Object[] getDataBinders();

}
