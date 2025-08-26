public class WeatherObserver implements Observer {
    public String name;
    public WeatherStation weatherStation;

    public WeatherObserver(String name, WeatherStation weatherStation) {
        this.name = name;
        this.weatherStation = weatherStation;
    }

    @Override
    public void update(double temperature) {
        System.out.println("WeatherObserver " + name + ": Weather data has changed! Current temperature is: " + weatherStation.getTemperature() + "°C" );
    }
}
