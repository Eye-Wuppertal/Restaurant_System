package com.tal.domain;

/*
CREATE TABLE `tb_category` (
  `cid` VARCHAR(32) PRIMARY KEY,
  `cname` VARCHAR(20) UNIQUE,
  `description` VARCHAR(20) DEFAULT NULL
);
*/

//分类的实体类
public class Category {
	private String cid;				//分类ID
	private String cname;			//分类名称
	private String description;		//分类描述信息

	public Category(){}

	public Category(String cid, String cname, String description) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.description = description;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", description=" + description + "]";
	}
}
