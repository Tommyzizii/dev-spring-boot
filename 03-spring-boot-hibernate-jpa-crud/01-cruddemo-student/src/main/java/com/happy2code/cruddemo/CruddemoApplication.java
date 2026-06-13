package com.happy2code.cruddemo;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.happy2code.cruddemo.dao.StudentDao;
import com.happy2code.cruddemo.entity.Student;

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

		int choice = 0;

		while (choice != 5) {

			System.out.println("Accessing Database.....");
			System.out.println("########################");
			System.out.println("	Menu:");
			System.out.println("	1. Create Student	");
			System.out.println("	2. Read Student	");
			System.out.println("	3. Update Student	");
			System.out.println("	4. Delete Student	");
			System.out.println("	5. Exit	");
			System.out.println("########################");

			choice = scanner.nextInt();

			if (choice == 1) {
				createStudent(studentDao);
			}
			else if (choice == 2) {
				readMenu(studentDao);
			}
			else if (choice == 3) {
				updateStudent(studentDao);

			}
			else if (choice == 4) {
				deleteStudent(studentDao);
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
		System.out.println();
	}

	public void readMenu(StudentDao studentDao){

		String option = "0";

		while (!option.equals("2.6")) {

			System.out.println("#########################################");
			System.out.println("	2.1. Read ALL Student");
			System.out.println("	2.2. Read Student by ID");
			System.out.println("	2.3. Read Student by Email");
			System.out.println("	2.4. Read Student by First Name");
			System.out.println("	2.5. Read Student by Last Name");
			System.out.println("	2.6. Back to Main Menu");
			System.out.println("#########################################");

			option = scanner.next();

			if(option.equals("2.1")){
				readAllStudents(studentDao);
			}
			else if(option.equals("2.2")){
				readStudentById(studentDao);
			}
			else if(option.equals("2.3")){
				readStudentByEmail(studentDao);
			}
			else if(option.equals("2.4")){
				readStudentByFirstName(studentDao);
			}
			else if(option.equals("2.5")){
				readStudentByLastName(studentDao);
			}
			else if(option.equals("2.6")){
				return;
			}
		}

	}

	private void readAllStudents(StudentDao studentDao) {
		System.out.println("Reading Student.....");

		List<Student> students = studentDao.findAll();

		for(Student theStudent : students){
			System.out.println("Student Details: " + theStudent.toString());
		}
	}


	private void readStudentById(StudentDao studentDao)
	{
		System.out.println("Reading Student.....");

		System.out.println("Enter Student ID: ");
		int id = scanner.nextInt();

		Student student = studentDao.findById(id);

		if(student == null) {
			System.out.println("Student not found.....");
				return;
		}

		System.out.println("Student Details: " + student.toString());
		System.out.println();
	}

	private void readStudentByEmail(StudentDao studentDao) {
		System.out.println("Reading Student.....");

		System.out.println("Enter Student Email: ");
		scanner.nextLine();
		String email = scanner.nextLine();

		List<Student> students = studentDao.findAllStudentsById(email);
		for (Student theStudent: students){
			System.out.println("Student Details: " + theStudent.toString());
		}

	}

	private void readStudentByFirstName(StudentDao studentDao) {
	}

	private void readStudentByLastName(StudentDao studentDao) {
	}

	private void updateStudent(StudentDao studentDao){
		System.out.println("Getting Student.....");
		
		System.out.println("Enter Student ID: ");
		int id = scanner.nextInt();
		Student student = studentDao.findById(id);
		
		System.out.println("Enter Student First Name to Update: ");
		String firstName = scanner.next();
		student.setFirstName(firstName);
		
		studentDao.updateStudent(student);

		System.out.println("Updated Student Details: " + student.toString());
		System.out.println("Student Updated Successfully.....");

	}

	private void deleteStudent(StudentDao studentDao){
		System.out.println("Getting Student.....");
		
		System.out.println("Enter Student ID: ");
		int id = scanner.nextInt();
		studentDao.deleteStudent(id);
		System.out.println("Student Deleted Successfully.....");
	}

}
