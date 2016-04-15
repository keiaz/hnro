package utils;

import java.util.ArrayList;

public class ArrayUtils {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<>();
		arr.add("test");
		arr.add("hi?");
		arr.add("hello~");
		arr.add("12345");
		
		int i;
		int size = arr.size();
		for(i = 0; i < size; i++) {
			System.out.println(arr.get(i));
			if (i == 3) {
				break;
			}
		}
		System.out.println(i == size);
	}
	
	public static String join(ArrayList<String> arr) {
		String result = arr.toString();
		result = result.substring(1, result.length() - 1);
		return result;
	}
}
