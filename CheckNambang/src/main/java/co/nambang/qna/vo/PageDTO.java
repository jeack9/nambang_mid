package co.nambang.qna.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageDTO {
	private int startPage, endPage; // 현재 페이지 기준 10개페이징 스타트, 엔드
	private boolean prev, next;
	private int page; // 현재페이지
	private String userId; 
	
	public PageDTO(int page, int totalCtn) {
		this.page = page; // 현재페이지
		this.endPage = (int) (Math.ceil(page / 5.0) * 5); // 10개의 페이지 버튼 제공
		this.startPage = this.endPage - 4;
		
		int realEnd = (int)Math.ceil(totalCtn / 5.0); //실제 마지막 페이지번호
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage;
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
