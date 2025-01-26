import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.System.exit;

public class Garage {
    private int time=0;
    private Protocol_Garage protocolGarage;
    private ArrayList<Vehicle> vehicles;

    public Garage(Protocol_Garage protocolGarage,ArrayList<Vehicle> vehicles ) {
        this.protocolGarage = protocolGarage;
        this.vehicles = vehicles;
    }

    public void start() {
        String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println("\n"+timeStamp);
        Runnable runnable = new Runnable() {
            public void run() {
                tick();
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(runnable, 1,1, TimeUnit.SECONDS);
    }
    private void tick() {

        time++;
        if(time==vehicles.get(0).getFixTime()) {
            String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
            Vehicle v = vehicles.remove(0);
            v.fixed();
            protocolGarage.fixed();
            System.out.println(timeStamp+ "\n");
            if(vehicles.isEmpty()) {
                System.out.println("All vehicles have been fixed, exiting");
                exit(1);
            }
            System.out.println(timeStamp);
            time=0;
        }
    }
}
