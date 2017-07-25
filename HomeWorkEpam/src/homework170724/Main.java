package homework170724;

public class Main {

    //TODO:Create Rat & Cat (with Helpers and with Inners)

    public static void main(String[] args) {

        //cat test
        ////////////
        Pet pet = new Cat();

        pet.play();
        System.out.println("----");
        pet.feed();
        System.out.println("----");
        pet.feed();
        System.out.println("----");
        pet.play();
        System.out.println("----");
        pet.play();

        //ret test
        ////////////

        pet = new Rat();
    }
}
