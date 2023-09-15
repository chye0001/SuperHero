import java.util.ArrayList;
import java.util.Scanner;

public class Database {

    private final ArrayList<Superhero> superheroList = new ArrayList<>(2);
    private int count = 2;
    private ArrayList<Superhero> searchResults = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    //Original konstruktør. (fjern "this....")
    /*public Database(){
        this.superheroList = new Superhero[2];
    }
     */

    //Midlertidig hardkodet superhelte så jeg ikke konstant skal oprette nye superheros når jeg vil teste koden.
    public Database() {
        Superhero ironMan = new Superhero("Iron Man", "Tony Stark", "Has big brain", 2005, true, 800);
        Superhero captainAmerica = new Superhero("Captain America", "Steve Rogers", "Superhuman Strength", 1941, true, 999);
        superheroList.add(ironMan);
        superheroList.add(captainAmerica);
    }

    public void addSuperhero(String name, String realName, String superPower,
                             int yearCreated, Boolean isHuman, double strength) {
        count++;
        Superhero newSuperhero = new Superhero(name, realName, superPower, yearCreated, isHuman, strength);
        superheroList.add(newSuperhero);
    }

    public ArrayList<Superhero> searchSuperhero(String search) {

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
        if (superheroList.size() == 0) {
            System.out.println("There are no superheros in the list to edit");
        } else if (superheroList.size() > 0) {
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
            int userChoise = sc.nextInt();

            Superhero chosenSuperheroToEdit = superheroList.get(userChoise - 1);
            System.out.println("\nThe chosen superhero to edit:\n" + chosenSuperheroToEdit);

            System.out.println("\nEdit data and press enter. If you do not wish to edit, just press enter to continue.\n");

            System.out.println("Name: " + chosenSuperheroToEdit.getName());
            String x = sc.nextLine();
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

            if (superhero.getIsHuman() == true) {
                list.append("Yes");
            } else {
                list.append("No");
            }
            list.append("\nStrength: ").append(superhero.getStrength()).append("\n\n");
        }
        return list.toString();
    }
}
