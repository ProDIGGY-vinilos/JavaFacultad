import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1to4 {
  static Scanner input = new Scanner( System.in);

  public void ej1() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Primeros enteros:" + i);
    }
    int cont = 0;
    int i = 0;
    while (cont < 10) {
      if (i % 2 == 0) {
        i++;
      } else {
        System.out.println("Primeros impares:" + i);
        i++;
        cont++;
      }
    }
  }

  public void ej2() {
    String[] palabras = new String[10];
    System.out.println("Ingrese 10 palabras:");
    for (int i = 0; i < palabras.length; i++) {
      palabras[i] = input.nextLine();
    }
    for (int i = 9; i >= 0; i--) {
      System.out.println(palabras[i]);
    }
  }

  public void ej3() {
    String[] palabras = new String[10];
    String busqueda;
    System.out.println("Ingrese 10 palabras:");
    for (int i = 0; i < palabras.length; i++) {
      palabras[i] = input.nextLine();
    }
    System.out.println("Ingrese una palabra a buscar:");
    busqueda = input.nextLine();
    for (int i = 0; i < palabras.length; i++) {
      if (palabras[i].equals(busqueda)) {
        System.out.println("La palabra se encuentra en la posición: " + (i + 1));
      }
    }
  }

  public void ej4() {
    int[] numeros = new int[20];
    int numero;
    ArrayList<Integer> mayores = new ArrayList<Integer>();

    System.out.println("Ingrese un número:");
    numero = input.nextInt();
    for (int i = 0; i < numeros.length; i++) {
      numeros[i] = (int) (Math.random() * 50);
      System.out.println(numeros[i]);
      if (numeros[i] > numero) {
        mayores.add(numeros[i]);
      }
    }
    System.out.println("Los números mayores al ingresado son:");
    for (Integer mayor : mayores) {
      System.out.print( " " + mayor );
    }
  }
}
