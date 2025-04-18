package lib;

public class TaxPayerData {
	public int monthlySalary;
	public int otherMonthlyIncome;
	public int numberOfMonthWorking;
	public int annualDeductible;
	public boolean isMarried;
	public int numberOfChildren;

	public TaxPayerData(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking,
	                    int annualDeductible, boolean isMarried, int numberOfChildren) {
		this.monthlySalary = monthlySalary;
		this.otherMonthlyIncome = otherMonthlyIncome;
		this.numberOfMonthWorking = numberOfMonthWorking;
		this.annualDeductible = annualDeductible;
		this.isMarried = isMarried;
		this.numberOfChildren = numberOfChildren;
	}
}
