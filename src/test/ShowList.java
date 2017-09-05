package test;

import java.sql.SQLException;
import java.util.List;

import dao.CarDAO;
import model.Car;

public class ShowList {

	public static void main(String[] args) throws SQLException {
		// To print all the database records
		CarDAO dao = new CarDAO();
		List<Car> cars = dao.getLista();
		
		for (Car car : cars) {
			System.out.println("Brand: " + car.getBrand());
			System.out.println("Type: " + car.getType());
		}

	}

}
