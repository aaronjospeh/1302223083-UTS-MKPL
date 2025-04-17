package lib;

public class PersonalInfo {
	public String employeeId;
	public String firstName;
	public String lastName;
	public String idNumber;
	public String address;
	public boolean isForeigner;
	public boolean gender;

	public PersonalInfo(String employeeId, String firstName, String lastName, String idNumber, String address, boolean isForeigner, boolean gender) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.isForeigner = isForeigner;
		this.gender = gender;
	}
}
