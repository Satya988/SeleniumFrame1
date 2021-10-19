package Mylog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4Jdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger=LogManager.getLogger(Log4Jdemo.class);
		logger.info("logger file info");
		logger.error("logger file error");
		logger.warn("logger file warn");
		logger.fatal("logger file fatal");
		logger.debug("debug");
		logger.trace("traceS");
		

	}

}
