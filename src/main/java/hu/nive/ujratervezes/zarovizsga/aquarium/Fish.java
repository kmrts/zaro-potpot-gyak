package hu.nive.ujratervezes.zarovizsga.aquarium;

public abstract class Fish {
    /*Emellett minden hal számára elérhetőek az alábbi metódusok:
    status(): adja vissza a hal adatait egy Stringben, pl Dory, weight: 9, color: blue, short-term memory loss: true
    feed(): megnöveli a hal súlyát, a pontos implementáció a hal fajtájától függ.

Clownfish
A bohóchal 1 grammot hízik etetéskor.
Tang
A tang 1 grammot hízik etetéskor, és rövidtávú-memória zavarban szenvedhet.
Kong
A kong 2 grammot hízik etetéskor.

40p ...

     */
    protected String name;
    protected int weight;
    protected String color;
    protected boolean memoryLoss;

    public Fish(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.memoryLoss= false;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public boolean hasMemoryLoss() {
        return memoryLoss;
    }

    public String status(){
        return String.format("%s, weight: %d, color: %s, short term memory loss: %s", name, weight, color, memoryLoss);
    }

    abstract void feed();

}
