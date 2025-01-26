import java.util.Scanner;

public class MainScreen {
    private static Garage garage;

    public static void start() {
        scanVehicles();
        garage = new Garage(protocolGarage, DB.getVehicles());
        garage.start();
    }
    private static Protocol_Garage protocolGarage= new Protocol_Garage() {
        @Override
        public void fixed() {
            System.out.println("Current vehicle has been fixed");
        }
    };
    public static void scanVehicles() {
        Scanner scanner = new Scanner(System.in);
        Vehicle v;
        String name;
        int type;
        while(true) {
            System.out.println("Enter a number (0->stop the scan, 1->Motorcycle, 2->Car, 3->Truck)");
            try{
                type = scanner.nextInt();
            }catch (Exception e) {
                e.getMessage();
                type=-1;
            }
            if(type==0){
                break;
            } if(type!=-1){
                scanner.nextLine();
                System.out.println("Enter vehicle name");
            }
            name = scanner.nextLine();
            switch (type) {
                case 1:
                    v = new Motorcycle(name);
                    DB.addVehicle(v);
                    break;
                case 2:
                    v = new Car(name);
                    DB.addVehicle(v);
                    break;
                case 3:
                    v = new Truck(name);
                    DB.addVehicle(v);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
