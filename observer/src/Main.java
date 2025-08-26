public class Main {
    public static void main(String[] args) {
        System.out.println("Observer Pattern");
        WeatherStation station = new WeatherStation("Station 1", 50, -50);
        System.out.printf("Weather station %s created with current temperature: %.2f°C%n", station.getStationName(), station.getTemperature());

        WeatherObserver observer1 = new WeatherObserver("Observer 1");
        WeatherObserver observer2 = new WeatherObserver("Observer 2");
        WeatherObserver observer3 = new WeatherObserver("Observer 3");

        station.registerObserver(observer1);
        station.registerObserver(observer2);
        station.registerObserver(observer3);

        station.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        station.removeObserver(0);
        //The station runs indefinitely, so the program will not terminate on its own.
    }
}
