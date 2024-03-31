package user.bean;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class UserPaging {
	private int currentPage;//
	private int pageBlock;//
	private int pageSize;//
	private int totalA;//
	private StringBuffer pagingHTML;
	
	public void makePaingHTML() {
		pagingHTML = new StringBuffer();
		
		int totalP = (totalA + pageSize-1) / pageSize;//
		
		int startPage = (currentPage-1) / pageBlock * pageBlock + 1;
		
		int endPage = startPage + pageBlock - 1;
		
		if(endPage > totalP) endPage = totalP;
		
		if(startPage != 1)
			pagingHTML.append("<span id='paging' onclick='userPaging(" + (startPage-1) + ")'이전</span>");
		
		for(int i=startPage; i<=endPage; i++) {
			if(i == currentPage)
				pagingHTML.append("<span id='currentPaging' onclick='userPaging(" + i + ")'>" + i + "</span>");         
			else
				pagingHTML.append("<span id='paging' onclick='userPaging(" + i + ")'>" + i + "</span>");
		}
		
		if(endPage < totalP)
			pagingHTML.append("<span id='paging' onclick='userPaging(" + (endPage+1) +")'다음</span>");
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageBlock() {
		return pageBlock;
	}

	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public StringBuffer getPagingHTML() {
		return pagingHTML;
	}

	public void setPagingHTML(StringBuffer pagingHTML) {
		this.pagingHTML = pagingHTML;
	}

	public int getTotalA() {
		return totalA;
	}

	public void setTotalA(int totalA) {
		this.totalA = totalA;
	}
	
	
	
}







