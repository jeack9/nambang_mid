/**
 * moJs/test.js
 */
let data = window.location.search;
let param = new URLSearchParams(data);
let proCode = param.get('proCode');

//let zzimProCode = [];
let totalCnt = document.querySelector('#totalCnt').value;
let zzimbtnList = document.querySelector('#zzimBtnClass');
let cartbtnList = document.querySelector('#cartBtnClass');
let offList = document.querySelector('#offList');


//zzim productCode 비교
let zzimCode;

let page = 1;

// 후기 행 만들기
function makeHugi(page) {
    let hugiList = document.querySelector('#hugiList');
    hugiList.innerHTML = '';
    fetch('mocontrol5.do?proCode=' + proCode + '&page=' + page)
        .then(result => result.json())
        .then(result => result.forEach((hugi) => {
            let tr = document.createElement('tr');
            
            // 필드 1 추가
            let th = document.createElement('th');
            th.innerHTML = hugi.userName;
            tr.appendChild(th);

            let img1 = document.createElement('img');
            let imageName = hugi.hugiImage;
            let encodedImageName = encodeURIComponent(imageName);
            let imagePath = 'image/' + encodedImageName;
            img1.src = imagePath;
            img1.setAttribute('id', 'hugiImg');
            tr.appendChild(img1);
            
            // 필드 2 추가
            let tdCompanyProduct = document.createElement('td');
            tdCompanyProduct.innerHTML = hugi.company + hugi.productName;
            tr.appendChild(tdCompanyProduct);

            let tdDate = document.createElement('td');
            tdDate.innerHTML = hugi.hugiDate;
            tr.appendChild(tdDate);

            let tdContent = document.createElement('td');
            tdContent.innerHTML = hugi.hugiContent;
            tr.appendChild(tdContent);

            hugiList.appendChild(tr);
        }));
}

function updatePaging(currentPage) {
    let paging = document.querySelectorAll('.hugipaging a');
    paging.forEach(a => {
        a.classList.remove('active');
        if (parseInt(a.getAttribute('data-page')) === currentPage) {
            page = currentPage;
            a.classList.add('active');
            console.log(page,'ppp');
        }
    });
}

function createPaging(totalCnt) {
    let hugiPaging = document.querySelector('.hugipaging');

    let startPage, endPage;
    let prev, next;
    let realEnd = Math.ceil(totalCnt / 5);

    endPage = Math.ceil(page / 10) * 10;
    startPage = endPage - 9;
    endPage = endPage > realEnd ? realEnd : endPage;

    prev = startPage > 1;
    next = endPage < realEnd;

    hugiPaging.innerHTML = '';
    
    if (prev) {
        let a = document.createElement('a');
        a.setAttribute('class', 'aTag');
        a.setAttribute('data-page', startPage - 1);
        a.setAttribute('href', '#');
        a.innerHTML = "&laquo";
        a.addEventListener('click', function(e) {
            e.preventDefault();
            page = parseInt(a.getAttribute('data-page'));
            updatePaging(page);
            makeHugi(page);
            createPaging(totalCnt); // 페이지 변경 시 페이징 갱신
        });
        hugiPaging.appendChild(a);
    }

    for (let p = startPage; p <= endPage; p++) {
        let a = document.createElement('a');
        a.setAttribute('data-page', p);
        a.setAttribute('href', '#');
        a.innerHTML = p;

        if (page == p) {
            a.className = 'active';
        }
        a.addEventListener('click', function(e) {
            e.preventDefault();
            page = parseInt(a.getAttribute('data-page'));
            updatePaging(page);
            makeHugi(page);
            createPaging(totalCnt); // 페이지 변경 시 페이징 갱신
        });
        hugiPaging.appendChild(a);
    }

    if (next) {
        let a = document.createElement('a');
        a.setAttribute('data-page', endPage + 1);
        a.setAttribute('href', '#');
        a.innerHTML = "&raquo";
        a.addEventListener('click', function(e) {
            e.preventDefault();
            page = parseInt(a.getAttribute('data-page'));
            updatePaging(page);
            makeHugi(page);
            createPaging(totalCnt); // 페이지 변경 시 페이징 갱신
        });
        hugiPaging.appendChild(a);
    }
}

function countPaging() {
    fetch('mocontrol8.do?proCode=' + proCode)
        .then(result => result.json())
        .then(result => {
            let totalCnt = result; // 댓글 건수
            createPaging(totalCnt);
        });
}

countPaging();	
		


