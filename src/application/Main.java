package application;

import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner scNum = new Scanner (System.in);
		Scanner scStr = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		
		System.out.print("Enter departmnent's name: ");
		String departamentName = scStr.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = scStr.nextLine();
		System.out.print("Level: ");
		String workerLevel = scStr.nextLine();
		System.out.print("Base salary: ");
		Double workerBaseSalary = scNum.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, new Departament(departamentName));
		
		System.out.print("How many contracts to this worker? ");
		int numberOfContracts = scNum.nextInt();
		
		for (int i = 1; i <= numberOfContracts; i++) {
			
			System.out.println("Enter contract #" + i + " data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date dateContract = sdf.parse(scStr.next());
			System.out.print("Value per hour: ");
			double salaryPerHour = scNum.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = scNum.nextInt();
			
			HourContract contract = new HourContract(dateContract, salaryPerHour, hours);
			worker.addContract(contract);
			
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = scStr.next();
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartament().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		scNum.close();
		scStr.close();
	}

}
