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

	// ── ANSI styles ──────────────────────────────────────────
	static final String RESET  = "\033[0m";
	static final String BOLD   = "\033[1m";
	static final String GREEN  = "\033[0;32m";
	static final String CYAN   = "\033[0;36m";
	static final String YELLOW = "\033[0;33m";
	static final String RED    = "\033[0;31m";
	static final String PURPLE = "\033[0;35m";
	static final String GRAY   = "\033[0;90m";

	static void line()  { System.out.println(GRAY + "  ────────────────────────────────────────" + RESET); }
	static void blank() { System.out.println(); }
	// ─────────────────────────────────────────────────────────

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

			blank();
			System.out.println(GRAY + "  ╔══════════════════════════════════════╗" + RESET);
			System.out.println(GRAY + "  ║  " + CYAN + BOLD + "Accessing Database....." + RESET + GRAY + "             ║" + RESET);
			System.out.println(GRAY + "  ╠══════════════════════════════════════╣" + RESET);
			System.out.println(GRAY + "  ║  " + PURPLE + BOLD + "Menu:" + RESET + GRAY + "                               ║" + RESET);
			System.out.println(GRAY + "  ║  " + CYAN + "1." + RESET + " Create Student" + GRAY + "                   ║" + RESET);
			System.out.println(GRAY + "  ║  " + CYAN + "2." + RESET + " Read Student" + GRAY + "                     ║" + RESET);
			System.out.println(GRAY + "  ║  " + CYAN + "3." + RESET + " Update Student" + GRAY + "                   ║" + RESET);
			System.out.println(GRAY + "  ║  " + RED  + "4." + RESET + " Delete Student" + GRAY + "                   ║" + RESET);
			System.out.println(GRAY + "  ║  " + RED  + "5." + RESET + " Delete All Students" + GRAY + "              ║" + RESET);
			System.out.println(GRAY + "  ║  " + GRAY + "6. Exit                             ║" + RESET);
			System.out.println(GRAY + "  ╚══════════════════════════════════════╝" + RESET);
			blank();
			System.out.print(YELLOW + "  ▶  " + RESET);

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
			else if (choice == 5){
				deleteAll(studentDao);
			}
			else if (choice == 6) {
				System.out.println("Exiting.....");
				break;
			}
			else {
				System.out.println("Invalid Choice.....");
			}
		}
	}

	private void createStudent(StudentDao studentDao) {

		blank();
		line();
		System.out.println(PURPLE + BOLD + "  Creating Student....." + RESET);
		line();

		System.out.print(CYAN + "  Enter Student First Name: " + RESET);
		String firstName = scanner.next();

		System.out.print(CYAN + "  Enter Student Last Name: " + RESET);
		String lastName = scanner.next();

		System.out.print(CYAN + "  Enter Student Email: " + RESET);
		String email = scanner.next();

		Student tempStudent = new Student(firstName, lastName, email);

		System.out.println(GRAY + "  Saving Student....." + RESET);
		studentDao.save(tempStudent);

		blank();
		System.out.println(GREEN + "  ✔  Student Saved Successfully!" + RESET);
		System.out.println(GREEN + "  ✔  Generating Student ID: " + YELLOW + BOLD + tempStudent.getId() + RESET);
		blank();
	}

	public void readMenu(StudentDao studentDao){

		String option = "0";

		while (!option.equals("2.6")){

			blank();
			line();
			System.out.println(PURPLE + BOLD + "  Read Menu:" + RESET);
			line();
			System.out.println(CYAN + "  2.1." + RESET + " Read ALL Student");
			System.out.println(CYAN + "  2.2." + RESET + " Read Student by ID");
			System.out.println(CYAN + "  2.3." + RESET + " Read Student by Email");
			System.out.println(CYAN + "  2.4." + RESET + " Read Student by First Name");
			System.out.println(CYAN + "  2.5." + RESET + " Read Student by Last Name");
			System.out.println(GRAY + "  2.6. Back to Main Menu" + RESET);
			blank();
			System.out.print(YELLOW + "  ▶  " + RESET);

			option = scanner.next();


			if(option.equals("2.1")) {
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
		blank();
		line();
		System.out.println(PURPLE + BOLD + "  Reading Student....." + RESET);
		line();

		List<Student> students = studentDao.findAll();

		for(Student theStudent : students){
			System.out.println(GREEN + "  • " + RESET + "Student Details: " + theStudent.toString());
		}
		blank();
	}


	private void readStudentById(StudentDao studentDao)
	{
		blank();
		line();
		System.out.println(PURPLE + BOLD + "  Reading Student....." + RESET);
		line();

		System.out.print(CYAN + "  Enter Student ID: " + RESET);
		int id = scanner.nextInt();

		Student student = studentDao.findById(id);

		if(student == null) {
			System.out.println(RED + "  ✖  Student not found....." + RESET);
				return;
		}

		System.out.println(GREEN + "  ✔  Student Details: " + RESET + student.toString());
		blank();
	}

	private void readStudentByEmail(StudentDao studentDao) {
		blank();
		line();
		System.out.println(PURPLE + BOLD + "  Reading Student....." + RESET);
		line();

		System.out.print(CYAN + "  Enter Student Email: " + RESET);
		scanner.nextLine();
		String email = scanner.nextLine();

		List<Student> students = studentDao.findAllStudentsById(email);
		for (Student theStudent: students){
			System.out.println(GREEN + "  • " + RESET + "Student Details: " + theStudent.toString());
		}
		blank();
	}

	private void readStudentByFirstName(StudentDao studentDao) {
	}

	private void readStudentByLastName(StudentDao studentDao) {
	}

	private void updateStudent(StudentDao studentDao){
		blank();
		line();
		System.out.println(PURPLE + BOLD + "  Getting Student....." + RESET);
		line();
		
		System.out.print(CYAN + "  Enter Student ID: " + RESET);
		int id = scanner.nextInt();
		Student student = studentDao.findById(id);
		
		System.out.print(CYAN + "  Enter Student First Name to Update: " + RESET);
		String firstName = scanner.next();
		student.setFirstName(firstName);
		
		studentDao.updateStudent(student);

		blank();
		System.out.println(GREEN + "  ✔  Updated Student Details: " + RESET + student.toString());
		System.out.println(GREEN + "  ✔  Student Updated Successfully!" + RESET);
		blank();
	}

	private void deleteStudent(StudentDao studentDao){
		blank();
		line();
		System.out.println(RED + BOLD + "  Getting Student....." + RESET);
		line();
		
		System.out.print(CYAN + "  Enter Student ID: " + RESET);
		int id = scanner.nextInt();
		studentDao.deleteStudent(id);
		System.out.println(GREEN + "  ✔  Student Deleted Successfully!" + RESET);
		blank();
	}

	private void deleteAll(StudentDao studentDao){
		blank();
		line();
		System.out.println(RED + BOLD + "  ⚠  Deleting All Students....." + RESET);
		line();

		int numRowsDeleted = studentDao.deleteAll();
		System.out.println(GREEN + "  ✔  Deleted " + YELLOW + BOLD + numRowsDeleted + RESET + GREEN + " students." + RESET);
		blank();
	}
}