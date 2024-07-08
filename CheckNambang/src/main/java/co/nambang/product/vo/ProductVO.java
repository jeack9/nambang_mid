package co.nambang.product.vo;


import lombok.Data;

@Data
public class ProductVO {
	private String productCode;
	private String productName;
	private int price;
	private int offPrice;
	private int weight;
	private String packageType;
	private String company;
	private String descriptImage;
	private String descript;
	private String productImage;
	private String category;
	private int volume;
	private int viewCnt;
	private int salesVolume;
	private String brandChosung;
	private int productBonus; // 상품별 적립금
	private int searchCondition; // 0: 답변대기, 1: 답변완료
}
