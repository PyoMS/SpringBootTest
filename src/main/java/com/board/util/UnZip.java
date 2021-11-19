package com.board.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.Inflater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//TODO Create 된 zip 파일 unzip
public class UnZip {
	private static final Logger logger = LoggerFactory.getLogger(UnZip.class);
	
	 /**
	   * 파일을 byte[] 으로 변환.
	   * 
	   * @param f
	   * @return
	   */
	public static byte[] convertFileToByteArr(File f) {
	    try {
//	      return FileUtils.readFileToByteArray(f);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return null;
	}
	
	public static byte[] unZip(byte[] data)
            throws Exception {
        Inflater decompressor = new Inflater();
        decompressor.setInput(data);

        ByteArrayOutputStream bos = new ByteArrayOutputStream(2048);

        byte[] buf = new byte[1024];
        int count = 0;
        while (!decompressor.finished()) {
            count = decompressor.inflate(buf);
            bos.write(buf, 0, count);
        }
        decompressor.end(); 
        bos.close();
        return bos.toByteArray();
    }
	
	public static String getString(byte[] data)
            throws Exception {

        Inflater decompressor = new Inflater();
        decompressor.setInput(data);

        ByteArrayOutputStream bos = new ByteArrayOutputStream(2048);

        byte[] buf = new byte[1024];
        int count = 0;
        while (!decompressor.finished()) {
            count = decompressor.inflate(buf);
            bos.write(buf, 0, count);
        }
        decompressor.end(); 
        bos.close();
        return new String(bos.toByteArray());
    }
	
}
