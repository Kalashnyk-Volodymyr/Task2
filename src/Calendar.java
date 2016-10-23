import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by v_kal on 22.10.2016.
 */
public class Calendar {
    private  LocalDate curr;
    public Calendar(){
        curr=LocalDate.now();
    }
    public Calendar(String yourDate){
        this.curr=LocalDate.parse(yourDate);
    }

    private String Calendar() {
        LocalDate first = curr.withDayOfMonth(1);     // первый день месяца
        String str = "Пн\tВт\tСр\tЧт\tПт\tСб\tВс";

        while (curr.getMonth() == first.getMonth()) {   // пока текущий месяц
            str = str + "\n";
            for (DayOfWeek d : DayOfWeek.values()) {
                if (d != first.getDayOfWeek()) {                        // Пропустить дни другого месяца
                    str = str + "  \t";
                    continue;
                } else {
                    if (curr.isEqual(first)) {                          // вывести заданую дату красным
                        str = str + "\033[31m" + first.getDayOfMonth() + "\033[0m" + "\t";
                        first = first.plusDays(1);                      // следующий день
                        if (curr.getMonth() != first.getMonth())        // если  месяц не совпадает закончить работу
                            break;
                        else
                            continue;
                    }
                    if (first.getDayOfWeek() == DayOfWeek.SATURDAY || first.getDayOfWeek() == DayOfWeek.SUNDAY) // отобразить выходной
                        str = str + "\033[34m" + first.getDayOfMonth() + "\033[0m" + "\t";
                    else
                        str = str + first.getDayOfMonth() + "\t";  // вывод обычного дня
                }
                first = first.plusDays(1);
                if (curr.getMonth() != first.getMonth())
                    break;
            }
        }
        return str;
    }
    @Override
    public String toString(){
        return Calendar();
    }
}
