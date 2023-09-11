public class Superhero {

    private String name;
    private String realName;
    private String superPower;
    private int yearCreated;
    private boolean isHuman;
    private double strength;

    public Superhero(String name, String realName, String superPower,
                      int yearCreated, boolean isHuman, double strength) {
        this.name = name;
        this.realName = realName;
        this.superPower = superPower;
        this.yearCreated = yearCreated;
        this.isHuman = isHuman;
        this.strength = strength;
    }
    public Superhero(){}

    public String getName(){
        return name;
    }
    public String getRealName(){
        return realName;
    }
    public String getSuperPower(){
        return superPower;
    }
    public int getYearCreated(){
        return yearCreated;
    }
    public boolean getIsHuman(){
        return isHuman;
    }
    public double getStrength(){
        return strength;
    }

    public String toString(){
        return "name: " + name + "\n" +
               "real name: " + realName + "\n" +
               "superpower: " + superPower + "\n" +
               "year created: " + yearCreated + "\n" +
               "is human: " + isHuman + "\n" +
               "strength: " + strength;
    }
}
