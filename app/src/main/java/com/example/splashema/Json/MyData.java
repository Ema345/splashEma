package com.example.splashema.Json;

import java.io.Serializable;

public class MyData implements Serializable {
    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    private String contra;
    private int image;

    public int getIdContra() {
        return idContra;
    }

    public void setIdContra(int idContra) {
        this.idContra = idContra;
    }

    private int idContra;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    private String red;
}
