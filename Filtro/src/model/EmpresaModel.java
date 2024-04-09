package model;

import database.ConfigDB;
import entities.Coder;
import entities.Empresa;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpresaModel {
    public List<Object> findAll() {
        Connection objConnection = ConfigDB.openConnection();
        List<Object> listEmpresas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM empresa;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                Empresa objEmpresa = new Empresa();
                objEmpresa.setId(objResult.getInt("id"));
                objEmpresa.setNombre(objResult.getString("nombre"));
                objEmpresa.setSector(objResult.getString("sector"));
                objEmpresa.setUbicacion(objResult.getString("ubicacion"));
                objEmpresa.setContacto(objResult.getString("contacto"));
                listEmpresas.add(objEmpresa);
            }
        }catch (Exception error){
            JOptionPane.showMessageDialog(null, "Error >"+error.getMessage());
        }
        ConfigDB.closeConnection();
        return listEmpresas;
    }
}
