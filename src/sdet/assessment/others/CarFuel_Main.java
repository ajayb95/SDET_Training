package sdet.assessment.others;

public class CarFuel_Main {
	public static void main(String[] args) {
		CarFuel_Car car = new CarFuel_Car();
		CarFuel_SUV suv = new CarFuel_SUV();

		car.topSpeed();
		suv.topSpeed();

		suv.fuelType();
		car.fuelType();
	}
}
