package entities;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Department {

	private static Locale local = new Locale("pt", "BR");
	private static NumberFormat nf = NumberFormat.getCurrencyInstance(local);

	private String name;
	private int payDay;

	private Address address;
	private List<Employee> employees = new ArrayList<>();

	public Department() {
		super();
	}

	public Department(String name, int payDay, Address address) {
		super();
		this.name = name;
		this.payDay = payDay;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPayDay() {
		return payDay;
	}

	public void setPayDay(int payDay) {
		this.payDay = payDay;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public void removeEmployee(Employee employee) {
		employees.remove(employee);
	}

	public double payroll() {
		double sum = 0;

		for (Employee employee : employees) {

			sum += employee.getSalary();
		}

		return sum;

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Departamento " + name + " = " + nf.format(payroll()) + "\n");
		sb.append("Pagamento realizado no dia " + payDay + "\n");
		sb.append("Funcionários:\n");
		for (Employee employee : employees) {
			sb.append(employee + "\n");
		}
		sb.append("\nPara dúvidas, favor entrar em contato: \n");
		sb.append(address);

		return sb.toString();
	}

}
