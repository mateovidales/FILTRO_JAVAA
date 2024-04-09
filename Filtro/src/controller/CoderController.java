package controller;

import entities.Coder;
import model.CoderModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class CoderController {

    public static void insert(){
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre del coder: ");
        String apellidos = JOptionPane.showInputDialog("Ingresa los apellidos del coder: ");
        String documento = JOptionPane.showInputDialog("Ingresa el documento del coder: ");
        int cohorte = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cohorte del coder: "));
        String cv = JOptionPane.showInputDialog("Ingrese el cv del coder: ");
        String clan = JOptionPane.showInputDialog("Ingresa el clan del coder: ");

        instanceModel().insert(new Coder(nombre,apellidos,documento,cohorte,cv,clan));
    }
    public static void getAll(){
        String list = getAll(instanceModel().findAll());
        JOptionPane.showMessageDialog(null,list);
    }
    public static String getAll(List<Object>list){
        String listString = "Lista de registros: \n";
        for (Object i:list){
            Coder objCoder = (Coder) i;
            listString += objCoder.toString() + "\n";
        }
        return listString;
    }
    public static void getByTechnology(){
        String listCoder = "Lista Coders \n";
        String cv = JOptionPane.showInputDialog("Ingrese el nombre de la tecnologia por la que desea buscar: ");
        for (Object i: instanceModel().findByTechnology(cv)){
            Coder objCoder = (Coder) i;
            listCoder += objCoder.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null,listCoder);
    }
    public static void getByClan(){
        String listCoder = "Lista Coders \n";
        String clan = JOptionPane.showInputDialog("Ingrese la nombre del clan por que desea buscar: ");
        for (Object i: instanceModel().findByClan(clan)){
            Coder objCoder = (Coder) i;
            listCoder += objCoder.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null,listCoder);
    }
    public static void getByCohorte(){
        String listCoder = "Lista Coders \n";
        String cohorte = JOptionPane.showInputDialog("Ingrese el numero del cohorte que desea buscar: ");
        for (Object i: instanceModel().findByCohorte(cohorte)){
            Coder objCoder = (Coder) i;
            listCoder += objCoder.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null,listCoder);
    }
    public static void delete(){
        Object[] opciones = Utils.listToArray(instanceModel().findAll());

        Coder objSelected = (Coder) JOptionPane.showInputDialog(
                null,
                "Selecciona un coder",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
        instanceModel().delete(objSelected);
    }
    public static void update(){
        Object[] opciones = Utils.listToArray(instanceModel().findAll());

        Coder objSelected = (Coder) JOptionPane.showInputDialog(
                null,
                "Selecciona un coder para editar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        objSelected.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre del coder: ",objSelected.getNombre()));
        objSelected.setApellidos(JOptionPane.showInputDialog(null, "Ingrese el nuevo apellido del coder: ",objSelected.getApellidos()));
        objSelected.setDocumento(JOptionPane.showInputDialog(null, "Ingrese el nuevo documento del coder: ",objSelected.getDocumento()));
        objSelected.setCohorte(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo cohorte del coder: ",objSelected.getCohorte())));
        objSelected.setCv(JOptionPane.showInputDialog(null, "Ingrese el nuevo cv del coder: ",objSelected.getCv()));
        objSelected.setClan(JOptionPane.showInputDialog(null, "Ingrese el nuevo clan del coder: ",objSelected.getClan()));
        instanceModel().update(objSelected);

    }
    public static CoderModel instanceModel(){
        return new CoderModel();
    }
}
