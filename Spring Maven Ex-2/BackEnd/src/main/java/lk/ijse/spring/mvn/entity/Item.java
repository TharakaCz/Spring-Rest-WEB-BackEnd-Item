package lk.ijse.spring.mvn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    private String icode;
    @Column(nullable = false)
    private String iname;
    @Column(nullable = false)
    private String idiscription;
    @Column(nullable = false)
    private int qty;
    @Column(nullable = false)
    private double unitprice;

    public Item() {
    }

    public Item(String iname, String idiscription, int qty, double unitprice) {
        this.setIname(iname);
        this.setIdiscription(idiscription);
        this.setQty(qty);
        this.setUnitprice(unitprice);
    }

    public Item(String icode, String iname, String idiscription, int qty, double unitprice) {
        this.setIcode(icode);
        this.setIname(iname);
        this.setIdiscription(idiscription);
        this.setQty(qty);
        this.setUnitprice(unitprice);
    }


    public String getIcode() {
        return icode;
    }

    public void setIcode(String icode) {
        this.icode = icode;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getIdiscription() {
        return idiscription;
    }

    public void setIdiscription(String idiscription) {
        this.idiscription = idiscription;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "icode='" + icode + '\'' +
                ", iname='" + iname + '\'' +
                ", idiscription='" + idiscription + '\'' +
                ", qty=" + qty +
                ", unitprice=" + unitprice +
                '}';
    }
}
