public class Database {

    private Superhero[] superheroList;
    private int count;

    public Database(){
        this.superheroList = new Superhero[5];
    }
    public void addSuperhero(String name, String realName, String superPower,
                             int yearCreated, boolean isHuman, double strengh){

        superheroList[count++] = new Superhero(name, realName, superPower, yearCreated, isHuman, strengh);

    }


}
