package com.yoon.eiheihei.conf;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Global {

    private static Configuration configuration = null;

    private Global() {

    }

    /**
     * 加载sys.properties配置文件
     */
    public static void loadProperties() {
        try {
            configuration = new PropertiesConfiguration("sys.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static String getProperties(String key) {
        if(configuration == null) {
            loadProperties();
        }
        String result = configuration.getString(key);
        return result;
    }
}
