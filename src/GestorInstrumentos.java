import java.util.List;

public class GestorInstrumentos {
    private List<Instrumento> inventario;

    public boolean agregarInstrumento(Instrumento ins){
        if (!this.inventario.contains(ins)){
            return this.inventario.add(ins);
        }
        return false;
    }


    public boolean eliminarPorClave(int clave){
        return inventario.removeIf(instrumento -> instrumento.getClave() == clave);
    }

    public List buscarPorAutor(String autor){
        return inventario.stream()
                .filter(instrumento -> instrumento.getAutor().equalsIgnoreCase(autor))
                .toList();
    }

    public List buscarPorTipo(String tipo){
        return inventario.stream()
                .filter(instrumento -> instrumento.getTipo().equalsIgnoreCase(tipo))
                .toList();
    }


    public List getInventario(){
        return inventario;
    }


}
