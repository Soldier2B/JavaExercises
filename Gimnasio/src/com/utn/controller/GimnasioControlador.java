package com.utn.controller;

import com.utn.model.Entrenador;

import java.util.Scanner;

import com.utn.model.Boxeador;

public class GimnasioControlador {
  
  //Atributtes ----------------------------------------
  
  public int boxeadoresAspirantes = 0;
  
  
  //Methods ----------------------------------------
  
  
  //Crea a los entrenadores del gym
  public Entrenador[] entrenadoresDelGym() {
    
    Entrenador[] entrenadoresDelGym = new Entrenador[4];
    
    entrenadoresDelGym[0] = new Entrenador();
    entrenadoresDelGym[0].asignarDatos("Johnny", "Mosca", 48.988, 50.802, "Gallo", 52.163, 53.525);
  
    entrenadoresDelGym[1] = new Entrenador();
    entrenadoresDelGym[1].asignarDatos("Matias", "Pluma", 55.338, 57.152, "Ligero", 58.967, 61.237);

    entrenadoresDelGym[2] = new Entrenador();
    entrenadoresDelGym[2].asignarDatos("Guille", "Welter", 63.503, 66.678, "Mediano", 69.853, 72.562);
  
    entrenadoresDelGym[3] = new Entrenador();
    entrenadoresDelGym[3].asignarDatos("Juan", "Mediopesado", 76.205, 79.378, "Pesado", 91.00, 200.00); 
    
    return entrenadoresDelGym;
    
  } 
  
