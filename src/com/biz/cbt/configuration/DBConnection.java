package com.biz.cbt.configuration;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBConnection {

	private static SqlSessionFactory sqlSessionFactory = null;
	static {
		
		        // *-config.xml 파일을 읽어서 (퀄리파이드 네임)
				// mybatis 초기값 설정값을 가져오기
				String configFile = "com/biz/cbt/configuration/mybatis-config.xml";
				InputStream is  = null;
				
				try {
					// configFile을 읽어오는 절차
					is = Resources.getResourceAsStream(configFile);
					
					// sqlSessionFactory을 싱글톤으로 생성하기 위한 절차
					SqlSessionFactoryBuilder sessionBuilder
					= new SqlSessionFactoryBuilder();
					if(sqlSessionFactory == null) {
						sqlSessionFactory = sessionBuilder.build(is);
					}
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
		
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		
		return sqlSessionFactory;
	}
	
}