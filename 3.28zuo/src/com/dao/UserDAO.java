package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.User;
import com.util.DBService;

public class UserDAO implements BaseDAO<User>{
	public User login(User user){
		String sql="select * from user where username='"+user.getUsername()+"'and password='"+user.getPassword()+"'";
        List<User> users=findBySQL(sql);
        return users.size()>0?users.get(0):null;
	}
	@Override
	public void add(User t) {
		
		String sql="insert into user values(null,'"+t.getUsername()+"','"+t.getPassword()+"')";
		System.err.println(sql);
		Statement stmt=DBService.getStatement();
	try{
		stmt.executeUpdate(sql);
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from user where id='"+id+"'";
		Statement stmt=DBService.getStatement();
		try{
			stmt.executeUpdate(sql);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		String sql="update user set username='"+t.getUsername()+"',password='"+t.getPassword()+"' where id="+t.getId();
		System.out.println(sql);
		Statement stmt=DBService.getStatement();
		try{
			stmt.executeUpdate(sql);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from user where id="+id;
		List<User>  users=findBySQL(sql);
		
		return users.size()>0?users.get(0):null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		String sql="select * from user";
		return findBySQL(sql);
	}

	@Override
	public List<User> findBySQL(String sql) {
		// TODO Auto-generated method stub
		List<User> users=new ArrayList<>(); 
		try{    
			Statement stmt=DBService.getStatement();
			ResultSet rs=stmt.executeQuery(sql);
		        while(rs.next()){	
		        	User u =new User();
		        	u.setId(rs.getInt(1));
		        	u.setUsername(rs.getString(2));
		        	u.setPassword(rs.getString(3));
		        	users.add(u);
		        }   
		       
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
	}
		return users;
	
		
	}
	@Override
	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		String sql="select * from user where username like'%"+name+"%'";	
		return findBySQL(sql);
	}

}
