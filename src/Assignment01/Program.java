package Assignment01;

public class Program {
	String name;
	double lengthOfAbsence;
	double amount;
	
	public Program(String name, double lengthOfAbsence, double amount) {
		super();
		this.name = name;
		this.lengthOfAbsence = lengthOfAbsence;
		this.amount = amount;
	}
	
	public void calculate() {
		
		double amount = this.amount;
		double exemption = 0;
		String limit = "";
		double personalEx = 0;
		double speTax = 0;
		double regTax = 0;
		
		if(this.lengthOfAbsence < 1) {
			
			exemption = 0;
			limit = "No";
			personalEx = 0;
			speTax = 0;
			regTax = this.amount;
			
		}else if(this.lengthOfAbsence >=1 && this.lengthOfAbsence <2) {
			
			exemption = 200.00;
			limit = "No";
			
			if(amount > exemption) {
				personalEx = 0;
				regTax = amount;
				
			}else {
				personalEx = exemption;
				speTax = 0;
				regTax = 0;}
			
		}else {
			
			exemption = 800.00;
			limit = "Yes";
			
			if(this.amount <= 800) {
				personalEx = this.amount;
				speTax = 0;
				regTax = 0;
			}else {
				personalEx = exemption;
				if(this.amount - personalEx >= 300) {
					speTax = 300;
					regTax = this.amount - personalEx - 300;
				}else {
					speTax = this.amount - personalEx;
					regTax = 0;}
			}
		}
		
		System.out.printf("...Maximum Personal Exemption %14s%.2f\n", "$", exemption);
		System.out.printf("...Include Limited Alcohol & Tobacco? %12s\n", limit);
		System.out.printf("Usable Personal Exemption %30s%.2f\n", "$", personalEx);
		System.out.printf("Amount Subject to Special Duty & Taxes %17s%.2f\n", "$", speTax);
		System.out.printf("Amount Subject to Regular Duty & Taxes %17s%.2f\n", "$", regTax);
		System.out.println("                                                       -------");
		System.out.printf("Total Amount of Imported Goods %24s%.2f", "$", this.amount);
		
	}
	
	public String returnLimit() {
		
		String limit = "";
		
		if(this.lengthOfAbsence < 2) {
			limit = "No";
		}else
			limit = "Yes";
		
		return limit;
	}
			
	public void displayResult() {
		
		int idx1 = this.name.indexOf(",");
		int idx2 = this.name.lastIndexOf(",");
		
		String lastName = this.name.substring(0, idx1);
		String firstName = this.name.substring(idx1+2, idx2);
		String initials = this.name.substring(idx2+2);
		
		System.out.printf("Import Exemption Report for %s %s %s\n", firstName, initials, lastName);
		System.out.println("---------------------------------------------------------------");
		System.out.printf("Absence Period (days) %28.1f\n", this.lengthOfAbsence);
		
		calculate();
	}

}
