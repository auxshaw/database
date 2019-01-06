package base;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Shelf;
import model.Supplier;

public class ShelfDAO extends BaseDAO{
	
	private static ShelfDAO sh = null;
	 
	public static synchronized ShelfDAO getInstance() {
		if (sh == null) {
			sh = new ShelfDAO();
		}
		return sh;
	}
	
	// update
	public boolean update(Shelf shelf) {
		boolean result = false;
		if (shelf == null) {
			return result;
		}
		try {
			// check
			if (queryByShelfid(shelf.getShelfid()) == 0) {
				return result;
			}
			// update
			String sql = "update shelf set shelflocation=? where shelfid=?";//**********
			String[] param = { shelf.getShelflocation() ,shelf.getShelfid()};
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
	public boolean delete(Shelf shelf) {
		boolean result = false;
		if (shelf == null) {
			return result;
			}
		try {
			// check
			if (queryByShelfid(shelf.getShelfid()) == 0) {
				return result;
			}
			//delete
			String sql = "delete from shelf where shelfid=? ";
			String[] param = { shelf.getShelfid() };
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
	public boolean add(Shelf shelf) {
		boolean result = false;
		if (shelf == null) {
			return result;
		}
		try {
			// check
			if (queryByShelfid(shelf.getShelfid()) == 1) {
				return result;
			}
			// insert
			String sql = "insert into shelf(shelfid,shelflocation) values(?,?)";
			String[] param = { shelf.getShelfid(),shelf.getShelflocation() };
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

	// querybyid
	public List<Shelf> querybyid(String shelfid) {
		List<Shelf> result = new ArrayList<Shelf>();
		
		if (shelfid == null) {
			return result;
		}
		String checkSql = "select * from shelf where shelfid=?";
		String [] checkParam = { shelfid };
		rs = db.executeQuery(checkSql, checkParam);
		try {
			while (rs.next()) {
				Shelf sh =new Shelf();
				sh.setShelfid(rs.getString("shelfid"));
				sh.setShelflocation(rs.getString("shelflocation"));		
				result.add(sh);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}
 
		return result;
	}
	
	
	// queryAll
	public List<Shelf> queryAll() {
		List<Shelf> result = new ArrayList<Shelf>();
		
		String sql = "select * from shelf ";
		rs = db.executeQuery(sql);
		try {
			while (rs.next()) {
				Shelf sh =new Shelf();
				sh.setShelfid(rs.getString("shelfid"));
				sh.setShelflocation(rs.getString("shelflocation"));		
				result.add(sh);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}
 
		return result;
	}

	
	// query by shelfid
	public int queryByShelfid(String shelfid) throws SQLException {
		int result = 0;
		if (shelfid == null) {
			return result;
		}
		String checkSql = "select * from shelf where shelfid=?";
		String [] checkParam = { shelfid };
		rs = db.executeQuery(checkSql, checkParam);
		if (rs.next()) {
			result = 1;
		}
		return result;
		}
	
}
