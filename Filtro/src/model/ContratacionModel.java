package model;

import database.ConfigDB;
import entities.Contratacion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContratacionModel implements CRUD{
    @Override
    public Object insert(Object obj){
    //Nos conectamos a la BD
    Connection objConnection = ConfigDB.openConnection();
    Contratacion objContratacion = (Contratacion) obj;
        try {
        String sql = "INSERT INTO contratacion (id,fecha_aplicacion,estado,salario,id_vacante, id_coder) VALUES (?,?,?,?,?,?);";
        PreparedStatement objPrepare = objConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        objPrepare.setInt(1, objContratacion.getId());
        objPrepare.setDate(2,objContratacion.getFecha_aplicacion());
        objPrepare.setString(3,objContratacion.getEstado());
        objPrepare.setDouble(4,objContratacion.getSalario());
        objPrepare.setInt(5,objContratacion.getId_vacante());
        objPrepare.setInt(6,objContratacion.getId_coder());

        objPrepare.execute();

        ResultSet objResult = objPrepare.getGeneratedKeys();
        while (objResult.next()){
            objContratacion.setId(objResult.getInt(1));
        }
        JOptionPane.showMessageDialog(null,"La contratacion fue agregado correctamente");
    }catch (Exception error){
        JOptionPane.showMessageDialog(null, error.getMessage());
    }
        ConfigDB.closeConnection();
        return objContratacion;
}

    @Override
    public List<Object> findAll() {
        Connection objConnection = ConfigDB.openConnection();
        List<Object>listContrataciones = new ArrayList<>();
        try {
            String sql = "SELECT * FROM contratacion INNER JOIN vacante ON vacante.id = contratacion.id +\n" +
                    "                    \"INNER JOIN coder ON coder.id = contratacion.id;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){

                Contratacion objContrataciones = new Contratacion();
                objContrataciones.setId(objResult.getInt("contratacion.id"));
                objContrataciones.setFecha_aplicacion(objResult.getDate("contratacion.fecha_aplicacion"));
                objContrataciones.setEstado(objResult.getString("contratacion.estado"));
                objContrataciones.setSalario(objResult.getFloat("contratacion.salario"));
                objContrataciones.setId_vacante(objResult.getInt("id_vacante"));
                listContrataciones.add(objContrataciones);
            }
        }catch (Exception e){
            System.out.println("Error"+e.getMessage());
        }
        ConfigDB.closeConnection();
        return listContrataciones;
    }


    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }
}
