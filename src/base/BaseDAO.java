package base;

import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public abstract class BaseDAO {
	protected final DBUtil db = DBUtil.getDBUtil();
	protected ResultSet rs;
	private static BaseDAO baseDAO;
 
	public BaseDAO() {
		init();
	}
 
	private void init() {
		// buildAbilityDAO();
	}
 
	// protected abstract void buildAbilityDAO();
 
	public static synchronized BaseDAO getAbilityDAO(DAO dao) {
		switch (dao) {
		case UserDAO:
			if (baseDAO == null || baseDAO.getClass() != UserDAO.class) {
				baseDAO = UserDAO.getInstance();
			}
			break;
		case GoodsDAO:
			if (baseDAO == null || baseDAO.getClass() != GoodsDAO.class) {
				baseDAO = GoodsDAO.getInstance();
			}
			break;
		case SupplierDAO:
			if (baseDAO == null || baseDAO.getClass() != SupplierDAO.class) {
				baseDAO = SupplierDAO.getInstance();
			}
			break;
		case ShelfDAO:
			if (baseDAO == null || baseDAO.getClass() != ShelfDAO.class) {
				baseDAO = ShelfDAO.getInstance();
			}
			break;
		case SupplyDAO:
			if (baseDAO == null || baseDAO.getClass() != SupplyDAO.class) {
				baseDAO = SupplyDAO.getInstance();
			}
			break;
		case OnsaleDAO:
			if (baseDAO == null || baseDAO.getClass() != OnsaleDAO.class) {
				baseDAO = OnsaleDAO.getInstance();
			}
			break;
		default:
			break;
		}
		return baseDAO;
	}
 
	protected void destroy() {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			db.close();
		}
	}
}
