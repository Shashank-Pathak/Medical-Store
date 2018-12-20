package devops.ilp1.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import devops.ilp1.db.MedicineDb;
import devops.ilp1.model.Medicine;

public class MedicineService {
	
	public static Set entrySet = new MedicineDb().medicineProfile.entrySet();
	public Medicine getMedicine(int id)
	{
		Medicine med = null;
		Iterator it = entrySet.iterator();

		while (it.hasNext()) {
			Map.Entry p = (Map.Entry) it.next();
			Medicine dbMed = (Medicine) p.getKey();

			if (id ==dbMed.getId()) 
			{
				med = new Medicine();
				med.setId(dbMed.getId());
				med.setName(dbMed.getName());
				med.setComposition(dbMed.getComposition());
				med.setExpDate(dbMed.getExpDate());
				med.setPrice(dbMed.getPrice());
				
			}
		}

		return med;
	}
	
	public boolean setMedicine(Medicine med)
	{

		boolean isMedicineSet = false;
		
		if(med != null && med.getId() != 0)
		{
			MedicineDb.medicineProfile.put(med, med.getId());
			isMedicineSet = true ;
			System.out.println("Number of medicines "+MedicineDb.medicineProfile.size());
		}
		
		return isMedicineSet;
	}
	
	public boolean deleteMedicine(int id)
	{
		boolean isDeleted = false;
		Iterator it = entrySet.iterator();
        while (it.hasNext()) {
			Map.Entry p = (Map.Entry) it.next();
			Medicine dbMed = (Medicine) p.getKey();
			if (id == dbMed.getId()) 
			{
				
				it.remove();
				isDeleted = true;
			}
		}
        System.out.println("Number of medicines "+MedicineDb.medicineProfile.size());
		return isDeleted;
	}
	
	public List<Medicine> getAllMedicines()
	{
		List<Medicine> meds = new ArrayList<Medicine>();
		Iterator it = entrySet.iterator();
        while (it.hasNext())
        {
			Map.Entry p = (Map.Entry) it.next();
			Medicine dbMed = (Medicine) p.getKey();
			meds.add(dbMed);
        }
		
		return meds;
	}
	


}
