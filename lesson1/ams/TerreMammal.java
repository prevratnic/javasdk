package lesson1.ams;

/**
 * Author: Ilya Varlamov aka privr@tnik
 * Date: 04.11.11
 * Time: 22:31
 */

public class TerreMammal extends Mammal {

    @Override
    public String moves() {
        return "run";
    }

    @Override
    public String sound() {
        return "Terre sound";
    }

}
