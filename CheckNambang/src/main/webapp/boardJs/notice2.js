/**
 * 
 */
let query = window.location.search;
let param = new URLSearchParams(query);
let notice = param.get('no');

fetch('sooControl2.do?no=' + notice)
		.then(result => result.json())
		.then(result => {
			result.forEach((ele) => {
				console.log(ele);
				document.querySelector('tbody tr:nth-of-type(1) td.col-sm-7').innerHTML = ele.noticeTitle;
				document.querySelector('tbody tr:nth-of-type(2) td.col-sm-7').innerHTML = ele.noticeWriter;
				document.querySelector('tbody tr:nth-of-type(3) td.col-sm-7').innerHTML = ele.noticeCreation;
				document.querySelector('tbody tr td.col-sm-9').innerHTML = ele.noticeContent;
			});
		});

