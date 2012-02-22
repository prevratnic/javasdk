package lesson1.ams;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 04.11.11
 * Time: 22:30
 */

public class Bird extends Animal {

    public Bird(){
        super("My name Bird");
    }

    @Override
    public String moves() {
        return "fly";
    }

    @Override
    public String sound() {
        return "Chirp";
    }

}
