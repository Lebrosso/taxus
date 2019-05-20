package application;

import javax.xml.bind.JAXBException;
import java.sql.Date;
import java.sql.SQLException;

public class ReportService {

    DbConnector conn;

    {
        try {
            conn = DbConnector.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getCount(Date dateTo, Date dateFrom, String voivodeship, String county,int userId, Table table) {
        try {
            conn.getCount(dateTo,dateFrom,voivodeship,county,userId,table);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getCount(Date dateTo, Date dateFrom, String voivodeship, String county, Table table) {
        try {
            conn.getCount(dateTo,dateFrom,voivodeship,county,table);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
