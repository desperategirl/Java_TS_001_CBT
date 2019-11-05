package com.biz.cbt.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class QuestionsDTO {

	private int cb_num; //	varchar2(6 byte)
	private String cb_que; //	nvarchar2(125 char)

	
}
