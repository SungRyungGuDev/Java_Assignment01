package Assignment01;

import java.util.Scanner;

public class Assignment01 {

	public static void main(String[] args) {
		
		String name = new String();
		double lengthOfAbsence;
		double amount;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Traveller's name (last, first, initials): ");
		name = sc.nextLine();
		System.out.print("Length of absence (# of days): ");
		lengthOfAbsence = sc.nextDouble();
		System.out.print("Total amount of imported goods ($ CAD): ");
		amount = sc.nextDouble();
		
		Program program = new Program(name, lengthOfAbsence, amount);
		
		program.displayResult();
	}
}
