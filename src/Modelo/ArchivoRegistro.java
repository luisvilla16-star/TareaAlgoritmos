package Modelo;

import java.util.*;
import java.io.*;
public class ArchivoRegistro {

    //El atributo de la clase define la ruta del archivo
    public String rutaArchivo="ArchivoInstrumentos.txt";

    //funcion que recibe una Lista con los intrumentos regisrados
    public void guardarDatos(List<Instrumento> inventario){

        //bloque try-catch para abrir el archivo, asegurandose que si no se cumple se lance la excepcion
        try(FileWriter fw= new FileWriter(rutaArchivo)){

            //este ciclo for each recorre cada elemento de la Lista, despues se utiliza el metodo
            //guardar establecido para que cada dato sea separado por comas
            for(Instrumento i : inventario){
                fw.write(i.guardar()+"\n");
            }
            fw.close();//cierre del archivo
            System.out.println("Guardado con exito");
        }catch(IOException e){
            System.out.println("Error al guardar en el archivo");
        }
    }

    public void cargarDatos(List<Instrumento> inventario){
        //bloque try-catch para abrir el archivo y leerlo
        try(BufferedReader bf=new BufferedReader(new FileReader(rutaArchivo))){
            String linea;

            //ciclo con condicion que establece que se repetira mientras el BufferedReader no llegue al final
            //del archivo y sea igual a null
            while((linea=bf.readLine())!=null){
                String datosArchivo[]= linea.split(",");//la funcion split nos permitira separar los datos por la coma

                //se crea un nuevo objeto Modelo.Instrumento, en su constructos se mandan los datos recuperados
                //en el orden definido
                Instrumento instrumento=new Instrumento(
                        datosArchivo[0],
                        Integer.parseInt(datosArchivo[1]),
                        datosArchivo[2],
                        datosArchivo[3],
                        datosArchivo[4],
                        Boolean.parseBoolean(datosArchivo[5]),
                        Boolean.parseBoolean(datosArchivo[6]),
                        datosArchivo[7]);
                inventario.add(instrumento);//se añaden a la Lista
            }

            System.out.println("Datos recuperados");
            bf.close();
        }catch(IOException e){
            System.out.println("Error al cargar el archivo");

        }
    }
}
