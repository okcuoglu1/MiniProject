package AppoinmentApp;

import java.time.LocalDate;
import java.util.List;

public class Doctor {

    private int id;
    private String name;
    private String department;
    private List<String> dates;


    public Doctor(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
        LocalDate day = LocalDate.now(); //Sisteme girilen tarih

        for(int i=0; i<7; i++){

            day = day.plusDays(1);
            this.dates.add(day.toString());



        }

    }
}
