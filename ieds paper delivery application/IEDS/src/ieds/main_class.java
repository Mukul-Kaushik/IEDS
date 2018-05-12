package ieds;

import java.io.File;
import java.io.IOException;

public class main_class {

	public static void main(String[] args) throws IOException {
		String url = "http://localhost:8080/ieds/servlet/upload_file";
		GetExam ge=new GetExam();
		while(true) {
			while(ge.readSchedule()) {
				File file =ge.getfile();
				File paper=new File("C:\\Users\\Mukul\\workspace\\IEDS\\bin\\ieds\\exams\\MAM401\\"+ge.code+".pdf");
				boolean success=file.renameTo(paper);
				if(success)
					System.out.println("Renamed");
				else
					System.out.println("File not renamed");
				int response=upload.uploadFile(paper, url);
				if(response==200) {
					System.out.println(ge.code+" Successfully uploaded");	
					ge.modifySchedule();
				}
			}
		}
	}	
}
