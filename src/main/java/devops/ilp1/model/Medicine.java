package devops.ilp1.model;

public class Medicine {
	
	
	int id ;
	String name;
	String composition ;
	String expDate;
	Double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getComposition() {
		return composition;
	}
	public void setComposition(String composition) {
		this.composition = composition;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Medicine()
	{
		
	}
	
	public Medicine(int id,	String name,String composition,	String expDate,	Double price)
	{
		super();
		this.id= id;
		this.name=name;
		this.composition=composition;
		this.expDate=expDate;
		this.price=price;
	}
	
}
