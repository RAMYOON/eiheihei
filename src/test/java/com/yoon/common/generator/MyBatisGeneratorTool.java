package com.yoon.common.generator;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * MyBatis的DAO生成工具
 *
 *
 */
public class MyBatisGeneratorTool {

	/**
	 * main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// 读取XML文件
			String path = MyBatisGeneratorTool.class.getResource("/").getPath();
			String fileName = "generatorConfig-automation.xml";
			String fullFileName = path + fileName;
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			File configFile = new File(fullFileName);
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
			outputMessage("成功生成DAO组件!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XMLParserException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 输出信息
	 * 
	 * @param msg
	 */
	public static void outputMessage(String msg) {
		int size = msg.getBytes().length;
		StringBuffer line = new StringBuffer();
		for (int i = 0; i < size; i++) {
			line.append("-");
		}
		System.out.println(line.toString());
		System.out.println(msg);
		System.out.println(line.toString());
	}
}
