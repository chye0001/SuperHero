import java.util.Scanner;

public class UserInterface {

    private Scanner sc = new Scanner(System.in);
    private int choice;
    private Database superheroDatabase = new Database();

    public UserInterface() {

    }

    public void startProgram() {

        int numberOfChoices = 5;
        System.out.println("Welcome til Superhero Universet!");

        do {
            System.out.print("\n1. Create superhero\n2. See list of superheros\n3. Search for a superhero \n4. Edit list of superheros\n5. Delete a superhero\n6. End program\nChoose: ");

            while (!sc.hasNextInt()) {
                System.out.print("You must enter a number: ");
                sc.nextLine();
            }

            choice = sc.nextInt();
            System.out.println();

            if (choice == 1) {
                createSuperhero();
            } else if (choice == 2) {
                listOfSuperheros();
            } else if (choice == 3) {
                searchSuperhero();
            } else if (choice == 4) {
                editList();
            } else if (choice == 5) {
                deleteSuperhero();
            } else if (choice == 6) {
                endProgram();
            }
        } while (choice != 6);
    }

    public void createSuperhero() {
        System.out.print("Add name: ");
        String x = sc.nextLine();
        String name = sc.nextLine();

        System.out.print("Add real name: ");
        String realName = sc.nextLine();

        System.out.print("Add superpower: ");
        String superPower = sc.nextLine();

        System.out.print("Add year created: ");
        while (!sc.hasNextInt()) {
            System.out.print("You must enter a number: ");
            //Linjen efter skal være af sc.next(); metoden, da denne metode tager alle former for input.
            //hvis det var sc.nextInt(); ville programmet crashe, hvis man inputer andet end integers, da denne scanner ikke kan indlæse andet end integer.
            sc.next();
        }
        int yearCreated = sc.nextInt();

        System.out.print("Add isHuman: ");
        while (!sc.hasNextBoolean()) {
            System.out.print("You must precisely type true or false: ");
            sc.next();
        }
        Boolean isHuman = sc.nextBoolean();

        System.out.print("Add strength: ");
        while (!sc.hasNextDouble()) {
            System.out.print("You must enter a number: ");
            sc.next();
        }
        double strength = sc.nextDouble();

        superheroDatabase.addSuperhero(name, realName, superPower, yearCreated, isHuman, strength);

        System.out.println("Superhero added to list, would you like to create a new superhero?");
    }

    public void deleteSuperhero(){
        if (superheroDatabase.getSize() == 0) {
            System.out.println("There are no superheros in your list.");
            return;
        } else {
            int count = 1;
            for (Superhero superhero : superheroDatabase.getSuperheroList()) {
                System.out.println(count++ + ": " + superhero.getName() + ", " +
                        superhero.getRealName() + ", " +
                        superhero.getSuperpower() + ", " +
                        superhero.getYearCreated() + ", " +
                        superhero.getIsHuman() + ", " +
                        superhero.getStrength());
            }
        }
        System.out.print("\nWhich superhero do you wish to delete? If you regret this option press 0.\nChoice: ");
        while (!sc.hasNextInt()){
            System.out.print("You must enter a number: ");
            sc.nextLine();
        }
        int userChoice = sc.nextInt();
        superheroDatabase.deleteSuperhero(userChoice);
    }

    public void listOfSuperheros() {
        System.out.println(superheroDatabase);
        if (superheroDatabase.getSuperheroList().isEmpty()) {
            System.out.println("The database is empty");
        }
        System.out.println("Would you like to see the list again?");
    }

    public void searchSuperhero() {
        System.out.print("Input search: ");
        String q = sc.next();
        String search = sc.nextLine();

        System.out.println(superheroDatabase.searchSuperhero(search));
        System.out.println("Would you like to search again?");
    }

    public void editList() {
        superheroDatabase.editSuperheroList();
        System.out.println("Would you like to edit the list again?");
    }

    public void endProgram() {
        System.out.println("Program ended");
    }
}
