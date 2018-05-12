import java.io.*;

import javax.servlet.ServletException;

import javax.servlet.http.*;

import com.oreilly.servlet.MultipartRequest;

 

public class upload_file extends HttpServlet {

 

    @Override

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

 

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

 
        String filePath = getServletContext().getRealPath("")
        + File.separator + "exams";
        System.out.println(filePath);
        MultipartRequest m = new MultipartRequest(request,filePath);

        System.out.print("File Successfully Uploaded");

    }

}