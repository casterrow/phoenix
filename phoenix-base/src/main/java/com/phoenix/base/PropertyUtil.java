package com.phoenix.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 
 * @author casterrow@163.com, Stephen Lau
 * @date Aug 19, 2015
 * @version 1.0
 *
 */
public class PropertyUtil extends PropertyPlaceholderConfigurer {

	/**
	 * Store key-value pairs from Spring container.
	 */
	private static Map<String, Object> ctxMap = new HashMap<String, Object>();
	
	
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
		
		for (Object key : props.keySet()) {
			//Put key-value pairs to a map.
			ctxMap.put(key.toString(), props.getProperty(key.toString()));
		}
		
	}
	
	
}
