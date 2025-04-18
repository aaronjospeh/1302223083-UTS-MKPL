package lib;

public class TaxFunction {

	// refactoring 1 Magic Numbers
	private static final int BASIC_NON_TAXABLE_INCOME = 54000000;
    private static final int MARRIAGE_ALLOWANCE = 4500000;
    private static final int CHILD_ALLOWANCE = 1500000;
    private static final double TAX_RATE = 0.05;

	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	// refactoring 3 Long Method
	private static int getValidatedNumberOfChildren(int numberOfChildren) {
		return Math.min(numberOfChildren, 3);
	}

	private static int calculateNonTaxableIncome(boolean isMarried, int numberOfChildren) {
		int nonTaxableIncome = BASIC_NON_TAXABLE_INCOME;
		if (isMarried) {
			nonTaxableIncome += MARRIAGE_ALLOWANCE;
		}
		nonTaxableIncome += numberOfChildren * CHILD_ALLOWANCE;
		return nonTaxableIncome;
	}

	// refactoring 5 Poor Naming
	private static int calculateAnnualIncome(int monthlySalary, int otherMonthlyIncome, int monthsWorkedInYear) {
		return (monthlySalary + otherMonthlyIncome) * monthsWorkedInYear;
	}

	// refactoring 4 Single Responsibility Principle
	public static void validateTaxPayerData(TaxPayerData data) {
			if (data.monthsWorkedInYear > 12) {
				throw new IllegalArgumentException("Jumlah bulan bekerja tidak boleh lebih dari 12.");
			}
			if (data.monthsWorkedInYear < 0) {
				throw new IllegalArgumentException("Jumlah bulan bekerja tidak boleh negatif.");
			}
			if (data.numberOfChildren < 0) {
				throw new IllegalArgumentException("Jumlah anak tidak boleh negatif.");
			}
		}


	// refactoring 1 Magic Numbers
	// refactoring 2 Primitive Obsession
	// refactoring 3 Long Method
	public static int calculateTax(TaxPayerData data) {
		// refactoring 4 Single Responsibility Principle
		validateTaxPayerData(data);
		
		int validChildCount = getValidatedNumberOfChildren(data.numberOfChildren);
		int nonTaxableIncome = calculateNonTaxableIncome(data.isMarried, validChildCount);
		int annualIncome = calculateAnnualIncome(data.monthlySalary, data.otherMonthlyIncome, data.numberOfMonthWorking);
		int taxableIncome = annualIncome - data.deductibleAmount - nonTaxableIncome;

		int tax = (int) Math.round(TAX_RATE * taxableIncome);
		return Math.max(tax, 0);
	}

}
