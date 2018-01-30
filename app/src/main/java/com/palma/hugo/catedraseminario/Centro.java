package com.palma.hugo.catedraseminario;

/**
 * Created by hugo on 24/1/2018.
 */

public class Centro {
    private String titulo;
    private int imagen;

    public Centro(String titulo, int imagen){
        this.titulo = titulo;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String tirulo) {
        this.titulo = tirulo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
