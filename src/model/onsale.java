package model;

public class Onsale {

	private String shelfid;
	private String goodsid;
	private String goodslocation;
	private String goodsname;
	
	//id
	public String getShelfid() {
		return shelfid;
	}
	 
	public void setShelfid(String shelfid) {
		this.shelfid = shelfid;
	}
	
	//id
	public String getGoodsid() {
		return goodsid;
	}
 
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	
	//location
	public String getGoodslocation() {
		return goodslocation;
	}
	 
	public void setGoodslocation(String goodslocation) {
		this.goodslocation = goodslocation;
	}
	
	//name
		public String getGoodsname() {
			return goodsname;
		}
	 
		public void setGoodsname(String goodsname) {
			this.goodsname = goodsname;
		}
}
