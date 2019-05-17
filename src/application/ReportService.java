package application;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
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

    public Tables getSpeciesForReport() throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Tables.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Tables tables = (Tables) jaxbUnmarshaller.unmarshal(new File("tables.xml") );

        for(Table tab : tables.getTables())
        {
            System.out.println(tab.getName());
            System.out.println(tab.getDisplayName());
        }

        return tables;
    }

    public void getCount(){
        try {
            conn.getCount(new Date(2017), new Date(2019), "2", "1", 2, "lelek" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
