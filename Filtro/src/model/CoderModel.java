package model;

import database.ConfigDB;
import entities.Coder;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoderModel implements CRUD{
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Coder objCoder = (Coder) obj;
        try {
            String sql = "INSERT INTO coder (nombre, apellidos,documento, cohorte, cv, clan) VALUES (?,?,?,?,?,?);";
            PreparedStatement objPrepared = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepared.setString(1,objCoder.getNombre());
            objPrepared.setString(2,objCoder.getApellidos());
            objPrepared.setString(3,objCoder.getDocumento());
            objPrepared.setInt(4,objCoder.getCohorte());
            objPrepared.setString(5,objCoder.getCv());
            objPrepared.setString(6,objCoder.getClan());
            objPrepared.execute();
            ResultSet objResult = objPrepared.getGeneratedKeys();
            while (objResult.next()){
                objCoder.setId(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "El coder se registro correctamente");
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "Error >"+error.getMessage());
        }
        ConfigDB.closeConnection();
        return objCoder;
    }
    @Override
    public List<Object> findAll() {
        Connection objConnection = ConfigDB.openConnection();
        List<Object> listCoders = new ArrayList<>();

        try {
            String sql = "SELECT * FROM coder;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                Coder objCoder = new Coder();
                objCoder.setId(objResult.getInt("id"));
                objCoder.setNombre(objResult.getString("nombre"));
                objCoder.setApellidos(objResult.getString("apellidos"));
                objCoder.setDocumento(objResult.getString("documento"));
                objCoder.setCohorte(objResult.getInt("cohorte"));
                objCoder.setCv(objResult.getString("cv"));
                objCoder.setClan(objResult.getString("clan"));
                listCoders.add(objCoder);
            }
        }catch (Exception error){
            JOptionPane.showMessageDialog(null, "Error >"+error.getMessage());
        }
        ConfigDB.closeConnection();
        return listCoders;
    }
    public List<Object> findByTechnology(String cv){
        Connection objConnection = ConfigDB.openConnection();
        List<Object> listCoders = new ArrayList<>();

        try {
            String sql = "SELECT * FROM coder WHERE cv like ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1,"%"+cv+"%");
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                Coder objCoder = new Coder();
                objCoder.setId(objResult.getInt("id"));
                objCoder.setNombre(objResult.getString("nombre"));
                objCoder.setApellidos(objResult.getString("apellidos"));
                objCoder.setDocumento(objResult.getString("documento"));
                objCoder.setCohorte(objResult.getInt("cohorte"));
                objCoder.setCv(objResult.getString("cv"));
                objCoder.setClan(objResult.getString("clan"));
                listCoders.add(objCoder);
            }
        }catch (Exception error){
            JOptionPane.showMessageDialog(null, "Error >"+error.getMessage());
        }
        ConfigDB.closeConnection();
        return listCoders;
    }
    public List<Object> findByClan(String clan){
        Connection objConnection = ConfigDB.openConnection();
        List<Object> listCoders = new ArrayList<>();

        try {
            String sql = "SELECT * FROM coder WHERE clan like ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1,"%"+clan+"%");
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                Coder objCoder = new Coder();
                objCoder.setId(objResult.getInt("id"));
                objCoder.setNombre(objResult.getString("nombre"));
                objCoder.setApellidos(objResult.getString("apellidos"));
                objCoder.setDocumento(objResult.getString("documento"));
                objCoder.setCohorte(objResult.getInt("cohorte"));
                objCoder.setCv(objResult.getString("cv"));
                objCoder.setClan(objResult.getString("clan"));
                listCoders.add(objCoder);
            }
        }catch (Exception error){
            JOptionPane.showMessageDialog(null, "Error >"+error.getMessage());
        }
        ConfigDB.closeConnection();
        return listCoders;
    }
    public List<Object> findByCohorte(String cohorte){
        Connection objConnection = ConfigDB.openConnection();
        List<Object> listCoders = new ArrayList<>();

        try {
            String sql = "SELECT * FROM coder WHERE cohorte like ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1,"%"+cohorte+"%");
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                Coder objCoder = new Coder();
                objCoder.setId(objResult.getInt("id"));
                objCoder.setNombre(objResult.getString("nombre"));
                objCoder.setApellidos(objResult.getString("apellidos"));
                objCoder.setDocumento(objResult.getString("documento"));
                objCoder.setCohorte(objResult.getInt("cohorte"));
                objCoder.setCv(objResult.getString("cv"));
                objCoder.setClan(objResult.getString("clan"));
                listCoders.add(objCoder);
            }
        }catch (Exception error){
            JOptionPane.showMessageDialog(null, "Error >"+error.getMessage());
        }
        ConfigDB.closeConnection();
        return listCoders;
    }
    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Coder objCoder = (Coder) obj;
        boolean delete = false;
        try {
            String sql = "DELETE FROM coder WHERE id = ?;";
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            objPrepared.setInt(1,objCoder.getId());
            int affectedRows = objPrepared.executeUpdate();
            if (affectedRows > 0){
                delete = true;
                JOptionPane.showMessageDialog(null, "El coder se elimino correctamente");
            }
        }catch (Exception error){
            JOptionPane.showMessageDialog(null, "Error >" + error.getMessage());
        }
        ConfigDB.closeConnection();
        return delete;
    }
    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Coder objCoder = (Coder) obj;
        boolean update = false;
        try {
            String sql = "UPDATE coder SET nombre = ?, apellidos = ?, documento = ?, cohorte = ?, cv = ?, clan = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1,objCoder.getNombre());
            objPrepare.setString(2,objCoder.getApellidos());
            objPrepare.setString(3,objCoder.getDocumento());
            objPrepare.setInt(4,objCoder.getCohorte());
            objPrepare.setString(5,objCoder.getCv());
            objPrepare.setString(6,objCoder.getClan());
            objPrepare.setInt(7,objCoder.getId());
            int affectedArrows = objPrepare.executeUpdate();
            if (affectedArrows>0){
                update = true;
                JOptionPane.showMessageDialog(null, "El coder se actualizo correctamente");
            }
        }catch (Exception error){
            JOptionPane.showMessageDialog(null,"Error >" + error.getMessage());
        }
        ConfigDB.closeConnection();
        return update;
    }
}
