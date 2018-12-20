package devops.ilp1.controllerWithoutDb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import devops.ilp1.model.Medicine;
import devops.ilp1.service.MedicineService;

@WebServlet("/ListAllMedicineServlet")
public class ListAllMedicineController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();		
		MedicineService ps = new MedicineService(); 
		List<Medicine> list = new ArrayList<Medicine>();
		list = ps.getAllMedicines();
		if (list != null)
		{
			request.setAttribute("medicineList", list);
			out.print("Fetch Medicines Data Successfully");
			RequestDispatcher rd = request.getRequestDispatcher("listAllMedicine.jsp");
            rd.forward(request,response);
            Iterator<Medicine> it = list.iterator();

            while (it.hasNext()) 
            {
              System.out.println("Removing object");
              out.println("Removing object");
              it.remove();
            }
            list.clear();

			
		}
		else
		{
			out.print("Failed to fetch Medicines Data");
			request.setAttribute("failedTask", "fetch All");
			RequestDispatcher rd = request.getRequestDispatcher("fail.jsp");
            rd.forward(request,response);
		}
	}


}
