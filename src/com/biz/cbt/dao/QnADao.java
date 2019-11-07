package com.biz.cbt.dao;

import com.biz.cbt.persistence.QAandAnsDTO;

public interface QnADao {

	// qDTO를 이용해서 테이블 tbl_cbt_test에 문제등록
	public void insert(QAandAnsDTO qDTO); 

	// strQuestionsCode 매개변수를 이용해서 DB에서 CB_NUM과 맞는 데이터를 가져오기
	public QAandAnsDTO findByNum(String strQuestionsCode); 

	// qnaDTO를 이용해서 테이블의 cb_num과 qnaDTO의 cb_num이 같은 데이터를 수정
	public void update(QAandAnsDTO qnaDTO);

	// 매개변수 qnaDTO의 cb_num과 DB의 CB_NUM이 같으면 지우라는 SQL DELETE문
	public void delete2(QAandAnsDTO qnaDTO); // 이건 안 씀
	
	// 매개변수 내용이 DB에서 CB_NUM과 같으면 지워버리라는 SQL DELETE문
	public void delete(String strQuestionsCode); 
	
	
}
