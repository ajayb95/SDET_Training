package sdet.assessment.others;

public class SecureMSG_Validator {

	public static boolean validate(String input) {
		int len = input.length();
		if (len > 0 && len < 100)
			return true;

		return false;
	}
}