  //Realiza el proceso de admision de aspirantes
  public void admision(Entrenador[] entrenadoresDelGym) {
    
    //Menu consola
  
    boolean exitAdmision = false;
    ++boxeadoresAspirantes;
    
    while (exitAdmision != true) {
      
    //Creo los boxeadores aspirantes
      Boxeador aspirante = new Boxeador();
    
      System.out.println("Ingrese el peso del aspirante a boxeador: ");
    
      Scanner input = new Scanner(System.in);
      aspirante.peso = input.nextDouble();
    
      boolean hayEntrenador = false;
      
    //Chequeo si hay entrenador disponible para la categoria designada al peso ingresado
      if (aspirante.peso > 30 && aspirante.peso < entrenadoresDelGym[1].minPesoCat1 && entrenadoresDelGym[0].disponible()) {
        System.out.println("Califica para la categoria: " + entrenadoresDelGym[0].categoria1 + '-' + entrenadoresDelGym[0].categoria2 + " y " + entrenadoresDelGym[0].nombre + " esta disponible para entrenarlo.");
        hayEntrenador = true;
      } else if (aspirante.peso > entrenadoresDelGym[1].minPesoCat1 && aspirante.peso < entrenadoresDelGym[2].minPesoCat1 && entrenadoresDelGym[1].disponible()) {
        System.out.println("Califica para la categoria: " + entrenadoresDelGym[1].categoria1 + '-' + entrenadoresDelGym[1].categoria2 + " y " + entrenadoresDelGym[1].nombre + " esta disponible para entrenarlo.");
        hayEntrenador = true;
      } else if (aspirante.peso > entrenadoresDelGym[2].minPesoCat1 && aspirante.peso < entrenadoresDelGym[3].minPesoCat1 && entrenadoresDelGym[2].disponible()) {
        System.out.println("Califica para la categoria: " + entrenadoresDelGym[2].categoria1 + '-' + entrenadoresDelGym[2].categoria2 + " y " + entrenadoresDelGym[2].nombre + " esta disponible para entrenarlo.");
        hayEntrenador = true;
      } else if (aspirante.peso > entrenadoresDelGym[3].minPesoCat1 && aspirante.peso < 200 && entrenadoresDelGym[3].disponible()) {
        System.out.println("Califica para la categoria: " + entrenadoresDelGym[3].categoria1 + '-' + entrenadoresDelGym[3].categoria2 + " y " + entrenadoresDelGym[3].nombre + " esta disponible para entrenarlo.");
        hayEntrenador = true;
      } else {
        System.out.println("No hay entrenador disponible para su categoria");
        exitAdmision = true;
      }
   
      System.out.println("\n----------------------------------------\n");
      
    //Si hay categoria entrenador disponible. Da la opcion de ingresar al nuevo boxeador al sistema.
      
      if(hayEntrenador == true) {
        
        System.out.println("Desea inscribir al aspirante al grupo del entrenador?");
        System.out.println("[1] Continuar con la inscripcion del aspirante.");
        System.out.println("[2] Volver al menu");
        
        int admisionCommand = input.nextInt();
        
        boolean exitInscripcion = false;
        
        while (exitInscripcion != true) {
          
        switch (admisionCommand) {
          case 1:
          //Inscripcion
         
            //Se ingresan los datos del boxeador, se le da su categoria, entrenador y dieta.
            //Se lo asigna al array de boxeadores q tiene cada entrenador
           
            
            System.out.println("Ingrese los siguientes datos");
            
            Scanner input2 = new Scanner(System.in);
            
            System.out.println("Nombre: ");
            aspirante.nombre = input2.nextLine();
            
            System.out.println("Apellido: ");
            aspirante.apellido = input2.nextLine();
            
            System.out.println("Edad: ");
            aspirante.edad = input.nextInt();
            System.out.println("Altura: ");
            aspirante.altura = input.nextDouble();
            
            System.out.println("----------------------------------------");
            
            //Asignacion al entrenador 1
            
            if (aspirante.peso < entrenadoresDelGym[0].minPesoCat1) {
              System.out.println("Se le asignara la categoria: " + entrenadoresDelGym[0].categoria1 + " y se le dara una dieta de engorde.");
              aspirante.dieta = "Engorde";
              aspirante.categoriaAsignada = entrenadoresDelGym[0].categoria1;
              entrenadoresDelGym[0].asignarBoxeador(aspirante);
              
            } else if (aspirante.peso > entrenadoresDelGym[0].minPesoCat1 && aspirante.peso < entrenadoresDelGym[0].maxPesoCat1) {
              System.out.println("Se le asignara la categoria: " + entrenadoresDelGym[0].categoria1 + '.');
              aspirante.categoriaAsignada = entrenadoresDelGym[0].categoria1;
              entrenadoresDelGym[0].asignarBoxeador(aspirante);
         
            } else if (aspirante.peso < entrenadoresDelGym[0].minPesoCat2 && aspirante.peso > entrenadoresDelGym[0].maxPesoCat1) {
              System.out.println("Se le asignara la categoria: " + entrenadoresDelGym[0].categoria1 + " y se le dara una dieta para bajar de peso.");
              aspirante.dieta = "Bajar de peso";
              aspirante.categoriaAsignada = entrenadoresDelGym[0].categoria1;
              entrenadoresDelGym[0].asignarBoxeador(aspirante);
           
            } else if (aspirante.peso > entrenadoresDelGym[0].minPesoCat2 && aspirante.peso < entrenadoresDelGym[0].maxPesoCat2) {
              System.out.println("Se le asignara la categoria: " + entrenadoresDelGym[0].categoria2);
              aspirante.categoriaAsignada = entrenadoresDelGym[0].categoria2;
              entrenadoresDelGym[0].asignarBoxeador(aspirante);
              
            } else if (aspirante.peso < entrenadoresDelGym[1].minPesoCat1 && aspirante.peso > entrenadoresDelGym[0].maxPesoCat2) {
              System.out.println("Se le asignara la categoria: " + entrenadoresDelGym[0].categoria2 + " y se le dara una dieta para bajar de peso.");
              aspirante.dieta = "Bajar de peso";
              aspirante.categoriaAsignada = entrenadoresDelGym[0].categoria2;
              entrenadoresDelGym[0].asignarBoxeador(aspirante);
              
              
           
            //Asignacion al entrenador 2
              
            } else if (aspirante.peso > entrenadoresDelGym[1].minPesoCat1 && aspirante.peso <entrenadoresDelGym[1].maxPesoCat1) {
              System.out.println("Se le asignara la categoria: " + entrenadoresDelGym[1].categoria1 + '.');
              aspirante.categoriaAsignada = entrenadoresDelGym[1].categoria1;
              entrenadoresDelGym[1].asignarBoxeador(aspirante);
           
            } else if (aspirante.peso < entrenadoresDelGym[1].minPesoCat2 && aspirante.peso > entrenadoresDelGym[1].maxPesoCat1) {
              System.out.println("Se le asignara la categoria: " + entrenadoresDelGym[1].categoria1 + " y se le dara una dieta para bajar de peso.");
              aspirante.dieta = "Bajar de peso";
              aspirante.categoriaAsignada = entrenadoresDelGym[1].categoria1;
              entrenadoresDelGym[1].asignarBoxeador(aspirante);
             
            } else if (aspirante.peso > entrenadoresDelGym[1].minPesoCat2 && aspirante.peso < entrenadoresDelGym[1].maxPesoCat2) {
              System.out.println("Se le asignara la categoria: " + entrenadoresDelGym[1].categoria2);
              aspirante.categoriaAsignada = entrenadoresDelGym[1].categoria2;
              entrenadoresDelGym[1].asignarBoxeador(aspirante);
              
            } else if (aspirante.peso < entrenadoresDelGym[2].minPesoCat1 && aspirante.peso > entrenadoresDelGym[1].maxPesoCat2) {
              System.out.println("Se le asignara la categoria: " + entrenadoresDelGym[1].categoria2 + " y se le dara una dieta para bajar de peso.");
              aspirante.dieta = "Bajar de peso";
              aspirante.categoriaAsignada = entrenadoresDelGym[1].categoria2;
              entrenadoresDelGym[1].asignarBoxeador(aspirante);
            
              
            //Asignacion al entrenador 3
          
            } else if (aspirante.peso > entrenadoresDelGym[2].minPesoCat1 && aspirante.peso <entrenadoresDelGym[2].maxPesoCat1) {
              System.out.println("Se le asignara la categoria: " + entrenadoresDelGym[2].categoria1 + '.');
              aspirante.categoriaAsignada = entrenadoresDelGym[2].categoria1;
              entrenadoresDelGym[2].asignarBoxeador(aspirante);
             
            } else if (aspirante.peso < entrenadoresDelGym[2].minPesoCat2 && aspirante.peso > entrenadoresDelGym[2].maxPesoCat1) {
              System.out.println("Se le asignara la categoria: " + entrenadoresDelGym[2].categoria1 + " y se le dara una dieta para bajar de peso.");
              aspirante.dieta = "Bajar de peso";
              aspirante.categoriaAsignada = entrenadoresDelGym[2].categoria1;
              entrenadoresDelGym[2].asignarBoxeador(aspirante);
            
            } else if (aspirante.peso > entrenadoresDelGym[2].minPesoCat2 && aspirante.peso < entrenadoresDelGym[2].maxPesoCat2) {
              System.out.println("Se le asignara la categoria: " + entrenadoresDelGym[2].categoria2);
              aspirante.categoriaAsignada = entrenadoresDelGym[2].categoria2;
              entrenadoresDelGym[2].asignarBoxeador(aspirante);
              
            } else if (aspirante.peso < entrenadoresDelGym[3].minPesoCat1 && aspirante.peso > entrenadoresDelGym[2].maxPesoCat2) {
              System.out.println("Se le asignara la categoria: " + entrenadoresDelGym[2].categoria2 + " y se le dara una dieta para bajar de peso.");
              aspirante.dieta = "Bajar de peso";
              aspirante.categoriaAsignada = entrenadoresDelGym[2].categoria2;
              entrenadoresDelGym[2].asignarBoxeador(aspirante);
          
            //Asignacion al entrenador 4
              
            } else if (aspirante.peso > entrenadoresDelGym[3].minPesoCat1 && aspirante.peso <entrenadoresDelGym[3].maxPesoCat1) {
              System.out.println("Se le asignara la categoria: " + entrenadoresDelGym[3].categoria1 + '.');
              aspirante.categoriaAsignada = entrenadoresDelGym[3].categoria1;
              entrenadoresDelGym[3].asignarBoxeador(aspirante);
              
            } else if (aspirante.peso < entrenadoresDelGym[3].minPesoCat2 && aspirante.peso > entrenadoresDelGym[3].maxPesoCat1) {
              System.out.println("Se le asignara la categoria: " + entrenadoresDelGym[3].categoria1 + " y se le dara una dieta para bajar de peso.");
              aspirante.dieta = "Bajar de peso";
              aspirante.categoriaAsignada = entrenadoresDelGym[3].categoria1;
              entrenadoresDelGym[3].asignarBoxeador(aspirante);
           
            } else if (aspirante.peso > entrenadoresDelGym[3].minPesoCat2 && aspirante.peso < entrenadoresDelGym[3].maxPesoCat2) {
              System.out.println("Se le asignara la categoria: " + entrenadoresDelGym[3].categoria2);
              aspirante.categoriaAsignada = entrenadoresDelGym[3].categoria2;
              entrenadoresDelGym[3].asignarBoxeador(aspirante);
              
            } else if (aspirante.peso > entrenadoresDelGym[3].maxPesoCat2) {
              System.out.println("Se le asignara la categoria: " + entrenadoresDelGym[3].categoria1 + " y se le dara una dieta para bajar de peso.");
              aspirante.dieta = "Bajar de peso";
              aspirante.categoriaAsignada = entrenadoresDelGym[3].categoria1;
              entrenadoresDelGym[3].asignarBoxeador(aspirante);
            
            } else {
              System.out.println("Hay un error en la asignacion.");
            }
            
            exitAdmision = true;
            exitInscripcion = true;
            System.out.println("----------------------------------------\n");
            
            break;
        
          //Volver al menu
          case 2:
            exitAdmision = true;
            exitInscripcion = true;
          
            break;

          default:
            System.out.println("El comando es incorrecto, intente nuevamente.\n");
            break;
        }  
        
        }
        
        
      //Resetea  
        
      } else {
        exitAdmision = true;
      }
    
  
    }
  
  }
  
