package com.biz.cbt.service;

import java.util.Scanner;

// 문제입력을 선택하면 오게 되는 메서드

// 문제입력 메뉴를 보여주는 메서드가 있고,

// 1. 문제등록, 
// 2. 문제수정, 
// 3. 문제삭제,
// 4. 종료 메서드가 있다.
public class QnAServiceV2 {

	Scanner scan = new Scanner(System.in);

	public void questionsViewMenu() { // 문제입력 메뉴를 보여주는 메서드

		System.out.println("======================================================");
		System.out.println("1. 문제등록   2. 문제수정   3. 문제삭제   4.종료 ");
		System.out.println("======================================================");
		System.out.println(" 번호를 눌러 메뉴를 선택하세요 >> ");

		int strMenu = Integer.valueOf(scan.nextLine());

		if (strMenu == 1) {
			questionsCreate(); // 1을 선택하면 문제등록 메서드

		} else if (strMenu == 2) {
			questionsInsert(); // 2을 선택하면 문제수정 메서드

		} else if (strMenu == 3) {
			questionsDelete(); // 3을 선택하면 문제삭제 메서드

		} else if (strMenu == 4) { // 4를 선택하면 종료
			System.out.println(" 1-4. 종료를 선택하셨습니다. ");
		}

	}

	public void questionsCreate() { // 문제등록 메서드

		System.out.println(" 1-1. 문제등록을 선택하셨습니다.");
		System.out.println();
		System.out.println(" 새로운 문제 입력 >> ");
		String strNewQuestion = scan.nextLine();

		System.out.println(" 1번 답안 입력 >> ");
		String strNewAnswers = scan.nextLine();
		System.out.println(strNewAnswers);

		System.out.println(" 2번 답안 입력 >> ");
		strNewAnswers = scan.nextLine();
		System.out.println(strNewAnswers);

		System.out.println(" 3번 답안 입력 >> ");
		strNewAnswers = scan.nextLine();
		System.out.println(strNewAnswers);

		System.out.println(" 4번 답안 입력 >> ");
		strNewAnswers = scan.nextLine();
		System.out.println(strNewAnswers);

		System.out.println(" 정답 번호 입력 >> ");
		int answer = Integer.valueOf(scan.nextLine());
		System.out.println(answer);

		System.out.println(" 새로운 문제가 등록되었습니다. ");

	}

	public void questionsInsert() { // 문제수정 메서드

		System.out.println(" 1-2. 문제수정을 선택하셨습니다.");
		System.out.println();
		System.out.println(" 수정할 문제의 문제번호를 입력하세요 >> ");
		System.out.println(" 입력하실 문제번호의 형식은 Q000 입니다. >> ");

		String strQuestionsCode = scan.nextLine(); // 문제번호를 입력해 문제를 수정

		System.out.println(" 1번 답안 입력 >> ");
		String strNewAnswers = scan.nextLine();
		System.out.println(strNewAnswers);

		System.out.println(" 2번 답안 입력 >> ");
		strNewAnswers = scan.nextLine();
		System.out.println(strNewAnswers);

		System.out.println(" 3번 답안 입력 >> ");
		strNewAnswers = scan.nextLine();
		System.out.println(strNewAnswers);

		System.out.println(" 4번 답안 입력 >> ");
		strNewAnswers = scan.nextLine();
		System.out.println(strNewAnswers);

		System.out.println(" 정답 번호 입력 >> ");
		int answer = Integer.valueOf(scan.nextLine());
		System.out.println(answer);

		System.out.println(" 문제가 수정되었습니다. ");

	}

	public void questionsDelete() { // 문제삭제 메서드
		
		System.out.println(" 1-3. 문제삭제를 선택하셨습니다. ");
		System.out.println(" 삭제하실 문제의 번호를 입력하세요. ");
		System.out.println(" 입력하실 문제번호의 형식은 Q000 입니다. >> ");

		// 문제번호를 입력해 문제를 선택하고 삭제
		String strQuestionsCode = scan.nextLine();

		System.out.println(" 정말로 삭제하시겠습니까? ");

	}

}
