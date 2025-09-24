package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(8);
        System.out.println(seller);
        System.out.println();

        System.out.println("=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }
        System.out.println();

        System.out.println("=== TEST 3: seller findAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }
        System.out.println();

        /*System.out.println("=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "Maria", "maria@gmail.com", LocalDate.of(1980,4,16), 4500.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id: " + newSeller.getId());
        System.out.println();*/

        /*System.out.println("=== TEST 5: seller update ===");
        seller = sellerDao.findById(14);
        seller.setName("Pedro Guilherme");
        seller.setEmail("pedro@gmail.com");
        seller.setBirthDate(LocalDate.of(1998, 04, 26));
        seller.setSalary(1000.00);
        sellerDao.update(seller);
        System.out.println("Update completed!");*/

        System.out.println("=== TEST 5: seller delete ===");
        System.out.println("Enter the id for delete test: ");
        int id = scanner.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed");

        scanner.close();
    }
}
