// package com.example.demo;
// // ================================================================================================================================================================
// abstract class Vehicle{
//     public final String brand;
//     public final int speed;

//     public Vehicle(final String brand, final int speed) {
//         if (speed <= 0) {
//             throw new IllegalArgumentException("speed 必須大於 0");
//         }
//         this.brand = brand;
//         this.speed = speed;
//     }

//     public final float accelerate(int amount) {
//         if (amount <= 0 ) {
//             throw new IllegalArgumentException("amount 加速必須大於 0");
//         }
//         return (float) speed + amount;
//     }

//     public final float brake(int amount) {
//         if (amount <= 0 || amount >= speed) {
//             throw new IllegalArgumentException("amount 減速必須小於 speed");
//         }
//         return (float) speed - amount;
//     }

//     abstract void honk();
//         // System.out.println("逼逼叫 " );
// }

// class Car extends Vehicle{
//     public Car(final String brand, final int speed) {
//        super(brand, speed);
//     }
//     @Override
//     void honk(){
//         System.out.println("Car: Beep Beep! " );
//     }
    
// }
// class Bike extends Vehicle{
//     public Bike(final String brand, final int speed) {
//         super(brand, speed);
//     }
//     @Override
//     void honk(){
//         System.out.println("Bike: Ring Ring! " );
//     }
// }
// // ================================================================================================================================================================
// interface ElectricVehicle {
//     float chargeBattery(int amount);
//     float getBatteryLevel(float battery);
// }
// class ElectricCar extends Vehicle implements ElectricVehicle{
//     public float battery;

//     public ElectricCar(final String brand, final int speed) {
//         super(brand, speed);
//     }

//     public float getBatteryLevel(float battery) {
//         this.battery = battery;
//         System.out.println("電池電量: " + battery);
//         return (float) this.battery;
//     }

//     public float chargeBattery(int amount) {
//         this.battery += amount;
//         return (float)  this.battery + amount;
//     }

//     @Override
//     void honk(){
//         System.out.println("ElectricCar: Beep Beep! " );
//     }
// }
// // ================================================================================================================================================================
// public class TestDr {
//     public static void main(String[] args){
//         Car car = new Car("BMW", 20);
//         Bike bike = new Bike("AMW", 30);
//         ElectricCar electricCar = new ElectricCar("CMW", 40);
//         car.honk();
//         bike.honk();
//         electricCar.honk();

//         System.out.println(car.brand + car.speed);
//         System.out.println(bike.brand + bike.speed);
//         System.out.println(electricCar.brand + electricCar.speed);

//         Vehicle mycar = new Car("BMW", 20);
//         Vehicle mybike = new Bike("AMW", 30);
//         Vehicle myelectricCar = new ElectricCar("CMW", 40);
        
//         mycar.accelerate(10);
//         System.out.println(mycar.accelerate(10));
        
//         mybike.brake(10);
//         System.out.println(mybike.brake(10));
       
//         myelectricCar.honk();
//     }
// }
