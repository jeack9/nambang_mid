package co.nambang.hugi.vo;

import java.util.Date;

import lombok.Data;

@Data
public class HugiVO {
	private int hugiNo;
	private String hugiContent;
	private Date hugiDate;
	private int hugiGood; //후기 추천수
	private String hugiImage;
	private String userId;
	private String productCode;
	private String opNo; // 주문상세번호
	private String userName;
}
