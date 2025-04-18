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
	
	// refactoring 1 Magic Numbers
	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {

		if (numberOfMonthWorking > 12) {
			System.err.println("Jumlah bulan bekerja tidak boleh lebih dari 12.");
		}

		if (numberOfChildren > 3) {
			numberOfChildren = 3;
		}

		int nonTaxableIncome = BASIC_NON_TAXABLE_INCOME;
		if (isMarried) {
			nonTaxableIncome += MARRIAGE_ALLOWANCE;
		}
		nonTaxableIncome += numberOfChildren * CHILD_ALLOWANCE;

		int annualIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
		int taxableIncome = annualIncome - deductible - nonTaxableIncome;

		int tax = (int) Math.round(TAX_RATE * taxableIncome);
		return Math.max(tax, 0);
	}

	
}
