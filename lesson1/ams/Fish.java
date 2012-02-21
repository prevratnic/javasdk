package lesson1.ams;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 04.11.11
 * Time: 22:30
 */

public class Fish extends Animal {

    @Override
    public String moves() {
        return "swim";
    }

    @Override
    public String sound() {
        return "nothing";
    }

    @Override
    public String output() {
        return "class Fish";
    }
}
