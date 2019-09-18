package com.yipai.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;


public class ConfigUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigUtil.class);
	
	private static Properties props;
	
	static{
        loadProps();
    }
	
	synchronized static private void loadProps(){
        props = new Properties();
        InputStream in = null;
        try {
        	// 通过类加载器进行获取properties文件流
            in = ConfigUtil.class.getClassLoader().getResourceAsStream("resource/config.properties");
            props.load(in);
        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException",e);
        } catch (IOException e) {
            LOGGER.error("IOException",e);
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
                LOGGER.error("IOException",e);
            }
        }
    }
	
	public static String getProperty(String key){
        if(null == props) {
            loadProps();
        }
        String value = null;
        try {
			value = new String(props.getProperty(key).getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("UnsupportedEncodingException",e);
		}
        
        return value;
    }

    public static String getProperty(String key, String defaultValue) {
        if(null == props) {
            loadProps();
        }
        String value = null;
        try {
			value = new String(props.getProperty(key, defaultValue).getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("UnsupportedEncodingException",e);
		}
        
        return value;
    }
}