  //Syso de los datos del dia
  public void reporte(Entrenador[] entrenadoresDelGym) {
    
    System.out.println("----------------------------------------");
    System.out.println("\nEn el dia de hoy ingresaron " + boxeadoresAspirantes + " aspirantes a boxeador.");
    System.out.println("La cantidad de boxeadores a cargo de cada entrenador es la siguiente: ");
    System.out.println(entrenadoresDelGym[0].nombre + " (" + entrenadoresDelGym[0].categoria1 + '-' + entrenadoresDelGym[0].categoria2 + "): " + entrenadoresDelGym[0].boxeadoresACargo + '.');
    System.out.println(entrenadoresDelGym[1].nombre + " (" + entrenadoresDelGym[1].categoria1 + '-' + entrenadoresDelGym[1].categoria2 + "): " + entrenadoresDelGym[1].boxeadoresACargo + '.');
    System.out.println(entrenadoresDelGym[2].nombre + " (" + entrenadoresDelGym[2].categoria1 + '-' + entrenadoresDelGym[2].categoria2 + "): " + entrenadoresDelGym[2].boxeadoresACargo + '.');
    System.out.println(entrenadoresDelGym[3].nombre + " (" + entrenadoresDelGym[3].categoria1 + '-' + entrenadoresDelGym[3].categoria2 + "): " + entrenadoresDelGym[3].boxeadoresACargo + ".\n");
    System.out.println("----------------------------------------");
    
  }
  
  
}

