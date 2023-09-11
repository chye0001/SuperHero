public class Database {

    private final Superhero[] superheroList;
    private int count = 0;

    public Database(){
        this.superheroList = new Superhero[2];
    }
    public void addSuperhero(String name, String realName, String superPower,
                             int yearCreated, boolean isHuman, double strength){

        superheroList[count++] = new Superhero(name, realName, superPower, yearCreated, isHuman, strength);
    }

    public String toString(){
        StringBuilder list = new StringBuilder();
        for (Superhero superhero : superheroList) {
            list.append("Superhero" + "\nName: ").append(superhero.getName())
            .append("\nReal name: ").append(superhero.getRealName())
            .append("\nSuperpower: ").append(superhero.getSuperPower())
            .append("\nYear created: ").append(superhero.getYearCreated())
            .append("\nIs human: ").append(superhero.getIsHuman())
            .append("\nStrength: ").append(superhero.getStrength()).append("\n\n");
        }
        return list.toString();


    }
}
