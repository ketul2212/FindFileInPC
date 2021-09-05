
package MainPackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Test extends GenericServlet{

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter p = res.getWriter();
        
        String file = req.getParameter("file");
        
        file += "+";
        
        MyThread1 t1 = new MyThread1(file);
	MyThread2 t2 = new MyThread2(file);
	MyThread3 t3 = new MyThread3(file);
	t1.start();
	t2.start();
	t3.start();
    }
    
}
