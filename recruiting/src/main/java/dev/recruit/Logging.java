package dev.recruit;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Logging {
	
	// 로깅을 수행할 Logger 객체 생성
	static final Logger logger = Logger.getLogger(Logging.class.getName());

	private static FileHandler fileHandler;
	static {
		try {
			fileHandler = new FileHandler("log-file/logfile%g", 200, 1100, true);


			logger.addHandler(fileHandler);
			logger.setFilter(new CustomFilter());
			
			
			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);
			
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void log(Level level, String message) {
        logger.log(level, message);
	}
}
