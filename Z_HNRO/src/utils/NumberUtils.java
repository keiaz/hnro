package utils;

public class NumberUtils {
	public static void main(String[] args) {
		System.out.println(toFixed(3.1, 3));
	}
	
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
