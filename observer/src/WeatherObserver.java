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
        System.out.printf("WeatherObserver %s: Weather data has changed! Current temperature is: %.2f°C%n", name, temperature);
    }
}
