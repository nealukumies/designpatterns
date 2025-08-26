public class WeatherObserver implements Observer {
    public String name;

    public WeatherObserver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(double temperature) {
        System.out.println("WeatherObserver " + name + ": Weather data has changed! Current temperature is: " + temperature + "°C" );
    }
}
