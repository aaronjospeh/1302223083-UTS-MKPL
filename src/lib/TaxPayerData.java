package lib;

public class TaxPayerData {
	public int monthlySalary;
	public int otherMonthlyIncome;
	
    //refactoring 5 poor naming
    public int monthsWorkedInYear;
    public int deductibleAmount;

	public boolean isMarried;
	public int numberOfChildren;

    // refactoring 5 poor naming
	public TaxPayerData(int monthlySalary, int otherMonthlyIncome, int monthsWorkedInYear,
                    int deductibleAmount, boolean isMarried, int numberOfChildren) {
        this.monthlySalary = monthlySalary;
        this.otherMonthlyIncome = otherMonthlyIncome;
        this.monthsWorkedInYear = monthsWorkedInYear;
        this.deductibleAmount = deductibleAmount;
        this.isMarried = isMarried;
        this.numberOfChildren = numberOfChildren;
    }
}
