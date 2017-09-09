package com.utn.model;

import com.utn.model.Boxeador;

public class Entrenador {

  //Attributes ----------------------------------------
  
  public String nombre;
  public String categoria1;
  public String categoria2;

  //Primer Categoria
  public double minPesoCat1;
  public double maxPesoCat1;
  
  //Segunda Categoria
  public double minPesoCat2;
  public double maxPesoCat2;
  
  // Boxeadores[];
  Boxeador boxeadores[] = new Boxeador[5];
  public int boxeadoresACargo = 0; 
  
  //Methods ----------------------------------------
  
  //Setea los datos de cada entrenador
  public void asignarDatos(String setNombre, String setCategoria1, double setMinPesoCat1, double setMaxPesoCat1,
                                             String setCategoria2, double setMinPesoCat2, double setMaxPesoCat2) {
    
    nombre = setNombre; 
    categoria1 = setCategoria1;
    categoria2= setCategoria2;
    minPesoCat1 = setMinPesoCat1;
    maxPesoCat1 = setMaxPesoCat1;
    minPesoCat2 = setMinPesoCat2;
    maxPesoCat2 = setMaxPesoCat2;
    
    
  }
  
  //Una vez decidido que cierto boxeador va a entrenar con el, se lo asigna a su grupo
  public void asignarBoxeador(Boxeador boxeador) {
    boxeadores[boxeadoresACargo] = boxeador;
    ++boxeadoresACargo;
  }
  
  //Chequea si el entrenador esta disponible para recibir aspirantes
  public boolean disponible() {
    if(boxeadoresACargo >= 5) {
      return false;
    } else {
      return true;
    }
    
  }

}
