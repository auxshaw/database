package model;

import java.math.BigDecimal;

public class Goods {
	private String goodsid;
	private String goodsname;
	private String goodstype;
	private BigDecimal price;
	private String productiondate;
	private int stocksize;
	
	//id
	public String getGoodsid() {
		return goodsid;
	}
 
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
 
	//name
	public String getGoodsname() {
		return goodsname;
	}
 
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	
	//type
	public String getGoodstype() {
		return goodstype;
	}
 
	public void setGoodstype(String goodstype) {
		this.goodstype = goodstype;
	}
	
	//price
	public BigDecimal getPrice() {
		return price;
	}
 
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	//date
	public String getProductiondate() {
		return productiondate;
	}
 
	public void setProductiondate(String productiondate) {
		this.productiondate = productiondate;
	}
	
	//stocksize
	public int getStocksize() {
		return stocksize;
	}
 
	public void setStocksize(int stocksize) {
		this.stocksize = stocksize;
	}
}
