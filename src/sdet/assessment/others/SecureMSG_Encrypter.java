package sdet.assessment.others;

public class SecureMSG_Encrypter {

	String input;

	SecureMSG_Encrypter(String input) {
		this.input = input;
	}

	public String getEncryptedName() {
		if (SecureMSG_Validator.validate(input))
			return modifyString(input);

		throw new IllegalArgumentException("Try again with valid name");
	}

	private String modifyString(String inp) {
		char[] arr = inp.toLowerCase().toCharArray();
		int left = 0, right = arr.length - 1;

		while (left < right) {
			char temp = arr[right];
			arr[right--] = arr[left];
			arr[left++] = temp;
		}

		return String.valueOf(arr);
	}
}
