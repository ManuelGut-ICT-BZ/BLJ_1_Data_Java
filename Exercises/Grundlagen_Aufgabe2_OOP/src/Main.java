//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller();
        controller.showWelcomeScreen();
        controller.readInRegistrations();
        String command = "";

        while (true) {
            controller.showMenu();
            command = controller.readUserInput();
            switch (command) {
                case "a" -> controller.showRegistrations();
                case "n" -> controller.addNewRegistration();
                case "g" -> controller.showBookedModules();
                case "m" -> controller.showMenu();
                case "q" -> {
                    return;
                }

            }
        }

    }
}