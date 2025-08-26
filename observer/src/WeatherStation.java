import java.util.ArrayList;
import java.util.List;

public class WeatherStation extends Thread {
    private String name;
    private double currentTemp;
    private double maxTemp;
    private double minTemp;
    private List<Observer> observers = new ArrayList<>();

    public WeatherStation(String name, double maxTemp, double minTemp) {
        this.name = name;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.currentTemp = Math.random() * (maxTemp - minTemp) + minTemp;
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(int index) {
        System.out.println("------------------------------");
        System.out.println(observers.get(index).getName() + " removed from Weather Station " + name);
        System.out.println("------------------------------");
        observers.remove(index);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(currentTemp);
        }
    }

    public double getTemperature() {
        return currentTemp;
    }

    public void setTemperature() {
        double setTemp = Math.random() * 1;
        if (setTemp > 0.5) {
            this.currentTemp += 1;
            if (this.currentTemp > maxTemp) {
                this.currentTemp = maxTemp;
            }
        } else {
            this.currentTemp -= 1;
            if (this.currentTemp < minTemp) {
                this.currentTemp = minTemp;
            }
        }
        notifyObservers();
    }

    public String getStationName() {
        return name;
    }

    @Override
    public void run(){
        System.out.println("Weather Station " + name + " started.");
        int time = 0;
        boolean running = true;
        boolean removedObserver = false;
        while (running) {
            if (time >=10 && !removedObserver) {
                removeObserver(0);
                removedObserver = true;
            }
            int random = (int)(Math.random() * 5 + 1);
            System.out.println("Time : " + time);
            try {
                Thread.sleep(random*1000);
                time += random;
                setTemperature();
                if (time >=20) {
                    System.out.println("Weather Station " + name + " stopped.");
                    running = false;
                }
            } catch (InterruptedException e) {
            e.printStackTrace();}
        }
    }
}
