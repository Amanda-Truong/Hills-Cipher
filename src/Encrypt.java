
public class Encrypt 
{
	//int[] cipher = {1,2,3,4};
	int[] cipher = new int[4];
	String message, crypted;
	int[] letter, crypting;
	public Encrypt(String s)
	{
		message = s.toUpperCase();
		toNum(message);
		encrypter(letter);

	}
	public Encrypt(String s, int[] x)
	{
		cipher = x;
		message = s.toUpperCase();
		toNum(message);
		encrypter(letter);
		

	}
//converts letters into numbers
	private void toNum(String s)
	{
		letter = new int[s.length()];
		crypting = new int[s.length()];
		for(int x=0;x<s.length();x++)
			letter[x] = s.charAt(x)-'A'+1;
	}
// change array of numbers into letters
	public  String toLetter(int[] go)
	{
		String push = "";

		for(int count=0; count < message.length(); count++)
		{
			if(go[count] ==0)
				push += "Z";
			else
			{
				char p = (char)(go[count]+ 'A'-1);
				push += p;
			}
		}
		return push;
	}
// encrypts message 
	private void encrypter(int[] f)
	{
		int count = 0;
		while(count < message.length())
		{
			crypting[count] = (letter[count]*cipher[0] + letter[count+1]*cipher[1])%26;
			crypting[count+1] = (letter[count]*cipher[2] + letter[count+1]*cipher[3])%26;
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
		return "|" + cipher[0] + "|" + cipher[1]+"|\n|"+ cipher[2]+ "|" + cipher[3]+"|";
	}
}
