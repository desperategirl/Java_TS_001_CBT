package com.biz.cbt.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBConnection {

	private static SqlSessionFactory sqlSessionFactory = null;
	static {
		
		        // *-config.xml 파일을 읽어서 (퀄리파이드 네임)
				// mybatis 초기값 설정값을 가져오기
				String configFile = "com/biz/cbt/config/mybatis-config.xml";
				InputStream is  = null;
				
				/*
				 * java에서 어떤 setting 값들을 모아서
				 * 어떤 설정을 하는 용도로 사용한다.
				 * setting 값들을 쉽게 관리할 수 있도록 도와주는 class
				 */
				
				Properties pros = new Properties();
				
				/*
				 *  DBMS에 접근할 username과 password를 실제 값으로 적용하고
				 *  프로젝트를 실행할 것
				 */
				
				pros.put("username", "USERNAME");
				pros.put("password", "PASSWORD");
				
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