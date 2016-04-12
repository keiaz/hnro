package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class MapUtils {
	public static void main(String[] args) {
		testLinkedHashMap();
		// HashMap<String, HashMap<String, String>> map = new HashMap<>();
		// HashMap<String, String> data = new HashMap<>();
		//
		// data.put("test", "01"); // 1
		// map.put("111", (HashMap<String, String>) data.clone());
		// data.put("test", "22"); // 5
		// map.put("222", (HashMap<String, String>) data.clone());
		// data.put("test", "03"); // 2
		// map.put("333", (HashMap<String, String>) data.clone());
		// data.put("test", "14"); // 3
		// map.put("444", (HashMap<String, String>) data.clone());
		// data.put("test", "55"); // 7
		// map.put("555", (HashMap<String, String>) data.clone());
		// data.put("test", "26"); // 6
		// map.put("666", (HashMap<String, String>) data.clone());
		// data.put("test", "17"); // 4
		// map.put("777", (HashMap<String, String>) data.clone());
		//
		// ArrayList<String> sortResult = sortByValue(map);
		// System.out.println(sortResult.toString());
	}
	
	static void testLinkedHashMap() {
		LinkedHashMap<String, String> lhm = new LinkedHashMap<>();
		lhm.put("test1", "hi?");
		lhm.put("test3", "- 3-");
		lhm.put("test2", " ....");
		lhm.put("test6", "~_~_~");
		lhm.put("test5", "~_~_~333");
		lhm.put("test2", "ddkckdkfdkf");
		
		Iterator<String> ite = lhm.values().iterator();
		while (ite.hasNext()) {
			String string = (String) ite.next();
			System.out.println(string);
		}
		
		ite = lhm.keySet().iterator();
		while (ite.hasNext()) {
			String string = (String) ite.next();
			System.out.println(string);
		}
	}
	
	//
	// @SuppressWarnings({ "unchecked", "rawtypes" })
	// public static LinkedHashMap<String, HashMap<String, String>> sortByValue2(HashMap<String, HashMap<String, String>> passedMap) {
	// List mapKeys = new ArrayList(passedMap.keySet());
	// List mapValues = new ArrayList(passedMap.values());
	// Collections.sort(mapValues);
	// Collections.sort(mapKeys);
	//
	// LinkedHashMap sortedMap = new LinkedHashMap();
	// Iterator valueIt = mapValues.iterator();
	// while (valueIt.hasNext()) {
	// Object val = valueIt.next();
	// Iterator keyIt = mapKeys.iterator();
	// while (keyIt.hasNext()) {
	// Object key = keyIt.next();
	//
	// String comp1 = passedMap.get(key).toString();
	// String comp2 = val.toString();
	//
	// if (comp1.equals(comp2)) {
	// passedMap.remove(key);
	// mapKeys.remove(key);
	// sortedMap.put((String) key, (Double) val);
	// break;
	// }
	//
	// }
	//
	// }
	// return sortedMap;
	// }
	
	/**
	 * 값을 기반으로 정렬 예시
	 * @param map
	 * @return
	 */
	public static ArrayList<String> sortByValue(final HashMap<String, HashMap<String, String>> map) {
		ArrayList<String> list = new ArrayList<>();
		list.addAll(map.keySet());
		
		Collections.sort(list, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				HashMap<String, String> v1 = map.get(o1);
				HashMap<String, String> v2 = map.get(o2);
				
				String vv1 = v1.get("test");
				String vv2 = v2.get("test");
				
				return ((Comparable<String>) vv1).compareTo(vv2);
			}
		});
		// Collections.reverse(list); // 내림차순 정렬
		return list;
	}
}
