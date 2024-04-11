package model;

import database.ConfigDB;
import entities.Contratacion;
import entities.Vacante;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratacionModel implements CRUD{
    @Override
    public Object insert(Object obj){
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
          String sql = "SELECT * FROM contratacion " +
                    "INNER JOIN vacante ON vacante.id = contratacion.id_vacante " +
                    "INNER JOIN coder ON coder.id = contratacion.id_coder";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){

                Contratacion objContrataciones = new Contratacion();
                objContrataciones.setId(objResult.getInt("contratacion.id"));
                objContrataciones.setFecha_aplicacion(objResult.getDate("contratacion.fecha_aplicacion"));
                objContrataciones.setEstado(objResult.getString("contratacion.estado"));
                objContrataciones.setSalario(objResult.getFloat("contratacion.salario"));
                objContrataciones.setId_vacante(objResult.getInt("contratacion.id_vacante"));
                objContrataciones.setId_coder(objResult.getInt("contratacion.id_coder"));
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
        Connection objConnection = ConfigDB.openConnection();
        Contratacion objContratacion = (Contratacion) obj;
        boolean delete = false;
        try {
            String sql = "DELETE FROM contratacion WHERE id = ?;";
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            objPrepared.setInt(1,objContratacion.getId());
            int affectedRows = objPrepared.executeUpdate();
            if (affectedRows>0){
                delete = true;
                JOptionPane.showMessageDialog(null, "La contratacion fue eliminada correctamente");
            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "error"+error.getMessage());
        }
        ConfigDB.closeConnection();
        return delete;
    }
    }

