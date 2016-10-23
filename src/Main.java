/**
 * Created by v_kal on 22.10.2016.
 */
import java.util.Scanner;
import java.time.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату формат(yyyy-mm-dd):");
        String yourDate = sc.nextLine();

        Calendar calendar;

        if (yourDate.length()>0)
            calendar = new Calendar(yourDate);
        else
            calendar=new Calendar();

        System.out.print(calendar);
    }
}
