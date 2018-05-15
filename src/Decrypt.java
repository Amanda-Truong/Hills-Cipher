
public class Decrypt 
{
	//int[] key = {1,2,3,4};
	int[] key = new int[4];
	String message, crypted;
	int[] letter, crypting;
	public Decrypt(String m)
	{
		message = m.toUpperCase();
		key = unlockKey(key);
		toNum(message);
		decrypter(letter);
	}
	public Decrypt(String m, int[] k)
	{
		message = m.toUpperCase();
		key = k;
		key = unlockKey(key);
		toNum(message);
		decrypter(letter);
	}
// creates the unlockkey
	private int[] unlockKey(int[] k)
	{
		double det = determinate(k);
		int[] key = new int[4];
	//inverse Matrix for the key to work, they must be positive numbers and modulo 26
		key[0] = toPositive(k[3],det);
		key[1] = toPositive(k[1],-det);
		key[2] = toPositive(k[2],-det);
		key[3] = toPositive(k[0],det);
		
		return key;
		
	}
// checks to see that the determinate isn't a factor of 13 or 2
	public static boolean checkDet(int[] k)
	{
		int det = (k[0]*k[3] - k[1]*k[2]);
		det %= 26;
		if(det%2 == 0 || det == 13)
		{
			return false;
		}
		else
			return true;
	}
// finds the determinate
	private double determinate(int[] k)
	{
		int det = (k[0]*k[3] - k[1]*k[2]);
		det %= 26;
		
		double push =0;
		
		// get the recipicols
		if(det == 3)
			push = 9;
		else if(det == 5)
			push = 21;
		else if(det == 7)
			push = 15;
		else if(det == 9)
			push = 3;
		else if(det == 11)
			push = 19;
		else if(det == 15)
			push = 7;
		else if(det == 17)
			push = 23;
		else if(det == 19)
			push = 11;
		else if(det == 21)
			push = 5;
		else if(det == 23)
			push = 17;
		else if(det == 25)
			push = 25;
		
		return push;
	}
// reverts the Message into an array of numbers
	private void toNum(String s)
	{
		letter = new int[s.length()];
		crypting = new int[s.length()];
		for(int x=0;x<s.length();x++)
			letter[x] = s.charAt(x)-'A'+1;
	}
// revert the array of numbers into letters
	public  String toLetter(int[] go)
	{
		String push = "";

		for(int count=0; count < message.length(); count++)
		{
			if(go[count] ==0)
				push += "Z";
			else
			{
				char p = (char)(go[count]+ 'A' - 1);
				push += p;
			}
		}
		return push;
	}
// checks the number value to assure they are positive and are modulo 26
	private int toPositive(int x, double det)
	{
		x = (int)(x*det%26);
		while(!(x >=0 && x < 26))
		{
			x+=26;
		}
		return x;
	}
// decrypts the message
	private void decrypter(int[] f)
	{
		int count = 0;
		while(count < message.length())
		{
			crypting[count] = (letter[count]*key[0] + letter[count+1]*key[1])%26;
			crypting[count+1] = (letter[count]*key[2] + letter[count+1]*key[3])%26;
			count+=2;
		}
	}
	public String toString()
	{
		return toLetter(crypting);
	}
	
// prints out the key 
	public String printKey()
	{
		return "|" + key[0] + "|" + key[1]+"|\n|"+ key[2]+ "|" + key[3]+"|";
	}
}
