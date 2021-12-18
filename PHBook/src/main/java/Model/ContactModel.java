  package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DbUtil.Dbutil;
import been.Contact;

public class ContactModel {
	public List<Contact> getAll(){
		List<Contact> contactList = new ArrayList<Contact>();
		Connection con = Dbutil.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from book");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Contact c = new Contact();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setContact(rs.getString("contact"));
				c.setDob(rs.getString("dob"));
				contactList.add(c);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Dbutil .closeConnection(con);
			
		}
		return contactList; 
		
	}
	
	public Contact editById(int id) {
		Contact contact = new Contact();
		Connection con = Dbutil.getConnection
				();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from phbook where id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setContact(rs.getString("contact"));
				contact.setDob(rs.getString("dob"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			Dbutil.closeConnection(con);
		}
		return contact;
	}

	public boolean update(Contact ct) {
		boolean flag = false;
		Connection con = Dbutil.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("update phbook set name=?, contact=?, dob=? where id=?");
			stmt.setString(1, ct.getName());
			stmt.setString(2, ct.getContact());
			stmt.setString(3, ct.getDob());
			stmt.setInt(4, ct.getId());
			int count = stmt.executeUpdate();
			if(count>0) {
				flag = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			Dbutil.closeConnection(con);
		}
		return flag;
	}
	public boolean create(Contact ct) {
		boolean flag = false;
		Connection con = Dbutil.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("insert into book values(?,?,?,?)");
			stmt.setInt(1, ct.getId());
			stmt.setString(2, ct.getName());
			stmt.setString(3, ct.getContact());
			stmt.setString(4, ct.getDob());
		
			int count = stmt.executeUpdate();
			if(count>0) {
				flag = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			Dbutil.closeConnection(con);
		}
		return flag;
	}
	

}

