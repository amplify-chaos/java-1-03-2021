package Unit8;

import Unit8.view.IUserInterface;
import Unit8.view.UserInterface;

public class App {
    public static void main(String[] args) {

        IUserInterface ui = new UserInterface();

        ui.showMenu();


    }
}
