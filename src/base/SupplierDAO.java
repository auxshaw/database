package base;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Supplier;

public class SupplierDAO extends BaseDAO{

	private static SupplierDAO sd = null;
	 
	public static synchronized SupplierDAO getInstance() {
		if (sd == null) {
			sd = new SupplierDAO();
		}
		return sd;
	}
	
	// update
	public boolean update(Supplier supplier) {
		boolean result = false;
		if (supplier == null) {
			return result;
		}
		try {
			// check
			if (queryBySupplierid(supplier.getSupplierid()) == 0) {
				return result;
			}
			// update
			String sql = "update supplier set suppliername=?,address=?,telephone=? where supplierid=?";//**********
			String[] param = { supplier.getSuppliername(),supplier.getAddress(),
					supplier.getTelephone(),supplier.getSupplierid()};
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
	public boolean delete(Supplier supplier) {
		boolean result = false;
		if (supplier == null) {
			return result;
			}
		try {
			// check
			if (queryBySupplierid(supplier.getSupplierid()) == 0) {
				return result;
			}
			//delete
			String sql = "delete from supplier where supplierid=? and suppliername=?";
			String[] param = {supplier.getSupplierid(),supplier.getSuppliername()};
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
	public boolean add(Supplier supplier) {
		boolean result = false;
		if (supplier == null) {
			return result;
		}
		try {
			// check
			if (queryBySupplierid(supplier.getSupplierid()) == 1) {
				return result;
			}
			// insert
			String sql = "insert into supplier(supplierid,suppliername,address,telephone) values(?,?,?,?)";
			String[] param = { supplier.getSupplierid(),supplier.getSuppliername(),
					supplier.getAddress(),supplier.getTelephone()};
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
	public List<Supplier> querybyid(String supplierid) {
		List<Supplier> result = new ArrayList<Supplier>();
		if (supplierid == null) {
			return result;
		}

		String sql = "select * from supplier where supplierid=? ";
		String [] param = { supplierid };
		rs = db.executeQuery(sql, param);
		try {
			while (rs.next()) {
				Supplier su =new Supplier();
				su.setSupplierid(rs.getString("supplierid"));
				su.setSuppliername(rs.getString("suppliername"));
				su.setAddress(rs.getString("address"));
				su.setTelephone(rs.getString("telephone"));				
				result.add(su);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}
 
		return result;
	}
	
	// querybyname
	public List<Supplier> querybyname(String suppliername) {
		List<Supplier> result = new ArrayList<Supplier>();
		if (suppliername == null) {
			return result;
		}

		String sql = "select * from supplier where suppliername like ? ";
		String [] param = { "%" +suppliername+"%" };
		rs = db.executeQuery(sql, param);
		try {
			while (rs.next()) {
				Supplier su =new Supplier();
				su.setSupplierid(rs.getString("supplierid"));
				su.setSuppliername(rs.getString("suppliername"));
				su.setAddress(rs.getString("address"));
				su.setTelephone(rs.getString("telephone"));				
				result.add(su);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}
 
		return result;
	}
	
	
	// queryAll
		public List<Supplier> queryAll() {
			List<Supplier> result = new ArrayList<Supplier>();
//			if (pageNum < 1) {
//				return result;
//			}
			
//			int beginNum = (pageNum - 1) * showNum;
			String sql = "select * from supplier ";
//			Integer[] param = { beginNum, showNum };
			rs = db.executeQuery(sql);
			try {
				while (rs.next()) {
					Supplier su =new Supplier();
					su.setSupplierid(rs.getString("supplierid"));
					su.setSuppliername(rs.getString("suppliername"));
					su.setAddress(rs.getString("address"));
					su.setTelephone(rs.getString("telephone"));				
					result.add(su);
				}
			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				destroy();
			}
	 
			return result;
		}
	
	// query by supplierid
	public int queryBySupplierid(String supplierid) throws SQLException {
		int result = 0;
		if (supplierid == null) {
			return result;
		}
		String checkSql = "select * from supplier where supplierid=?";
		String [] checkParam = { supplierid };
		rs = db.executeQuery(checkSql, checkParam);
		if (rs.next()) {
			result = 1;
		}
		return result;
		}
	
	
}
