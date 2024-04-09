package controller;

import entities.Coder;
import entities.Contratacion;
import entities.Empresa;
import entities.Vacante;
import model.ContratacionModel;
import utils.Utils;

import javax.swing.*;
import java.sql.Date;
import java.util.List;

public class ContratacionController {
    public static void insert() {
        Date fecha = Date.valueOf(JOptionPane.showInputDialog("Ingrese la fecha de la contratacion"));
        String estado = JOptionPane.showInputDialog("Ingrese el estado de la contratacion");
        float salario = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el salario"));

        Object[] opcionesVacante = Utils.listToArray(VacanteController.instanceModel().findAll());
        Object[] opcionesCoder = Utils.listToArray(CoderController.instanceModel().findAll());

        Vacante objVacante = (Vacante) JOptionPane.showInputDialog(
                null,
                "Seleccione una empresa",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesVacante,
                opcionesVacante[0]
        );
        Coder objCoder = (Coder) JOptionPane.showInputDialog(
                null,
                "Seleccione una empresa",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesCoder,
                opcionesCoder[0]);
        instanceModel().insert(new Contratacion(fecha, estado, salario, objVacante.getId(), objCoder.getId(),objVacante,objCoder));
    }

    public static void getAll(){
        String list = getAll(instanceModel().findAll());

        JOptionPane.showMessageDialog(null,list);
    }

    //creamos una sobreescritura para guardar toda la lista en string y despues mostrarla en un JOPTION
    public static String getAll(List<Object> list){
        String listString = "Lista de Reservas \n";
        for (Object i: list){
            Contratacion objContratacion = (Contratacion) i;
            listString+=objContratacion.toString()+"\n";
        }
        return listString;
    }


    public static ContratacionModel instanceModel(){
        return new ContratacionModel();
    }
}
