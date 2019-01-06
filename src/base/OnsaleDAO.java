package base;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Onsale;
import model.Supply;

public class OnsaleDAO extends BaseDAO{

	private static OnsaleDAO on = null;
	 
	public static synchronized OnsaleDAO getInstance() {
		if (on == null) {
			on = new OnsaleDAO();
		}
		return on;
	}
	
	// update
	public boolean update(Onsale onsale) {
		boolean result = false;
		if (onsale == null) {
			return result;
		}
		try {
			// check
			if (queryBySupply(onsale.getShelfid(),onsale.getGoodsid()) == 0) {
				return result;
			}
			// update
			String sql = "update onsale set goodslocation=? where shelfid=? and goodsid=?";//**********
			String[] param = { onsale.getGoodslocation() ,onsale.getShelfid(), onsale.getGoodsid() };
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
	public boolean delete(Onsale onsale) {
		boolean result = false;
		if (onsale == null) {
			return result;
			}
		try {
			// check
			if (queryBySupply(onsale.getShelfid(),onsale.getGoodsid()) == 0) {
				return result;
			}
			//delete
			String sql = "delete from onsale where shelfid=? and goodsid=? ";
			String[] param = { onsale.getShelfid(),onsale.getGoodsid() };
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
	public boolean add(Onsale onsale) {
		boolean result = false;
		if (onsale == null) {
			return result;
		}
		try {
			// check
			if (queryBySupply(onsale.getShelfid(),onsale.getGoodsid()) == 1) {
				return result;
			}
			// insert
			String sql = "insert into onsale(shelfid,goodsid,goodslocation) values(?,?,?)";
			String[] param = { onsale.getShelfid(), onsale.getGoodsid(), onsale.getGoodslocation() };
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
	public List<Onsale> querybygid(String goodsid) {
		List<Onsale> result = new ArrayList<Onsale>();
		
		if (goodsid == null) {
			return result;
		}
		String checkSql = "select * from onsale where goodsid=?";
		String [] checkParam = { goodsid };
		rs = db.executeQuery(checkSql, checkParam);
		try {
			while (rs.next()) {
				Onsale ons =new Onsale();
				ons.setShelfid(rs.getString("shelfid"));
				ons.setGoodsid(rs.getString("goodsid"));
				ons.setGoodslocation(rs.getString("goodslocation"));
				result.add(ons);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}
 
		return result;
	}

	
	// queryAll
	public List<Onsale> queryAll() {
		List<Onsale> result = new ArrayList<Onsale>();
		
		String sql = "select * from onsale";
		rs = db.executeQuery(sql);
		try {
			while (rs.next()) {
				Onsale ons =new Onsale();
				ons.setShelfid(rs.getString("shelfid"));
				ons.setGoodsid(rs.getString("goodsid"));
				ons.setGoodslocation(rs.getString("goodslocation"));
				result.add(ons);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}
 
		return result;
	}

	
	// query by shelfid, goodsid
	public int queryBySupply(String shelfid,String goodsid) throws SQLException {
		int result = 0;
		if (shelfid == null||goodsid==null) {
			return result;
		}
		String checkSql = "select * from onsale where shelfid=? and goodsid=?";
		String [] checkParam = { shelfid,goodsid };
		rs = db.executeQuery(checkSql, checkParam);
		if (rs.next()) {
			result = 1;
		}
		return result;
		}	
	
	
}
