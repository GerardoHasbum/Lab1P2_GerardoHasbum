
package lab1p2_gerardohasbum;
import java.util.Date;
public class Usuario {
    String Nombre;
    String Apellido;
    String FeNa;
    String Correo;
    String Contra;

    public Usuario(String Nombre, String Apellido, String FeNa, String Correo, String Contra) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.FeNa = FeNa;
        this.Correo = Correo;
        this.Contra = Contra;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getFeNa() {
        return FeNa;
    }

    public void setFeNa(String FeNa) {
        this.FeNa = FeNa;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContra() {
        return Contra;
    }

    public void setContra(String Contra) {
        this.Contra = Contra;
    }

    @Override
    public String toString() {
        return Nombre + " "+ Apellido+"\n"+FeNa+"\n"+Correo+"\n"+Contra;
    }
    
    
    
}
