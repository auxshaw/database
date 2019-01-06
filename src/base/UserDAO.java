package base;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Goods;
import model.User;

public class UserDAO extends BaseDAO{

	private static UserDAO ad = null;
	 
	public static synchronized UserDAO getInstance() {
		if (ad == null) {
			ad = new UserDAO();
		}
		return ad;
	}
 
	public boolean queryForLogin(String username, String password,int permission) {
		boolean result = false;
		if (username.length() == 0 || password.length() == 0) {
			return result;
		}
		String sql = "select * from user where username=? and password=? and permission=?";
		String[] param = { username, password,String.valueOf(permission) };
		rs = db.executeQuery(sql, param);
		try {
			if (rs.next()) {
				result = true;
				System.out.println(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			destroy();
		}
		return result;
	}
	
	// update
		public boolean update(User user) {
			boolean result = false;
			if (user == null) {
				return result;
			}
			try {
				// check
				if (queryByUsername(user.getUsername()) == 0) {
					return result;
				}
				// update
				String sql = "update user set password=? where username=?";//**********
				String[] param = { user.getPassword(),user.getUsername()};
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
		
		// query by username
		public int queryByUsername(String username) throws SQLException {
			int result = 0;
			if (username == null) {
				return result;
			}
			String checkSql = "select * from user where username=?";
			String [] checkParam = { username };
			rs = db.executeQuery(checkSql, checkParam);
			if (rs.next()) {
				result = 1;
			}
			return result;
		}
		
		// query by username
		public List<User> queryByname(String username) {
			List<User> result = new ArrayList<User>();
			if (username == null) {
				return result;
			}
			String checkSql = "select * from user where username=?";
			String [] checkParam = { username };
			rs = db.executeQuery(checkSql, checkParam);
			try {
				if (rs.next()) {
					User u=new User();
					u.setUsername(rs.getString("username"));
					u.setPassword(rs.getString("password"));
					u.setPermission(rs.getInt("permission"));
					result.add(u);
				}
			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				destroy();
			}
			
			return result;
		}
		
}
