abstract class AbstractVehicle {
    abstract public void park();
}

class Car extends AbstractVehicle {
    int year;

    @Override
    public void park() {
        System.out.println("Car Parking..");
    }
}

class AnonymousAbstractDemo {
    public static void main(String[] args) {
        AbstractVehicle v = new AbstractVehicle() {
            @Override
            public void park() {
                System.out.println("Car Parking..Anonymous inner");
            }
        };
        AbstractVehicle v2 = new Car();
        v.park();
        v2.park();
    }
}