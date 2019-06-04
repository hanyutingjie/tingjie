package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.pojo.car;
import com.util.DBService;

public class CarDAO implements BaseDAO<car>{
    
	@Override
	public void add(car t) {
		// TODO Auto-generated method stub
		String sql="insert into car values(null,'"+t.getColor()+"','"+t.getName()+"','"+t.getPrice()+"',"+t.getImg()+")";
		try {
			DBService.getStatement().executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from car where id="+id;
		try {
			DBService.getStatement().executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(car t) {
		// TODO Auto-generated method stub
		String sql="";
		if(t.getImg().equals(""))
			sql="update car set name='"+t.getName()+"' ,color='"+t.getColor()+"' ,price="+t.getPrice()+" where id="+t.getId();
		else
	       sql="update car set name='"+t.getName()+"' ,color='"+t.getColor()+"' ,price="+t.getPrice()+" ,img='"+t.getImg()+"' where id="+t.getId();
	try {
		DBService.getStatement().executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Override
	public car findById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from car where id="+id;
		List<car>  cars=findBySQL(sql);
		
		return cars.size()>0?cars.get(0):null;
	}

	@Override
	public List<car> findAll() {
		// TODO Auto-generated method stub
		String sql="select * from car";
		return findBySQL(sql);
		
	}

	@Override
	public List<car> findBySQL(String sql) {
		// TODO Auto-generated method stub
		Statement stmt = DBService.getStatement();
		List<car> cars = new ArrayList<>();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				car c = new car();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setColor(rs.getString(3));
				c.setImg(rs.getString(4));
				c.setPrice(rs.getDouble(5));
				cars.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cars;

			}
	@Override
	public List<car> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<car> findByCondition(car c) {
		// TODO Auto-generated method stub
		String sql="select * from car where 1=1";
    	if(!c.getName().equals(""))
    		sql+=" and name like '%"+c.getName()+"%'";
    	if(!c.getColor().equals(""))
    		sql+=" and color like '%"+c.getColor()+"%'";
    	if(c.getPrice()!=0.0 && c.getPrice1()!=0.0)
    		sql+=" and price between "+c.getPrice()+" and "+c.getPrice1();
    	return findBySQL(sql);
	}



}
