package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Car;

public class CarDAO {
	
	// connection with the database
	private Connection connection;
	
	public CarDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void add(Car car) {
		String sql = "insert into cars" + "(brand,type)" + "values (?,?)";
		
		try {
			//prepared statement for insert
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//set the values
			stmt.setString(1, car.getBrand());
			stmt.setString(2, car.getType());
			
			//execute
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Car> getLista() {
		try {
			List<Car> cars = new ArrayList<Car>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from cars");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				// creating the object car
				Car car = new Car();
				car.setId(rs.getLong("id"));
				car.setBrand(rs.getString("brand"));
				car.setType(rs.getString("type"));
				
				// adding the object to the list
				cars.add(car);
			}
			rs.close();
			stmt.close();
			return cars;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
