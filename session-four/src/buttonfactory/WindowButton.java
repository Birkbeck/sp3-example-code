package buttonfactory;

// 2. Concrete Product: Windows Button
class WindowsButton implements Button {
    public void render() {
        System.out.println("Rendering a square, grey Windows-style button.");
    }

    public void onClick() {
        System.out.println("Windows click sound: *Bing!*");
    }
}