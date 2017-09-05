package test;

import dao.CarDAO;
import model.Car;

public class Insert {

	public static void main(String[] args) {
		// Ready to record on the database
		Car car = new Car();
		car.setBrand("Chevrolet");
		car.setType("Celta");
		
		// Record in this connection
		CarDAO dao = new CarDAO();
		
		// Method used
		dao.add(car);
		System.out.println("Committed!");

	}

}
