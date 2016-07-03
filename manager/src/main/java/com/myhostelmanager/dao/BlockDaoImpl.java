package com.myhostelmanager.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myhostelmanager.model.Block;

@Repository("blockDao")
public class BlockDaoImpl implements BlockDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List getBlocks(String hId) {
		System.out.println("Hid in getBlocks():"+hId);
		String hql = "from Block where hid= '"+hId+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<Block> blocks = query.list();
        System.out.println("Blocks Size:"+blocks.size());
		return blocks;
	}

}
