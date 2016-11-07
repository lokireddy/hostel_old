package com.myhostelmanager.dao;

import java.util.List;

import com.myhostelmanager.model.Person;

public interface OperationsDao {
	public List getMobileNumbers();
	public void savePerson(Person person);
}
