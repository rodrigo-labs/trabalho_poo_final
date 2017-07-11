package trabalho;


import trabalho.controller.Controller;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {
        Controller controle = new Controller();

        controle.menuPrincipal();
    }
}