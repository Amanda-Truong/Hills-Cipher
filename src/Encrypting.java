import java.util.Scanner;
public class Encrypting {

	public static void main(String[] args) {
		int[] cipher;
		String message;
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.print("Enter a Message: ");
			message = sc.nextLine();
			message = message.replace(" ", "");
			if(message.length()%2 != 0)
				System.out.println("Use a phrase with an even number of letters");
		}
		while(!(message.length()%2 == 0));
		do
		{
			System.out.print("Enter Four Numbers in Order for the Key of the Cipher: ");
			cipher = new int[4];
			for(int x = 0; x < 4;x++)
				cipher[x] = sc.nextInt();
			if(!Decrypt.checkDet(cipher))
				System.out.print("Use a key that has a determinant not a factor of 2 or 13");
		}
		while(!Decrypt.checkDet(cipher));
		Encrypt e = new Encrypt(message, cipher);
		System.out.println("\nCipher:\n"+e.printKey());
		System.out.print("Encrypted message: " + e);
	}

}
