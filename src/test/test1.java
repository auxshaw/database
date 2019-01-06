package test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import base.BaseDAO;
import base.DAO;
import base.GoodsDAO;
import base.OnsaleDAO;
import base.ShelfDAO;
import base.SupplierDAO;
import base.SupplyDAO;
import base.UserDAO;
import model.Goods;
import model.Onsale;
import model.Shelf;
import model.Supplier;
import model.Supply;
import util.DBUtil;

class test1 {

	@Test
	void test() throws SQLException {
		
		Onsale o1=new Onsale();
		OnsaleDAO o=new OnsaleDAO();
//		o1.setShelfid("1");
//		o1.setGoodsid("1");
//		o1.setGoodslocation("A区1架1排");
//		System.out.println(((OnsaleDAO) BaseDAO.getAbilityDAO(DAO.OnsaleDAO)).update(o1));
//		List<Onsale> result = new ArrayList<Onsale>();
//		result =((OnsaleDAO) BaseDAO.getAbilityDAO(DAO.OnsaleDAO)).queryAll();
//		Iterator <Onsale> it = result.iterator();
//		while(it.hasNext()) {
//			Onsale onsale = it.next();
//			System.out.println(onsale.getShelfid()+"\t"+onsale.getGoodsid()+"\t"+onsale.getGoodslocation());
//		}
		
//		Supply su1=new Supply();
//		SupplyDAO sy1=new SupplyDAO();
//		su1.setGoodsid("1");
//		su1.setSupplierid("2");
//		System.out.println(((SupplyDAO) BaseDAO.getAbilityDAO(DAO.SupplyDAO)).add(su1));
//		List<Supply> result = new ArrayList<Supply>();
//		result =((SupplyDAO) BaseDAO.getAbilityDAO(DAO.SupplyDAO)).querybysuid("1");
//		Iterator <Supply> it = result.iterator();
//		while(it.hasNext()) {
//			Supply supply = it.next();
//			System.out.println(supply.getGoodsid()+"\t"+supply.getSupplierid());
//		}
		
//		ShelfDAO sh=new ShelfDAO();
//		Shelf sh1=new Shelf();
//		sh1.setShelfid("3");
//		sh1.setShelflocation("C区");
//		System.out.print(((ShelfDAO) BaseDAO.getAbilityDAO(DAO.ShelfDAO)).querybyid("1"));
//		List<Shelf> result = new ArrayList<Shelf>();
//		result =((ShelfDAO) BaseDAO.getAbilityDAO(DAO.ShelfDAO)).queryAll();
//		Iterator <Shelf> it = result.iterator();
//		while(it.hasNext()) {
//			Shelf shelf = it.next();
//			System.out.println(shelf.getShelfid()+"\t"+shelf.getShelflocation());
//		}
//		
		
//		GoodsDAO g=new GoodsDAO();
//		Goods g1 = new Goods() ;
//		SupplierDAO s=new SupplierDAO();
//		Supplier s1=new Supplier();
//		s1.setSupplierid("2");
//		s1.setSuppliername("上海市****");
//		s1.setAddress("上海市奉贤区金钱公路3469号");
//		s1.setTelephone("(+86)2157470278");
//		((GoodsDAO) BaseDAO.getAbilityDAO(DAO.GoodsDAO)).querybyGOODSID(2);
//		System.out.print(((SupplierDAO) BaseDAO.getAbilityDAO(DAO.SupplierDAO)).add(s1));
//		List<Supplier> result = new ArrayList<Supplier>();
//		result =((SupplierDAO) BaseDAO.getAbilityDAO(DAO.SupplierDAO)).querybyid("2");
//		Iterator <Supplier> it = result.iterator();
//		while(it.hasNext()) {
//			Supplier supplier = it.next();
//			System.out.println(supplier.getSupplierid()+"\t"+supplier.getSuppliername()+"\t"+supplier.getAddress()+"\t"
//					+supplier.getTelephone());
//		}
		
//		List<Goods> result = new ArrayList<Goods>();
//		result =((GoodsDAO) BaseDAO.getAbilityDAO(DAO.GoodsDAO)).querybyGoodsname("子");
//		Iterator <Goods> it = result.iterator();
//		while(it.hasNext()) {
//			Goods goods = it.next();
//			System.out.println(goods.getGoodsid()+"\t"+goods.getGoodsname()+"\t"+goods.getGoodstype()+"\t"+goods.getPrice()+"\t"
//					+goods.getProductiondate()+"\t"+goods.getStocksize());
//		}
		
//		BigDecimal pri = new BigDecimal("5.00");
//		g1.setGoodsid("3");
//		g1.setGoodsname("尺子");
//		g1.setGoodstype("学习用品");
//		g1.setPrice(pri);
//		g1.setProductiondate("2018-10-20");
//		g1.setStocksize(30);
//		System.out.print(g.add(g1));
//		System.out.print(g.delete(g1));
//		System.out.print(g.update(g1));

//		int id=rs.getInt("goodsid");
//		String name = rs.getString("goodsname");
//	    String type = rs.getString("goodstype");
//	    BigDecimal price = rs.getBigDecimal("price");
//	    String date =rs.getString("productiondate");
//	    int size =rs.getInt("stocksize");
//	    // 输出数据
//	    System.out.print(id+name+type+price+date+size);
//	    System.out.print("\n");
		
		
//		final DBUtil db = DBUtil.getDBUtil();
//		
//		String sql;
//        sql = "SELECT username, password,permission FROM user";
//        ResultSet rs = db.executeQuery(sql);
//    
//        // 展开结果集数据库
//        try {
//			while(rs.next()){
//			    // 通过字段检索
//			    String username = rs.getString("username");
//			    String password = rs.getString("password");
//			    String permission = rs.getString("permission");
//			    // 输出数据
//			    System.out.print("username: " + username);
//			    System.out.print(", password: " + password);
//			    System.out.print(", permission: " + permission);
//			    System.out.print("\n");
//			}
//		} catch (SQLException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//        db.close();
	}

}
