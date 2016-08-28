package com.myhostelmanager.dao;

import java.util.List;

import com.myhostelmanager.model.Person;

public interface OperationsDao {
	public List getMobileNumbers(String bId);
	public void savePerson(Person person);
}
