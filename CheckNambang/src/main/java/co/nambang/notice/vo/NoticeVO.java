package co.nambang.notice.vo;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeVO {
	private int noticeNo;
	private String noticeTitle;
	private String noticeWriter;
	private Date noticeCreation;
	private String noticeContent;
}