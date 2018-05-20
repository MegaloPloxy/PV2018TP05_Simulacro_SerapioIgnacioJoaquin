/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador;

import aplicacion.modelo.datos.ListaImagenes;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Serapio PC
 */
@ManagedBean
@SessionScoped
public class ImagenFormBean implements Serializable{
    private transient UploadedFile file = null;
    private byte[] imagen;
    private byte[] imgAux;
    private ListaImagenes listaImagenes;
    

    /**
     * Creates a new instance of ImagenFormBean
     */
    public ImagenFormBean() {
        listaImagenes = new ListaImagenes();
    }
    
    public void agregarImagen() {
        setImagen(file.getContents());
        getListaImagenes().llenarListado(imagen);
        FacesMessage message = new FacesMessage("Succesful", file.getFileName() + "is Uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public StreamedContent getImagenSubida() throws IOException{
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE){
            return new DefaultStreamedContent();
        }
        else{
            if(getImagen()==null){
                return null;
            }
            else{
                return new DefaultStreamedContent(new ByteArrayInputStream(getImagen()), "img.png");
            }
        }
    }

    /**
     * @return the file
     */
    public UploadedFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(UploadedFile file) {
        this.file = file;
    }

    /**
     * @return the imagen
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the imgAux
     */
    public byte[] getImgAux() {
        return imgAux;
    }

    /**
     * @param imgAux the imgAux to set
     */
    public void setImgAux(byte[] imgAux) {
        this.imgAux = imgAux;
    }

    /**
     * @return the listaImagenes
     */
    public ListaImagenes getListaImagenes() {
        return listaImagenes;
    }

    /**
     * @param listaImagenes the listaImagenes to set
     */
    public void setListaImagenes(ListaImagenes listaImagenes) {
        this.listaImagenes = listaImagenes;
    }
    
}
