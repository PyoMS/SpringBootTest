package com.board.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ReadFile {
	private static final Logger logger = LoggerFactory.getLogger(ReadFile.class);
	private String data;
	
	public ReadFile(Path path) {
		try {
			File file = new File(path.toString());
			if(!file.exists()){throw new FileNotFoundException();}
			this.data = Files.readAllLines(path).get(0);
			if(data.contains("=")) {
				data = data.substring(data.indexOf('=')+1);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public String getStringData() {
		return this.data;
	}
	
}
