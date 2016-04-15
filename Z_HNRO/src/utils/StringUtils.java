package utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	public static void main(String[] args) {
		String compcd = "hh01";
		String plantcd = "pl01";
		String linecd = "li01";
		String processcd = "pr01";
		String eqpcd = "eq01";
		String cartypecd = "ct01";
		String itemcd = "it01";
		String pmfcd = "pc01";
		String pmfsubcd = "ps01";
		String mkdate = "20140401";
		String mktime1 = "080000";
		String mktime2 = "090000";
		
		String query = "" + " SELECT " + "		*" + " FROM" + "		 dbo.PTR001 p1" + "		,dbo.PTR002 p2" + " WHERE" + "		p1.REG_NO = p2.REG_NO" + "		AND p1.COMPANY_CD = 'compcd'" + "		AND p1.plant_CD = 'plantcd'" + "		AND p1.line_CD = 'linecd'"
				+ "		AND p1.process_CD = 'processcd'" + "		AND p1.eqp_CD = 'eqpcd'" + "		AND p1.cartype_CD = 'cartypecd'" + "		AND p1.item_CD = 'itemcd'" + "		AND p1.pmf_CD = 'pmfcd'" + "		AND p1.pmf_sub_CD = 'pmfsubcd'" + "		AND p2.MK_DATE = 'mkdate' "
				+ "		AND p2.MK_TIME BETWEEN 'starttime' AND 'endtime'";
		
		int i;
		long start = System.currentTimeMillis();
		String result = "";
		for (i = 0; i < 10000; i++) {
			result = query.replace("compcd", compcd).replace("plantcd", plantcd).replace("linecd", linecd).replace("processcd", processcd).replace("eqpcd", eqpcd).replace("cartypecd", cartypecd).replace("itemcd", itemcd).replace("pmfcd", pmfcd).replace("pmfsubcd", pmfsubcd).replace("mkdate", mkdate)
					.replace("starttime", mktime1).replace("endtime", mktime2);
		}
		System.out.println(System.currentTimeMillis() - start);
		System.out.println(result);
		
		StringBuilder sb = null;
		start = System.currentTimeMillis();
		for (i = 0; i < 10000; i++) {
			sb = new StringBuilder("SELECT * FROM dbo.PTR001 p1, dbo.PTR002 p2 WHERE p1.REG_NO = p2.REG_NO AND p1.COMPANY_CD = '");
			sb.append(compcd).append("' AND p1.plant_CD = '").append(plantcd).append("' AND p1.line_CD = '").append(linecd).append("' AND p1.process_CD = '").append(processcd);
			sb.append("' AND p1.eqp_CD = '");
			sb.append(eqpcd);
			sb.append("' AND p1.cartype_CD = '");
			sb.append(cartypecd);
			sb.append("' AND p1.item_CD = '");
			sb.append(itemcd);
			sb.append("' AND p1.pmf_CD = '");
			sb.append(pmfcd);
			sb.append("' AND p1.pmf_sub_CD = '");
			sb.append(pmfsubcd);
			sb.append("' AND p2.MK_DATE = '");
			sb.append(mkdate);
			sb.append("' AND p2.MK_TIME BETWEEN '");
			sb.append(mktime1);
			sb.append("' AND '");
			sb.append(mktime2);
			sb.append("'");
		}
		System.out.println(System.currentTimeMillis() - start);
		System.out.println(sb.toString());
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
