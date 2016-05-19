package common.utils;

import java.math.BigDecimal;
import java.math.MathContext;

public class NumberUtils {
	public static void main(String[] args) {
		System.out.println(devide(10, 0));
	}
	
	/**
	 * 나누기
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static double devide(double num1, double num2) {
		if (num2 == 0) {
			return 0;
		}
		
		BigDecimal db1 = BigDecimal.valueOf(num1);
		BigDecimal db2 = BigDecimal.valueOf(num2);
		
		return db1.divide(db2, MathContext.DECIMAL128).doubleValue();
	}
	
	/**
	 * 소수점 자리수 고정
	 * @param num
	 * @param digit
	 * @return
	 */
	public static String toFixed(double num, int digit) {
		String snum = Double.toString(num);
		int dotIdx = snum.indexOf(".");
		int size = digit - (snum.length() - dotIdx - 1);
		int i;
		
		for (i = 0; i < size; i++) {
			snum += "0";
		}
		
		return snum;
	}
}
