package org.Intutech.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.Intutech.Been.Notes;
import org.Intutech.Been.Source;
import org.Intutech.Dbutil.Dbutil;



public class QuickModel {

	public boolean save (Source so) {
		boolean b = false;
		
		
		Connection con = Dbutil.getConnection();
		
		try {
			PreparedStatement kalyan = con.prepareStatement("insert into notes values(?,?,?,?)");
			kalyan.setInt(1, so.getId());
			kalyan.setString(2, so.getName());
			kalyan.setString(3, so.getEMail());
			kalyan.setString(4, so.getPassword());
			int result = kalyan.executeUpdate();
			
			if(result !=0) {
				b=true;
			}
			
			
		} catch(Exception e){
			e.printStackTrace();
			
			
		} finally {
			Dbutil.closeConnection(con);
		}
		
		return b;
	}
	public boolean auth(Source so) {
		boolean b = false;
		
		
		Connection con = Dbutil.getConnection();
		
		try {
			PreparedStatement kalyan = con.prepareStatement("select id from notes where name=? and pass=?");
		
			kalyan.setString(1, so.getName());
			kalyan.setString(2, so.getPassword());
			ResultSet rs = kalyan.executeQuery();
			if(rs != null) {
				b=true;
			}
			
			
		} catch(Exception e){
			e.printStackTrace();
			
			
		} finally {
			Dbutil.closeConnection(con);
		}
		
		return b;
	}
	public int id(Source so) {
		
		int id =0;
		
		Connection con = Dbutil.getConnection();
		
		try {
			PreparedStatement kalyan = con.prepareStatement("select id from notes where name=? and pass=?");
		
			kalyan.setString(1, so.getName());
			kalyan.setString(2, so.getPassword());
			ResultSet rs = kalyan.executeQuery();
			if(rs != null) {
				
				while(rs.next()) {
					id = rs.getInt("id");
					System.out.println("ID In model : "+id);
				}
			}
			
			
		} catch(Exception e){
			e.printStackTrace();
			
			
		} finally {
			Dbutil.closeConnection(con);
		}
		
		return id;
	}
	
	public boolean saveNotes(Notes so) {
		boolean b = false;
		
		
		Connection con = Dbutil.getConnection();
		
		try {
			PreparedStatement kalyan = con.prepareStatement("insert into notes1 values(?,?,?)");
			kalyan.setInt(1, so.getSr());
			kalyan.setString(2, so.getTital());
			kalyan.setString(3, so.getDis());
			int result = kalyan.executeUpdate();
			
			if(result !=0) {
				b=true;
			}
			
			
		} catch(Exception e){
			e.printStackTrace();
			
			
		} finally {
			Dbutil.closeConnection(con);
		}
		
		return b;
	}
	public List<Notes> getAll(Notes id){
		List<Notes> contactList = new ArrayList<Notes>();
		Connection con = Dbutil.getConnection();
		System.out.println("in model id is "+id);
		try {
			PreparedStatement stmt = con.prepareStatement("select * from notes1 where sr=?");
			stmt.setInt(1, id.getSr());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Notes c = new Notes();
				c.setSr(rs.getInt("sr"));
				c.setTital(rs.getString("tital"));
				c.setDis(rs.getString("dis"));
				contactList.add(c);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Dbutil .closeConnection(con);
			
		}
		return contactList; 
		
	}
	public List<Source> get(Notes id){
		List<Source> user = new ArrayList<Source>();
		Connection con = Dbutil.getConnection();
		System.out.println("in model id is "+id);
		try {
			PreparedStatement stmt = con.prepareStatement("select * from notes where id=?");
			stmt.setInt(1, id.getSr());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Source c = new Source();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				user.add(c);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Dbutil .closeConnection(con);
			
		}
		return user; 
		
	}
	public boolean delete(int id) {
		boolean flag = false;
		Connection con = Dbutil.getConnection();
		try {
			 	PreparedStatement stmt = con.prepareStatement("delete from notes1 where sr=?");
			 	stmt.setInt(1, id);
			 	int count = stmt.executeUpdate();
			 	if(count>0) {
			 		flag = true;
			 	}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Dbutil.closeConnection(con);
		}
		return flag;
	}
	public boolean editById(int id, Notes so) {
boolean b = false;
		
		
		Connection con = Dbutil.getConnection();
		
		try {
			PreparedStatement kalyan = con.prepareStatement("update notes1 set tital=? dis=? where sr=?");
			kalyan.setInt(1, so.getSr());
			kalyan.setString(2, so.getTital());
			kalyan.setString(3, so.getDis());
			int result = kalyan.executeUpdate();
			
			if(result !=0) {
				b=true;
			}
			
			
		} catch(Exception e){
			e.printStackTrace();
			
			
		} finally {
			Dbutil.closeConnection(con);
		}
		
		return b;
	}
	
	
	
}
