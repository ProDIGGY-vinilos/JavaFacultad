package ej5;

public class Vendedor extends Empleado {
  private int totalVentas;
  private double comision;

  public Vendedor(int dni, String nombre, String apellido, String email, double sueldoBase,
      int totalVentas, double comision) {
    super(dni, nombre, apellido, email, sueldoBase);
    this.totalVentas = totalVentas;
    this.comision = comision;
  }

  public Vendedor(int dni, String nombre, String apellido, String email, double sueldoBase) {
    super(dni, nombre, apellido, email, sueldoBase);
  }

  public Vendedor() {
    super();
  }

  public int getTotalVentas() {
    return totalVentas;
  }

  public void setTotalVentas(int totalVentas) {
    this.totalVentas = totalVentas;
  }

  public double getComision() {
    return comision;
  }

  public void setComision(double comision) {
    this.comision = comision;
  }

  public double calcularSueldo() {
    double sueldo = getSueldoBase() + (comision * totalVentas / 100);
    return sueldo;
  }
}
