import lombok.Data;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}


record DataRecord (int x, int y, int z) {}

@Data
class Data2 {
    int x;
    int y;
    int z;
}