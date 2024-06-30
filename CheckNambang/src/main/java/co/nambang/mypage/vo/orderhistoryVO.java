package co.nambang.mypage.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class orderhistoryVO {
	private String productName;
	private int orderNo;
	private int opVolume;
	private Date orderDate;
	private int orderPrice;
	private String userId;
}
