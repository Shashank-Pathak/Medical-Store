package devops.ilp1.controllerWithoutDb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import devops.ilp1.service.MedicineService;

@WebServlet("/DeleteMedicineServlet")
public class DeleteMedicineController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("deleteMedId"));
		MedicineService ps = new MedicineService(); 
		
		if(ps.deleteMedicine(id) == true)
		{
			out.print("Deleted Medicine Successfully");
			request.setAttribute("Task", "Deleted");
			response.sendRedirect("success.jsp");
           
			
		}
		else
		{
			out.print("Failed to delete Medicine");
			request.setAttribute("failedTask", "delete");
			response.sendRedirect("fail.jsp");
		}
	}



}
