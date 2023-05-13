import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        long unixtimestamp = date.getTime();
        System.out.println(unixtimestamp);

        Date anotherDate = Calendar.getInstance().getTime();
        long anotherUTS = anotherDate.getTime();
        System.out.println(anotherUTS);
    }
}