package template;

import java.util.Random;

public class Resource {
    public Resource() {
        System.out.println("Resource created");
    }

    public static void main(String[] args) {
        Resource resource = new Resource();
        resource.useResource();
        resource.employResource();
        resource.dispose();
    }

    public void useResource() {
        riskyOperation();
        System.out.println("Resource used");
    }

    public void employResource() {
        riskyOperation();
        System.out.println("Resource employed");
    }

    public void dispose() {
        System.out.println("Resource disposed");
    }

    private void riskyOperation() {
        if (new Random().nextInt(10) == 0) {
            throw new RuntimeException();
        }
    }
}
