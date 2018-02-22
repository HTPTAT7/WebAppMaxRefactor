package by.http.password.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.http.password.bean.User;
import by.http.password.dao.UserDao;

public class UserDaoMySqlImpl extends AbstractDaoMySqlImpl implements UserDao {

	private static final String SQL_INSERT_USER = "INSERT INTO userinf(login, password, role) values ( ?, ?, ?)";
	private static final String SQL_SELECT_USER = "select id, role, login, password from userinf where login = ? and password = ?";
	private static final String SQL_SELECT_USER_ALL = "select id, role, login, password from userinf";

	@Override
	public void create(User user) {

		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_INSERT_USER)) {

			ps.setString(1, user.getLogin());
			ps.setInt(2, user.getPass());
			ps.setString(3, "user");
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> readAll() {

		List<User> users = new ArrayList<>();

		try (Connection cn = wcn.getConnection(); Statement st = cn.createStatement();) {
			ResultSet rs = st.executeQuery(SQL_SELECT_USER_ALL);
			while (rs.next()) {
				users.add(buildUser(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User readUser(User userIn) {

		User user = null;

		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_SELECT_USER)) {
			ps.setString(1, userIn.getLogin());
			ps.setInt(2, userIn.getPass());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = buildUser(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	private User buildUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt(SQL_USER_ID));
		user.setRole(rs.getString(SQL_USER_ROLE));
		user.setLogin(rs.getString(SQL_USER_LOGIN));
		user.setPass(rs.getInt(SQL_USER_PASS));
		return user;
	}

	@Override
	public User read(int id) {
		throw new UnsupportedOperationException("Method is not implemented");
	}

	@Override
	public void update(User t) {
		throw new UnsupportedOperationException("Method is not implemented");
	}

	@Override
	public void delete(int id) {
		throw new UnsupportedOperationException("Method is not implemented");
	}
}
