package com.tal.domain;
/*
    @TODO:
    @Author tal
*/
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
	private double pPrice;		//商品价格
	private String pimage;			//图片路径
	private Date pdate;				//商品创建日期
	private int isHot;				//是否是热门商品（1是，0不是）
	private int pflag;				//商品状态（0下架，1在售）
	private String cid;				//商品所属分类

	public Product(){}

	public Product(String pid, String pname, double pPrice, String pimage, Date pdate, int isHot,
			 int pflag, String cid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pPrice = pPrice;
		this.pimage = pimage;
		this.pdate = pdate;
		this.isHot = isHot;
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

	public double getpPrice() {
		return pPrice;
	}

	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
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
		return "Product [pid=" + pid + ", pname=" + pname + ",  pPrice=" + pPrice
				+ ", pimage=" + pimage + ", pdate=" + pdate + ", isHot=" + isHot + ", pflag="
				+ pflag + ", cid=" + cid + "]";
	}

}