// zzimCode 의 값에 따라 처리.
fetch('mocontrol7.do?proCode=' + proCode + '&userId=' + login)
	.then(result => result.json())
	.then(result => {
		if (result.retCode == 'OK') {
			document.querySelector("#zzimhart").setAttribute('class', 'icon_heart_alt');
		} else {
			document.querySelector("#zzimhart").setAttribute('class', 'icon_heart');
		}

		fetch('mocontrol2.do?proCode=' + proCode)
			.then(result => result.json())
			.then(result => result.product.forEach(pro => {

				let img = document.querySelector('.product__details__pic__item--large')

				let imageName = pro.productImage;
				if (!imageName.includes('.')) {
					imageName += '.jpg'; // 확장자를 추가, 필요 시 다른 확장자로 변경 가능
				}
				
				let encodedImageName = encodeURIComponent(imageName);
    			let imagePath = 'image/' + encodedImageName;
    			img.src = imagePath;
    			
				img.onerror = function() {
			        console.error('이미지를 불러오지 못했습니다: ' + imagePath);
			      
			    };

				let title = document.querySelector('#titleList');
				title.innerHTML = pro.company + pro.productName;

				let price = document.querySelector('.product__details__price');
				let price2 = document.querySelector('.product__details__price2');
				let offBtn = document.createElement('button');
				let offImg = document.createElement('img');
				if (pro.offPrice == 0) {
					price.innerHTML = pro.price + '원';
				} else if (pro.offPrice != 0) {
					price.innerHTML = pro.offPrice + '원';
					price2.innerHTML = pro.price + '원';

					offBtn.setAttribute('type', 'button');
					offBtn.setAttribute('data-toggle', 'modal');
					offBtn.setAttribute('data-target', '#exampleModalScrollable');
					offBtn.setAttribute('id', 'imgBtn');

					offImg.src = 'moImg/물음표.png'
					offImg.setAttribute('id', 'offImg');
					offBtn.appendChild(offImg);

					offList.appendChild(offBtn);

					let priceInfo = document.querySelector('#priceInfo');
					let offInfo = document.querySelector('#offInfo');
					priceInfo.innerHTML = pro.price + '원';
					offInfo.innerHTML = pro.offPrice + '원';
				}


				let text = '23시 이전주문 시 내일 아침 7시 전 도착\n(대구,부산,울산 샛별배송 운영시간 별도 확인)';
				fields1 = ['배송', '포장타입', '중량/용량', '상품선택'];
				fields2 = [text, pro.packageType, pro.weight, pro.company + pro.productName + pro.weight]
				let list = document.querySelector('#detailList');

				fields1.forEach((field, idx, arry) => {
					let tr = document.createElement('tr');
					let td = document.createElement('td');
					th = document.createElement('th');

					th.innerText = field;

					if (idx == 2 || idx == arry.length - 1) {
						if (pro.weight >= 1000) td.innerText = fields2[idx] + "kg";
						else td.innerText = fields2[idx] + "g";
					}
					else td.innerText = fields2[idx];
					tr.appendChild(th);
					tr.appendChild(td);

					list.appendChild(tr);
				});


				let endPrice = document.querySelector('#endPrice');
				document.querySelector('.pro-qty').addEventListener('click', function() {
					totalCnt = document.querySelector('#totalCnt').value;
					if (pro.offPrice == 0) {
						endPrice.innerHTML = '총 상품금액 : ' + (totalCnt * pro.price) + '원';
					} else if (pro.offPrice != 0) {

						endPrice.innerHTML = '총 상품금액 : ' + (totalCnt * pro.offPrice) + '원';
					}
				})
				if (pro.offPrice == 0) {
					endPrice.innerHTML = '총 상품금액 : ' + pro.price + '원';
				} else if (pro.offPrice != 0) {

					endPrice.innerHTML = '총 상품금액 : ' + pro.offPrice + '원';
				}


				let descrip = document.querySelector('#tabs-1');
				let p = document.createElement('p')
				p.innerHTML = pro.descript;
				descrip.appendChild(p);

				let info = document.querySelector('#tabs-2');
				img = document.createElement('img');
				let infoImg = pro.descriptImage;
				if (!infoImg.includes('.')) {
					infoImg += '.jpg'; // 확장자를 추가, 필요 시 다른 확장자로 변경 가능
				}
				let encodedImageName2 = encodeURIComponent(infoImg);
    			let imagePath2 = 'image/' + encodedImageName2;
				
				img.src = imagePath2;
				info.appendChild(img);
				img.onerror = function() {
			        console.error('이미지를 불러오지 못했습니다: ' + imagePath2);
			      
			    };
				
				makeHugi(page);
			}))
			.catch(err => console.log(err));
	})


	/
	//페이징 시 원댓글 삭제

	//찜 추가,삭제
	document.querySelector('#zzimBtn').addEventListener('click', function() {
		if (document.querySelector('#zzimhart').getAttribute('class') == 'icon_heart_alt') {
			fetch('mocontrol3.do?proCode=' + proCode + '&userId=' + login)
				.then(result => result.json())
				.then(result => {
					if (result.retCode == 'OK') {
						document.querySelector('#zzimhart').setAttribute('class', 'icon_heart');
						alert('찜 등록 성공');
					}
				})
		} else {
			fetch('mocontrol6.do?proCode=' + proCode)
				.then(result => result.json())
				.then(result => {
					if (result.retCode == 'OK') {
						document.querySelector('#zzimhart').setAttribute('class', 'icon_heart_alt');
						alert('찜 삭제 성공');

					}
				})
		}
	})

document.querySelector('.primary-btn').addEventListener('click', cartFnc);
function cartFnc() {
	fetch('mocontrol4.do?proCode=' + proCode + '&userId=' + login + '&cartVolume=' + totalCnt)
		.then(result => result.json())
		.then(result => {
			if (result.retCode == 'OK') {
				alert('장바구니 등록 성공');
			} else if (result.retCode == 'NG') {
				alert('장바구니 등록 실패');
			}
		})
}

