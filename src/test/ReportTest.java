package test;

import application.ReportService;
import application.Tables;
import org.junit.Test;
import javax.xml.bind.JAXBException;
import static org.junit.Assert.assertEquals;

public class ReportTest {

    @Test
    public void testMarshaller() throws JAXBException {
        ReportService service = new ReportService();
        Tables tables = service.getSpeciesForReport();
        assertEquals(3,tables.getTables().size());
    }
}
