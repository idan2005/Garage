import java.util.ArrayList;

public class DB {
    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    public static void addVehicle(Vehicle v)
    {
        vehicles.add(v);
    }

    public static ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
}
