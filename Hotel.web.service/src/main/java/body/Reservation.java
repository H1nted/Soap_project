package body;

import java.time.LocalDate;

public class Reservation {

	//Attributes
	private LocalDate dateArv ;
	private LocalDate dateDep ;
	private String id;

	
	//Constructors
	public Reservation() {
	}
	
	public Reservation(int year, int month, int day) {
		this.setDateArv(year,month,day);

	}
	
	public Reservation(int year, int month, int day,int yeardep, int monthdep, int daydep) {
		this.setDateArv(year, month, day);
		this.setDateDep(yeardep, monthdep, daydep);
	}
	
	public Reservation(LocalDate arrivé, LocalDate depart) {
		this.dateArv = arrivé;
		this.dateDep = depart;
	}
	//Methods
	public LocalDate getDateArv() {
		return this.dateArv;
	}

	public LocalDate getDateDep() {
		return this.dateDep;
	}
	public String getid() {
		return this.id;
	}

	public void setid(String id) {
		this.id = id;
	}
	public void setDateArv(int year, int month, int day) {
		this.dateArv = LocalDate.of(year, month, day);
	}

	public void setDateDep(int year, int month, int day) {
		this.dateDep = LocalDate.of(year, month, day);
//		while (this.dateDep.isBefore(dateArv) || this.dateDep.isEqual(dateArv)) {
//			this.dateDep = LocalDate.of(year, month, day);
		}
	
	
	
}

	


