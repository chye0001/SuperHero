import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Database superheroList = new Database();

        System.out.println("Velkommen til Superhero Universet!");
        System.out.print("\n1. Create superhero\n2. See list of superheros\n3. Search for a superhero \n9. End program\nChoose: ");

        int choice = sc.nextInt();
        System.out.println();

        if (choice==1) {
            do {
                System.out.print("Add name: ");
                String x = sc.nextLine();
                String name = sc.nextLine();

                System.out.print("Add real name: ");
                String realName = sc.nextLine();

                System.out.print("Add superpower: ");
                String superPower = sc.nextLine();

                System.out.print("Add year created: ");
                while(!sc.hasNextInt()){
                    System.out.print("You must enter a number: ");
                    //Linjen efter skal være af sc.next(); metoden, da denne metode tager alle former for input.
                    //hvis det var sc.nextInt(); ville programmet crashe, hvis man inputer andet end integers, da denne scanner ikke kan indlæse andet end integer.
                    sc.next();
                }
                int yearCreated = sc.nextInt();

                System.out.print("Add isHuman: ");
                while(!sc.hasNextBoolean()) {
                    System.out.print("You must precisely type true or false: ");
                    sc.next();
                }
                Boolean isHuman = sc.nextBoolean();

                System.out.print("Add strength: ");
                double strength = sc.nextDouble();

                superheroList.addSuperhero(name, realName, superPower, yearCreated, isHuman, strength);

                System.out.println("Superhero added to list, would you like to create a new superhero?");
                System.out.print("\n1. Create superhero\n2. See list of superheros\n3. Search for a superhero\n9. End program\nChoose: ");
                choice = sc.nextInt();

            } while (choice!=9 && choice!=2 && choice!=3);

            if (choice==2){
                System.out.println(superheroList);
            }
            if (choice==3){
                System.out.print("Input search: ");
                String search = sc.nextLine();

                System.out.println(superheroList.searchSuperhero(search));
            }
            if (choice==9){
                System.out.println("Program ended");
            }

        } else if (choice==2) {
            System.out.println(superheroList);}

        else if (choice==3){
            System.out.print("Input search: ");
            String z = sc.next();
            String search = sc.nextLine();

            System.out.println(superheroList.searchSuperhero(search));
        }

        else {
            System.out.println("Program ended");
        }
    }
}
