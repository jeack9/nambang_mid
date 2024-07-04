package co.nambang.cart.vo;

import co.nambang.product.vo.ProductVO;
import lombok.Data;

@Data
public class CartVO {
	private String productCode;
	private int cartVolume;
	private String userId;
	private ProductVO pvo;
}
