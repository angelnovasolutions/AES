package mx.com.beo.aes;

public class TestAES {
	
	public static void main(String[] args){
		
		PBKDF2AES PBKDF2AES_test = new PBKDF2AES();
		
		try {
			
			String stringOriginal = "Hola Mundo";
			String stringEncrypted = PBKDF2AES_test.encrypt(stringOriginal);
			
			System.out.println(stringEncrypted);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
