import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class PrintCalendar {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java PrintCalendar <month> <year>");
            System.exit(1);
        }

        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);

        printMonth(year, month);
    }

    public static void printMonth(int year, int month) {
        printMonthTitle(year, month);
        printMonthBody(year, month);
    }

    public static void printMonthTitle(int year, int month) {
        Calendar calendar = new GregorianCalendar(year, month - 1, 1);
        String monthName = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
        
        System.out.println("        " + monthName + " " + year);
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    public static void printMonthBody(int year, int month) {
        Calendar calendar = new GregorianCalendar(year, month - 1, 1);
        
        int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int numberOfDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        int i = 0;
        for (i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        for (i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%4d", i);

            if ((i + startDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}