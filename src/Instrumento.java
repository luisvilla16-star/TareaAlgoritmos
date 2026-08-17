public class Instrumento {
    private String nombre;
    private  int clave;
    private String tipo;
    private String condicion;
    private String autor;
    private boolean validez;
    private boolean confiabiblidad;
    private String cita;

    public Instrumento(String nombre, int clave, String tipo, String condicion,
                       String autor, boolean validez, boolean confiabiblidad, String cita){
        this.nombre=nombre;
        this.clave=clave;
        this.tipo=tipo;
        this.condicion=condicion;
        this.autor=autor;
        this.validez=validez;
        this.confiabiblidad=confiabiblidad;
        this.cita=cita;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int  getClave(){
        return clave;
    }

    public void setClave(int clave){
        this.clave=clave;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo=tipo;
    }

    public String  getCondicion(){
        return condicion;
    }

    public void setCondicion(String condicion){
        this.condicion=condicion;
    }

    public String  getAutor(){
        return autor;
    }

    public void setAutor(String autor){
        this.autor=autor;
    }

    public boolean getValidez(){
        return validez;
    }

    public void setValidez(boolean validez ){
        this.validez=validez;
    }

    public boolean getConfiabilidad(){
        return confiabiblidad;
    }

    public void setConfiabilidad(boolean confiabiblidad){
        this.confiabiblidad=confiabiblidad;
    }

    public String getCita(){
        return cita;
    }

    public void setCita(String cita){
        this.cita=cita;
    }


    @Override

    public String toString(){
        return "nombre: " + nombre +" clave: " +clave +" tipo: " +tipo
                +" condicion: " +condicion +" autor: " +autor +" validez: "
                +validez +" confiabilidad: " +confiabiblidad +" cita: " +cita;
    }

    public String guardar(){
        return nombre + "," + clave + "," + tipo + "," + condicion + ","
               + autor + "," + validez + "," + confiabiblidad + "," + cita;
    }

}

