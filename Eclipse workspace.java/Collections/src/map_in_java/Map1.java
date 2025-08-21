package map_in_java;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Map1 {
	/*
	 * Map: ====== when you represent a group of individual object as a single
	 * entity. in the form of key value pair then we should go for a map interface
	 * null keys are allowed ,if more than one null key ,it will replace the value
	 * of 2nd null key. values can be repeated key should not be repeated.
	 */

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(0, "banana");
		map.put(1, "apple");
		map.put(3, "kiwi");
		map.put(2, "orange");
		map.put(null, "null");
		map.put(null, "banana");
		System.out.println(map);
		System.out.println(map.containsKey(1));
		System.out.println(map.isEmpty());
		System.out.println(map.remove(0));
		System.out.println(map);
		System.out.println(map.containsValue("banana"));
        System.out.println("using entryset method");
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		for (Entry<Integer, String> keyValue : entrySet ) {
			System.out.println(keyValue);
		}
		System.out.println("using forEach");
		map.forEach((k, v) -> System.out.println(k + "=>" + v));
		
		System.out.println("using keyset method");
		Set<Integer>keySet=map.keySet();
		for(Integer key:keySet) {
			System.out.println("key:=>"+key);
		}
		

	}

}
