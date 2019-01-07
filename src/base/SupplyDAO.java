package base;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Shelf;
import model.Supply;

public class SupplyDAO extends BaseDAO{

	private static SupplyDAO s = null;
	 
	public static synchronized SupplyDAO getInstance() {
		if (s == null) {
			s = new SupplyDAO();
		}
		return s;
	}

//	// update
//	public boolean updategoodsid(Supply supply) {
//		boolean result = false;
//		if (supply == null) {
//			return result;
//		}
//		try {
//			// check
//			if (queryBySupply(supply.getGoodsid(),supply.getSupplierid()) == 0) {
//				return result;
//			}
//			// update
//			String sql = "update supply set goodsid=? where supplierid=?";//**********
//			String[] param = { supply.getGoodsid(),supply.getSupplierid() };
//			int rowCount = db.executeUpdate(sql, param);
//			if (rowCount == 1) {
//				result = true;
//			}
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} finally {
//			destroy();
//		}
//		return result;
//		}
	
	
	// delete
	public boolean delete(Supply supply) {
		boolean result = false;
		if (supply == null) {
			return result;
			}
		try {
			// check
			if (queryBySupply(supply.getGoodsid(),supply.getSupplierid()) == 0) {
				return result;
			}
			//delete
			String sql = "delete from supply where goodsid=? and supplierid=? ";
			String[] param = { supply.getGoodsid(),supply.getSupplierid() };
			int rowCount = db.executeUpdate(sql, param);	
			if (rowCount == 1) {	
				result = true;
				}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}
		return result;
	}	

	//add
	public boolean add(Supply supply) {
		boolean result = false;
		if (supply == null) {
			return result;
		}
		try {
			// check
			if (queryBySupply(supply.getGoodsid(),supply.getSupplierid()) == 1) {
				return result;
			}
			// insert
			String sql = "insert into supply(goodsid,supplierid) values(?,?)";
			String[] param = { supply.getGoodsid(),supply.getSupplierid() };
			if (db.executeUpdate(sql, param) == 1) {
				result = true;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}
		return result;
	}	

	// querybygid
	public List<Supply> querybygid(String goodsid) {
		List<Supply> result = new ArrayList<Supply>();
		
		if (goodsid == null) {
			return result;
		}
		String checkSql = "select supply.goodsid,goodsname,supply.supplierid,suppliername from supply,goods,supplier where supply.goodsid=? and goods.goodsid=supply.goodsid and supplier.supplierid=supply.supplierid";
		String [] checkParam = { goodsid };
		rs = db.executeQuery(checkSql, checkParam);
		try {
			while (rs.next()) {
				Supply s =new Supply();
				s.setGoodsid(rs.getString("goodsid"));
				s.setSupplierid(rs.getString("supplierid"));
				s.setGoodsname(rs.getString("goodsname"));
				s.setSuppliername(rs.getString("suppliername"));	
				result.add(s);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}
 
		return result;
	}
	
	// querybysuid
	public List<Supply> querybysuid(String supplierid) {
		List<Supply> result = new ArrayList<Supply>();
		
		if (supplierid == null) {
			return result;
		}
		String checkSql = "select supply.goodsid,goodsname,supply.supplierid,suppliername from supply,goods,supplier where supply.supplierid=? and goods.goodsid=supply.goodsid and supplier.supplierid=supply.supplierid";
		String [] checkParam = { supplierid };
		rs = db.executeQuery(checkSql, checkParam);
		try {
			while (rs.next()) {
				Supply s =new Supply();
				s.setGoodsid(rs.getString("goodsid"));
				s.setSupplierid(rs.getString("supplierid"));
				s.setGoodsname(rs.getString("goodsname"));
				s.setSuppliername(rs.getString("suppliername"));	
				result.add(s);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}
 
		return result;
	}

	// queryAll
	public List<Supply> queryAll() {
		List<Supply> result = new ArrayList<Supply>();
		
		String sql = "select supply.goodsid,goodsname,supply.supplierid,suppliername from supply,goods,supplier where goods.goodsid=supply.goodsid and supplier.supplierid=supply.supplierid";
		rs = db.executeQuery(sql);
		try {
			while (rs.next()) {
				Supply s =new Supply();
				s.setGoodsid(rs.getString("goodsid"));
				s.setSupplierid(rs.getString("supplierid"));
				s.setGoodsname(rs.getString("goodsname"));
				s.setSuppliername(rs.getString("suppliername"));
				result.add(s);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}
 
		return result;
	}
	
	
	// query by goodsid,supplierid
	public int queryBySupply(String goodsid,String supplierid) throws SQLException {
		int result = 0;
		if (goodsid == null||supplierid==null) {
			return result;
		}
		String checkSql = "select * from supply where goodsid=? and supplierid=?";
		String [] checkParam = { goodsid,supplierid };
		rs = db.executeQuery(checkSql, checkParam);
		if (rs.next()) {
			result = 1;
		}
		return result;
		}	
}
