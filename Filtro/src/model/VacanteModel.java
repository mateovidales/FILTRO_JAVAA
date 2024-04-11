package model;

import database.ConfigDB;
import entities.Coder;
import entities.Empresa;
import entities.Vacante;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VacanteModel implements CRUD{
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Vacante objVacante = (Vacante) obj;
        try {
            String sql = "INSERT INTO vacante (titulo, descripcion,duracion, estado, id_empresa, tecnologia) VALUES (?,?,?,?,?,?);";
            PreparedStatement objPrepared = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepared.setString(1,objVacante.getTitulo());
            objPrepared.setString(2,objVacante.getDescripcion());
            objPrepared.setString(3,objVacante.getDuracion());
            objPrepared.setString(4,objVacante.getEstado());
            objPrepared.setInt(5,objVacante.getId_empresa());
            objPrepared.setString(6,objVacante.getTecnologia());

            objPrepared.execute();
            ResultSet objResult = objPrepared.getGeneratedKeys();
            while (objResult.next()){
                objVacante.setId(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "la vacante se registro correctamente");
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "Error >"+error.getMessage());
        }
        ConfigDB.closeConnection();
        return objVacante;
    }
    @Override
    public List<Object> findAll() {
        Connection objConnection = ConfigDB.openConnection();
        List<Object> listVacantes = new ArrayList<>();

        try {
            String sql = "SELECT * FROM vacante INNER JOIN empresa ON empresa.id = vacante.id_empresa;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                Vacante objVacante = new Vacante();
                Empresa objEmpresa = new Empresa();
                objVacante.setId(objResult.getInt("vacante.id"));
                objVacante.setTitulo(objResult.getString("vacante.titulo"));
                objVacante.setDescripcion(objResult.getString("vacante.descripcion"));
                objVacante.setDuracion(objResult.getString("vacante.duracion"));
                objVacante.setEstado(objResult.getString("vacante.estado"));
                objVacante.setId_empresa(objResult.getInt("vacante.id_empresa"));
                objVacante.setTecnologia(objResult.getString("vacante.tecnologia"));

                objEmpresa.setId(objResult.getInt("empresa.id"));
                objEmpresa.setNombre(objResult.getString("empresa.nombre"));
                objEmpresa.setSector(objResult.getString("empresa.sector"));
                objEmpresa.setUbicacion(objResult.getString("empresa.ubicacion"));
                objEmpresa.setContacto(objResult.getString("empresa.contacto"));

                objVacante.setObjEmpresa(objEmpresa);
                listVacantes.add(objVacante);
            }
        }catch (Exception error){
            JOptionPane.showMessageDialog(null, "Error >"+error.getMessage());
        }
        ConfigDB.closeConnection();
        return listVacantes;

    }
    public List<Object> findByTitle(String titulo){
        Connection objConnection = ConfigDB.openConnection();
        List<Object> listVacantes = new ArrayList<>();

        try {
            String sql = "SELECT * FROM vacante INNER JOIN empresa ON empresa.id = vacante.id_empresa WHERE vacante.titulo like ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1,"%"+titulo+"%");
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                Vacante objVacante = new Vacante();
                Empresa objEmpresa = new Empresa();
                objVacante.setId(objResult.getInt("vacante.id"));
                objVacante.setTitulo(objResult.getString("vacante.titulo"));
                objVacante.setDescripcion(objResult.getString("vacante.descripcion"));
                objVacante.setDuracion(objResult.getString("vacante.duracion"));
                objVacante.setEstado(objResult.getString("vacante.estado"));
                objVacante.setId_empresa(objResult.getInt("vacante.id_empresa"));
                objVacante.setTecnologia(objResult.getString("vacante.tecnologia"));

                objEmpresa.setId(objResult.getInt("empresa.id"));
                objEmpresa.setNombre(objResult.getString("empresa.nombre"));
                objEmpresa.setSector(objResult.getString("empresa.sector"));
                objEmpresa.setUbicacion(objResult.getString("empresa.ubicacion"));
                objEmpresa.setContacto(objResult.getString("empresa.contacto"));

                objVacante.setObjEmpresa(objEmpresa);
                listVacantes.add(objVacante);
            }
        }catch (Exception error){
            JOptionPane.showMessageDialog(null, "Error >"+error.getMessage());
        }
        ConfigDB.closeConnection();
        return listVacantes;
    }
    public List<Object> findByTechnology(String tecnologia){
        Connection objConnection = ConfigDB.openConnection();
        List<Object> listVacantes = new ArrayList<>();

        try {
            String sql = "SELECT * FROM vacante INNER JOIN empresa ON empresa.id = vacante.id_empresa WHERE vacante.tecnologia like ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1,"%"+tecnologia+"%");
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()){
                Vacante objVacante = new Vacante();
                Empresa objEmpresa = new Empresa();
                objVacante.setId(objResult.getInt("vacante.id"));
                objVacante.setTitulo(objResult.getString("vacante.titulo"));
                objVacante.setDescripcion(objResult.getString("vacante.descripcion"));
                objVacante.setDuracion(objResult.getString("vacante.duracion"));
                objVacante.setEstado(objResult.getString("vacante.estado"));
                objVacante.setId_empresa(objResult.getInt("vacante.id_empresa"));
                objVacante.setTecnologia(objResult.getString("vacante.tecnologia"));

                objEmpresa.setId(objResult.getInt("empresa.id"));
                objEmpresa.setNombre(objResult.getString("empresa.nombre"));
                objEmpresa.setSector(objResult.getString("empresa.sector"));
                objEmpresa.setUbicacion(objResult.getString("empresa.ubicacion"));
                objEmpresa.setContacto(objResult.getString("empresa.contacto"));

                objVacante.setObjEmpresa(objEmpresa);
                listVacantes.add(objVacante);
            }
        }catch (Exception error){
            JOptionPane.showMessageDialog(null, "Error >"+error.getMessage());
        }
        ConfigDB.closeConnection();
        return listVacantes;
    }
    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Vacante objVacante = (Vacante) obj;
        boolean delete = false;
        try {
            String sql = "DELETE FROM vacante WHERE id = ?;";
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            objPrepared.setInt(1,objVacante.getId());
            int affectedRows = objPrepared.executeUpdate();
            if (affectedRows>0){
                delete = true;
                JOptionPane.showMessageDialog(null, "La vacante fue eliminada correctamente");
            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "error"+error.getMessage());
        }
        ConfigDB.closeConnection();
        return delete;
    }
    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Vacante objVacante = (Vacante) obj;
        boolean update = false;
        try {
            String sql = "UPDATE vacante SET titulo = ?, descripcion = ?, duracion = ?, estado = ?, id_empresa = ?, tecnologia = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1,objVacante.getTitulo());
            objPrepare.setString(2,objVacante.getDescripcion());
            objPrepare.setString(3,objVacante.getDuracion());
            objPrepare.setString(4,objVacante.getEstado());
            objPrepare.setInt(5,objVacante.getId_empresa());
            objPrepare.setString(6,objVacante.getTecnologia());
            objPrepare.setInt(7,objVacante.getId());


            int affectedArrows = objPrepare.executeUpdate();
            if (affectedArrows>0){
                update = true;
                JOptionPane.showMessageDialog(null, "la vacante se actualizo correctamente");
            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null,"Error >" + error.getMessage());
        }
        ConfigDB.closeConnection();
        return update;
    }
}
