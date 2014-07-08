package com.icrany.pojo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	private String html;//分页的html样式
	
	private String url ;//在填充分页的url用的，必须以 / 结尾，因为之后是一个数字用于查询第几页
	
	public Pager(){
		this.pageSize = DEFAULT_PAGE_SIZE;
		this.showPageSize = DEFAULT_SHOW_PAGE_SIZE;
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
		if(prePage < 1) this.prePage = 1;
		else this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		if(nextPage > this.pageTotal) this.nextPage = this.pageTotal;
		else this.nextPage = nextPage;
		
	}

	//分页类自行进行分析，只需把结果传这个类,这个类根据相应的逻辑输出这个分页的html
	public void doWithArticles(List<Article> articles,int currentPage,HttpServletRequest request){
		
		this.itemTotal = articles.size();//设置查询的结果总数
		
		setPageIndex(currentPage);//设置当前页
		setPrePage(currentPage-1);//设置前一页
		setPageTotal((this.itemTotal + this.pageSize ) / this.pageSize);//设置一共有多少页
		setNextPage(currentPage+1);	//设置下一页，首先判断是否有下一页
		
		//这里自己进行逻辑处理，输出那个分页的 html 代码
		StringBuilder htmlPaging  = new StringBuilder("");
		
		htmlPaging.append("<li><a href='"
						+ url
						+ this.prePage + "'>&laquo;</a></li>");
		
		int begin = getPageIndex();
		int end = begin +  getShowPageSize() ;//左闭右开区间
		
		if(getPageIndex() >= 5){
			begin = getPageIndex() - 4;
		}else{
			begin = 1;
		}
		
		end = begin + getShowPageSize();
		if( end > getPageTotal()){
			end = getPageTotal() + 1;
		}
		
		for(int i = begin ,j = 0 ; i < end ;i++,j++){
			
			if(i == getPageIndex() ){
				htmlPaging.append("<li class='active'><a href='"
						+  url
						+ ( i )//this.pageIndex + j
						+ "'>"
						+ ( i ) 
						+ "</a></li>");				
			}else{
			
				htmlPaging.append("<li><a href='"
						+  url
						+ ( i )
						+ "'>"
						+ ( i ) 
						+ "</a></li>");
			}
		}
		
		htmlPaging.append("<li><a href='"
				+ url
				+ this.nextPage + "'>&raquo;</a></li>");
		
		this.html = htmlPaging.toString();
	}

	public int getShowPageSize() {
		return showPageSize;
	}

	public void setShowPageSize(int showPageSize) {
		this.showPageSize = showPageSize;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
