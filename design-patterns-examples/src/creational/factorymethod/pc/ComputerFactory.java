package creational.factorymethod.pc;

public class ComputerFactory {

    public static Computer getComputer(String type, String ram, String hdd, String cpu) {
        return switch (type) {
            case "PC" -> new PC(ram, hdd, cpu);
            case "Server" -> new Server(ram, hdd, cpu);
            default -> null;
        };
    }
}