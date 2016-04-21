package utils;

import com.google.common.base.CaseFormat;

public class GuavaUtils {
	public static void main(String args[]) {
		String val = "testNumber";
		System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, val));
	}
	
	/**
	 * camel case를 underscore(대문자)로 변경한다. userId > USER_ID
	 * @param str
	 * @return
	 */
	public static String lowerCamelToUpperUnderscore(String str) {
		return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, str);
	}
}
