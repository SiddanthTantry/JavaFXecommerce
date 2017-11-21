package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SearchDetails {
    private final StringProperty pid;
    private final StringProperty name;
    private final StringProperty mrp;
    private final StringProperty catagory;

    public SearchDetails(String pid, String name, String mrp,String catagory) {
        this.pid = new SimpleStringProperty(pid);
        this.name = new SimpleStringProperty(name);
        this.mrp = new SimpleStringProperty(mrp);
        this.catagory = new SimpleStringProperty(catagory);
    }
    public String getPid() {
        return pid.get();
    }
    public String getName() {
        return name.get();
    }
    public String getMrp() {
        return mrp.get();
    }
    public String getCatagory() {
        return catagory.get();
    }

    public void setPid(String value) {
        pid.set(value);
    }
    public void setName(String value) {
        name.set(value);
    }
    public void setMrp(String value) {
        mrp.set(value);
    }
    public void setCatagory(String value) {
        catagory.set(value);
    }


}
