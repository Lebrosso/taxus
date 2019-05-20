package application;


import java.sql.Date;

public class App {
    public static void main (String[]args){
       // new ReportGenerator().generate();
        Table tab = new Table();
        tab.setDisplayName("Lelek");
        tab.setName("lelek");
        //1541462400
        //1556582400
        new ReportService().getCount(new Date(1541462400),new Date(1556582400),"2","2",39,tab);
    }
}
