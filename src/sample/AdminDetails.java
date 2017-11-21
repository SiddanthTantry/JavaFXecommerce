package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AdminDetails {
    private final StringProperty pid;
    private final StringProperty pname;
    private final StringProperty mrp;
    private final StringProperty cat;
    private final StringProperty stock;

    public AdminDetails(String pid, String pname, String mrp,String cat,String stock) {
        this.pid = new SimpleStringProperty(pid);
        this.pname = new SimpleStringProperty(pname);
        this.mrp = new SimpleStringProperty(mrp);
        this.cat = new SimpleStringProperty(cat);
        this.stock = new SimpleStringProperty(stock);
    }

    public String getPid() {
        return pid.get();
    }
    public String getPname() {
        return pname.get();
    }
    public String getMrp() {
        return mrp.get();
    }
    public String getCat() {
        return cat.get();
    }
    public String getStock() {
        return stock.get();
    }

    public void setPid(String value) {
        pid.set(value);
    }
    public void setPname(String value) {
        pname.set(value);
    }
    public void setMrp(String value) {
        mrp.set(value);
    }
    public void setCat(String value) {
        cat.set(value);
    }
    public void setStock(String value) {
        stock.set(value);
    }
    public StringProperty pidProperty() {
        return pid;
    }

    public StringProperty pnameProperty() {
        return pname;
    }
    public StringProperty mrpProperty() {
        return mrp;
    }
    public StringProperty catProperty() {
        return cat;
    }
    public StringProperty stockProperty() {
        return stock;
    }
}
