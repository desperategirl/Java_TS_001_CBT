package com.biz.cbt.service;

import org.apache.ibatis.session.SqlSession;

import com.biz.cbt.config.DBConnection;
import com.biz.cbt.dao.QnADao;

// 문제풀이 메서드가 있는 클래스

public class QnAServiceV3 {

	protected QnADao qnaDao;

	public QnAServiceV3() {

		SqlSession sqlSession = DBConnection.
				getSqlSessionFactory().
				openSession(true);

		// this.questionsDao = sqlSession.getMapper(QuestionsDao.class);
		this.qnaDao = sqlSession.getMapper(QnADao.class);
	    // this.answerDao = sqlSession.getMapper(AnswerDao.class);

	}

	public void questionsSolution() { // 문제풀이 메서드
		System.out.println("2. 문제풀이를 선택하셨습니다. ");

	}

}
