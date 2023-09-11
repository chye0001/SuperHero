public class Database {

    private Superhero[] superheroList;
    private int count = 0;

    public Database(){
        this.superheroList = new Superhero[2];
    }
    public void addSuperhero(String name, String realName, String superPower,
                             int yearCreated, boolean isHuman, double strengh){

        superheroList[count++] = new Superhero(name, realName, superPower, yearCreated, isHuman, strengh);
    }

    public Superhero getSuperheroList(){
        return superheroList[0];
    }

    public String toString(){
        String list = "";
        for (Superhero superhero : superheroList) {
            list += "Superhero" +
                    "\nName: " + superhero.getName() +
                    "\nReal name: " + superhero.getRealName() +
                    "\nSuperpower: " + superhero.getSuperPower() +
                    "\nYear created: " + superhero.getYearCreated() +
                    "\nIs human: " + superhero.getIsHuman() +
                    "\nStrength: " + superhero.getStrength() + "\n\n";
        }
        return list;


    }
}
