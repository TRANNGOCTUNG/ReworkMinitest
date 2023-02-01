package material;

import java.time.LocalDate;

public class CrispyFlour extends Material {

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int quantity;

    public CrispyFlour(){

    }
    public CrispyFlour( String id, String name, LocalDate manufacturingDate, int cost,int quantity){
        super(id,name,manufacturingDate,cost);
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return quantity * getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusDays(1);
    }


    @Override
    public String toString(){
        return "Lớp bôt: "+
                "id : " + getId() +
                "Tên bột: " + getName() +
                "Số lượng: " + getQuantity() +
                "Ngày bán: " + getManufacturingDate() +
                "Hết hạn: " + getExpiryDate() +
                "Giá: " + getCost();
    }
    @Override
    public double getRealMoney() {
        int dueMonth = getExpiryDate().getMonthValue() - LocalDate.now().getMonthValue();
        if (dueMonth <=2) {
            return getAmount() *  0.4;
        } else if (dueMonth <4) {
            return getAmount() * 0.2;
        } else {
            return getAmount() *  0.05;
        }
    }
}
