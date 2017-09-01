package com.g10.ssm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * @ClassName: CustomDateConverter
 * @Description: 自定义的类型转换器
 * @author 	FYW
 * @date 	2017年8月10日 上午9:57:19
 */
public class CustomDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String arg0) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			return simpleDateFormat.parse(arg0);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
