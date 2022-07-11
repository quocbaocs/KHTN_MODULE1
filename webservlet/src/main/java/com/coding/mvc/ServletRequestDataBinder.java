package com.coding.mvc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class ServletRequestDataBinder {

	public static Object bind(HttpServletRequest request, Class<?> dataType, String dataName)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (isPrimitve(dataType)) {
			return createObject(dataType, request.getParameter(dataName));
		}
		Object dataObj = null;
		Set<String> paramNames = request.getParameterMap().keySet();
		try {
			dataObj = dataType.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Method setter = null;
		for (String fieldName : paramNames) {
			setter = findSetter(dataType, fieldName);
			if (setter != null) {
				setter.invoke(dataObj, createObject(setter.getParameterTypes()[0], request.getParameter(fieldName)));
			}
		}
		
		return dataObj;
	}

	private static Method findSetter(Class<?> dataType, String fieldName) {
		// TODO Auto-generated method stub
		Method[] methods = dataType.getMethods();
		String pName = null;
		for (Method m : methods) {
			if (!m.getName().startsWith("set")) {
				continue;
			}
			pName = m.getName().substring(3);
			if (pName.toLowerCase().equals(fieldName.toLowerCase())) {
				return m;
			}
		}
		return null;
	}

	private static Object createObject(Class<?> dataType, String parameter) {
		// TODO Auto-generated method stub
		if (dataType.getName().equals("int") || dataType == Integer.class) {
			return new Integer(parameter);

		} else if (dataType.getName().equals("long") || dataType == Long.class) {
			return new Long(parameter);
		} else if (dataType.getName().equals("float") || dataType == Float.class) {
			return new Float(parameter);
		} else if (dataType.getName().equals("double") || dataType == Double.class) {
			return new Double(parameter);
		} else if (dataType.getName().equals("byte") || dataType == Byte.class) {
			return new Byte(parameter);
		} else if (dataType.getName().equals("boolean") || dataType == Boolean.class) {
			return new Boolean(parameter);
		} else if (dataType.getName().equals("short") || dataType == Short.class) {
			return new Short(parameter);
		} else if (dataType == Date.class) {
			return new Date(Long.parseLong(parameter));
		} else if (dataType == String.class) {
			return new String(parameter);
		} else {

			return parameter;
		}
	}

	private static boolean isPrimitve(Class<?> dataType) {
		// TODO Auto-generated method stub
		if (dataType.getName().equals("int") || dataType == Long.class || dataType.getName().equals("long")
				|| dataType == Integer.class || dataType.getName().equals("float") || dataType == Float.class
				|| dataType.getName().equals("double") || dataType == Double.class || dataType.getName().equals("byte")
				|| dataType == Byte.class || dataType.getName().equals("short") || dataType == Short.class
				|| dataType.getName().equals("char") || dataType == Character.class
				|| dataType.getName().equals("boolean") || dataType == Boolean.class || dataType == String.class
				|| dataType == Date.class)
			return true;
		return false;
	}

}
