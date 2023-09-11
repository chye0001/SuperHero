import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Database superheroList = new Database();

        System.out.println("Velkommen til Superhero Universet!");
        System.out.print("\n1. Create superhero\n9. End program\nChoose: ");

        int choice = sc.nextInt();
        System.out.println();

        if (choice==1) {
            do {
                System.out.print("Add name: ");
                String name = sc.next();

                System.out.print("Add real name: ");
                String realName = sc.next();

                System.out.print("Add superpower: ");
                String superPower = sc.next();

                System.out.print("Add year created: ");
                int yearCreated = sc.nextInt();

                System.out.print("Add isHuman: ");
                boolean isHuman = sc.nextBoolean();

                System.out.print("Add strength: ");
                double strength = sc.nextDouble();

                superheroList.addSuperhero(name, realName, superPower, yearCreated, isHuman, strength);

                System.out.println("Superhero added to list, would you like to create a new superhero?");

                System.out.print("\n1. Create superhero\n9. End program\nChoose: ");
                choice = sc.nextInt();
                System.out.println();

            } while (choice!=9);
            System.out.println("\nProgram ended");
            System.out.println(superheroList);
        }
        else {
            System.out.println("Program ended");
        }
    }
}
