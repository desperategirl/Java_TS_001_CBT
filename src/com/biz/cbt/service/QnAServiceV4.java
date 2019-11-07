package com.biz.cbt.service;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.biz.cbt.config.DBConnection;
import com.biz.cbt.dao.AnswerDao;
import com.biz.cbt.dao.QnADao;
import com.biz.cbt.dao.QuestionsDao;

// 문제은행의 시작메뉴의 method가 있는 클래스.
// 문제를 CRUD하는 메뉴와 만들어진 문제를 푸는 메뉴가 있다
public class QnAServiceV4 {

	protected QuestionsDao questionsDao;
	protected QnADao answersDao;
	protected AnswerDao answerDao;
	Scanner scan = new Scanner(System.in);

	// 문제입력을 선택한 후
	// 문제등록, 문제수정, 문제삭제 메서드를 불러와 
	// 작업을 수행하게 하기 위해 
	// 세 메서드들이 있는 클래스의 인스턴스를 만들었다.
	QnAServiceV2 qNa2 = new QnAServiceV2();
	
	// 문제풀이를 선택한 후
	// 문제풀이 메서드를 불러와
	// 작업을 수행하게 하기 위해
	// 문제풀이 메서드가 있는 클래스의 인스턴스를 만들었다.
	QnAServiceV3 qNa3 = new QnAServiceV3();

	/*
	public QnAServiceV1() {

		SqlSession sqlSession = DBConnection.
				getSqlSessionFactory().
				openSession(true);

		this.questionsDao = sqlSession.getMapper(QuestionsDao.class);
		this.answersDao = sqlSession.getMapper(AnswersDao.class);
	    this.answerDao = sqlSession.getMapper(AnswerDao.class);

	}
	*/

	public void viewStartMenu() { // 맨 처음 시작메뉴

		while (true) {
		
			System.out.println("=============================================");
			System.out.println("1. 문제입력   2. 문제풀이   3. 종료");
			System.out.println("=============================================");
			System.out.println(" 번호를 눌러 메뉴를 선택하세요 >> ");
			int strMenu = Integer.valueOf(scan.nextLine());
			if (strMenu == 1) {
				qNa2.questionsViewMenu(); // 1. 문제입력메뉴 메서드로
			} else if (strMenu == 2) {
				qNa3.questionsSolution(); // 2. 문제풀이 메서드로
			} else if (strMenu == 3) { // 종료
				System.out.println(" 선택을 종료합니다. ");
			} else {
				System.out.println("숫자만 입력하세요.");
			}
		}
	}

	

}
