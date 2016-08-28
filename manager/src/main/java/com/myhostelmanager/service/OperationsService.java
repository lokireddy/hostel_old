package com.myhostelmanager.service;

import com.myhostelmanager.form.NewTenantForm;
import com.myhostelmanager.model.Person;

public interface OperationsService {

	public boolean isPersonExist(NewTenantForm newTenantForm);
	public Person personFormToPerson(NewTenantForm newTenantForm);
	public void savePerson(Person person);
}
