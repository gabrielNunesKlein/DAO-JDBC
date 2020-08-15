package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TESTE 1: department FindById ===");
		Department dep =  depDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== TESTE 2: department FindAll ===");
		List<Department> list = new ArrayList<>();
		list = depDao.findAll();
		for(Department d : list){
			System.out.println(d);
		}
		
		System.out.println("\n=== TESTE 3: department insert ===");
		Department depI = new Department(null, "Music");
		depDao.insert(depI);
		System.out.println("Inserted! new Id = " + depI.getId());
		
		System.out.println("\n=== TESTE 4: department update ===");
		dep = depDao.findById(1);
		dep.setName("Nootboks");
		depDao.update(dep);
		System.out.println("Update Completed");
		
		System.out.println("\n=== TESTE 5: department delete ===");
		System.out.print("Informe Id para delete: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Delete completed");
		sc.close();
	}

}
