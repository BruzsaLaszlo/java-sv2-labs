package enumtype.solarsystem;

import java.util.Arrays;

public class SolarSystemMain {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(SolarSystem.values()));

        if (SolarSystem.JUPITER.getNumberOfMoons() > SolarSystem.EARTH.getNumberOfMoons())
            System.out.println("A Jupiternek több holdja van mint Földnek");

    }

}
