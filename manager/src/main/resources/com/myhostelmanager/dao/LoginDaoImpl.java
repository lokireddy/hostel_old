package com.myhostelmanager.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myhostelmanager.model.Block;
import com.myhostelmanager.model.Login;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List getUser(String uid, String pwd) {
		 List<Login> logins = sessionFactory.getCurrentSession().createCriteria(Login.class).list();
		return logins;
		
	}

	@Override
	public List<Block> getBlocks(String hostelId) {
		
		String hql = "from Block where hid= '"+hostelId+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<Block> blocks = query.list();
		
		return blocks;
	}

	@Override
	public String getHostelName(String hostelId) {
		String hql = "select hname from Hostel where hid= '"+hostelId+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<String> hnames = query.list();
		return hnames.get(0);
	}
	
}
