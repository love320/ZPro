package com.love320.zpro.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapUtils {

	public static Map copy(Map map) {
		Map newMap = new HashMap();
		Set<String> keys= map.keySet();
		for(String key : keys ){
			Object obj = map.get(key);
			if(obj instanceof String[]){
				newMap.put(key, ((String[])obj)[0]);
			}else{
				newMap.put(key, obj);
			}
		}
		return newMap;
	}
	
	public static Map copy(Map map,String  code) {
		Map newMap = new HashMap();
		Set<String> keys= map.keySet();
		for(String key : keys ){
			Object obj = map.get(key);
			if(obj instanceof String[]){
				try {
					newMap.put(key, URLDecoder.decode(((String[])obj)[0],code));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}else{
				newMap.put(key, obj);
			}
		}
		return newMap;
	}


}
