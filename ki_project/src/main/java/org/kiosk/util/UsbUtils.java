package org.kiosk.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component("UsbUtils")
public class UsbUtils {

	public String makeJsonString(Object obj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}

	public void makeJsonTextFile(String uploadPath, String fileName, String jsonText) {

		if (uploadPath.charAt(uploadPath.length() - 1) != '/') {
			uploadPath = uploadPath + "/";
		}
		try {
			fileName += ".txt";
			// BufferedWriter 와 FileWriter를 조합하여 사용 (속도 향상)
			BufferedWriter fw = new BufferedWriter(new FileWriter(uploadPath + fileName, false));

			// 파일안에 문자열 쓰기
			fw.write(jsonText);
			fw.flush();

			// 객체 닫기
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 디렉토리 및 파일을 압축한다.
	 * 
	 * @param path
	 *            압축할 디렉토리 및 파일
	 * @param toPath
	 *            압축파일을 생성할 경로
	 * @param fileName
	 *            압축파일의 이름
	 */
	public void createZipFile(String path, String toPath, String fileName) {
		fileName += ".zip";
		File dir = new File(path);
		String[] list = dir.list();
		String _path;

		if (!dir.canRead() || !dir.canWrite()) {
			return;
		}
		if (path.charAt(path.length() - 1) != '/') {
			_path = path + "/";
		} else {
			_path = path;
		}
		try {
			ZipOutputStream zip_out = new ZipOutputStream(
					new BufferedOutputStream(new FileOutputStream(toPath + "/" + fileName), 2048));

			for (int i = 0; i < list.length; i++) {
				zip_folder("", path, new File(_path + list[i]), zip_out);
			}

			zip_out.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found : " + e.getMessage());

		} catch (IOException e) {
			System.out.println("IOException : " + e.getMessage());
		} finally {

		}
	}

	/**
	 * ZipOutputStream를 넘겨 받아서 하나의 압축파일로 만든다.
	 * 
	 * @param parent
	 *            상위폴더명
	 * @param file
	 *            압축할 파일
	 * @param zout
	 *            압축전체스트림
	 * @throws IOException
	 */
	private static void zip_folder(String parent, String path, File file, ZipOutputStream zout) throws IOException {
		byte[] data = new byte[2048];
		int read;

		if (file.isFile()) {
			ZipEntry entry = new ZipEntry(parent + file.getName());
			zout.putNextEntry(entry);
			BufferedInputStream instream = new BufferedInputStream(new FileInputStream(file));

			while ((read = instream.read(data, 0, 2048)) != -1)
				zout.write(data, 0, read);

			zout.flush();
			zout.closeEntry();
			instream.close();

		} else if (file.isDirectory()) {
			String parentString = file.getPath().replace(path, "");
			parentString = parentString.substring(0, parentString.length() - file.getName().length());
			ZipEntry entry = new ZipEntry(parentString + file.getName() + "/");
			zout.putNextEntry(entry);

			String[] list = file.list();
			if (list != null) {
				int len = list.length;
				for (int i = 0; i < len; i++) {
					zip_folder(entry.getName(), path, new File(file.getPath() + "/" + list[i]), zout);
				}
			}
		}
	}

}
