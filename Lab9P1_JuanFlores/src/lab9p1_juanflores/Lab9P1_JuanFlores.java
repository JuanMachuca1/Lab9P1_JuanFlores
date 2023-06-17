/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab9p1_juanflores;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Lab9P1_JuanFlores {

    static Scanner leer = new Scanner (System.in);
    static Scanner leer2 = new Scanner (System.in);
    
    public static void main(String[] args) {
        
        
        boolean menu=true;
        
        ArrayList<Libros> libreria = new ArrayList<>();
        
        while(menu){
            System.out.println("1. Libros y mas libros REMASTERED");
            System.out.println("2. Salir");
            System.out.println("Ingresar una opción: ");
            int opcion = leer.nextInt();
            int cont=0;
            
            switch(opcion){
                case 1:
                    boolean menuSub = true;
                    while(menuSub){
                    System.out.println("""
                                       1. Crear un nuevo libro
                                       2. Listar libros disponibles
                                       3. Modificar alguna caracteristica del libro
                                       4. Eliminar Libros
                                       5. Buscar un libro por titulo
                                       6. Buscar libros segun el autor
                                       7. Filtrar libros segun un genero especifico
                                       8. Salir 
                                       Ingrese una opcion:
                                       """);
                    int opcionSub = leer.nextInt();
                    
                    switch(opcionSub){
                        case 1:
                            //metodo para agregar cada libro
                            Agregar_Libro(libreria);
                            cont++;
                            
                            break;
                            
                        case 2:
                            if (cont>0){
                            Imprimir(libreria);
                            }else{
                                System.out.println("No tienes ningun libro, debes ingresar uno");
                            }
                            break;
                            
                        case 3:
                            if(cont>0){
                            System.out.println("Ha ingresado la opción de modificar libros, elija el libro que modificara: ");
                            System.out.println("");
                            Imprimir(libreria);
                            
                            ModificarLibro(libreria);
                            }else{
                                System.out.println("No tienes libro para modificar, agrega uno");
                            }
                            break;
                            
                        case 4:
                            if(cont>0){
                                
                               Eliminar(libreria);
                               
                            }else{
                                System.out.println("no tienes libros para eliminar, ingresa uno");
                            }
                            
                            break;
                            
                        case 5:
                            if(cont>0){
                                BuscarTitulo(libreria);
                            }else{
                                System.out.println("no tienes libro para buscar, ingresa uno");
                            }
                            
                            break;
                            
                        case 6:
                            if(cont>0){
                                BuscarAutor(libreria);
                            }else{
                                System.out.println("no tienes libro para buscar, ingresa uno");
                            }
                            
                            break;
                            
                            
                        case 7:
                            if(cont>0){
                                BuscarGenero(libreria);
                            }else{
                                System.out.println("no tienes libro para buscar, ingresa uno");
                            }
                            
                            break;
                            
                        case 8:
                            
                            menuSub=false;
                            
                            break;
                            
                        default:
                            System.out.println("Opcion invalida");
                            break;
                              
                    }
                }
                             
                    break;
                case 2:
                    menu=false;
                    System.out.println("Adios");
                    break;
                    
                default:    
                    System.out.println("opcion invalida ");
                     break;
                
            }
            
        }
    }
    //metodo para agregar
    public static ArrayList<Libros> Agregar_Libro(ArrayList<Libros> libros){
        
        Libros NuevoLibro = new Libros();
        
        System.out.println("Ingrese el titulo del libro: ");
        NuevoLibro.setTitulo(leer2.nextLine());
        System.out.println("Ingrese el autor del libro: ");
        NuevoLibro.setAutor(leer2.nextLine());
        System.out.println("Ingrese el genero del autor: ");
        NuevoLibro.setGenero(leer2.nextLine());
        System.out.println("Ingrese la edad: ");
        int edad = leer.nextInt();
        
        while(edad<1){
            System.out.println("Ingrese la edad: ");
            edad = leer.nextInt();
        }
        NuevoLibro.setEdad(edad);
        
        libros.add(NuevoLibro);
        
        System.out.println("El libro se agrego correctamente..");
        System.out.println("");
        
        return libros;
        
    } 
    //metodo para listar
    public static void Imprimir(ArrayList<Libros> libro){
       
        System.out.println("Libros disponibles: ");
        System.out.println("");
        
        for (int i = 0; i < libro.size(); i++) {
            System.out.println("Libro "+(i+1));
            System.out.println("Título: "+libro.get(i).getTitulo());
            System.out.println("Autor: "+libro.get(i).getAutor());
            System.out.println("Genero: "+libro.get(i).getGenero());
            
           System.out.println("Edad Minima: "+libro.get(i).getEdad());
            
           System.out.println("");
        }

    }
    
    //metodo para modificar una parte del libro
    public static ArrayList <Libros> ModificarLibro(ArrayList<Libros> libros){
        
        ArrayList<Libros> librosMod = libros;
        
        boolean librofound = false;
        //
        System.out.println("Seleccione un libro para modificar");
        int libroop=leer.nextInt();
        
        if(libroop<=libros.size()){
         System.out.println("Libro seleccionado: "+libroop);
        
               
        
        System.out.println("Has saleccionado el libro "+libros.get(libroop-1).getTitulo()+" ¿Que atributo desea modificar?");
        
        
        System.out.println("""
                           1.Titulo
                           2.Autor
                           3.Genero
                           4.Edad Minima
                           """);
        int opcionCambio= leer.nextInt();
        
        System.out.println("opcion ingresada: "+ opcionCambio);
        
         switch(opcionCambio){
             case 1:
                 //titulo
                 System.out.print("Modificara el titulo del libro, ingrese un nuevo titulo: ");
                 String tituloNew = leer2.nextLine();
                 libros.get(libroop-1).setTitulo(tituloNew);
                 libros.get(libroop-1).getTitulo();
                 
                 System.out.println("libro modificado exitosamente...");
                 break;
                 
             case 2:
                 //autor
                 System.out.print("Modificara el autor del libro, ingrese un nuevo autor: ");
                 String autorNew = leer2.nextLine();
                 libros.get(libroop-1).setAutor(autorNew);
                 libros.get(libroop-1).getAutor();
                 
                 System.out.println("libro modificado exitosamente...");
                break;
                
             case 3:
                 //genero
                 System.out.print("Modificara el genero del libro, ingrese un nuevo genero: ");
                 String generoNew = leer2.nextLine();
                 libros.get(libroop-1).setGenero(generoNew);
                 libros.get(libroop-1).getGenero();
                 
                 System.out.println("libro modificado exitosamente...");
                break;
                
             case 4:
                 //Edad minima
                 System.out.print("Modificara la edad minina, ingrese una nueva edad: ");
                 int  edadNew = leer.nextInt();
                 libros.get(libroop-1).setEdad(edadNew);
                 libros.get(libroop-1).getEdad();
                 
                 System.out.println("libro modificado exitosamente...");
                 break;
             
             default:
                 System.out.println("opcion invalida ");
                 break;
        }    
       }else{
            System.out.println("libro no encontrado");
        }
         return libros;
    }
    
    //metodo para eliminar libros
    public static ArrayList<Libros> Eliminar(ArrayList<Libros> libro){
        
        System.out.println(" Que libro desea eliminar: ");
        int opcionLibro = leer.nextInt();
        
//        while(opcionLibro>libro.size()){     AQUI HABIA HECHO UNA VALIDACION DE QUE INGRESE UNA POSICION QUE ESTUVIERA 
//                                             SI O SI EN EL LIBRO (OSEA QUE OBLIGUE A ELIMINAR UN LIBRO PERO TERMINE HACIENDO UNA NORMAL 
//                                                  DE LIBRO NO ENCONTRADO :) ERES MUY BUEN INSTRUCTOR <3
//            System.out.println("No hay libros en esa posicion, ingresa otra posicion: ");
//            opcionLibro = leer.nextInt();
//        }
        if(opcionLibro<=libro.size()){
        //boolean eliminar = false;
        
        for (int i = 0; i < libro.size(); i++) {
            
            if(libro.get(opcionLibro-1) == libro.get(i)){
                //eliminar = true;
                libro.remove(i);
            }
           
        }
        
            System.out.println("El libro ha sido eliminado con exito");
        }else{
            System.out.println("Libro no encontrado");
        }
        
        
        
        return libro;
    }
    
    //metodo buscar por libro
    
    public static void BuscarTitulo(ArrayList<Libros>libro){
        
        System.out.println("Ingrese el titulo a buscar: ");
        String titulo = leer2.nextLine();
        boolean Titulo = false;
        for (int i = 0; i < libro.size(); i++) {
            
            if(titulo.equalsIgnoreCase(libro.get(i).getTitulo())){
                Titulo = true;
                System.out.println("Libro "+(i+1));
                System.out.println("Titulo: "+libro.get(i).getTitulo());
                System.out.println("Autor: "+libro.get(i).getAutor());
                System.out.println("Genero: "+libro.get(i).getGenero());
                System.out.println("Edad minima: "+libro.get(i).getEdad());
            }
        }
        if(!Titulo){
            System.out.println("Libro no encontrado...");
        }
        
    }
    //metodo para buscar por autor
    public static void BuscarAutor(ArrayList<Libros>libro){
        
        System.out.println("Ingrese el Autor a buscar: ");
        String autor = leer2.nextLine();
        boolean Autor = false;
        for (int i = 0; i < libro.size(); i++) {
            
            if(autor.equalsIgnoreCase(libro.get(i).getAutor())){
                Autor = true;
                System.out.println("Libro "+(i+1));
                System.out.println("Titulo: "+libro.get(i).getTitulo());
                System.out.println("Autor: "+libro.get(i).getAutor());
                System.out.println("Genero: "+libro.get(i).getGenero());
                System.out.println("Edad minima: "+libro.get(i).getEdad());
            }
        }
        if(!Autor){
            System.out.println("Libro no encontrado...");
        }
        
    }
    //metodo para buscar por genero
        public static void BuscarGenero(ArrayList<Libros>libro){
        
        System.out.println("Ingrese el genero a buscar: ");
        String genero = leer2.nextLine();
        boolean Genero = false;
        for (int i = 0; i < libro.size(); i++) {
            
            if(genero.equalsIgnoreCase(libro.get(i).getGenero())){
                Genero = true;
                System.out.println("Libro "+(i+1));
                System.out.println("Titulo: "+libro.get(i).getTitulo());
                System.out.println("Autor: "+libro.get(i).getAutor());
                System.out.println("Genero: "+libro.get(i).getGenero());
                System.out.println("Edad minima: "+libro.get(i).getEdad());
            }
        }
        if(!Genero){
            System.out.println("Libro no encontrado");
        }
        
        
    }
}
  