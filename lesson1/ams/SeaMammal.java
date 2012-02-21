package lesson1.ams;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 04.11.11
 * Time: 22:31
 */

public class SeaMammal extends Mammal {

    @Override
    public String moves() {
        return "swim";
    }

    @Override
    public String sound() {
        return "Sea sound";
    }

    @Override
    public String output() {
        return "class SeaMammal";
    }
}
