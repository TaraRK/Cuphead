package com.example.demo1.controller;


import java.util.HashMap;

public class KeyEventHandler {
	private static HashMap<String, Boolean> pressedKeys = new HashMap<>();

	public static void pressKey(String keyName){
		pressedKeys.put(keyName, true);
	}
	public static void releaseKey(String keyName){
		pressedKeys.put(keyName, false);
	}
	public static int getStatus(String... keyNames){
		for (String keyName : keyNames) {
			if(pressedKeys.getOrDefault(keyName, false))
				return 1;
		}
		return 0;
	}
}
