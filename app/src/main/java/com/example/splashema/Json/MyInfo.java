package com.example.splashema.Json;
import java.io.Serializable;
public class MyInfo implements Serializable {
    private String usuario;
    private String password;
    private String correo;
    private String edad;
    private Boolean sexo;
    private Boolean TUsuario;
    public MyInfo() {
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getCorreo() {
        return correo;
    }
    public void setedad(String edad) {
        this.edad = edad;
    }
    public String getedad() {
        return edad;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public Boolean getSexo() {
        return sexo;
    }
    public void setSexo(Boolean sexo) {
        this.sexo = sexo;
    }
    public Boolean getTUsuario() {
        return TUsuario;
    }
    public void setTUsuario(Boolean TUsuario) {
        this.TUsuario = TUsuario;
    }
}
