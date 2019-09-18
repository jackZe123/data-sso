/**   
* @Title: DateConvert.java 
* @Package com.haocang.project.swagger 
* @Description: TODO(用一句话描述该文件做什么) 
* @author （zxx）  
* @date 2017年12月13日 下午3:29:40 
* @version V1.0   
*/
package com.yipai.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/** 
* @ClassName: DateConvert 
* @Description: TODO(公司: 上海昊沧系统控制技术有限责任公司) 
* 
* @author (何戎欣)  
* @date 2017年12月13日 下午3:29:40 
* @ClassName: DateConvert
* @param     参数
* @return return_type    返回类型
* @throws
* @version V1.0
* @Title: enclosing_method  
*/
public class DateConvert implements Converter<String, Date>{

	/* (非 Javadoc) 
	* <p>Title: convert</p> 
	* <p>Description: </p> 
	* @param arg0
	* @return 
	* @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object) 
	*/
	@Override
	public Date convert(String stringDate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        try {  
            return simpleDateFormat.parse(stringDate);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        return null;  
	}


}
