package co.nambang.pthistory.vo;


import java.util.Date;

import lombok.Data;

@Data
public class PtHistoryVO {
	private int pointNO;
	private int point;
	private Date pointDate;
	private String pointReason;
	private String userId;
}
