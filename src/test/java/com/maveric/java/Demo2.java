package com.maveric.java;

import java.util.ArrayList;
import java.util.HashMap;

public class Demo2 {

	public static void main(String[] args) {
		
		HashMap<Integer, String> map=new HashMap<Integer, String>();
		
		map.put(1, "john");
		map.put(2,"peter");
		
		map.put(2,"peter123");
		
		System.out.println(map);
		
		String value=map.get(5);
		System.out.println(value);
	}
}
