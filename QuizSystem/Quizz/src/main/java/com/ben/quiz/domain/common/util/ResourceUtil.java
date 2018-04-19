package com.ben.quiz.domain.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utilities for resource folder
 * 
 * @author QuangNV
 *
 */
public class ResourceUtil {

	private static Properties prop = new Properties();
	private static Logger logger = LoggerFactory.getLogger(ResourceUtil.class);

	public static InputStream readFile(String path) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
        return loader.getResourceAsStream(path);
	}

	public static String getProperty(String path, String key) {
		String value = "";
		try {
			prop.load(readFile(path));
			value = prop.getProperty(key);
		} catch (IOException e) {
			logger.error("Error: ", e.getMessage());
		}
		return value;
	}
	
}
