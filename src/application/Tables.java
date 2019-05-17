package application;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Tables")
public class Tables {

    public Tables(){
        //tables = new ArrayList();
    }

    private List<Table> tables;

    public List<Table> getTables(){
      return tables;
    }
    @XmlElement(name = "table")
    public void setTables(List<Table> tables){
      this.tables = tables;
    }
}
