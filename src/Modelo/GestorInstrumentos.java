package Modelo;

import java.util.Comparator;
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

    public List buscarPorCondicion(String condicion){
        return inventario.stream()
                .filter(instrumento -> instrumento.getCondicion().equalsIgnoreCase(condicion))
                .toList();
    }

    public List buscarPorEvaluacionConfiabilidad(boolean confiabilidad){
        return inventario.stream()
                .filter(instrumento -> instrumento.getConfiabilidad() == confiabilidad)
                .toList();
    }
    public List buscarPorEvaluacionValidez(boolean validez){
        return inventario.stream()
                .filter(instrumento -> instrumento.getValidez() == validez)
                .toList();
    }

    public List buscarPorCondicionYEvaluacionConfiabilidad(String condicion,boolean confiabilidad){
        return inventario.stream()
                .filter(instrumento -> instrumento.getCondicion().equalsIgnoreCase(condicion)
                        && instrumento.getConfiabilidad() == confiabilidad)
                .toList();
    }

    public List buscarPorCondicionYEvaluacionValidez(String condicion,boolean validez){
        return inventario.stream()
                .filter(instrumento -> instrumento.getCondicion().equalsIgnoreCase(condicion)
                        && instrumento.getValidez() == validez)
                .toList();
    }

    public List ordenarPorClave(){
        return inventario.stream()
                .sorted(Comparator.comparing(Instrumento::getClave))
                .toList();
    }

    public void setInventario(List<Instrumento> inventario){
        this.inventario = inventario;
    }
    public List getInventario(){
        return inventario;
    }


}
