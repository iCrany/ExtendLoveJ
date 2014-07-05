package com.icrany.pojo;

/**
 * 一个分页类
 * @author Administrator
 *
 */
public class Pager {

	private static final int DEFAULT_PAGE_SIZE = 10;
	
	private static final int DEFAULT_SHOW_PAGE_SIZE = 10;
	
	private int showPageSize;//这里是那个分页显示栏中应该显示的长度
	
	private int pageSize;//每页显示的页数,一页中有多少行
	
	private int pageIndex;//当前页数
	
	private int pageTotal;//总页数
	
	private int itemTotal;//从数据库中查询的结果总数
	
	private int prePage;//前一页
	
	private int nextPage;//下一页
	
	public Pager(){
		this.pageSize = DEFAULT_PAGE_SIZE;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		if(pageIndex < this.pageSize)
			this.pageIndex = pageIndex;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public int getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(int itemTotal) {
		this.itemTotal = itemTotal;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		if(prePage > this.prePage)
			this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	
}
