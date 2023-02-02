package model;

import java.time.LocalDate;

public  class Meat extends Material {
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    private double weight;

    public Meat(){

    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight){
        super(id,name,manufacturingDate,cost);
        this.weight = weight;
    }
    @Override
    public double getAmount() {
        return getCost() * weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusDays(7);
    }


    @Override
    public String toString(){
        return "thịt: "+
                "Cân nặng: " + getWeight() +
                "id: " + getId() +
                "Loại thịt: " + getName() +
                "Ngày sản xuất: " + getManufacturingDate() +
                "Hết hạn: " + getExpiryDate() +
                "Giá: " + getCost();
    }
    @Override
    public double getRealMoney() {
        int dueDate = getExpiryDate().getDayOfMonth() - LocalDate.now().getDayOfMonth();
        if (dueDate < 5) {
            return getAmount() *  0.3;
        }
        else {
            return getAmount() *  0.1;
        }
    }
}
