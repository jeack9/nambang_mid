package co.nambang.odproduct.vo;


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
}
