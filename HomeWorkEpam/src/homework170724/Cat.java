package homework170724;

public class Cat implements Pet {

    //TODO: with inners

    private Brain brain = new Hungry();

    private class Hungry implements Brain {

        @Override
        public void feed() {
            mew();
            eat();
            purr();

            brain = new Fed();
        }

        @Override
        public void play() {
            mew();
            stratch();
            mew();
        }

        @Override
        public void wash() {
            mew();
            stratch();
            mew();
            stratch();
        }
    }

    private class Fed implements Brain {

        @Override
        public void feed() {
            mew();
            mew();
        }

        @Override
        public void play() {
            mew();
            stratch();
            purr();

            brain = new Hungry();
        }

        @Override
        public void wash() {
            mew();
            stratch();
            mew();
            stratch();
        }
    }


    @Override
    public void feed() {
        brain.feed();
    }

    @Override
    public void play() {
        brain.play();
    }

    @Override
    public void wash() {
        brain.wash();
    }

    private void stratch() {
        System.out.println("stratches");
    }

    private void eat() {
        System.out.println("eats");
    }

    private void purr() {
        System.out.println("mrrrrr-mrrrrr");
    }

    private void mew() {
        System.out.println("mew-mew");
    }
}
