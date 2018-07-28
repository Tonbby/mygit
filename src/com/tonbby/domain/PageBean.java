package com.tonbby.domain;

import java.util.List;

public class PageBean<E> {

	private List<E> list;
	private Integer currPage;  //当前页
	private Integer pageSize;  //页码
	private Integer totalPage; //不用提供set方法，get方法里面直接计算
	private Integer totalCount;
	
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return (int) Math.ceil(totalCount*1.0/pageSize);
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public PageBean(List<E> list, Integer currPage, Integer pageSize, Integer totalCount) {
		//totalPage不用构造
		super();
		this.list = list;
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}
	public PageBean() {
		super();
		
	}
	
	
	
}
