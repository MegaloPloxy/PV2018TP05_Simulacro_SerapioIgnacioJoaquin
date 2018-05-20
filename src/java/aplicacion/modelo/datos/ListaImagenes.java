/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.datos;

import aplicacion.modelo.Imagen;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Serapio PC
 */
public class ListaImagenes implements Serializable{
    private ArrayList<Imagen> listaImagenes;
    private byte imagen;
    private int numImg;

    public ListaImagenes() {
        listaImagenes = new ArrayList();
    }
    
    public void llenarListado (byte[] imgGuardar){
        if(getListaImagenes().isEmpty()){
            setNumImg(0);
        }
        else{
            setNumImg(getListaImagenes().size());
        }
        getListaImagenes().add(new Imagen(getNumImg(), imgGuardar));
    }

    /**
     * @return the listaImagenes
     */
    public ArrayList<Imagen> getListaImagenes() {
        return listaImagenes;
    }

    /**
     * @param listaImagenes the listaImagenes to set
     */
    public void setListaImagenes(ArrayList<Imagen> listaImagenes) {
        this.listaImagenes = listaImagenes;
    }

    /**
     * @return the imagen
     */
    public byte getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(byte imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the numImg
     */
    public int getNumImg() {
        return numImg;
    }

    /**
     * @param numImg the numImg to set
     */
    public void setNumImg(int numImg) {
        this.numImg = numImg;
    }
    
    
    
}
