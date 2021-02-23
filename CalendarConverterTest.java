
package calendarconverter;

public class CalendarConverterTest {

    public static void main(String[] args) throws InterruptedException {
        CalendarConverter calendarConverter = new CalendarConverter();
        calendarConverter.setDefaultCloseOperation(CalendarConverter.EXIT_ON_CLOSE);
        calendarConverter.setSize(500, 500);
        calendarConverter.setVisible(true);
        CalendarConverterFunction.display_Images();
       
    }
    
}
