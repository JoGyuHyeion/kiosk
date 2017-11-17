package org.kiosk.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

@Component("UploadFileUtils")
public class UploadFileUtils {

	@Resource(name = "FileUtils")
	private FileUtils fileUtils;

	private final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);

	public String uploadImageFile(String uploadPath, String originalName, byte[] fileData, String savedName,
			String[] dirPath) throws Exception {
		// String savedPath = calcPath(uploadPath);
		String savedPath = savePath(uploadPath, dirPath);
		String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
		String uploadedFileName = null;
		savedName = savedName + "." + formatName;

		if (fileUtils.getMediaType(formatName) != null) {
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
	private String makeThumbnail(String uploadPath, String path, String fileName) throws Exception {
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 300);
		String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;
		// s_로 시작하면 썸네일 이미지이다.
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	private String makeIcon(String uploadPath, String path, String fileName) throws Exception {

		String iconName = uploadPath + path + File.separator + fileName;
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	private String calcPath(String uploadPath) {

		Calendar cal = Calendar.getInstance();

		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		makeDir(uploadPath, yearPath, monthPath, datePath);
		logger.info(datePath);

		return datePath;
	}

	private String savePath(String uploadPath, String... paths) {
		String savePath = "";
		for (String path : paths) {
			savePath = savePath + File.separator + path;
		}
		makeDir(uploadPath, savePath);
		return savePath;
	}

	private void makeDir(String uploadPath, String... paths) {

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

	public void deleteFile(String uploadPath, String fileName) {

		logger.info("delete all files: " + fileName);

		if (fileName != null) {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			MediaType mType = fileUtils.getMediaType(formatName);
			if (mType != null) {
				String notSName=fileName.replace("s_", "");
				System.out.println("notSName : "+notSName);
//				String front = fileName.substring(0, 12);
//				String end = fileName.substring(14);
//				
//				System.out.println("front : "+front);
//				System.out.println("end : "+end);
//				System.out.println("total1 : "+uploadPath + (front + end).replace('/', File.separatorChar));
//				new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
				System.out.println("total1 : "+uploadPath + (notSName).replace('/', File.separatorChar));
				new File(uploadPath + (notSName).replace('/', File.separatorChar)).delete();
			
			}
			System.out.println("total : "+uploadPath+fileName.replace('/', File.separatorChar));
			new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
		}

	}
}
