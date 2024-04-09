package controller;

import entities.Coder;
import entities.Empresa;
import model.EmpresaModel;

import javax.swing.*;
import java.util.List;

public class EmpresaController {
    public static void getAll(){
        String list = getAll(instanceModel().findAll());
        JOptionPane.showMessageDialog(null,list);
    }
    public static String getAll(List<Object> list){
        String listString = "Lista de registros: \n";
        for (Object i:list){
            Empresa objEmpresa = (Empresa) i;
            listString += objEmpresa.toString() + "\n";
        }
        return listString;
    }

    public static EmpresaModel instanceModel(){
        return new EmpresaModel();
    }

}
