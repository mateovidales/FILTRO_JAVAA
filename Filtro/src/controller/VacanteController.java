package controller;

import entities.Coder;
import entities.Empresa;
import entities.Vacante;
import model.VacanteModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class VacanteController {

    public static void insert(){
        String titulo = JOptionPane.showInputDialog("Ingrese el titulo de la vacante");
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion de la vacante");
        String duracion = JOptionPane.showInputDialog("Ingrese la duracion de la vacante");
        String estado = JOptionPane.showInputDialog("Ingrese el estado de la vacante: (ACTIVO O INACTIVO)" );
        String tecnologia = JOptionPane.showInputDialog("Ingrese la tecnologia requerida: ");

        Object[] opcionesEmpresa = Utils.listToArray(EmpresaController.instanceModel().findAll());
        System.out.println(opcionesEmpresa[0]);
        Empresa objEmpresa = (Empresa) JOptionPane.showInputDialog(
                null,
                "Seleccione una empresa",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesEmpresa,
                opcionesEmpresa[0]
        );
        instanceModel().insert(new Vacante(titulo,descripcion,duracion,estado, objEmpresa.getId(), objEmpresa, tecnologia));
    }

    public static void getAll(){
        String list = getAll(instanceModel().findAll());
        JOptionPane.showMessageDialog(null,list);
    }
    public static String getAll(List<Object> list){
        String listString = "Lista de registros: \n";
        for (Object i:list){
            Vacante objVacante = (Vacante) i;
            listString += objVacante.toString() + "\n";
        }
        return listString;
    }
    public static void getByTitle(){
        String listVacante = "Lista Vacantes \n";
        String titulo = JOptionPane.showInputDialog("Ingrese el titulo de la vacante que desea buscar: ");
        for (Object i: instanceModel().findByTitle(titulo)){
            Vacante objVacante = (Vacante) i;
            listVacante += objVacante.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null,listVacante);
    }
    public static void getByTechnology(){
        String listVacante = "Lista Vacantes \n";
        String tecnologia = JOptionPane.showInputDialog("Ingrese el nombre de la tecnologia por la que desea buscar: ");
        for (Object i: instanceModel().findByTechnology(tecnologia)){
            Vacante objVacante = (Vacante) i;
            listVacante += objVacante.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null,listVacante);
    }
    public static void delete(){
        Object[]opcion = Utils.listToArray(instanceModel().findAll());

        Vacante objSelected = (Vacante) JOptionPane.showInputDialog(
                null,
                "Seleccione la reserva para eliminar ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcion,
                opcion[0]);
        instanceModel().delete(objSelected);
    }

    public static void update(){
        Object[] opciones = Utils.listToArray(instanceModel().findAll());
        Vacante objSelected = (Vacante) JOptionPane.showInputDialog(
                null,
                "Selecciona la vacante a actualizar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
        String titulo = JOptionPane.showInputDialog(null,"Ingrese el nuevo titulo de la vacante: ",objSelected.getTitulo());
        String descripcion = JOptionPane.showInputDialog(null,"Ingrese la nueva descripcion: ",objSelected.getDescripcion());
        String duracion = JOptionPane.showInputDialog(null,"Ingrese la nueva duracion de la vacante: ",objSelected.getDuracion());
        String estado = JOptionPane.showInputDialog(null,"Ingrese el nuevo estado:(ACTIVO O INACTIVO) ",objSelected.getEstado());
        String tecnologia = JOptionPane.showInputDialog(null,"Ingrese la nueva tecnologia: ",objSelected.getTecnologia());

        Object[] opcionesEmpresa = Utils.listToArray(EmpresaController.instanceModel().findAll());

        Empresa objEmpresa = (Empresa) JOptionPane.showInputDialog(
                null,
                "Seleccione una empresa",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesEmpresa,
                opcionesEmpresa[0]
        );
        instanceModel().update(new Vacante(titulo,descripcion,duracion,estado, objSelected.getId(), objEmpresa, tecnologia));
    }
    public static VacanteModel instanceModel(){
        return new VacanteModel();
    }

}
