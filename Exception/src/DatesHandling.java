import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DatesHandling{
    public static void main(String[] args) {
        subAction();
    }

    public static void subAction() {
        try{
            action();
        }catch(ParseException ex) {
            ex.printStackTrace();
        }
    }

    public static void action() throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateSTR = "2002-08-12";
        Date date = sdf.parse(dateSTR);
        System.out.println(date);
    }


}