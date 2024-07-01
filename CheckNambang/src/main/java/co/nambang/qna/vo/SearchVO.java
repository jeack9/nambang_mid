package co.nambang.qna.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 검색조건을 담는 클래스.
 */
 
@Data
@AllArgsConstructor
@NoArgsConstructor

public class SearchVO {
	private int page;
	private int searchCondition; // 0: 답변대기, 1: 답변완료
	private String keyword; // 제목
	private String userId;
}
