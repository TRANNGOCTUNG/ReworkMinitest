package main;

import material.CrispyFlour;
import material.Material;
import material.Meat;
import org.w3c.dom.Node;

import java.time.LocalDate;
import java.util.*;

public class MaterialManagers {
    Scanner input = new Scanner(System.in);
    int index;
    ArrayList<Material> materials;
    public MaterialManagers(){
        materials = new ArrayList<>();
        materials.add(new CrispyFlour("01", "Bột acai", LocalDate.now().minusMonths(2), 10000, 1));
        materials.add(new CrispyFlour("02", "Bột cacao", LocalDate.now().minusMonths(3), 15000, 2));
        materials.add(new CrispyFlour("03", "Bột nấm", LocalDate.now().minusMonths(4), 20000, 3));
        materials.add(new CrispyFlour("04", "Bột nghệ", LocalDate.now().minusMonths(5), 25000, 4));
        materials.add(new CrispyFlour("05", "Bột đậu nành", LocalDate.now().minusMonths(6), 30000, 5));
        materials.add(new Meat("06", "Gà", LocalDate.now().minusDays(3), 120000, 6));
        materials.add(new Meat("07", "Lơn", LocalDate.now().minusDays(4), 60000, 7));
        materials.add(new Meat("08", "Trâu", LocalDate.now().minusDays(5), 300000, 8));
        materials.add(new Meat("09", "Bò", LocalDate.now().minusDays(6), 200000, 9));
        materials.add(new Meat("10", "Dê", LocalDate.now().minusDays(7), 1000000, 10));
    }
    public void display(){
        for (Material m: materials
             ) {
            System.out.println(m);
        }
    }
    public int size() {
        return materials.size();
    }
    public int getIndex() {
        System.out.println("Enter Index");
        return input.nextInt();
    }
    public void addMaterial(Material material) {
        materials.add(material);
    }

    public void editMaterial(Material material) {
        int index = getIndex();
        if(index < 0 || index > size() - 1) {
            System.out.println("Material cannot be added at this location!");
        } else {
            materials.set(index, material);
        }
    }

    public void deleteMaterial() {
        int index = getIndex();
        if (index < 0 || index > size() - 1) {
            System.out.println("Material delete be added at this location!");
        } else {
            materials.remove(index);
        }
    }
    public String enterId() {
        System.out.println("Enter id: ");
        return input.nextLine();
    }
    public String enterName() {
        System.out.println("Enter name: ");
        return input.nextLine();
    }
    public int enterCost() {
        System.out.println("Enter cost: ");
        return input.nextInt();
    }
    public int addMonths() {
        System.out.println("Enter the number of months you want to add: ");
        return input.nextInt();
    }
    public int addDays() {
        System.out.println("Enter the number of days you want to add: ");
        return input.nextInt();
    }
    public double enterWeight() {
        System.out.println("Enter weight");
        return input.nextDouble();
    }
    public int enterQuantity() {
        System.out.println("Enter quantity: ");
        return input.nextInt();
    }

    public void differenceCostCrispyFlour() {
        double totalOriginCost = 0;
        double totalCostAfterSale = 0;
        double differenceCost;
        for (Material material : materials) {
            if (material instanceof CrispyFlour) {
                totalOriginCost += material.getAmount();
                totalCostAfterSale += ((CrispyFlour) material).getRealMoney();
            }
        }
        differenceCost = totalOriginCost - totalCostAfterSale;
        System.out.println("Initial CrispyFlour price: " + totalOriginCost);
        System.out.println("Promotional CrispyFlour price " + totalCostAfterSale);
        System.out.println("Price CrispyFlour difference: " + differenceCost);
    }

    public void differenceCostMeat() {
        double totalOriginCost = 0;
        double totalCostAfterSale = 0;
        double differenceCost;
        for (Material material : materials) {
            if (material instanceof Meat) {
                totalOriginCost += material.getAmount();
                totalCostAfterSale += ((Meat) material).getRealMoney();
            }
        }
        differenceCost = totalOriginCost - totalCostAfterSale;
        System.out.println("Initial Meat price: " + totalOriginCost);
        System.out.println("Promotional Meat price " + totalCostAfterSale);
        System.out.println("Price Meat difference: " + differenceCost);
    }
}
