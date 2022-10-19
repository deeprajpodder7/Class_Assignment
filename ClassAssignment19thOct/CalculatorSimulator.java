package ClassAssignment19thOct;

//creating custom exception classes
class CountryNotValidException extends Exception {
public CountryNotValidException(String string) {
        super(string);
    }}
class EmployeeNameInValidException extends Exception {
    public EmployeeNameInValidException(String string) {
        super(string);
    }}
class TaxNotEligibleException extends Exception {
    public TaxNotEligibleException(String string) {
        super(string);}}
	
class TaxCalculator1{
    public double calculateTax(String empName, boolean isIndian, double empSal) {    //tax calculating method
        double taxAmount = 0;
        try {
            if (isIndian== false) {
                throw new CountryNotValidException("The employee should be an Indian citizen for calculating tax");        //custom exception
            }
            if (empName == null) {                //if employee name is not passed
                throw new EmployeeNameInValidException("The employee name cant be empty");                                //custom exception
            }
            if (empSal > 100000 && isIndian == true) {                            // Salary greater than 10k and emp. is indian
                return taxAmount = empSal * 8 / 100;
            } else if ((empSal > 50000 && empSal < 100000)) {// Salary between than 50k to 1Lakh and emp. is indian
                return taxAmount = empSal * 6 / 100;
            } else if ((empSal > 30000 && empSal < 50000)) {  // Salary between than 30k to 50k and emp. is indian
                return taxAmount = empSal * 5 / 100;
            } else if ((empSal > 10000 && empSal < 30000)) { // Salary between than 10k to 30k and emp. is indian
                return taxAmount = empSal * 4 / 100;
            } else {                                                            //if any exception is not met
                throw new TaxNotEligibleException("The employee does not need to pay tax");                                //custom exception
            }
        } catch (Exception e) {    // hadeling custom exceptions
            System.out.println(e);
        }
       return taxAmount;
    }}
class CalculatorSimulator {    // Main class
    public static void main(String[] args){
            TaxCalculator1 obj = new TaxCalculator1();//object of Testcalculator
        System.out.println("1st case");//case 1
            System.out.println("Tax amount is " + obj.calculateTax("Ron", false, 34000));

            System.out.println("2nd case");//case 2
            System.out.println("Tax amount is " + obj.calculateTax("Tim", true, 1000));

            System.out.println("3rd case");//case 3
            System.out.println("Tax amount is " + obj.calculateTax("Jack", true, 55000));


            System.out.println("4th case");//case 4
            System.out.println("Tax amount is " + obj.calculateTax(null, true, 30000));
        }}