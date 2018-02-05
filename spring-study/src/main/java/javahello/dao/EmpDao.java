package javahello.dao;

import org.springframework.stereotype.Repository;

import javahello.entity.Emp;

@Repository
public class EmpDao {

	public Emp findEmp(Integer id) {
		Emp e = new Emp();
		e.setId(id);
		return e;
	}
}
