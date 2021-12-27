package com.tal.domain;

import java.util.Date;

/*
CREATE TABLE `tb_product` (
  `pid` VARCHAR(32) PRIMARY KEY,
  `pname` VARCHAR(50) DEFAULT NULL,
  `market_price` DOUBLE DEFAULT NULL,
  `shop_price` DOUBLE DEFAULT NULL,
  `pimage` VARCHAR(200) DEFAULT NULL, 
  `pdate` TIMESTAMP,
  `is_hot` INT(1) DEFAULT NULL,
  `pdesc` VARCHAR(255) DEFAULT NULL,
  `pflag` INT(1) DEFAULT NULL,
  `cid` VARCHAR(32) DEFAULT NULL
);
*/
//商品的实体类
public class Product {

	private String pid;				//商品ID
	private String pname;			//商品名称
	private double marketPrice;		//市场价
	private double shopPrice;		//商城价
	private String pimage;			//图片路径
	private Date pdate;				//商品创建日期
	private int isHot;				//是否是热门商品（1是，0不是）
	private String pdesc;			//商品描述
	private int pflag;				//商品状态（0下架，1在售）
	private String cid;				//商品所属分类

	public Product(){}

	public Product(String pid, String pname, double marketPrice, double shopPrice, String pimage, Date pdate, int isHot,
			String pdesc, int pflag, String cid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.marketPrice = marketPrice;
		this.shopPrice = shopPrice;
		this.pimage = pimage;
		this.pdate = pdate;
		this.isHot = isHot;
		this.pdesc = pdesc;
		this.pflag = pflag;
		this.cid = cid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public double getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(double shopPrice) {
		this.shopPrice = shopPrice;
	}

	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public int getIsHot() {
		return isHot;
	}

	public void setIsHot(int isHot) {
		this.isHot = isHot;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public int getPflag() {
		return pflag;
	}

	public void setPflag(int pflag) {
		this.pflag = pflag;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", marketPrice=" + marketPrice + ", shopPrice=" + shopPrice
				+ ", pimage=" + pimage + ", pdate=" + pdate + ", isHot=" + isHot + ", pdesc=" + pdesc + ", pflag="
				+ pflag + ", cid=" + cid + "]";
	}

}
