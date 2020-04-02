package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

public class InsertStringIntoJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String sqlQuery= "INSERT INTO myTable (ID, CITY, STATE, LAT_N, LONG_W) VALUES (13, 'Phoenix', 'AZ', 33, 112)";
		String keyString="",valueString="";
		String a[]=sqlQuery.split(" ");
		System.out.println("Operation--"+a[0]);
		
	    int i=0;
		while(sqlQuery.contains("(") && sqlQuery.contains(")"))
		{
		String m=sqlQuery.substring(sqlQuery.indexOf("(")+1, sqlQuery.indexOf(")"));
		//System.out.println(m);
		if(i==0)
			keyString=m;
		
		else
			valueString=m;
		i++;
		sqlQuery=sqlQuery.substring(sqlQuery.indexOf(")")+1);
		
	     }
		
		List<String> keyList= new ArrayList(Arrays.asList(keyString.split(",")));
		List<String> valueList= new ArrayList(Arrays.asList(valueString.split(",")));
		
		
		/*
		 * for(int j=0;j<keyList.size();j++) {
		 * System.out.println(" -->"+keyList.get(j)); }
		 * 
		 * for(int j=0;j<valueList.size();j++) {
		 * System.out.println(" -->"+valueList.get(j)); }
		 */
		   
        ObjectMapper mapperObj = new ObjectMapper();
        Map<String, String> inputMap = new HashMap<String, String>();
        for(int j=0;j<keyList.size();j++)
		{
        	inputMap.put(keyList.get(j).toString().trim(), valueList.get(j).toString().trim());
		}
       // System.out.println(inputMap);
        // convert map to JSON String
        try {
            String jsonResp = mapperObj.writeValueAsString(inputMap);
            System.out.println(jsonResp.replace("\"", ""));
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    
	}
	
	

}
