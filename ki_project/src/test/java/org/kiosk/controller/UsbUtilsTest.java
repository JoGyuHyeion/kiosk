package org.kiosk.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kiosk.service.Vol_checkService;
import org.kiosk.util.UsbUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class UsbUtilsTest {

	@Inject
	private UsbUtils usbUtils;
	@Inject
	private Vol_checkService vol_checkService;

	private String path = "D:\\resources";
	private String toPath = "D:\\";
	private String fileName = "resources";
	private String fileName2 = path.substring(path.lastIndexOf("\\") + 1);

	@Test
	public void name() throws Exception {
		System.out.println(fileName2);
	}

	// @Test
	public void testJsonTextFile() throws Exception {
		usbUtils.makeJsonTextFile(path, "json", usbUtils.makeJsonString(vol_checkService.read(1)));
	}

	// @Test
	public void testZip() throws Exception {
		usbUtils.createZipFile(path, toPath, fileName2);
	}
}
