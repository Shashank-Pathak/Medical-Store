package devops.ilp1.service;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import devops.ilp1.model.Medicine;


public class MedicineServiceTest {

	@Test
	public void testGetMedicine() {
		
		Medicine med1 = new Medicine(107,"Crocin","Paracetamol","2020-10-24",60.00);
		new MedicineService().setMedicine(med1);
		assertNotNull(new MedicineService().getMedicine(107));
		
	}

	@Test
	public void testSetMedicine() {
		
		Medicine med1 = new Medicine(107,"Crocin","Paracetamol","2020-10-24",60.00);
		assertEquals(true,new MedicineService().setMedicine(med1));
	}

	@Test
	public void testDeleteMedicine() {
		Medicine med1 = new Medicine(107,"Crocin","Paracetamol","2020-10-24",60.00);
		new MedicineService().setMedicine(med1);
		assertEquals(true,new MedicineService().deleteMedicine(107));
	}

	@Test
	public void testGetAllMedicines() {
		List<Medicine> meds = null;
		int count = 0;
		Medicine med = null;
		Iterator it = null;
		int listSize = 0;
		MedicineService ms = new MedicineService();
		meds = ms.getAllMedicines();
		it = meds.iterator();
		listSize = MedicineService.entrySet.size();
		System.out.println("Number of medicines present is "+listSize);
		
		while(it.hasNext())
		{
			med =(Medicine)it.next();
			it.remove();
			count++;
			
		}
		assertEquals(listSize, count);
	}

}
