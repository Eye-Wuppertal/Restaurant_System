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
//��Ʒ��ʵ����
public class Product {

	private String pid;				//��ƷID
	private String pname;			//��Ʒ����
	private double pPrice;		//��Ʒ�۸�
	private String pimage;			//ͼƬ·��
	private Date pdate;				//��Ʒ��������
	private int isHot;				//�Ƿ���������Ʒ��1�ǣ�0���ǣ�
	private int pflag;				//��Ʒ״̬��0�¼ܣ�1���ۣ�
	private String cid;				//��Ʒ��������

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
