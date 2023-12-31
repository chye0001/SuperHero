import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Database {

    private final ArrayList<Superhero> superheroList = new ArrayList<>(2);
    private final Scanner sc = new Scanner(System.in);

    //Midlertidig hardkodet superhelte så jeg ikke konstant skal oprette nye superheros når jeg vil teste koden.
    public Database() {
        Superhero ironMan = new Superhero("Iron Man", "Tony Stark", "Has big brain", 2005, true, 800);
        Superhero captainAmerica = new Superhero("Captain America", "Steve Rogers", "Superhuman Strength", 1941, true, 999);
        superheroList.add(ironMan);
        superheroList.add(captainAmerica);
    }

    public int getSize(){
        return superheroList.size();
    }

    //Denne metode anvendes til at få fat i listen med superhelte i klassen UserInterface, og anvendes til at printe "fejlmeddeles", hvis listen er tom.
    public ArrayList<Superhero> getSuperheroList(){
        return superheroList;
    }
    public void addSuperhero(String name, String realName, String superPower,
                             int yearCreated, Boolean isHuman, double strength) {
        Superhero newSuperhero = new Superhero(name, realName, superPower, yearCreated, isHuman, strength);
        superheroList.add(newSuperhero);
    }

    public void deleteSuperhero(int userChoice) {

        try {
            if (userChoice == 0) {
                System.out.println("No superheros were deleted");
            } else if (userChoice > 0 && userChoice <= superheroList.size()) {
                superheroList.remove(userChoice - 1);
                System.out.println("\nThe superhero was deleted from your superhero list.");
            } else { // catches any indexOutOfBoundsExceptions
                while (userChoice > superheroList.size() || userChoice < 0) {
                    System.out.print("You have to choose within the list size: ");
                    userChoice = sc.nextInt();
                }
                if (userChoice == 0) {
                    System.out.println("No superheros were deleted");
                    return;
                }
                superheroList.remove(userChoice - 1);
                System.out.println("\nThe superhero was deleted from your superhero list.\nWould you like to delete another superhero?");
            }
        }catch (InputMismatchException ime){
            System.out.print("\nYou can't input anything but a number within the list size.\n");
            System.out.println("Try again but from the beginning");
        }
    }

    public ArrayList<Superhero> searchSuperhero(String search) {
        ArrayList<Superhero> searchResults = new ArrayList<>();
        for (Superhero superhero : superheroList) {
            if (superhero.getName().toLowerCase().contains(search.toLowerCase()) || superhero.getRealName().toLowerCase().contains(search.toLowerCase())) {
                if (!searchResults.contains(superhero.getName()) || !searchResults.contains(superhero.getRealName())) {
                    searchResults.add(superhero);
                }
            }
        }
        return searchResults;
    }

    public void editSuperheroList() {
        if (superheroList.isEmpty()) {
            System.out.println("There are no superheros in the list to edit");
        } else  {
            int count = 1;
            for (Superhero superhero : superheroList) {
                System.out.println(count++ + ": " + superhero.getName() + ", " +
                        superhero.getRealName() + ", " +
                        superhero.getSuperpower() + ", " +
                        superhero.getYearCreated() + ", " +
                        superhero.getIsHuman() + ", " +
                        superhero.getStrength());
            }
            System.out.print("Choose a superhero from the list to edit: ");

            //This whole try-code block throws an indexOutOfBoundsExceptions if user inputs a value that's out of bounds.
            try {
                //This block of code forces user to input a number.
                while (!sc.hasNextInt()) {
                    System.out.print("You must enter a number from the list: ");
                    sc.nextLine();
                }

                int userChoise = sc.nextInt();

                Superhero chosenSuperheroToEdit = superheroList.get(userChoise - 1);

                System.out.println("\nThe chosen superhero to edit:\n" + chosenSuperheroToEdit);

                System.out.println("\nEdit data and press enter. If you do not wish to edit, just press enter to continue.\n");

                System.out.println("Name: " + chosenSuperheroToEdit.getName());
                sc.nextLine();
                String newName = sc.nextLine();
                if (!newName.isEmpty()) {
                    chosenSuperheroToEdit.setName(newName);
                }

                System.out.println("Real name: " + chosenSuperheroToEdit.getRealName());
                String newRealName = sc.nextLine();
                if (!newRealName.isEmpty()) {
                    chosenSuperheroToEdit.setRealName(newRealName);
                }

                System.out.println("Superpower: " + chosenSuperheroToEdit.getSuperpower());
                String newSuperpower = sc.nextLine();
                if (!newSuperpower.isEmpty()) {
                    chosenSuperheroToEdit.setSuperPower(newSuperpower);
                }

                System.out.println("Year created: " + chosenSuperheroToEdit.getYearCreated());
                String newYearCreated = sc.nextLine();
                if (!newYearCreated.isEmpty()) {
                    chosenSuperheroToEdit.setYearCreated(Integer.parseInt(newYearCreated));
                }

                System.out.println("Is human: " + chosenSuperheroToEdit.getIsHuman());
                String newIsHuman = sc.nextLine();
                if (!newIsHuman.isEmpty()) {
                    chosenSuperheroToEdit.setIsHuman(Boolean.parseBoolean(newIsHuman));
                }

                System.out.println("Strength: " + chosenSuperheroToEdit.getStrength());
                String newStrength = sc.nextLine();
                if (!newStrength.isEmpty()) {
                    chosenSuperheroToEdit.setStrength(Integer.parseInt(newStrength));
                }

                if (!newName.isEmpty() || !newRealName.isEmpty() ||
                        !newSuperpower.isEmpty() || !newYearCreated.isEmpty() ||
                        !newIsHuman.isEmpty() || !newStrength.isEmpty()) {
                    System.out.println("The chosen superhero has been edited!\n");
                } else {
                    System.out.println("No edits has been performed.");
                }

                //this Catch-block catches any indexOutOfBoundsExceptions.
            } catch (Exception e) {
                //This do-while loop, forces the user to input a "positive value" / number from the list.
                do {
                    System.out.print("You have to choose between 1-" + --count + ": ");
                } while (sc.nextInt() <= 0);
               editSuperheroList();
            }
        }
    }


    public String toString() {
        StringBuilder list = new StringBuilder();
        for (Superhero superhero : superheroList) {
            list.append("Superhero" + "\nName: ").append(superhero.getName())
                    .append("\nReal name: ").append(superhero.getRealName())
                    .append("\nSuperpower: ").append(superhero.getSuperpower())
                    .append("\nYear created: ").append(superhero.getYearCreated())
                    .append("\nIs human: ");

            if (superhero.getIsHuman()) {
                list.append("Yes");
            } else {
                list.append("No");
            }
            list.append("\nStrength: ").append(superhero.getStrength()).append("\n\n");
        }
        return list.toString();
    }
}
