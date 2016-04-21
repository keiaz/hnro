package utils;

import java.util.ArrayList;

public class ArrayUtils {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<>();
		arr.add("test");
		arr.add("hi?");
		arr.add("hello~");
		arr.add("12345");
		
		String[] result = toArray(arr);
		System.out.println(result);
	}
	
	public static String join(ArrayList<String> arr) {
		String result = arr.toString();
		result = result.substring(1, result.length() - 1);
		return result;
	}
	
	public static String[] toArray(ArrayList<String> arr) {
		return arr.toArray(new String[0]);
	}
}
