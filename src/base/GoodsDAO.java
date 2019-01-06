package base;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Goods;

public class GoodsDAO extends BaseDAO{

	private final int showNum = 15;
	private static GoodsDAO ud = null;
 
	public static synchronized GoodsDAO getInstance() {
		if (ud == null) {
			ud = new GoodsDAO();
		}
		return ud;
	}
 
	// update
	public boolean update(Goods goods) {
		boolean result = false;
		if (goods == null) {
			return result;
		}
		try {
			// check
			if (queryByGoodsid(goods.getGoodsid()) == 0) {
				return result;
			}
			// update
			String sql = "update goods set goodsname=?,goodstype=?,price=?,productiondate=?,stocksize=? where goodsid=?";//**********
			String[] param = { goods.getGoodsname(),goods.getGoodstype(),String.valueOf(goods.getPrice()),
					goods.getProductiondate(),String.valueOf(goods.getStocksize()),goods.getGoodsid()};
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
 
	// delete
	public boolean delete(Goods goods) {
		boolean result = false;
		if (goods == null) {
			return result;
		}
		try {
			// check
			if (queryByGoodsid(goods.getGoodsid()) == 0) {
				return result;
			}
			String sql = "delete from goods where goodsid=? and goodsname=?";
			String[] param = {goods.getGoodsid(),goods.getGoodsname()};	
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
 
	// add
	public boolean add(Goods goods) {
		boolean result = false;
		if (goods == null) {
			return result;
		}
		try {
			// check
			if (queryByGoodsid(goods.getGoodsid()) == 1) {
				return result;
			}
			// insert
			String sql = "insert into goods(goodsid,goodsname,goodstype,price,productiondate,stocksize) values(?,?,?,?,?,?)";
			String[] param = { goods.getGoodsid(),goods.getGoodsname(),goods.getGoodstype(),String.valueOf(goods.getPrice()),
					goods.getProductiondate(),String.valueOf(goods.getStocksize()) };
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
 
	// query by goodsid1
	public List<Goods> querybyGOODSID(String id) {
		List<Goods> result = new ArrayList<Goods>();
		if (id ==null) {
			return result;
			}
	
		String sql = "select * from goods where goodsid=?";
		String [] param = { id };
		rs = db.executeQuery(sql, param);
		try {
			while (rs.next()) {
			Goods go =new Goods();
			go.setGoodsid(rs.getString("goodsid"));
			go.setGoodsname(rs.getString("goodsname"));
			go.setGoodstype(rs.getString("goodstype"));
			go.setPrice(rs.getBigDecimal("price"));
			go.setProductiondate(rs.getString("productiondate"));
			go.setStocksize(rs.getInt("stocksize"));
			result.add(go);
			}
			} catch (SQLException se) {
				se.printStackTrace();
				} finally {
					destroy();
					}
		return result;
		}
	
	// query by goodsname
	public List<Goods> querybyGoodsname(String name) {
		List<Goods> result = new ArrayList<Goods>();
		if (name == null) {
			return result;
			}	
		String sql = "select * from goods where goodsname like ?";
		String [] param = {"%"+ name+"%" };
		rs = db.executeQuery(sql, param);
		try {
			while (rs.next()) {
				Goods go =new Goods();
				go.setGoodsid(rs.getString("goodsid"));
				go.setGoodsname(rs.getString("goodsname"));
				go.setGoodstype(rs.getString("goodstype"));
				go.setPrice(rs.getBigDecimal("price"));
				go.setProductiondate(rs.getString("productiondate"));
				go.setStocksize(rs.getInt("stocksize"));
				result.add(go);
				}
			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				destroy();
			}
		return result;
		}

	// queryAll
	public List<Goods> queryAll() {
		List<Goods> result = new ArrayList<Goods>();
//		if (pageNum < 1) {
//			return result;
//		}
		
//		int beginNum = (pageNum - 1) * showNum;
		String sql = "select * from goods";
//		Integer[] param = { beginNum, showNum };
		rs = db.executeQuery(sql);
		try {
			while (rs.next()) {
				Goods go =new Goods();
				go.setGoodsid(rs.getString("goodsid"));
				go.setGoodsname(rs.getString("goodsname"));
				go.setGoodstype(rs.getString("goodstype"));
				go.setPrice(rs.getBigDecimal("price"));
				go.setProductiondate(rs.getString("productiondate"));
				go.setStocksize(rs.getInt("stocksize"));
				result.add(go);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}
 
		return result;
	}
 
 
	// query by goodsid
	public int queryByGoodsid(String goodsid) throws SQLException {
		int result = 0;
		if (goodsid == null) {
			return result;
		}
		String checkSql = "select * from goods where goodsid=?";
		String [] checkParam = { goodsid };
		rs = db.executeQuery(checkSql, checkParam);
		if (rs.next()) {
			result = 1;
		}
		return result;
	}

}
