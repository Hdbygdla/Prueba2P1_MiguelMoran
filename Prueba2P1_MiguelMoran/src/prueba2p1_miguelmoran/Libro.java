/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba2p1_miguelmoran;
/**
 *
 * @author flash
 */
public class Libro {
    private String Nombre;
    private String Autor;
    private String ID;
    private boolean Estado;
    private String owner;

    public Libro(String Nombre, String Autor, String ID, boolean Estado, String owner) {
        this.Nombre = Nombre;
        this.Autor = Autor;
        this.ID = ID;
        this.Estado = Estado;
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getAutor() {
        return Autor;
    }

    public String getID() {
        return ID;
    }

    public boolean isEstado() {
        return Estado;
    }
    
    public void Prestar(String owner){
        this.owner = owner;
        Estado = false;
    }
    
    public void Regresar(){
        this.owner = " ";
        Estado = true;
    }
}
