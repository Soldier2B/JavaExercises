package com.utn.view;

import java.util.Scanner;

import com.utn.controller.GimnasioControlador;
import com.utn.model.Entrenador;

public class Test {

  public static void main(String[] args) {
    
    System.out.println("----------------------------------------");
    System.out.println("Bienvenido al sistema administrativo.");
    System.out.println("----------------------------------------\n");
    GimnasioControlador gimnasio = new GimnasioControlador();
    
    Entrenador[] entrenadoresDelGym = gimnasio.entrenadoresDelGym();
    
    boolean exit = false;
    
    while (exit == false) {
      
      System.out.println("Que desea hacer? ");
      System.out.println("Seleccione el numero de la accion que desea realizar");
      
      System.out.println("[1] Chequear disponibilidad de entrenadores.");
      System.out.println("[2] Ver el informe diario");
      System.out.println("[0] Salir del programa");
      
      Scanner input = new Scanner(System.in);
      int command = input.nextInt();
      
      switch (command) {
      case 1:
        //funcion admision
       gimnasio.admision(entrenadoresDelGym);
       
        
        break;
        
      case 2:
        //funcion reporte diario
        gimnasio.reporte(entrenadoresDelGym);
        
        break;
      
      case 0:
        exit = true;
        
        break;

      default:
        System.out.println("El comando es incorrecto, intente nuevamente.\n");
        break;
      }        
      
    } 
    
  }
  
}
