package devops.ilp1.controllerWithoutDb;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class GetMedicineTest extends Mockito{
	
	@Mock
	 HttpServletRequest request;
	 @Mock
	 HttpServletResponse response;
	 @Mock
	 RequestDispatcher rd;
	 @Before
	 public void setUp() throws Exception {
	  MockitoAnnotations.initMocks(this);
	 }

   //@Test
   public void testGetMedicineSuccess() throws Exception {
       when(request.getParameter("getMedId")).thenReturn("103");
       when(request.getRequestDispatcher("/medicineDetail.jsp")).thenReturn(rd);            
       StringWriter stringWriter = new StringWriter();
       PrintWriter writer = new PrintWriter(stringWriter);
       when(response.getWriter()).thenReturn(writer);
       new GetMedicineController().doPost(request, response);
    
      //verify(rd).forward(request, response);
      // verify(rd).forward(request, response);
       String result = stringWriter.getBuffer().toString().trim();
       assertEquals("Successful to fetch Medicine Data", result);
     
   }
   
   
   @Test
   public void testGetMedicineFail() throws Exception {
       when(request.getParameter("getMedId")).thenReturn("99999");
       when(request.getRequestDispatcher("/fail.jsp")).thenReturn(rd);            
       StringWriter stringWriter = new StringWriter();
       PrintWriter writer = new PrintWriter(stringWriter);
       when(response.getWriter()).thenReturn(writer);
       new GetMedicineController().doPost(request, response);
    
      // verify(rd).forward(request, response);
      // verify(rd).forward(request, response);
       String result = stringWriter.getBuffer().toString().trim();
       assertEquals("Failed to fetch Medicine Data", result);
     
   }

}
