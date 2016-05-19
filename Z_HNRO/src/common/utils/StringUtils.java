package common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	public static void main(String[] args) {
		String code = "A|B|CA|DB|E";
		String val = "DB";
		System.out.println(indexOfForString(code, "(^|\\|)" + val + "(\\||$)"));
	}
	
	/**
	 * 수치형 문자열 대소비교
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean compareString(String str1, String str2) {
		// return str1 < str2; // 문자열끼리 대소비교는 불가.
		int int1 = Integer.parseInt(str1);
		int int2 = Integer.parseInt(str2);
		return int1 < int2;
	}
	
	/**
	 * 수치형 문자열 대소비교 2
	 * @param str1
	 * @param str2
	 * @return str1보다 str2가 더 크면 -1, 같으면 0, 작으면 1
	 */
	public static int compareTo(String str1, String str2) {
		return str1.compareTo(str2);
	}
	
	/**
	 * 문자열을 디코딩
	 * @param str
	 * @param enc
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String decode(String str, String enc) throws UnsupportedEncodingException {
		return URLDecoder.decode(str, enc);
	}
	
	/**
	 * 빈 문자열일 경우 null 반환
	 * @param str
	 * @return
	 */
	public static String emptyStringToNull(String str) {
		if (str == null || str.isEmpty()) {
			return null;
		}
		return str;
	}
	
	/**
	 * 문자열을 인코딩
	 * @param str
	 * @param enc
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String encode(String str, String enc) throws UnsupportedEncodingException {
		return URLEncoder.encode(str, "UTF-8");
	}
	
	/**
	 * 문자열에서 패턴과 일치하는 부분의 index를 반환.없으면 -1 반환.
	 * @param target 탐색할 문자열
	 * @param pattern 정규식 패턴 문자열
	 * @return
	 */
	public static int indexOfForString(String target, String pattern) {
		Matcher m = Pattern.compile(pattern).matcher(target);
		int idx = -1;
		while (m.find()) {
			idx = m.start();
			break;
		}
		return idx;
	}
	
	/**
	 * 특수문자 앞에 excape 문자 삽입
	 * @param str
	 * @param escape
	 * @return
	 */
	public static String insertEscapeCharInFrontOfSpecialChars(String str, String escape) {
		str = str.replaceAll("_", escape + "_");
		str = str.replaceAll("%", escape + "%");
		
		str = str.replaceAll("'", "''"); // '(작은따옴표)는 escape로 처리되지 않았기에 별도처리
		
		return str;
	}
	
	/**
	 * Object를 문자열로 변환하여 문자열이 비었는지 여부를 체크
	 * @param objStr
	 * @return 비어있으면 true
	 */
	public static boolean isEmpty(Object objStr) {
		if (objStr == null) {
			return true;
		}
		String str = toString(objStr);
		return isEmpty(str);
	}
	
	/**
	 * 문자열이 비었는지 여부를 체크
	 * @param str
	 * @return 비어있으면 true
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.isEmpty();
	}
	
	/**
	 * 문자열 절삭.
	 * @param str
	 * @param start 문자열 절삭 시작 index. 시작은 0부터. "abcd"를 1부터 시작하면 "bcd"가 된다. 지정한 인덱스부터 절삭. 결과에 포함된다.
	 * @param end 문자열 절삭 종료 index. "abcd"를 2로 지정해서 자르면 "ab"가 된다. 즉 지정한 인덱스 앞까지만 절삭. 결과에 포함되지 않는다.
	 * @return
	 */
	public static String substring(String str, int start, int end) {
		return str.substring(start, end);
	}
	
	/**
	 * Object를 문자열로 변경
	 * @param value
	 * @return
	 */
	public static String toString(Object value) {
		String result = null;
		if (value != null) {
			result = value.toString();
		}
		return result;
	}
}
