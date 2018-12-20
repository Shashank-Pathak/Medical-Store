package devops.ilp1.db;

import java.util.HashMap;
import java.util.Map;

import devops.ilp1.model.Medicine;


public class MedicineDb {
	
public static Map<Medicine,Integer> medicineProfile= new HashMap<Medicine,Integer>();
	
	
	public MedicineDb()
	{
		Medicine med1 = new Medicine(101,"Crocin","Paracetamol","24/10/2020",60.00);
		Medicine med2 = new Medicine(102,"Combiflam","Ipubrufen","4/10/2022",40.00);
		Medicine med3 = new Medicine(103,"Citrix","Cetrizine","2/1/2021",80.00);
		
		medicineProfile.put(med1,med1.getId());
		medicineProfile.put(med2,med2.getId());
		medicineProfile.put(med3,med3.getId());
		
	}


}
