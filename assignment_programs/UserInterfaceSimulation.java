public class UserInterfaceSimulation {
    public static void main(String[] args) {
        UIComponent[] components = new UIComponent[3];

        components[0] = new Button("Submit");
        components[1] = new TextField("Enter your name");
        components[2] = new Button("Cancel");

        displayUI(components);
    }

    private static void displayUI(UIComponent[] components) {
        System.out.println("User Interface Components:");
        for (UIComponent component : components) {
            component.display();
        }
    }
}

interface UIComponent {
    void display();
}

class Button implements UIComponent {
    private String label;

    public Button(String label) {
        this.label = label;
    }

    @Override
    public void display() {
        System.out.println("Button: " + label);
    }
}

class TextField implements UIComponent {
    private String placeholder;

    public TextField(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    public void display() {
        System.out.println("Text Field with Placeholder: " + placeholder);
    }
}