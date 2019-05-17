package application;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Table")
@XmlType(propOrder = {"name", "displayName"})
public class Table {

    private String name;
    private String displayName;

    public String getName() {
        return name;
    }
    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    @XmlElement(name = "displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

}
