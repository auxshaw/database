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
import base.UserDAO;
import model.Goods;
import util.DBUtil;

class test1 {

	@Test
	void test() throws SQLException {
		
		GoodsDAO g=new GoodsDAO();
		Goods g1 = new Goods() ;
//		System.out.print(g.queryByGoodsid(2));
		
//		List<Goods> result = new ArrayList<Goods>();
//		result =((GoodsDAO) BaseDAO.getAbilityDAO(DAO.GoodsDAO)).querybyGOODSID(2);
//		Iterator <Goods> it = result.iterator();
//		while(it.hasNext()) {
//			Goods goods = it.next();
//			System.out.println(goods.getGoodsid()+"\t"+goods.getGoodsname()+"\t"+goods.getGoodstype()+"\t"+goods.getPrice()+"\t"
//					+goods.getProductiondate()+"\t"+goods.getStocksize());
//		}
		
//		BigDecimal pri = new BigDecimal("3.00");
//		g1.setGoodsid(2);
//		g1.setGoodsname("��");
//		g1.setGoodstype("�칫��Ʒ");
//		g1.setPrice(pri);
//		g1.setProductiondate("2018-10-10");
//		g1.setStocksize(20);
//		System.out.print(g.add(g1));
//		System.out.print(g.delete(g1));
//		System.out.print(g.update(g1));

//		int id=rs.getInt("goodsid");
//		String name = rs.getString("goodsname");
//	    String type = rs.getString("goodstype");
//	    BigDecimal price = rs.getBigDecimal("price");
//	    String date =rs.getString("productiondate");
//	    int size =rs.getInt("stocksize");
//	    // �������
//	    System.out.print(id+name+type+price+date+size);
//	    System.out.print("\n");
		
		
//		final DBUtil db = DBUtil.getDBUtil();
//		
//		String sql;
//        sql = "SELECT username, password,permission FROM user";
//        ResultSet rs = db.executeQuery(sql);
//    
//        // չ����������ݿ�
//        try {
//			while(rs.next()){
//			    // ͨ���ֶμ���
//			    String username = rs.getString("username");
//			    String password = rs.getString("password");
//			    String permission = rs.getString("permission");
//			    // �������
//			    System.out.print("username: " + username);
//			    System.out.print(", password: " + password);
//			    System.out.print(", permission: " + permission);
//			    System.out.print("\n");
//			}
//		} catch (SQLException e) {
//			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
//		}
//        db.close();
	}

}
