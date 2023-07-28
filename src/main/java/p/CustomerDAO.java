package p;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class CustomerDAO extends MadangDAO{
//	final static String SELECT = "SELECT id, name, address, phone FROM customer";
//	final static String SELECT_BY_ID = "SELECT id, name, address, phone FROM customer WHERE id = ?";
//	final static String INSERT = "INSERT INTO customer (name, address, phone) VALUES (?,?,?)";
//	final static String UPDATE = "UPDATE customer SET name = ?, address = ?, phone = ? WHERE id = ?";
//	final static String DELETE = "DELETE FROM customer WHERE id = ?";
//	Properties sqls;
	
	final static String QUERY_PATH = "/p/customer_sql.properties";
	final static Map<String, String> QM;
	
	static {
		try {
			QM = QueryLoader.instance().load(QUERY_PATH);
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
			
			throw new ExceptionInInitializerError(ioe);
		}
	}
	
	public CustomerDAO() {
		super();
		
		
	}
	
	public List<Customer> select() {
		List<Customer> rtn = new ArrayList<>();

		try
		//(Connection c = dataSource.getConnection();)
		{
				//PreparedStatement ps = c.prepareStatement(QM.get("select"));
				//ResultSet rs = ps.executeQuery();
				
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<List<Customer>> h = new BeanListHandler<>(Customer.class);
			//BeanListHandler<Customer> h = new BeanListHandler<>(Customer.class);
			rtn = qr.query(QM.get("select"), h);
//			while (rs.next()) {
//				Customer customer = new Customer();
//				customer.setId(rs.getInt("id"));
//				customer.setName(rs.getString("name"));
//				customer.setAddress(rs.getString("address"));
//				customer.setPhone(rs.getString("phone"));
//				rtn.add(customer);
//			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}
	
	public Customer selectById(int id) {
		Customer rtn = null;

		try (Connection c = dataSource.getConnection();
		/* PreparedStatement ps = c.prepareStatement(QM.get("select_by_id")); */
			) {
			QueryRunner qr = new QueryRunner();
			ResultSetHandler<Customer> h = new BeanHandler<>(Customer.class);
			Object[] p = {id};
			rtn = qr.query(c, QM.get("select_by_id"), h, p);
				/*
				 * ps.setInt(1, id); try (ResultSet rs = ps.executeQuery();) { if (rs.next()) {
				 * rtn = new Customer(); rtn.setId(rs.getInt("id"));
				 * rtn.setName(rs.getString("name")); rtn.setAddress(rs.getString("address"));
				 * rtn.setPhone(rs.getString("phone")); } }
				 */

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}
	
	public void insert(Customer customer) {
		
		try (Connection c = dataSource.getConnection();
				//PreparedStatement ps = c.prepareStatement(QM.get("insert"));
				) {
			QueryRunner qr = new QueryRunner();
			Object[] p = {customer.getName(), customer.getAddress(), customer.getPhone()};
			qr.execute(c, QM.get("insert"), p);
			
//			ps.setString(1, customer.getName());
//			ps.setString(2, customer.getAddress());
//			ps.setString(3, customer.getPhone());
//			ps.executeUpdate();
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public void update(Customer customer) {
		try (Connection c = dataSource.getConnection();
				//PreparedStatement ps = c.prepareStatement(QM.get("update"));
			) {
			
			QueryRunner qr = new QueryRunner();
			Object[] p = {customer.getName(), customer.getAddress(), customer.getPhone(), customer.getId()};
			qr.execute(c, QM.get("update"), p);
			
//			ps.setString(1, customer.getName());
//			ps.setString(2, customer.getAddress());
//			ps.setString(3, customer.getPhone());
//			ps.setInt(4, customer.getId());
//			ps.executeUpdate();
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public void delete(int id) throws HasOrderingException {
		try (Connection c = dataSource.getConnection();
			//PreparedStatement ps = c.prepareStatement(QM.get("delete"));
				) {
			
			QueryRunner qr = new QueryRunner();
			Object[] p = {id};
			qr.execute(c, QM.get("delete"), p);
			
//			ps.setInt(1, id);
//			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
