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

    /**
     * 获取全局配置文件中参数key对应的值
     * @param key 全局配置文件的键
     * @return 返回一个字符串，该字符串是参数key对应的值，如getProperties(server_url)的返回值为: "http://127.0.0.1/"
     */
    public static String getProperties(String key) {
        if(configuration == null) {
            loadProperties();
        }
        String result = configuration.getString(key);
        return result;
    }
}
