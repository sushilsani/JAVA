/*
	Program to count the number of distinct words in a file
*/
import java.util.*;
import java.io.*;


public class WordCount {
	public static void main(String[] args) 
	{
		String str="";
		String[] strArr=null;
		try	{	
				// Reading The File input for the program

				FileInputStream fin= new FileInputStream("input/wordcount.txt");
				int i;
				StringBuffer sBuf = new StringBuffer();
				while( (i = fin.read())!=-1)
				{
					sBuf.append((char)i);
				}

				// now we have put all words inside an array

				str = sBuf.toString().replace("\n"," ");
				strArr = str.split(" ");
				
				System.out.println("****** STR contents:******\n\n");
				System.out.println(str);
				System.out.println("****** STRARR contents:******\n\n");
				System.out.println(Arrays.toString(strArr));

						// String arr[i]charAtIndexOf(84)
			}
		catch(Exception e)
			{
				System.out.println("Exception Found." +e);
			}		

		//Declaring a TreeMap to get the desrired output(distinct word as KEY and no. of occurences as VALUE)

		TreeMap<String, Integer> m = new TreeMap<String, Integer>();
		
		for(String word : strArr)
		{
			Integer count = m.get(word);
			if (count == null)
			{
				count = 0;
			}
			m.put(word,count+1);
		}
		System.out.println("****** TreeMap contents:******\n\n");
		System.out.println(m);
		
		//As the MAP is not iterable so making each entry as a set so that we can iterate
		Set s1 = m.entrySet();
		Iterator itr = s1.iterator();

		System.out.println("****** Word Count contents:******\n\n");

		try{
				
			File file = new File("output/wordcount_result.txt");
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			Writer w = new BufferedWriter(osw);

			while(itr.hasNext()){
				Map.Entry m1 = (Map.Entry)itr.next();
				System.out.println(m1.getKey() + "---"+ m1.getValue());
				w.write(m1.getKey() + " "+ m1.getValue() +"\n");
			}
			w.close();
		} // End of writing the desired result in a file
		catch(IOException e)
		{
			System.err.println("Problem writing to the file wordcount_result.txt");
		}
	}
}
