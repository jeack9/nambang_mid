<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <style>
 #topItems{
 	border-bottom: 2px solid rgb(51, 51, 51);
 }
 </style>
 
 <!--  begin -->
 <form action = "woonControl8.do" name = "removeForm">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                	<div id ="topItems">
                		<h2>찜한 상품</h2>
			 			<span>찜한 상품은 최대 200개까지 저장됩니다.</span>
                	</div>
                    <div class="shoping__cart__table" >
                        <table>
                            <thead>
                                <tr>
                                    <th class="shoping__product">Products(name)</th>
                                    <th>Price</th>
                                    <th>offPrice</th>
                                    <th>Quantity</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody id = "itemsList">
                                <tr style="display: none;">
                                    <td class="shoping__cart__item">
                                        <img src = ''>
                                        <h5></h5>
                                    </td>
                                    <td class="shoping__cart__price">
                                        
                                    </td>
                                    <td class="shoping__cart__offprice">
                                    </td>
                                    <td class="shoping__cart__quantity">
                                        <div class="quantity">
                                            <div class="pro-qty">
                                                <input type="text" value="1">
                                            </div>
                                        </div>
                                    </td>
                                    <td class="shoping__cart__total">
                                    </td>
                                    <td class="shoping__cart__item__close">
                                        <button type = "submit"class = "btn btn-danger" id = "deleteBtn"><span>삭제</span></button>
                                    </td>
                                      <td class="shoping__cart__item__close">
                                        <button type = "button" class = "btn btn-warning" style = "color: rgb(95, 0, 128)"><span>담기</span></button>
                                    </td>
                                </tr>
                             
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
		 
 </form> 
<script src = "kdwjs/pick.js"></script>	