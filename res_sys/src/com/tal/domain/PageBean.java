package com.tal.domain;
/*
    @TODO:
    @Author tal
*/
import java.util.List;

//用于保存分页数据的JavaBean
public class PageBean<T> {

	private List<T> list;		//保存本页数据的List集合
	private int pageNum;		//页号
	private int pageSize;		//页大小
	private int pageCount;		//总页数（总记录条数/页大小  + 总条数%页大小==0？0:1 ）
	private int recordCount;	//总记录条数
	private int startIndex;		//起始下标( (pageNum-1)*pageSize )
	
	public PageBean(){}
	
	public PageBean(List<T> list, int pageNum, int pageSize, int recordCount) {
		super();
		this.list = list;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
	}
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		//（总记录条数/页大小  + 总条数%页大小==0？0:1 ）
		this.pageCount = recordCount/pageSize + ( recordCount%pageSize==0?0:1 );
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getStartIndex() {
		this.startIndex = (pageNum-1)*pageSize;
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
}
