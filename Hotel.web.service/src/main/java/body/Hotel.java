package body;

import java.util.ArrayList;

public class Hotel {

	//Attributes
		private String name ="RESORT";
		private Stars star = Stars.E5;
		private ArrayList<Chamber> chambers = new ArrayList<Chamber>();
		
	//Constructor
	public Hotel() {		
		}
	
	
	public Hotel(String name, Stars star) {
		super();
		this.name = name;
		this.star = star;
	}


	public Hotel(String name, Stars star, ArrayList<Chamber> chambers) {
		this.name = name;
		this.star = star;
		this.chambers = chambers;
}

	//Methods



		public ArrayList<Chamber> getChambers() {
			return this.chambers;
		}

		public String getName() {
			return this.name;
		}
		

		public Stars getStar() {
			return this.star;
		}


		public void setStar(Stars star) {
			this.star = star;		
		}


		public void setName(String name) {
			this.name = name;
		}

}
