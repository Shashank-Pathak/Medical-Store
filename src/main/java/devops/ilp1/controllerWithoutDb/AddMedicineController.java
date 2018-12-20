package devops.ilp1.controllerWithoutDb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import devops.ilp1.model.Medicine;
import devops.ilp1.service.MedicineService;

@WebServlet("/AddMedicineServlet")
public class AddMedicineController extends HttpServlet {
	

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		int id = Integer.parseInt(request.getParameter("medId"));
		String name = request.getParameter("medName");
		String composition = request.getParameter("medComposition");
		String expDate = request.getParameter("medExpDate");
		Double price = Double.parseDouble(request.getParameter("medPrice"));
		
		Medicine med = new Medicine();
		med.setId(id);
		med.setName(name);
		med.setComposition(composition);
		med.setExpDate(expDate);
		med.setPrice(price);
		
		MedicineService ms = new MedicineService();
		
		if(ms.setMedicine(med) == true)
		{
			out.write("Saved Medicine Data Successfully");
			request.setAttribute("Task", "Saved");
			response.sendRedirect("success.jsp");
		
		}
		else
		{
			out.print("Failed to add Medicine");
			request.setAttribute("failedTask", "to save");
			response.sendRedirect("fail.jsp");
		}
	}


}
