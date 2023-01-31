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
}
