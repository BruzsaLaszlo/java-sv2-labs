package compositionlist.computer;

public class PersonalComputerMain {

    public static void main(String[] args) {

        PersonalComputer pc = new PersonalComputer(new Cpu("Intel i5-4670K",3.5));

        pc.addHardware(new Hardware("SSD", "Samsung 860 EVO 512GB"));
        pc.addHardware(new Hardware("Grapics card", "Nvidia GeForce GTX 460"));
        pc.addHardware(new Hardware("Monitor", "LG UM2968P"));
        pc.addSoftware(new Software("Windows",11));
        pc.addSoftware(new Software("Jetbrains Intellij IDEA", 2021.2));
        pc.addSoftware(new Software("Vivaldi", 4.3));

        System.out.println(pc.getHardwares());
        System.out.println(pc.getSoftwares());
        System.out.println(pc.getCpu());
    }

}
