package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String address;

	// refactoring 2 Primitive Obsession
	private LocalDate joinedDate;

	private int monthWorkingInYear;

	private boolean isForeigner;
	private boolean gender; // true = Laki-laki, false = Perempuan

	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;

	private String spouseName;
	private String spouseIdNumber;

	// refactoring 5 Data Clumps
	private List<Child> children;

	// refactoring 1 Long Parameter List
	public Employee(PersonalInfo info, LocalDate dateJoined) {
		this.employeeId = info.employeeId;
		this.firstName = info.firstName;
		this.lastName = info.lastName;
		this.idNumber = info.idNumber;
		this.address = info.address;
		this.isForeigner = info.isForeigner;
		this.gender = info.gender;

		this.joinedDate = dateJoined;

		// refactoring 5 Data Clumps
		children = new LinkedList<>();
	}

	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	
	// refactoring 3 Duplicate Code
	public void setMonthlySalary(int grade) {
		int baseSalary;
		switch (grade) {
			case 1: baseSalary = 3000000; break;
			case 2: baseSalary = 5000000; break;
			case 3: baseSalary = 7000000; break;
			default: baseSalary = 0;
		}
		monthlySalary = isForeigner ? (int)(baseSalary * 1.5) : baseSalary;
	}

	public void setAnnualDeductible(int deductible) {
		this.annualDeductible = deductible;
	}

	public void setAdditionalIncome(int income) {
		this.otherMonthlyIncome = income;
	}

	// refactoring 4 Inconsistent Naming
	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = spouseIdNumber;
	}

	// refactoring 5 Data Clumps
	public void addChild(String childName, String childIdNumber) {
		children.add(new Child(childName, childIdNumber));
	}

	public int getAnnualIncomeTax() {

		//Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();

		// refactoring 2 Primitive Obsession
		if (date.getYear() == joinedDate.getYear()) {
			monthWorkingInYear = date.getMonthValue() - joinedDate.getMonthValue();
		} else {
			monthWorkingInYear = 12;
		}

		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible,
				spouseIdNumber.equals(""), children.size());
	}
}
