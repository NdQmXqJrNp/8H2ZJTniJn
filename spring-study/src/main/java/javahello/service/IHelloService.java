package javahello.service;

import javahello.entity.Emp;

public interface IHelloService {

	Emp findEmp(Integer id);

	Integer getAOPValue();
}
