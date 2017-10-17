package org.kiosk.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {

	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);

	public static String uploadImageFile(String uploadPath, String originalName, byte[] fileData, String savedName,
			String[] dirPath) throws Exception {
		// String savedPath = calcPath(uploadPath);
		String savedPath = savePath(uploadPath, dirPath);
		String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
		String uploadedFileName = null;
		savedName = savedName + "." + formatName;

		if (FileUtils.getMediaType(formatName) != null) {
			File target = new File(uploadPath + savedPath, savedName);
			FileCopyUtils.copy(fileData, target);
			uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
			System.out.println("=================makeThumbnail===================");
			System.out.println(uploadedFileName);
		} else {
			// uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
			System.out.println("============makeIcon===================");
			System.out.println(uploadedFileName);
		}
		return uploadedFileName;
	}

	// 썸네일 이미지 생성(이미지 파일)
	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception {
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 300);
		String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;
		// s_로 시작하면 썸네일 이미지이다.
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	private static String makeIcon(String uploadPath, String path, String fileName) throws Exception {

		String iconName = uploadPath + path + File.separator + fileName;
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	private static String calcPath(String uploadPath) {

		Calendar cal = Calendar.getInstance();

		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		makeDir(uploadPath, yearPath, monthPath, datePath);
		logger.info(datePath);

		return datePath;
	}

	private static String savePath(String uploadPath, String... paths) {
		String savePath = "";
		for (String path : paths) {
			savePath = savePath + File.separator + path;
		}
		makeDir(uploadPath, savePath);
		return savePath;
	}

	private static void makeDir(String uploadPath, String... paths) {
		
		if (new File(paths[paths.length - 1]).exists()) {
			return;
		}
		for (String path : paths) {
			File dirPath = new File(uploadPath + path);
			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}

	public static void deleteFile(String uploadPath, String... files) {

		logger.info("delete all files: " + files);
		if (files == null || files.length == 0) {
		}
		for (String fileName : files) {
			if (fileName != null) {
				String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
				MediaType mType = FileUtils.getMediaType(formatName);
				if (mType != null) {
					String front = fileName.substring(0, 12);
					String end = fileName.substring(14);
					new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
				}
				new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
			}
		}
	}
}
