package utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtils {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<>();
		arr.add("test");
		arr.add("hi?");
		arr.add("hello~");
		arr.add("12345");
		
		System.out.println(subList(arr, 1, arr.size()).toString());
	}
	
	public static String join(ArrayList<String> arr) {
		String result = arr.toString();
		result = result.substring(1, result.length() - 1);
		return result;
	}
	
	/**
	 * [0,1,2,3]을 1,3으로 끊으면 [1,2]가 반환된다
	 * @param arr
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public static ArrayList<String> subList(ArrayList<String> arr, int startIndex, int endIndex) {
		List<String> subResult = arr.subList(startIndex, endIndex);
		ArrayList<String> result = new ArrayList<>();
		result.addAll(subResult);
		return result;
	}
	
	public static String[] toArray(ArrayList<String> arr) {
		return arr.toArray(new String[0]);
	}
}
