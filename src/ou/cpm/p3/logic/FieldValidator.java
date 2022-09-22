package ou.cpm.p3.logic;

public class FieldValidator {

	public static boolean validateFieldNotEmpty(String fieldValue) {
		return !fieldValue.isBlank();
	}
	
	public static boolean validatePasswordsEqual(String psw, String pswRepeat) {
		return psw.equals(pswRepeat);
	}
	
	public static boolean validateAllFields(String name, String psw, String pswRepeat) {
		return 
			   validateFieldNotEmpty(name) && validateFieldNotEmpty(psw) && validateFieldNotEmpty(pswRepeat)// validates not empty
			   && validatePasswordsEqual(psw, pswRepeat)// validates not same passwords
			   && true;// needs to compare with true otherwise all false would return true
	}
}
