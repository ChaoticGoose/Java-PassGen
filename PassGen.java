import java.io.*;
import java.util.Random;

class PassGen
{
	public static void main(String[] argv)
	{
			//this program takes a seed from standard in, and generates outputs to standard output
			//reader to read from standard input
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		long seed = 0;
		boolean randomSeed = false;
		
		try
		{
			seed = Long.parseLong(reader.readLine());
			
			if(seed == 0)
				randomSeed = true;
		}
		catch(Exception e)
		{
			randomSeed = true;
			//System.out.println("0 or Bad input, using random seed");
		}

		Random rand;		
		//generate a random number generator object, and either use the provided seed, or a randomly allocated seed
		if(randomSeed)
		{
			seed = new Random().nextLong();
		}
		rand = new Random(seed);
		
		//now that we have a seeded random number, we can generate the text, using a defined character set
		String charsetRAW = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-=+[]{};':/<>?";
		String[] charset = charsetRAW.split("");
		
		System.out.println("12 11");
		
		for(int j = 0; j<11; j++)
		{
			String line = "";
			//for the length and height (12 by 11), generate the output
			for(int i = 0; i< 12; i++)
			{
				line += charset[Math.abs(rand.nextInt()) % (charset.length-1)];
			}
			System.out.println(line);
		}
		
		System.out.println(seed);
	}
}
