package lk.ijse.spring.mvn.dto;

public class ItemDTO {

    private String icode;
    private String iname;
    private String idiscription;
    private int qty;
    private double unitprice;

    public ItemDTO() {
    }

    public ItemDTO(String iname, String idiscription, int qty, double unitprice) {
        this.setIname(iname);
        this.setIdiscription(idiscription);
        this.setQty(qty);
        this.setUnitprice(unitprice);
    }

    public ItemDTO(String icode, String iname, String idiscription, int qty, double unitprice) {
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
        return "ItemDTO{" +
                "icode='" + icode + '\'' +
                ", iname='" + iname + '\'' +
                ", idiscription='" + idiscription + '\'' +
                ", qty=" + qty +
                ", unitprice=" + unitprice +
                '}';
    }
}
