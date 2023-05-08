package ej5;

public class Administrativo extends Empleado {
  private double horasExtras;
  private double horasMes;

  public Administrativo(int dni, String nombre, String apellido,
      String email, double sueldoBase, double horasExtras,
      double horasMes) {
    super(dni, nombre, apellido, email, sueldoBase);
    this.horasExtras = horasExtras;
    this.horasMes = horasMes;
  }

  public Administrativo(int dni, String nombre, String apellido,
      String email, double sueldoBase) {
    super(dni, nombre, apellido, email, sueldoBase);
  }

  public Administrativo() {
    super();
  }

  public double getHorasExtras() {
    return horasExtras;
  }

  public void setHorasExtras(double horasExtras) {
    this.horasExtras = horasExtras;
  }

  public double getHorasMes() {
    return horasMes;
  }

  public void setHorasMes(double horasMes) {
    this.horasMes = horasMes;
  }

  public double calcularSueldo() {
    double sueldo = getSueldoBase() * ((horasExtras * 1.5) + horasMes) / horasMes;
    return sueldo;
  }

}
