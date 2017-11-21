package sample;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class OrderDetails {
    private final StringProperty id;
    private final StringProperty orderdate;
    private final StringProperty deliverydate;
    private final StringProperty cost;
    private final StringProperty pid;
    private final StringProperty cid;


    //Default constructor
    public OrderDetails(String id, String orderdate, String deliverydate,String cost,String pid, String cid) {
        this.id = new SimpleStringProperty(id);
        this.orderdate = new SimpleStringProperty(orderdate);
        this.deliverydate = new SimpleStringProperty(deliverydate);
        this.cost = new SimpleStringProperty(cost);
        this.pid = new SimpleStringProperty(pid);
        this.cid = new SimpleStringProperty(cid);
    }

    //Getters
    public String getId() {
        return id.get();
    }

    public String getOrderdate() {
        return orderdate.get();
    }
    public String getDeliverydate() {
        return deliverydate.get();
    }

    public String getCost() {
        return cost.get();
    }

    public String getPid() {
        return pid.get();
    }
    public String getCid() {
        return cid.get();
    }

    //Setters
    public void setId(String value) {
        id.set(value);
    }

    public void setOrderdate(String value) {
        orderdate.set(value);
    }

    public void setDeliverydate(String value) {
        deliverydate.set(value);
    }
    public void setCost(String value) {
        cost.set(value);
    }
    public void setPid(String value) {
        pid.set(value);
    }
    public void setCid(String value) {
        cid.set(value);
    }

    //Property values
    public StringProperty idProperty() {
        return id;
    }

    public StringProperty deliverydateProperty() {
        return deliverydate;
    }

    public StringProperty orderdateProperty() {
        return orderdate;
    }
    public StringProperty costProperty() {
        return cost;
    }
    public StringProperty pidProperty() {
        return pid;
    }
    public StringProperty cidProperty() {
        return cid;
    }


}
