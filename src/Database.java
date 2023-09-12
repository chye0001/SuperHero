import java.util.ArrayList;

public class Database {

    private final ArrayList<Superhero> superheroList = new ArrayList<>(2);

    //Original konstruktør. (fjern "this....")
    /*public Database(){
        this.superheroList = new Superhero[2];
    }
     */

    //Midlertidig hardkodet superhelte så jeg ikke konstant skal oprette nye superheros når jeg vil teste koden.
    public Database() {
        Superhero ironMan = new Superhero("Iron Man", "Tony Stark", "Has a bigbran", 2005, true, 800);
        Superhero captainAmerica = new Superhero("Captain America", "Steve Rogers", "Superhuman Strength", 1941, true, 999);
        superheroList.add(ironMan);
        superheroList.add(captainAmerica);
    }

    public void addSuperhero(String name, String realName, String superPower,
                             int yearCreated, Boolean isHuman, double strength) {

        Superhero newSuperhero = new Superhero(name, realName, superPower, yearCreated, isHuman, strength);
        superheroList.add(newSuperhero);
    }

    public String toString() {
        StringBuilder list = new StringBuilder();
        for (Superhero superhero : superheroList) {
            list.append("Superhero" + "\nName: ").append(superhero.getName())
                    .append("\nReal name: ").append(superhero.getRealName())
                    .append("\nSuperpower: ").append(superhero.getSuperPower())
                    .append("\nYear created: ").append(superhero.getYearCreated())
                    .append("\nIs human: ");

                    if(superhero.getIsHuman()==true){
                        list.append("Yes");
                    }
                    else {
                        list.append("No");
                    }
                    list.append("\nStrength: ").append(superhero.getStrength()).append("\n\n");
        }
        return list.toString();
    }

    /*
    public String toString() {
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < count; i++) {
            list.append("Superhero" + "\nName: ").append(superheroList[i].getName())
                    .append("\nReal name: ").append(superheroList[i].getRealName())
                    .append("\nSuperpower: ").append(superheroList[i].getSuperPower())
                    .append("\nYear created: ").append(superheroList[i].getYearCreated())
                    .append("\nIs human: ").append(superheroList[i].getIsHuman())
                    .append("\nStrength: ").append(superheroList[i].getStrength()).append("\n\n");
        }
        return list.toString();
    }
     */
}
