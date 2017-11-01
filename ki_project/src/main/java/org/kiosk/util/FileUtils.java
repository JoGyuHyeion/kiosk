package org.kiosk.util;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.MediaType;

public class FileUtils {
	
	private static Map<String, MediaType> mediaMap;
	private static Map<String, String> fileMap;
	
	static{
		
		mediaMap = new HashMap<String, MediaType>();		
		mediaMap.put("JPG", MediaType.IMAGE_JPEG);
		mediaMap.put("GIF", MediaType.IMAGE_GIF);
		mediaMap.put("PNG", MediaType.IMAGE_PNG);
		
		fileMap = new HashMap<String, String>();	
		fileMap.put("JPG", "JPG");
		fileMap.put("PNG", "PNG");
		fileMap.put("GIF", "GIF");


		
	}
	
	public static MediaType getMediaType(String type){
		
		return mediaMap.get(type.toUpperCase());
	}
	
	public static String getFileType(String type){
		return fileMap.get(type.toUpperCase());
	}
}



