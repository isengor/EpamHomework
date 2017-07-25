package homework170724;

public class Rat implements Pet {

    //TODO: with helpers
    private Brain brain = new Hungry(this);

    @Override
    public void feed() {
        brain.feed();
    }

    @Override                           //внешние раздражители
    public void play() {
        brain.play();
    }

    @Override
    public void wash() {
        brain.wash();
    }

    private void bite() {
        System.out.println("bites");
    }

    private void eat() {                    //внутренняя реакция
        System.out.println("eats");
    }

    private void squeak() {
        System.out.println("pi-pi-pi");
    }

}

class Hungry implements Brain {

    private Rat rat;

    public Hungry(Rat rat) {
        this.rat = rat;
    }


    @Override
    public void feed() {

    }

    @Override
    public void play() {


    }

    @Override
    public void wash()  {

    }
}

class Fed implements Brain {

    private Rat rat;

    public Fed(Rat rat) {
        this.rat = rat;
    }

    @Override
    public void feed() {
        // но как внешний класс должен активировать внутреннюю реакцию ????

    }

    @Override
    public void play() {

    }

    @Override
    public void wash() {

    }
}
