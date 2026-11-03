interface ParkableVehicle {
    void park();
}

class AnonymousInterfaceDemo {
    public static void main(String[] args) {
        ParkableVehicle v = new ParkableVehicle() {
            @Override
            public void park() {
                System.out.println("Anonymous inner");
            }
        };
        v.park();
    }
}