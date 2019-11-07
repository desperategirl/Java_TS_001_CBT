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

public class QAandAnsDTO {
	
	private String cb_num; // 	varchar2(6 byte)
	private String cb_que; // 	nvarchar2(125 char)
	private String cb_a1; // 	nvarchar2(125 char)
	private String cb_a2; // 	nvarchar2(125 char)
	private String cb_a3; // 	nvarchar2(125 char)
	private String cb_a4; // 	nvarchar2(125 char)
	private String cb_ans; // 	nvarchar2(125 char)
}
