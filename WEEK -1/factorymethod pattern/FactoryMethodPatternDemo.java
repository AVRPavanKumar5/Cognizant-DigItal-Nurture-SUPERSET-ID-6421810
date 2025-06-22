interface Vehicle {
    void start();
    void stop();
    String getType();
}


class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car engine started");
    }
    
    @Override
    public void stop() {
        System.out.println("Car engine stopped");
    }
    
    @Override
    public String getType() {
        return "Car";
    }
}

class Motorcycle implements Vehicle {
    @Override
    public void start() {
        System.out.println("Motorcycle engine started");
    }
    
    @Override
    public void stop() {
        System.out.println("Motorcycle engine stopped");
    }
    
    @Override
    public String getType() {
        return "Motorcycle";
    }
}

class Truck implements Vehicle {
    @Override
    public void start() {
        System.out.println("Truck engine started");
    }
    
    @Override
    public void stop() {
        System.out.println("Truck engine stopped");
    }
    
    @Override
    public String getType() {
        return "Truck";
    }
}

class Bus implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bus engine started");
    }
    @Override
    public void stop() {
        System.out.println("Bus engine stopped");
    }
    @Override
    public String getType() {
        return "Bus";
    }
}

class Bicycle implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bicycle ride started");
    }
    @Override
    public void stop() {
        System.out.println("Bicycle ride stopped");
    }
    @Override
    public String getType() {
        return "Bicycle";
    }
}

// Factory Method Pattern
abstract class VehicleFactory {
    public abstract Vehicle createVehicle();
    
    public void testVehicle() {
        Vehicle vehicle = createVehicle();
        vehicle.start();
        System.out.println("Testing " + vehicle.getType());
        vehicle.stop();
    }
}

class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}

class MotorcycleFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Motorcycle();
    }
}

class TruckFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Truck();
    }
}

class BusFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Bus();
    }
}

class BicycleFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Bicycle();
    }
}

public class FactoryMethodPatternDemo {
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        carFactory.testVehicle();

        VehicleFactory motorcycleFactory = new MotorcycleFactory();
        motorcycleFactory.testVehicle();

        VehicleFactory truckFactory = new TruckFactory();
        truckFactory.testVehicle();

        VehicleFactory busFactory = new BusFactory();
        busFactory.testVehicle();

        VehicleFactory bicycleFactory = new BicycleFactory();
        bicycleFactory.testVehicle();
    }
}