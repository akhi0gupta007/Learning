package com.learn;

import com.ds.model.CarBody;

public class Car extends CarBody implements Vehicle, Alarm {

	int valx = 10;

	Car() {

		this(10);
		System.out.println("Car 0 arg constructor");

	}

	Car(int x) {
		System.out.println("Car 1 arg constructor");
	}

	@Override
	public double getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String turnAlarmOff() {
		int z = super.valx;
		return Vehicle.super.turnAlarmOff();
	}

	@Override
	public String turnAlarmOn() {
		return Vehicle.super.turnAlarmOn();
	}

	public static void main(String[] args) {
		new Car();
	}

	static void access() {
//	 Alarm.val = 200; //final static
	}

}

interface Alarm {
	public int val = 20;

	default String turnAlarmOn() {
		return "Turning the alarm on.";
	}

	default String turnAlarmOff() {
		return "Turning the alarm off.";
	}
}

interface Vehicle {

	default String turnAlarmOn() {
		return null;
		// custom implementation
	}

	default String turnAlarmOff() {
		return null;
		// custom implementation
	}

	double getSpeed();

	default double getSpeedInKMH(double speed) {
		return speed;
		// conversion
	}
}