package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.URIResolver;

import org.apache.catalina.core.ApplicationContext;


import com.sun.org.apache.xalan.internal.xsltc.trax.*;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/hello"}
    )
public class HelloServlet extends HttpServlet {
	
	
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	try {
			Exploit testexploit = new Exploit();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
    	System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "True");
    	
		ServletOutputStream out = resp.getOutputStream();
		out.write("<!DOCTYPE html>".getBytes());
		out.write("<html>\n".getBytes());
		out.write("<body>\n".getBytes());
		out.write("<p><a href=\"classpath.jsp\">classpath</a></p>\n".getBytes());
		String data = req.getParameter("data");
		if (data == null) {
			try {
				MyValue valobj = new MyValue();
				valobj.age=22;
				valobj.name="derp";
				
				data = Serial.toJSON(valobj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			out.write("<p>Deserializing...".getBytes());

			try {
				Serial.fromJSON(data);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.write(e.toString().getBytes());
				out.write("derp".getBytes());
			}

			out.write("Done!</p>\n".getBytes());
		}
		out.write("<form action=\"/hello\" method=\"POST\">\n".getBytes());
		out.write(String.valueOf("<p><textarea type=\"text\" name=\"data\">"+data+"</textarea></p>\n").getBytes());
		out.write("<p><input type=\"submit\"></p>\n".getBytes());
		out.write("</form>\n".getBytes());
		out.write("</body>\n".getBytes());
		out.write("</html>\n".getBytes());
		out.flush();
		out.close();
		
	}
}
