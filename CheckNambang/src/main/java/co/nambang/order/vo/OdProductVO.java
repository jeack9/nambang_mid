package co.nambang.order.vo;


import java.util.Date;

import lombok.Data;

@Data
public class OdProductVO {
	private int orderNo;
	private int addrNo;
	private int orderPrice;
	private String orderYocheong;
	private Date orderDate;
}
