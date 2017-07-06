package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import dao.EmpDAO;
import entity.Emp;

public class TestCase {
	
	private SqlSession session;
	
	@Before
	public void init(){
		SqlSessionFactoryBuilder ssfb =
				new SqlSessionFactoryBuilder();
		
		SqlSessionFactory ssf = ssfb.build(
				TestCase.class.getClassLoader()
				.getResourceAsStream("SqlMapConfig.xml"));
		
		session = ssf.openSession();
	}
	
	@Test
	public void test1(){
		
		//getMapper方法返回一个符合Mapper映射器(EmpDAO)要求的对象
		EmpDAO dao = session.getMapper(EmpDAO.class);
		
		Emp emp = new Emp();
		emp.setName("李韩");
		emp.setAge(new Double(25));
		
		dao.save(emp);
		//提交事务
		session.commit();
		session.close();
	}
	
	
	@Test
	public void test2(){
		EmpDAO dao = session.getMapper(EmpDAO.class);
		List<Emp> data = dao.findAll();
		
		System.out.println(data);
		session.close();
	}
	
	@Test
	public void test3(){
		EmpDAO dao = session.getMapper(EmpDAO.class);
		Emp emp = dao.findById(8);
		System.out.println(emp);
		session.close();
	}
	
	@Test
	public void test4(){
		EmpDAO dao = session.getMapper(EmpDAO.class);
		
		Emp emp = dao.findById(8);
		System.out.println(emp);
		emp.setAge(emp.getAge()-5);
		
		dao.modify(emp);
		
		emp = dao.findById(8);
		System.out.println(emp);
		
		session.commit();
		session.close();
	}
	
	@Test
	public void test5(){
		EmpDAO dao = session.getMapper(EmpDAO.class);
		dao.delete(8);
		
		session.commit();
		session.close();
	}
	
	
	@Test
	public void test6(){
		EmpDAO dao = session.getMapper(EmpDAO.class);
		Map data = dao.findById2(6);
		
		System.out.println(data);
		
		session.close();
	}
	
}
