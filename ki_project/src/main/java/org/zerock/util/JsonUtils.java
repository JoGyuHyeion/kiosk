package org.zerock.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.zerock.dto.GpsDTO;
import org.zerock.dto.PinmarkDTO;

public class JsonUtils {
	
	private static GpsDTO gpsDTO;
	private final static int distance_radius = 5000;// 반경 범위
	private static JSONArray jArray, pinArray;
	private static JSONObject jObject;
	private static JSONParser parser;
	private static Iterator it;
	private static List<PinmarkDTO> list;
	
	// 이미지 파일 json형식
	public static JSONArray uploadJsonPicture(String[] imgArr) {
		jArray = new JSONArray();
		for (int i = 0; i < imgArr.length; i++) {
			JSONObject obj = new JSONObject();
			obj.put("picName", imgArr[i]);

			jArray.add(obj);
		}
		return jArray;
	}
	
	/////////////////pinmark read 공통메소드///////////////////////////////////////////////
	private static List<PinmarkDTO> readPaserPinmark(JSONArray jArray) throws ParseException{
		parser = new JSONParser();
		list = new ArrayList<PinmarkDTO>();
		for(int i=0; i< jArray.size();i++){
			JSONObject object =(JSONObject)jArray.get(i);
			PinmarkDTO pinmarkDTO = new PinmarkDTO();
			pinmarkDTO.setpName(object.get("pName").toString());
			pinmarkDTO.setpLat(object.get("pLat").toString());
			pinmarkDTO.setpLon(object.get("pLon").toString());
			list.add(pinmarkDTO);
		}
		return list;
	}
	

}
