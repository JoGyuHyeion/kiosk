package org.kiosk.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonUtils {
	
	private  JSONArray jArray;
	
	// 이미지 파일 json형식
	public  JSONArray uploadJsonPicture(String[] imgArr) {
		jArray = new JSONArray();
		for (int i = 0; i < imgArr.length; i++) {
			JSONObject obj = new JSONObject();
			obj.put("picName", imgArr[i]);

			jArray.add(obj);
		}
		return jArray;
	}
}
