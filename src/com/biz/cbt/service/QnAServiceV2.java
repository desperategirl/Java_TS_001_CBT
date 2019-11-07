package com.biz.cbt.service;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.biz.cbt.config.DBConnection;
import com.biz.cbt.dao.QnADao;
import com.biz.cbt.persistence.QAandAnsDTO;

// 문제입력을 선택하면 오게 되는 메서드

// 문제입력 메뉴를 보여주는 메서드가 있고,

// 1. 문제등록, 
// 2. 문제수정, 
// 3. 문제삭제,
// 4. 종료 메서드가 있다.
public class QnAServiceV2  {

	protected QnADao qnaDao;
	
	public QnAServiceV2() {

		SqlSession sqlSession = DBConnection.
				getSqlSessionFactory().
				openSession(true);

		// this.questionsDao = sqlSession.getMapper(QuestionsDao.class);
		this.qnaDao = sqlSession.getMapper(QnADao.class);
	    // this.answerDao = sqlSession.getMapper(AnswerDao.class);

	}
	
	Scanner scan = new Scanner(System.in);

	public void questionsViewMenu() { // 문제입력 메뉴를 보여주는 메서드

		System.out.println("======================================================");
		System.out.println("1. 문제등록   2. 문제수정   3. 문제삭제   4.종료 ");
		System.out.println("======================================================");
		System.out.println(" 번호를 눌러 메뉴를 선택하세요 >> ");

		int strMenu = Integer.valueOf(scan.nextLine());

		if (strMenu == 1) {
			questionsInsert(); // 1을 선택하면 문제등록 메서드

		} else if (strMenu == 2) {
			questionsUpdate(); // 2을 선택하면 문제수정 메서드

		} else if (strMenu == 3) {
			questionsDelete(); // 3을 선택하면 문제삭제 메서드

		} else if (strMenu == 4) { // 4를 선택하면 종료
			System.out.println(" 1-4. 종료를 선택하셨습니다. ");
		}

	}

	public void questionsInsert() { // 문제등록 메서드
		QAandAnsDTO qDTO = new QAandAnsDTO();

		System.out.println(" 1-1. 문제등록을 선택하셨습니다.");
		System.out.println();
		System.out.println("문제 번호 입력(Q000형식으로 입력하세요.) >> ");
		String strNewQuestionNumber = scan.nextLine();
		qDTO.setCb_num(strNewQuestionNumber);

		while (true) {
			System.out.println(" 새로운 문제 입력 >> ");
			String strNewQuestion = scan.nextLine();
			if (strNewQuestion.isEmpty()) {
				System.out.println(" 문제는 반드시 입력되어야합니다. 다시 입력하세요");
				continue;
			}
			else {
				qDTO.setCb_que(strNewQuestion);
				break;
			}
		}
		

		System.out.println(" 1번 답안 입력 >> ");
		String strNewAnswers = scan.nextLine();
		qDTO.setCb_a1(strNewAnswers);

		System.out.println(" 2번 답안 입력 >> ");
		strNewAnswers = scan.nextLine();
		qDTO.setCb_a2(strNewAnswers);

		System.out.println(" 3번 답안 입력 >> ");
		strNewAnswers = scan.nextLine();
		qDTO.setCb_a3(strNewAnswers);

		System.out.println(" 4번 답안 입력 >> ");
		strNewAnswers = scan.nextLine();
		qDTO.setCb_a4(strNewAnswers);

		System.out.println(" 정답 입력 >> ");
		strNewAnswers = scan.nextLine();
		qDTO.setCb_ans(strNewAnswers);

		System.out.println(qDTO.toString());
		qnaDao.insert(qDTO);

		System.out.println(" 새로운 문제가 등록되었습니다. ");

	}

	public void questionsUpdate() { // 문제수정 메서드

		QAandAnsDTO qnaDTO;

		System.out.println(" 1-2. 문제수정을 선택하셨습니다.");
		System.out.println();
		System.out.println(" 수정할 문제의 문제번호를 입력하세요 >> ");
		System.out.println(" 입력하실 문제번호의 형식은 Q000 입니다. >> ");

		// 문제번호를 입력해 문제를 수정
		String strQuestionsCode = scan.nextLine();
		qnaDTO = qnaDao.findByNum(strQuestionsCode);

		if (strQuestionsCode == qnaDTO.getCb_num()) {

			System.out.println(" 1번 답안 입력 >> ");
			String strNewAnswers = scan.nextLine();
			if (strNewAnswers.isEmpty())
				;
			else
				qnaDTO.setCb_a1(strNewAnswers);

			System.out.println(" 2번 답안 입력 >> ");
			strNewAnswers = scan.nextLine();
			if (strNewAnswers.isEmpty())
				;
			else
				qnaDTO.setCb_a2(strNewAnswers);

			System.out.println(" 3번 답안 입력 >> ");
			strNewAnswers = scan.nextLine();
			if (strNewAnswers.isEmpty())
				;
			else
				qnaDTO.setCb_a3(strNewAnswers);

			System.out.println(" 4번 답안 입력 >> ");
			strNewAnswers = scan.nextLine();
			if (strNewAnswers.isEmpty())
				;
			else
				qnaDTO.setCb_a4(strNewAnswers);

			System.out.println(" 정답 입력 >> ");
			strNewAnswers = scan.nextLine();
			if (strNewAnswers.isEmpty())
				;
			else {
				qnaDTO.setCb_ans(strNewAnswers);
			}

			System.out.println(qnaDTO.toString());
			qnaDao.update(qnaDTO);

			System.out.println(" 문제가 수정되었습니다. ");

		}

	}

	public void questionsDelete() { // 문제삭제 메서드

		System.out.println(" 1-3. 문제삭제를 선택하셨습니다. ");
		System.out.println(" 삭제하실 문제의 번호를 입력하세요. ");
		System.out.println(" 입력하실 문제번호의 형식은 Q000 입니다. >> ");

		// 문제번호를 입력해 문제를 선택하고 삭제
		String strQuestionsCode = scan.nextLine();
		System.out.println(" 입력하신 문제번호는 " + strQuestionsCode + "입니다.");
		System.out.println(" 정말로 삭제하시겠습니까?(Y/N) ");
		
		String YesOrNo = scan.nextLine();
		
		if (YesOrNo.equalsIgnoreCase("Y")) {
			
			qnaDao.delete(strQuestionsCode);
			System.out.println(" 문제가 삭제되었습니다. ");
		
		} else if (YesOrNo.equalsIgnoreCase("N"))
			System.out.println(" 문제 삭제를 수행하지 않습니다. ");
		else
			System.out.println(" y와 n 둘 중에 하나를 선택하여 입력하세요. ");

		/*
		 * QAandAnsDTO qnaDTO; strQuestionsCode = scan.nextLine(); qnaDTO =
		 * qnaDao.findByNum(strQuestionsCode);
		 * 
		 * if (strQuestionsCode == qnaDTO.getCb_num()) { qnaDao.delete2(qnaDTO); }
		 * 
		 * 
		 */

	}

}
