package view;

import controller.MaterialManagers;
import model.CrispyFlour;
import model.Meat;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MaterialManagers materialManagers = new MaterialManagers();
        Scanner input = new Scanner(System.in);
        int number;
        do{
            System.out.println("""
        Menu:
       
        1. Show material list.
        2. Add a new Crispy Flour.
        3. Add a new Meat.
        4. Edit a new Crispy Flour.
        5. Edit a new Meat.
        6. Delete Material.
        7. Origin and sale price of CrispyFlour.
        8. Origin and sale price of Meat.
        0.Exit.""");
            System.out.println("Enter number");
            number = input.nextInt();
            switch (number) {
                case 1 -> materialManagers.display();

                case 2 -> {
                    materialManagers.addMaterial(new CrispyFlour(materialManagers.enterId(),
                            materialManagers.enterName(), LocalDate.now().plusMonths(materialManagers.addMonths()),
                            materialManagers.enterCost(), materialManagers.enterQuantity()));
                    materialManagers.display();
                }

                case 3 -> {
                    materialManagers.addMaterial(new Meat(materialManagers.enterId(),
                            materialManagers.enterName(), LocalDate.now().plusDays(materialManagers.addDays()),
                            materialManagers.enterCost(), materialManagers.enterWeight()));
                    materialManagers.display();
                }

                case 4 -> {
                    materialManagers.editMaterial(new CrispyFlour(materialManagers.enterId(),
                            materialManagers.enterName(), LocalDate.now().plusMonths(materialManagers.addMonths()),
                            materialManagers.enterCost(), materialManagers.enterQuantity()));
                    materialManagers.display();
                }

                case 5 -> {
                    materialManagers.editMaterial(new Meat(materialManagers.enterId(),
                            materialManagers.enterName(), LocalDate.now().plusDays(materialManagers.addDays()),
                            materialManagers.enterCost(), materialManagers.enterWeight()));
                    materialManagers.display();
                }

                case 6 -> {
                    materialManagers.deleteMaterial();
                    materialManagers.display();
                }
                case 7 -> materialManagers.differenceCostCrispyFlour();
                case 8 -> materialManagers.differenceCostMeat();
                case 0 -> System.exit(number);
                default -> System.out.println("Please choose again!\n");
            }
        }while (true);
    }

}