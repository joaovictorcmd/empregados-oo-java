package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Nome do departamento: ");
			String departName = sc.nextLine();
			System.out.print("Dia do pagamento: ");
			int payDay = sc.nextInt();
			sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Telefone: ");
			String phone = sc.nextLine();
			System.out.println();

			Address address = new Address(email, phone);
			Department department = new Department(departName, payDay, address);

			System.out.print("Quantos funcionários tem o departamento? ");
			int n = sc.nextInt();
			sc.nextLine();
			System.out.println();

			for (int i = 0; i < n; i++) {
				System.out.printf("Dados do funcionário %d:\n", (i + 1));
				System.out.print("Nome: ");
				String employeeName = sc.nextLine();
				System.out.print("Salário: ");
				double salary = sc.nextDouble();
				sc.nextLine();
				System.out.println();

				Employee employee = new Employee(employeeName, salary);
				department.addEmployee(employee);
			}

			System.out.println("FOLHA DE PAGAMENTO:");
			System.out.println(department);

			sc.close();
		} catch (Exception e) {
			System.out.println();
			System.err.println("OS DADOS FORAM INSERIDOS DE FORMA INCORRETA.");
			System.err.println("VERIFIQUE AS INFORMAÇÕES E TENTE NOVAMENTE!");
			System.out.println();
			main(args);
		}
	}

}
