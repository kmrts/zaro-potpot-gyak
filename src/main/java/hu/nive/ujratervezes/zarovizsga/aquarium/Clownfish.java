package hu.nive.ujratervezes.zarovizsga.aquarium;

public class Clownfish extends Fish{

    public Clownfish(String name, int weight, String color) {
        super(name, weight, color);
    }

//    @Override
//    public String getName() {
//        return getName();
//    }
//
//    @Override
//    public int getWeight() {
//        return 0;
//    }
//
//    @Override
//    public String getColor() {
//        return null;
//    }
//
//    @Override
//    public boolean isMemoryLoss() {
//        return false;
//    }

    @Override
    void feed() {
        weight+= 1;

    }

}
