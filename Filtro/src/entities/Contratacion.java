package entities;

import java.sql.Date;

public class Contratacion {
    private int id;
    private Date fecha_aplicacion;
    private String estado;
    private float salario;

    private int id_vacante;
    private int id_coder;
    private Vacante objVacante;
    private Coder objCoder;

    public Contratacion() {
    }

    public Contratacion(Date fecha_aplicacion, String estado, float salario, int id_vacante, int id_coder, Vacante objVacante, Coder objCoder) {
        this.fecha_aplicacion = fecha_aplicacion;
        this.estado = estado;
        this.salario = salario;
        this.id_vacante = id_vacante;
        this.id_coder = id_coder;
        this.objVacante = objVacante;
        this.objCoder = objCoder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_aplicacion() {
        return fecha_aplicacion;
    }

    public void setFecha_aplicacion(Date fecha_aplicacion) {
        this.fecha_aplicacion = fecha_aplicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getId_vacante() {
        return id_vacante;
    }

    public void setId_vacante(int id_vacante) {
        this.id_vacante = id_vacante;
    }

    public int getId_coder() {
        return id_coder;
    }

    public void setId_coder(int id_coder) {
        this.id_coder = id_coder;
    }

    public Vacante getObjVacante() {
        return objVacante;
    }

    public void setObjVacante(Vacante objVacante) {
        this.objVacante = objVacante;
    }

    public Coder getObjCoder() {
        return objCoder;
    }

    public void setObjCoder(Coder objCoder) {
        this.objCoder = objCoder;
    }

    @Override
    public String toString() {
        return "Contratacion{" +
                "fecha_aplicacion=" + fecha_aplicacion +
                ", estado='" + estado + '\'' +
                ", salario=" + salario +
                ", objVacante=" + objVacante +
                ", objCoder=" + objCoder +
                '}';
    }
}
