package common.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class MathUtils {
	public static void main(String[] args) {
		ArrayList<String> data = new ArrayList<String>(Arrays.asList("Ann", "Test", "Banana", "Alise", "Marisa"));
		int i, size = data.size();
		ArrayList<Integer> numSet = new ArrayList<>();
		for (i = 0; i < size; i++) {
			System.out.println(data.get(getRandomIndex(size, numSet)));
		}
	}
	
	static int getRandom(int digit) {
		Double num = Math.floor(Math.random() * digit);
		return num.intValue();
	}
	
	static int getRandomIndex(int digit, ArrayList<Integer> numSet) {
		Double num = Math.floor(Math.random() * digit);
		int intNum = num.intValue();
		while (numSet.contains(intNum)) {
			num = Math.floor(Math.random() * digit);
			intNum = num.intValue();
		}
		numSet.add(intNum);
		return intNum;
	}
}
