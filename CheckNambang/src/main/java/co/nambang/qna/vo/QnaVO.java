package co.nambang.qna.vo;


import java.util.Date;

import lombok.Data;

@Data
public class QnaVO {
	private int qnaNo;
	private int orderNo;
	private String userId;
	private String qnaType1;
	private String qnaType2;
	private String qnaTitle;
	private String qnaContent;
	private Date qnaDate;
	private String qnaImage;
	private int qnaState;
}
