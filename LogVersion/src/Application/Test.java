package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {

    public static void main(String[] args) {
        try {
            Calendar now = Calendar.getInstance();
            String line = "Date: 30 - March - 2013";
            line = line.substring(Entry.DATE.length());
//            byte index = 0;
//            int date = Integer.parseInt(line.substring(0, 2));
//            line = line.substring(5);
//            StringBuilder month = new StringBuilder();
//
//            while (line.charAt(index) != '-') {
//                month.append(line.charAt(index));
//                index++;
//            }
//            month.deleteCharAt(month.length() - 1);
//            System.out.println(month.toString());
//            line = line.substring(index + 2);

//            System.out.println(line);
            SimpleDateFormat moo = MainScreen.DEFAULT_DATE;//new SimpleDateFormat("dd - MMMM -", Locale.ENGLISH);
            Date dated = moo.parse(line);
            System.out.println(MainScreen.DEFAULT_DATE.format(dated));
//            dated = MainScreen.DEFAULT_DATE.parse(MainScreen.DEFAULT_DATE.format(dated));
//            System.out.println(MainScreen.DEFAULT_DATE.format(dated));

//            int year = Integer.parseInt(line);
//            System.out.println(date + " " + month + " " + year);
        } catch (ParseException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
