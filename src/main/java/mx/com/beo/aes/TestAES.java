package mx.com.beo.aes;

public class TestAES {
	
	public static void main(String[] args){
		
		PBKDF2AES PBKDF2AES_test = new PBKDF2AES();
		
		try {
			
			String cadena = PBKDF2AES_test.encrypt("Hola Mundo");
			
			System.out.println(cadena);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
