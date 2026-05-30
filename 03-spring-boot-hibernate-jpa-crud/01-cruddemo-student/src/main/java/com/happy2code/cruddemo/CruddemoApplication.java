package com.happy2code.cruddemo;

import com.happy2code.cruddemo.dao.StudentDao;
import com.happy2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class CruddemoApplication {

	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
			menu(studentDao);
		};
	}

	public void menu(StudentDao studentDao) {

		System.out.println("Accessing Database.....");

		int choice = 0;

		while (choice != 5) {

			System.out.println("1. Create Student");
			System.out.println("2. Read Student");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit");

			choice = scanner.nextInt();

			if (choice == 1) {
				createStudent(studentDao);
			}
			else if (choice == 2) {

			}
			else if (choice == 3) {

			}
			else if (choice == 4) {

			}
			else if (choice == 5) {
				System.out.println("Exiting.....");
				break;
			}
			else {
				System.out.println("Invalid Choice.....");
			}
		}
	}

	private void createStudent(StudentDao studentDao) {

		System.out.println("Creating Student.....");

		System.out.println("Enter Student First Name: ");
		String firstName = scanner.next();

		System.out.println("Enter Student Last Name: ");
		String lastName = scanner.next();

		System.out.println("Enter Student Email: ");
		String email = scanner.next();

		Student tempStudent = new Student(firstName, lastName, email);

		System.out.println("Saving Student.....");
		studentDao.save(tempStudent);

		System.out.println("Student Saved Successfully.....");
		System.out.println("Generating Student ID: " + tempStudent.getId());
	}
}
