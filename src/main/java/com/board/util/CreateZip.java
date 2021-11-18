package com.board.util;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.board.home.service.TestAPIService;

/**
 * 
 * TODO binary zip 파일
 * 1. binary -> zip
 * 2. zip 해제 후 get CORPCODE.xml // path:src/main/resources/corpCode
 * 
 * */ 
public class CreateZip {
	private static final Logger logger = LoggerFactory.getLogger(CreateZip.class);
	private final int MAX_SIZE = 1024*1024;
	private String binaryData;
	
	public CreateZip(String binaryData) {
		this.binaryData = binaryData;
		getCorpCodeZipFile();
	}

	public String getBinaryData() {
		return binaryData;
	}

	public void setBinaryData(String binaryData) {
		this.binaryData = binaryData;
	}

	public void getCorpCodeZipFile() {
        byte[] buf = new byte[MAX_SIZE];
        ZipOutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        try {
            outputStream = new ZipOutputStream(new FileOutputStream("result.zip"));

            fileInputStream = new FileInputStream(this.binaryData);
            outputStream.putNextEntry(new ZipEntry(this.binaryData));

            int length = 0;
            while (((length = fileInputStream.read()) > 0)) {
                outputStream.write(buf, 0, length);
            }
            outputStream.closeEntry();
            fileInputStream.close();
            outputStream.close();
        } catch (IOException e) {
        	logger.error(e.getMessage());
        } finally {
            try {
                outputStream.closeEntry();
                outputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
            	logger.error(e.getMessage());
            }
        }
	}
	
}
