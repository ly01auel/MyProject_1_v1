package cn.com.lin.entity;

import java.util.List;

public class PageBean<T> {
	// 当前页
	private int currentPage = 1;
	// 单页记录数
	private int pageCount = 5;
	// 总页数
	private int totlePage;
	// 总记录数
	private int totleCount;
	// 结果集
	private List<T> dataList;
	// 当前用户信息
	private User user;
	// 检索条件
	private T condition;
	
	public int getCurrentPage() {
		return currentPage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotlePage() {
		return totlePage;
	}

	// 设置总页数
	public void setTotlePage() {
		this.totlePage = this.totleCount % this.pageCount == 0 ? this.totleCount / this.pageCount
				: this.totleCount / this.pageCount + 1;
	}

	public int getTotleCount() {
		return totleCount;
	}

	public void setTotleCount(int totleCount) {
		this.totleCount = totleCount;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", pageCount=" + pageCount + ", totlePage=" + totlePage
				+ ", totleCount=" + totleCount + ", dataList=" + dataList.size() + ", user={" + user.getId() + ","
				+ user.getUserName() + "," + user.getPassword() + "}]";
	}

}
