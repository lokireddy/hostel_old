package com.myhostelmanager.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myhostelmanager.controller.MainController;
import com.myhostelmanager.model.Person;

@Repository("operationsDao")
public class OperationsDaoImpl implements OperationsDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	Logger logger=LoggerFactory.getLogger(MainController.class);
	
	public List getMobileNumbers(String bId) {
		logger.info("Block Id:{}", bId);
		String hql = "select mobile from Person where bId = '" + bId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<String> mobileNos = query.list();
		return mobileNos;
	}

	public void savePerson(Person person) {
		try{
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().save(person);
			sessionFactory.getCurrentSession().getTransaction().commit();
			logger.info("Person saved to DataBase.");
		}catch(HibernateException e){
			logger.error(e.getMessage());
		}
		
	}
}
