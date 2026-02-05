package buttonfactory;

// 3. Concrete Product: Mac Button
class MacButton implements Button {
    public void render() {
        System.out.println("Rendering a rounded, translucent macOS-style button.");
    }

    public void onClick() {
        System.out.println("Mac click sound: *Pop!*");
    }
}