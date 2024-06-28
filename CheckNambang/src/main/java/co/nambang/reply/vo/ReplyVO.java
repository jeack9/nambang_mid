package co.nambang.reply.vo;


import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int qnaNo;
	private String replyContent;
	private Date replyDate;
	
}
