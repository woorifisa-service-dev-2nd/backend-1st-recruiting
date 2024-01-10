package dev.recruit.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ResultLog {
	public ResultLog(Logger logger){
		try {
			final String fileName = "myfile.log";
			Handler fileHandler = new FileHandler(fileName);
			
			Formatter logFormatter = new SimpleFormatter();
			
			fileHandler.setFormatter(logFormatter);
			
			logger.addHandler(fileHandler);
			
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// 로그 파일에 로그 저장하는 메서드
	public void saveLog(Logger logger, String str) {
		logger.log(Level.INFO, str);
	}

}
