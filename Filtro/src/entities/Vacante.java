package entities;

public class Vacante {
    private int id;
    private String titulo;
    private String descripcion;
    private String duracion;
    private String estado;
    private int id_empresa;
    private Empresa objEmpresa;
    private String tecnologia;

    public Vacante() {
    }

    public Vacante(String titulo, String descripcion, String duracion, String estado, int id_empresa, Empresa objEmpresa, String tecnologia) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.estado = estado;
        this.id_empresa = id_empresa;
        this.objEmpresa = objEmpresa;
        this.tecnologia = tecnologia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public Empresa getObjEmpresa() {
        return objEmpresa;
    }

    public void setObjEmpresa(Empresa objEmpresa) {
        this.objEmpresa = objEmpresa;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    @Override
    public String toString() {
        return
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", duracion='" + duracion + '\'' +
                ", estado='" + estado + '\'' +
                ", tecnologia=" + tecnologia +
                ", Empresa=" + this.objEmpresa;
    }
}
