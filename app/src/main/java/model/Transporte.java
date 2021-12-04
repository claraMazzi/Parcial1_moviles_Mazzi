package model;

public class Transporte {
    private Integer id;
    private String tipo;
    private String modelo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "tipo='" + tipo + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }

    public Transporte(Integer id, String modelo, String tipo) {
        this.id = id;
        this.tipo = tipo;
        this.modelo = modelo;
    }
}
