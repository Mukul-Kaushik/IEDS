package ieds;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.*;
import java.util.Date;
import java.util.Random;
public class GetExam {
	String code;
	boolean readSchedule(){
		BufferedReader br;
		String date,time;
		try {
			//Reading schedule.csv
			br=new BufferedReader(new FileReader("C:\\Users\\Mukul\\workspace\\IEDS\\bin\\ieds\\schedule.csv"));
			String temp[]=br.readLine().split(",");
			code=temp[0];
			date=temp[1];
			time=temp[2];
			//getting current time and date
			DateFormat df = new SimpleDateFormat("dd-MM-yy HH:mm"); 
			Date dateobj = new Date(); 
			String temp1[]=df.format(dateobj).split(" ");
			String cdate=temp1[0];
			String ctime=temp1[1];
			/*System.out.println(df.format(dateobj));
			System.out.println(date);
			System.out.println((ctime.compareTo(time)>=0)&&(cdate.compareTo(date)>=0));*/
			if(cdate.compareTo(date)>=0 && ctime.compareTo(time)>=0) {
				return true;
			}
			else
				return false;
		}catch (Exception e) {
			System.out.println("Schedule not found");
		}
		return false;
		
	}
	
	

	File getfile() {
		
			File file = new File("C:\\Users\\Mukul\\workspace\\IEDS\\bin\\ieds\\exams\\"+code);
	        String[] paths = file.list();
	        int total_files=paths.length;
	        System.out.println(total_files +" sets of "+code);
	        Random randomNum = new Random();
	        int random=	1+randomNum.nextInt(total_files);
	        File selectedfile=new File("C:\\Users\\Mukul\\workspace\\IEDS\\bin\\ieds\\exams\\"+code+"\\set"+random+".pdf");
	        return selectedfile;
	}
	
	boolean modifySchedule() {
		File schedule =new File("schedule.csv");
		String newContent = "";
		String removed=null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Mukul\\workspace\\IEDS\\bin\\ieds\\schedule.csv"));
			  String line = br.readLine();
	            int temp=0;
	            while (line != null) 
	            {
	            	if(temp!=0) {
	            		newContent = newContent + line + System.lineSeparator();
	                 
	                	line = br.readLine();
	            	}
	            	else {
	            		removed=line;
	            		System.out.println(removed);
	            		line=br.readLine();
	            		FileWriter fw=new FileWriter("C:\\Users\\Mukul\\workspace\\IEDS\\bin\\ieds\\completed.csv",true);
	            		fw.append(System.lineSeparator()+removed);
	            		fw.close();
	            	}
	            		
	            	temp++;
	            }
	             
	            FileWriter writer = new FileWriter("C:\\Users\\Mukul\\workspace\\IEDS\\bin\\ieds\\schedule.csv");
	            writer.write(newContent);
	            br.close();
	            writer.close();
		} catch(Exception e) {
			System.out.println("File not modified");
		}
		return true;
	}
}