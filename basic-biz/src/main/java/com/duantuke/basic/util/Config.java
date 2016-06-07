package com.duantuke.basic.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.log4j.Logger;


public class Config {
	private static Logger logger = Logger.getLogger(Config.class);
	// public static final String SERVER_CFG = "netb";
	// private static final Map map = new HashMap();
	
	private static PropertiesConfiguration config = null;

	static {

		try {

			init();
		} catch (ConfigurationException e) {
			throw new RuntimeException("config.properties加载失败");
		}
	}
	public Config() {
		/**
		try {
			init();
		} catch (ConfigurationException e) {
			throw new RuntimeException("config.properties加载失败");
		}
		*/
	}

	/*
	* public static void init() { map.clear(); // majl 修改属性文件名称@20090313
	* ResourceBundle rb = ResourceBundle.getBundle(SERVER_CFG);
	* logger.debug("Config init..."); String key; String value; for(Enumeration
	* keys = rb.getKeys(); keys.hasMoreElements(); map.put(key, value)) { key =
	* (String)keys.nextElement(); value = rb.getString(key).trim(); }
	* 
	* }
	*/

	/**
	* 初始化配置文件并加载配置
	*/
	public static void init() throws ConfigurationException {
		config = new PropertiesConfiguration("config.properties");
		FileChangedReloadingStrategy change = new FileChangedReloadingStrategy();
		// 一分钟刷新一次
		change.setRefreshDelay(60000);
		config.setReloadingStrategy(new FileChangedReloadingStrategy());
	}
	/**
	* 
	* 读取配置文件中的字符串
	* @param key 键值
	* @return 对应的字符串值
	*/
	public static String getValue(String key) {
		// String value = (String)map.get(key);
		if (config == null)
			logger.error("config is null*****************");
		String value = config.getString(key);
		return value;
	}

	/**
	* 读取配置文件中的字符串(键值为'prefix.key'的形式)
	* @param prefix 键值前缀
	* @param key 键值
	* @return 对应的字符串值
	*/
	public static String getValue(String prefix, String key) {
		// String value = (String)map.get(key);
		String value = config.getString(prefix + "." + key);
		return value;
	}
	
	/**
	 * Config是否需要更新
	 * @return
	 */
	public static boolean reloadingRequired(){
		return config.getReloadingStrategy().reloadingRequired();
	}

}
