package co.nambang.odproduct.vo;


import java.util.Date;

import lombok.Data;

@Data
public class OdProductVO {
	private int opNo;
	private int orderNo;
	private String productCode;
	private String userId;
	private int opVolume;
	private int opPrice;
	private String productImage;
	private String productName;
	private String company;
	private String opVolume1;
	private String opPrice1;
	private Date orderDate;
	private String orderNo1;
}
