package intefaceExer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import intefaceExer.entities.Contract;
import intefaceExer.entities.Installment;
import intefaceExer.services.ContractService;
import intefaceExer.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter contract data:");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract Value: ");
		Double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.print("Enter number Installments: ");
		Integer n = sc.nextInt();
		
		ContractService cs = new ContractService(new PaypalService());
		cs.processContract(contract, n);
		
		System.out.println("Installments: ");
		for (Installment installments: contract.getInstallments()) {
			System.out.println(installments);
		}
		
		sc.close();

	}

}
