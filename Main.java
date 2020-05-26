import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;

import org.json.JSONException;
import org.json.JSONObject;

public class Main {

	public static void main(String[] args) throws IOException, JSONException 
	{
		double[] a = new double[10000];
		JSONObject o1  = new JSONObject();
		JSONObject o2 = new JSONObject();
	
		File file1 = new File("E:\\Memory.txt");
		try (BufferedReader bf = new BufferedReader(new FileReader(file1))) 
        {
            String readLine;
            double temp;

            int line = 0,i = 0;
            double sum=0.0,max = 0.0;
            while ((readLine = bf.readLine()) != null) 
            {
                if (line % 2 != 0) {
                	String str=readLine;
                	str=str.replaceAll("[^0-9]","");
                    str=str.trim();
                    temp=Integer.parseInt(str);
                   
                    a[i++]=temp/10000;
                   
                }
                line++;
            }
            String str1;
            for(int j=0;j<938;j++)
            {
            	str1 = String.format("%d",j);
            	o2.put(str1 + "s", a[j]);
            	if(max<a[j])
            		max=a[j];
            	sum=sum+a[j];
            }
            
            double avg=sum/938;
            DecimalFormat df = new DecimalFormat("#.###");
            df.setRoundingMode(RoundingMode.CEILING);
            o1.put("AverageMemory(MB)", df.format(avg));
            o1.put("values: ", o2);
            o1.put("MaximumMemory(MB)", df.format(max));
            System.out.println(o1);
         }
 }
}
