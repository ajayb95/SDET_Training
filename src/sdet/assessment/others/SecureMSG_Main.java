package sdet.assessment.others;

public class SecureMSG_Main {

	public static void main(String[] args) {
		SecureMSG_Encrypter obj1 = new SecureMSG_Encrypter("Kate Winslet");
		SecureMSG_Encrypter obj2 = new SecureMSG_Encrypter("");

		System.out.println(obj1.getEncryptedName());
		System.out.println();
		System.out.println(obj2.getEncryptedName());
	}
}
