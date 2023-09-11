import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Velkomen til Superhero Universet!");
        Database superheroList = new Database();



        System.out.print("Add name: ");
        String name = sc.next();

        System.out.print("Add realname: ");
        String realName = sc.next();

        System.out.print("Add superpower: ");
        String superPower = sc.next();

        System.out.print("Add year created: ");
        int yearCreated = sc.nextInt();

        System.out.print("Add isHuman: ");
        boolean isHuman = sc.nextBoolean();

        System.out.print("Add strength: ");
        double strength = sc.nextDouble();


        Superhero chris = new Superhero(name, realName, superPower, yearCreated, isHuman, strength);
        System.out.println(chris);


        /*
        superheroList.addSuperhero("Superman", "Clark Kent", "-Fly,\n-Superhuman strengh,\n-Lasereyes", 1938, true, 99999);
        System.out.println(superheroList);

         */


    }
}
