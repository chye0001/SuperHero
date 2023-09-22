import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner = new Scanner(System.in);
    private final Database superheroDatabase = new Database();

    public UserInterface() {

    }

    public void startProgram() {

        int choice;

        System.out.println("Welcome til Superhero Universet!");

        do {
            System.out.print("\n1. Create superhero\n2. See list of superheros\n3. Search for a superhero \n4. Edit list of superheros\n5. Delete a superhero\n6. End program\nChoose: ");

            while (!scanner.hasNextInt()) {
                System.out.print("You must enter a number: ");
                scanner.nextLine();
            }

            choice = scanner.nextInt();
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
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.print("Add real name: ");
        String realName = scanner.nextLine();

        System.out.print("Add superpower: ");
        String superPower = scanner.nextLine();

        System.out.print("Add year created: ");
        while (!scanner.hasNextInt()) {
            System.out.print("You must enter a number: ");
            //Linjen efter skal være af sc.next(); metoden, da denne metode tager alle former for input.
            //Hvis det var sc.nextInt(); ville programmet crashe, hvis man inputer andet end integers, da denne scanner ikke kan indlæse andet end integer.
            scanner.next();
        }
        int yearCreated = scanner.nextInt();

        System.out.print("Add isHuman: ");
        while (!scanner.hasNextBoolean()) {
            System.out.print("You must precisely type true or false: ");
            scanner.next();
        }
        Boolean isHuman = scanner.nextBoolean();

        System.out.print("Add strength: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("You must enter a number: ");
            scanner.next();
        }
        double strength = scanner.nextDouble();

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
        while (!scanner.hasNextInt()){
            System.out.print("You must enter a number: ");
            scanner.nextLine();
        }
        int userChoice = scanner.nextInt();
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
        scanner.next();
        String search = scanner.nextLine();

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
