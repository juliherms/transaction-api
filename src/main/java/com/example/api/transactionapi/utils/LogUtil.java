package com.example.api.transactionapi.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class responsible to log
 * @author j.a.vasconcelos
 *
 */
public class LogUtil {

	private static final Logger logger = LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());

	public static void error(String messagem) {
		logger.error(messagem);
	}

	public static void info(String messagem) {
		logger.info(messagem);
	}

	public static void warning(String messagem) {
		logger.warn(messagem);
	}

	public static void error(Exception exception) {
		exception.printStackTrace();
	}

}
