<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
 #topTitle{
 	border-bottom: 2px solid rgb(51, 51, 51);
 }
 #history{
	display: flex;
    flex-wrap: wrap;
    align-content: flex-end;
 }
 #numCss{
 	text-align: left;
 }
</style>
<!-- begin cart -->

   <section class="shoping-cart spad">

        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__table">
                      	 <div id ="topTitle">
							<h3>주문 내역 상세</h3>
						</div>
                        <table>
                            <thead>
                            	<tr id = "numCss">
                            		<th>주문 번호</th>
                            		<th id = "num"></th>
                            	</tr>
                                <tr>
                                    <th class="shoping__product">상품 이미지</th>
                                    <th>이름</th>
                                    <th>가격</th>
                                    <th>갯수</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody id = "cartList" >
                                <tr style="display: none;">
                                    <td class="shoping__cart__item">
                                        <img src="img/cart/cart-1.jpg" alt="">
                                    </td>
                                    <td class = "shoping__cart__item_name">
                                    	<h5>Vegetable’s Package</h5>
                                    </td>
                                    <td class="shoping__cart__price">
                                        $55.00
                                    </td>
                                    <td class="shoping__cart__quantity">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>
                        
<script src = "kdwjs/orderHistory.js"></script>