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

public class DeleteMedicineTest extends Mockito{
	

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

   @Test
   public void testDeleteMedicineSuccess() throws Exception {
       when(request.getParameter("deleteMedId")).thenReturn("101");
       when(request.getRequestDispatcher("/success.jsp")).thenReturn(rd);            
       StringWriter stringWriter = new StringWriter();
       PrintWriter writer = new PrintWriter(stringWriter);
       when(response.getWriter()).thenReturn(writer);
       new DeleteMedicineController().doPost(request, response);
    
      // verify(rd).forward(request, response);
      // verify(rd).forward(request, response);
       String result = stringWriter.getBuffer().toString().trim();
       assertEquals("Deleted Medicine Successfully", result);
     
   }
   
   
   @Test
   public void testDeleteMedicineFail() throws Exception {
       when(request.getParameter("deleteMedId")).thenReturn("99999");
       when(request.getRequestDispatcher("/fail.jsp")).thenReturn(rd);            
       StringWriter stringWriter = new StringWriter();
       PrintWriter writer = new PrintWriter(stringWriter);
       when(response.getWriter()).thenReturn(writer);
       new DeleteMedicineController().doPost(request, response);
    
      // verify(rd).forward(request, response);
      // verify(rd).forward(request, response);
       String result = stringWriter.getBuffer().toString().trim();
       assertEquals("Failed to delete Medicine", result);
     
   }

}
