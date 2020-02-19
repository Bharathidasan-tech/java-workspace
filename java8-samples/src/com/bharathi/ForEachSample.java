package com.bharathi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ForEachSample {

	public static void main(String arg[]) {

		Map<String, Integer> items = new HashMap<>();

		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

		// to get the particular key value from the map
		items.forEach((k, v) -> {
			if ("E".equalsIgnoreCase(k)) {
				System.out.println("particular key value value is  " + v);
			}
		});

		List<String> list = Arrays.asList("Bharathi", "dasan", "java", "Bharathidasan");

		// print the list values
		list.stream().forEach(System.out::println);

		List names = Arrays.asList("Reflection", "Collection", "Stream");
		List result = (List) names.stream().filter(s -> ((String) s).startsWith("S")).collect(Collectors.toList());

		result.forEach(value -> {
			System.out.println(" filter value is=  " + value);
		});

	}
}
