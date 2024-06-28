package co.nambang.cart.vo;

import lombok.Data;

@Data
public class CartVO {
	private String productCode;
	private int cartVolume;
	private String userId;
}
