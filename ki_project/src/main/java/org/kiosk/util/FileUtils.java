package org.kiosk.util;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
@Component("FileUtils")
public class FileUtils {

	private Map<String, MediaType> mediaMap;
	private Map<String, String> fileMap;

	{

		mediaMap = new HashMap<String, MediaType>();
		mediaMap.put("JPG", MediaType.IMAGE_JPEG);
		mediaMap.put("GIF", MediaType.IMAGE_GIF);
		mediaMap.put("PNG", MediaType.IMAGE_PNG);

		fileMap = new HashMap<String, String>();
		fileMap.put("JPG", "JPG");
		fileMap.put("PNG", "PNG");
		fileMap.put("GIF", "GIF");

	}

	public MediaType getMediaType(String type) {

		return mediaMap.get(type.toUpperCase());
	}

	public String getFileType(String type) {
		return fileMap.get(type.toUpperCase());
	}
}
