package buttonfactory;

// 4. The Factory
class ButtonFactory {
    public static Button createButton(String osType) {
        if (osType.equalsIgnoreCase("Windows")) {
            return new WindowsButton();
        } else if (osType.equalsIgnoreCase("Mac")) {
            return new MacButton();
        }
        throw new IllegalArgumentException("Unknown Operating System: " + osType);
    }
}