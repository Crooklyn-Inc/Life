import java.util.Date;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Life {
    public int userYear, userMonth, userDate;
    public int numOfDays, numOfWeeks, numOfYears;
    public int userBDInMonths, userAgeInMonths;
    int hYearsInMonths;
    int difference;

    DecimalFormat f = new DecimalFormat("#.0");

    Scanner input = new Scanner(System.in);

    Date d = new Date();

    int year = d.getYear();
    int currentYear = year + 1900;

    int month = d.getMonth();
    int currentMonth = month + 1;

    int date = d.getDate();

    int currentDateInMonths = ((currentYear * 12) - 1) + currentMonth;


    public void getUsersDOB() {
        System.out.println("Enter your date of birth");

        System.out.print("Year: ");
        userYear = input.nextInt();
        while (userYear <= 0 || userYear < year || userYear < 1900) {
            System.out.print("Invalid input.\n"
                    + "Enter a year: ");
            userYear = input.nextInt();
        }

        System.out.print("Month: ");
        userMonth = input.nextInt();
        while (userYear <= 0 || userYear < month) {
            System.out.print("Invalid input.\n"
                    + " Enter a month: ");
            userMonth = input.nextInt();
        }

        System.out.print("Date: ");
        userDate = input.nextInt();
        while (userDate <= 0) {
            System.out.print("Invalid input.\n"
                    + " Enter a date: ");
            userDate = input.nextInt();
        }


        userBDInMonths = ((userYear * 12) - 1) + userMonth;

        howOld();

        System.out.println("You've used " + userAgeInMonths + " months of your life.");
        System.out.println("This is about " + f.format(userAgeInMonths * 4.3) + " weeks.");
        System.out.println("And about " + f.format((userAgeInMonths * 4.3) * 7) + " days.");
    }

    public int howOld() {
        userAgeInMonths = currentDateInMonths - userBDInMonths;
        hYearsInMonths = 80 * 12;

        return userAgeInMonths;

    }

    public void printCalendar() {

        // printing how old user is in months
        // ⬛ = 1 month

        for (int i = 1; i <= userAgeInMonths; i++) {
            if (i % 30 == 0 && i > 0) {
                System.out.println("⬛");
            } else {
                System.out.print("⬛" + " ");
            }
        }

        difference = hYearsInMonths - userAgeInMonths;

        //printing left over ⬜

        int x = 30 - (userAgeInMonths % 30);
        for (int c = 1; c <= x; c++) {
            System.out.print("⬜" + " ");
        }
        System.out.println();

        difference = hYearsInMonths - userAgeInMonths - x;

        for (int i = 1; i <= difference; i++) {
            if (i % 30 == 0 && i > 0) {
                System.out.println("⬜");
            } else {
                System.out.print("⬜" + " ");
            }
        }


    }

    public static void main(String[] args) {
        Life r = new Life();
        System.out.println("           Hey!!!");
        System.out.println("Welcome to the SAD calendar.");
        System.out.println("============================");


        r.getUsersDOB();
        r.printCalendar();


    }

}
