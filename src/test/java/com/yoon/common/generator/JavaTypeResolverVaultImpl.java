package com.yoon.common.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

/**
 * 自定义Java类型解析器
 * 
 * @author yuxixuan
 *
 */
public class JavaTypeResolverVaultImpl extends JavaTypeResolverDefaultImpl {
	@Override
	protected FullyQualifiedJavaType calculateBigDecimalReplacement(IntrospectedColumn column,
			FullyQualifiedJavaType defaultType) {
		FullyQualifiedJavaType answer;

		if (column.getScale() > 0 || column.getLength() > 18 || forceBigDecimals) {
			answer = defaultType;
		} else if (column.getLength() > 9) {
			answer = new FullyQualifiedJavaType(Long.class.getName());
		} else {
			answer = new FullyQualifiedJavaType(Integer.class.getName());
		}
		return answer;
	}
}
