public class Main {
    public static void main(String[] args) {
        NewDateInterface calendar = new CalendarToNewDateAdapter();
        System.out.println("Current date: " + calendar.getDay() + "." + (calendar.getMonth() + 1) + "." + calendar.getYear());
        calendar.setDay(24);
        calendar.setMonth(12);
        System.out.println("Switched to Christmas: " + calendar.getDay() + "." + (calendar.getMonth() + 1) + "." + calendar.getYear());
        calendar.advanceDays(7);
        System.out.println("One week later it´s New Years Eve: " + calendar.getDay() + "." + (calendar.getMonth() + 1) + "." + calendar.getYear());
    }
}
