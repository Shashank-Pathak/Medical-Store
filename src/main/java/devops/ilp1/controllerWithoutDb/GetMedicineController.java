package devops.ilp1.controllerWithoutDb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import devops.ilp1.model.Medicine;
import devops.ilp1.service.MedicineService;

@WebServlet("/GetMedicineServlet")
public class GetMedicineController extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		int id = Integer.parseInt(request.getParameter("getMedId"));
		MedicineService ps = new MedicineService(); 
		
		Medicine med = ps.getMedicine(id);
		if (med != null)
		{
			String name = med.getName();
			String composition = med.getComposition();
			String expDate = med.getExpDate();
			Double price = med.getPrice();
			
			request.setAttribute("medId",id);
			request.setAttribute("medName",name);
			request.setAttribute("medComposition",composition);
			request.setAttribute("medExpDate",expDate);
			request.setAttribute("medPrice",price);
			
			out.print("Successful to fetch Medicine Data");
			RequestDispatcher rd = request.getRequestDispatcher("medicineDetail.jsp");
            rd.forward(request,response);         
			
		}
		else
		{
			out.print("Failed to fetch Medicine Data");
			request.setAttribute("failedTask", "get");
			RequestDispatcher rd = request.getRequestDispatcher("/fail.jsp");
            rd.forward(request,response);
		}
	}


}
