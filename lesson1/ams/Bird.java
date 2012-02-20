package lesson1.ams;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 04.11.11
 * Time: 22:30
 */

public class Bird extends Animal {

    @Override
    public String moves() {
        return "fly";
    }

    @Override
    public String sound() {
        return null;
    }

    @Override
    public String output() {
        return null;
    }
}
