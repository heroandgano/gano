package p;

import java.io.IOException;
import java.sql.*;
import java.util.*;

public class OrderingDAO extends MadangDAO{
	Properties sqls;
	
	public OrderingDAO() {
		super();
		
		sqls = new Properties();
		try {
			sqls.load(getClass().getResourceAsStream("/p/ordering_sql.properties"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public List<Ordering> select() {
		List<Ordering> rtn = new ArrayList<>();

		try (Connection c = dataSource.getConnection();
				PreparedStatement ps = c.prepareStatement(sqls.getProperty("select"));
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				Ordering ordering = new Ordering();
				ordering.setId(rs.getInt("id"));
				ordering.setSellingPrice(rs.getInt("salePrice"));
				ordering.setOrderingDate(rs.getDate("orderDate"));
				Customer customer = new Customer();
				customer.setName(rs.getString("name"));
				ordering.setCustomer(customer);
				Book book = new Book();
				book.setTitle(rs.getString("title"));
				ordering.setBook(book);
				rtn.add(ordering);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}
	
	public void insert(Ordering ordering) {
		try (Connection c = dataSource.getConnection(); PreparedStatement ps = c.prepareStatement(sqls.getProperty("insert"));) {
			ps.setInt(1, ordering.getCustomerId());
			ps.setInt(2, ordering.getBookId());
			ps.setInt(3, ordering.getSellingPrice());
			ps.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
			ps.executeUpdate();
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public int selectCountByCustomerId(int customerId) {
		int rtn = -1;

		try (Connection c = dataSource.getConnection(); PreparedStatement ps = c.prepareStatement(sqls.getProperty("selectCountByCustomerId"));) {
			ps.setInt(1, customerId);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					rtn = rs.getInt(1);
				}
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}
	
	public int selectCountByBookId(int bookId) {
		int rtn = -1;

		String sql = "SELECT COUNT(*) FROM orders WHERE bookId = ?";
		try (Connection c = dataSource.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, bookId);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					rtn = rs.getInt(1);
				}
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}
}
