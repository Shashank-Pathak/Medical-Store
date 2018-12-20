package devops.ilp1.controllerWithoutDb;

import static org.junit.Assert.*;

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

public class AddMedicineTest extends Mockito {

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
   public void testAddMedicineSuccess() throws Exception {
       when(request.getParameter("medId")).thenReturn("101");
       when(request.getParameter("medName")).thenReturn("Crocin");
       when(request.getParameter("medComposition")).thenReturn("Paracetamol");
       when(request.getParameter("medExpDate")).thenReturn("2020-10-14");
       when(request.getParameter("medPrice")).thenReturn("60");
       when(request.getRequestDispatcher("/success.jsp")).thenReturn(rd);            
       StringWriter stringWriter = new StringWriter();
       PrintWriter writer = new PrintWriter(stringWriter);
       when(response.getWriter()).thenReturn(writer);
       new AddMedicineController().doPost(request, response);
    
      // verify(rd).forward(request, response);
      // verify(rd).forward(request, response);
       String result = stringWriter.getBuffer().toString().trim();
       assertEquals("Saved Medicine Data Successfully", result);
     
   }
   
}
