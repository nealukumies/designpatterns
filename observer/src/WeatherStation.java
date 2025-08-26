import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    private String name;
    private double currentTemp;
    private double maxTemp;
    private double minTemp;
    private List<Observer> observers = new ArrayList<>();

    public WeatherStation(String name, double currentTemp, double maxTemp, double minTemp) {
        this.name = name;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.currentTemp = Math.random() * (maxTemp - minTemp) + minTemp;
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
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

    public String getName() {
        return name;
    }
}
