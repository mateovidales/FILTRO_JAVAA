import controller.CoderController;
import controller.ContratacionController;
import controller.VacanteController;
import database.ConfigDB;
import entities.Coder;
import entities.Contratacion;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int opcion = 0, opcion2=0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    1. Administrar Coder
                    2. Administrar Vacante
                    3. Administrar Contratacion
                    4. Salir
                    INGRESE UNA OPCION:
                    """));

            switch (opcion){
                case 1:
                    do {
                        opcion2 = Integer.parseInt(JOptionPane.showInputDialog("""
                    1. Listar Coders
                    2. Crear Coder
                    3. Eliminar Coder
                    4. Actualizar Coder
                    5. Buscar por Tecnologia
                    6. Buscar por Clan
                    7. Buscar por Cohorte
                    8. Salir
                    INGRESE UNA OPCION:
                    """));
                        switch (opcion2){
                            case 1:
                                CoderController.getAll();
                                break;
                            case 2:
                                CoderController.insert();
                                break;
                            case 3:
                                CoderController.delete();
                                break;
                            case 4:
                                CoderController.update();
                                break;
                            case 5:
                                CoderController.getByTechnology();
                                break;
                            case 6:
                                CoderController.getByClan();
                                break;
                            case 7:
                                CoderController.getByCohorte();
                                break;
                        }
                    }while (opcion2 != 8);
                    break;
                case 2:
                    do {
                        opcion2 = Integer.parseInt(JOptionPane.showInputDialog("""
                    1. Listar Vacante
                    2. Crear Vacante
                    3. Eliminar Vacante
                    4. Actualizar Vacante
                    5. Buscar Vacante por titulo
                    6. Buscar Vacante por Tecnologia
                    7. Salir
                    INGRESE UNA OPCION:
                    """));
                        switch (opcion2){
                            case 1:
                                VacanteController.getAll();
                                break;
                            case 2:
                                VacanteController.insert();
                                break;
                            case 3:
                                VacanteController.delete();
                                break;
                            case 4:
                                VacanteController.update();
                                break;
                            case 5:
                                VacanteController.getByTitle();
                                break;
                            case 6:
                                VacanteController.getByTechnology();
                                break;
                        }
                    }while (opcion2 != 7);
                    break;
                case 3:
                    do {
                        opcion2 = Integer.parseInt(JOptionPane.showInputDialog("""
                    1. Listar Contrataciones
                    2. Crear Contratacion
                    3. Eliminar Contratacion
                    4. Actualizar Contratacion1
                    5. Salir
                    INGRESE UNA OPCION:
                    """));
                        switch (opcion2){
                            case 1:
                                ContratacionController.getAll();
                                break;
                            case 2:
                                ContratacionController.insert();
                                break;
                            case 3:
                                ContratacionController.delete();
                                break;
                            case 4:
                                break;
                        }
                    }while (opcion2 != 5);
                    break;
            }
        }while (opcion !=4);
    }
}