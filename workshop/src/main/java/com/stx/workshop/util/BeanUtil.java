package com.stx.workshop.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.Timestamp;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.collections.FastHashMap;

public final class BeanUtil {
	protected static final Set<String> DATE_CLASS_NAME = new TreeSet<>();
	
	protected static final Set<String> BASIC_TYPE = new TreeSet<>();
	
	public static final Set<String> DB_RESERVED_FIELD = new TreeSet<>();
	
	public static final Set<String> NUMERIC_TYPE = new TreeSet<>();
	
	public static final String CLASS_NAME = "class";
	
	private static FastHashMap descriptorsCache;
	
	private static FastHashMap descriptorsFieldCache;
	
	private static FastHashMap multiLinguaTypeCache;
	
	public static final Set<String> CHANGES_IGNORE_FIELD = new HashSet<>();
	
	static {
		DATE_CLASS_NAME.add(java.util.Date.class.getName());
		DATE_CLASS_NAME.add(java.sql.Date.class.getName());
		DATE_CLASS_NAME.add(Time.class.getName());
		DATE_CLASS_NAME.add(Timestamp.class.getName());
		
		boolean[] booleanArray = new boolean[0];
		byte[] byteArray = new byte[0];
		char[] charArray = new char[0];
		double[] doubleArray = new double[0];
		float[] floatArray = new float[0];
		int[] intArray = new int[0];
		long[] longArray = new long[0];
		short[] shortArray = new short[0];
		String[] stringArray = new String[0];
		
		BASIC_TYPE.add(BigDecimal.class.getName());
		BASIC_TYPE.add(BigInteger.class.getName());
		BASIC_TYPE.add(Boolean.class.getName());
		BASIC_TYPE.add("boolean");
	}
}
