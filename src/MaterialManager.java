import java.time.LocalDate;
import java.util.Scanner;

public class MaterialManager {
    public static void main(String[] args) {
        Material[] materials = new Material[10];

        CrispyFlour crispyFlour = new CrispyFlour("01", "Bột acai", LocalDate.now().minusMonths(2), 10000, 1);
        CrispyFlour crispyFlour1 = new CrispyFlour("02", "Bột cacao", LocalDate.now().minusMonths(3), 15000, 2);
        CrispyFlour crispyFlour2 = new CrispyFlour("03", "Bột nấm", LocalDate.now().minusMonths(4), 20000, 3);
        CrispyFlour crispyFlour3 = new CrispyFlour("04", "Bột nghệ", LocalDate.now().minusMonths(5), 25000, 4);
        CrispyFlour crispyFlour4 = new CrispyFlour("05", "Bột đậu nành", LocalDate.now().minusMonths(6), 30000, 5);

        materials[0] = crispyFlour;
        materials[1] = crispyFlour1;
        materials[2] = crispyFlour2;
        materials[3] = crispyFlour3;
        materials[4] = crispyFlour4;

        Meat meat = new Meat("06", "Gà", LocalDate.now().minusDays(3), 120000, 6);
        Meat meat1 = new Meat("07", "Lơn", LocalDate.now().minusDays(4), 60000, 7);
        Meat meat2 = new Meat("08", "Trâu", LocalDate.now().minusDays(5), 300000, 8);
        Meat meat3 = new Meat("09", "Bò", LocalDate.now().minusDays(6), 200000, 9);
        Meat meat4 = new Meat("10", "Dê", LocalDate.now().minusDays(7), 1000000, 10);

        materials[5] = meat;
        materials[6] = meat1;
        materials[7] = meat2;
        materials[8] = meat3;
        materials[9] = meat4;

        double realCost = getRealPrice(materials[9]);
        System.out.println(realCost);

        Meat m = (Meat) materials[5];
        System.out.println(m.getCost());

    }

    int index;
    Scanner input = new Scanner(System.in);
    public void deleteElement(){
        System.out.println("nhập vị trí muốn xóa");
        index = input.nextInt();
    }

    public static double getRealPrice(Material material){
        LocalDate now = LocalDate.now();
        LocalDate expiryDate;
        if(material instanceof Meat){
            Meat meat = (Meat)material;
            expiryDate = meat.getExpiryDate();
            if(expiryDate.minusDays(5).isBefore(now)){
                return material.getCost() * 0.6;
            } else {
                return material.getCost() * 0.9;
            }
        } else {
            CrispyFlour flour = (CrispyFlour)material;
            expiryDate = flour.getExpiryDate();
            if(expiryDate.minusMonths(2).isBefore(now)){
                return material.getCost() * 0.6;
            } else if (expiryDate.minusMonths(4).isBefore(now)) {
                return material.getCost() * 0.8;
            } else {
                return material.getCost() * 0.95;
            }
        }
    }

}
