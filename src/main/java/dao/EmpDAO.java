package dao;

import java.util.List;
import java.util.Map;

import entity.Emp;

/**
 * MapperÓ³ÉäÆ÷
 */
public interface EmpDAO {
	public void save(Emp emp);
	public List<Emp> findAll();
	public Emp findById(int id);
	public void modify(Emp emp);
	public void delete(int id);
	public Map findById2(int id);
}
