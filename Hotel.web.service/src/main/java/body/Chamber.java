package body;

import java.util.ArrayList;

public class Chamber {

	//Attributes
	private int number;
	private int beds;
	private double price;
	private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	private Hotel hotel;
	
	//Constructors
	public Chamber() {
	}	
	
	public Chamber(int number, int beds, double price) {
		this.setNumber(number);
		this.setBeds(beds);
		this.setPrice(price);
	}
	

	public Chamber(int number, int beds, double price, Hotel hotel) {
		this.setNumber(number);
		this.setBeds(beds);
		this.setPrice(price);
		this.hotel = hotel;
	}

	//Methods



	public int getNumber() {
		return this.number;
	}

	public int getBeds() {
		return this.beds;
	}

	public double getPrice() {
		return this.price;
	}

	public Hotel getHotel() {
		return this.hotel;
	}
	
	public ArrayList<Reservation> getReservation() {
		return this.reservations;
	}
	
	public void setReservation(int year, int month, int day,int yeardep, int monthdep, int daydep) {
		Reservation r = new Reservation(year, month, day, yeardep, monthdep, daydep);
		this.reservations.add(r);
	}
	
	public void setHotel(Hotel h) {
		this.hotel = h;
	}
	
	public void setNumber(int number) {
		if (number > 0 && number <= 100) {
			this.number = number;}
		else {
			System.err.println("Chamber number out of range ! ");}
	}
	
	public void setBeds(int beds) {
		if(beds >= 1 && beds <= 3) {
			this.beds = beds;}
		else {
			System.err.println("Beds number out of range ! ");
		}
	}
	
	public void setPrice(double price) {
		if(price > 10) {
			this.price = price;}
		else {
			System.err.println("Price out of range (minimum 15$ !");
		}
	}
}
