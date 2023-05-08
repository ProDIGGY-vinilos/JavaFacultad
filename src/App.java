import java.util.LinkedList;

import javax.swing.JOptionPane;

import ej5.*;
import ej6.data.ProductData;

public class App {
        public static void main(String[] args)
                        throws Exception {
                // Ejercicio1to4 ejercicio = new Ejercicio1to4();
                // ejercicio.ej4();
                // Ejercicio5a();
                ProductData pro = new ProductData();
                System.out.println( pro.getAll() );
        }

        public static void Ejercicio5a() {
                int opc = 0, i = 0;
                String nombre,
                                apellido,
                                email;
                int dni;
                double sueldoBase;

                LinkedList<Empleado> empleados = new LinkedList<Empleado>();
                JOptionPane.showMessageDialog(null,
                                "Bienvenido al sistema de empleados");
                opc = Integer.parseInt(
                                JOptionPane.showInputDialog(null,
                                                "Desea ingresar un empleado? 1- si 2- no"));
                while (opc == 1 || i < 20) {
                        int tipo = Integer.parseInt(
                                        JOptionPane.showInputDialog(null,
                                                        "Ingrese el tipo de empleado 1- vendedor 2- administrativo"));
                        nombre = JOptionPane.showInputDialog(null,
                                        "Ingrese el nombre");
                        apellido = JOptionPane.showInputDialog(
                                        null, "Ingrese el apellido");
                        email = JOptionPane.showInputDialog(null,
                                        "Ingrese el email");
                        dni = Integer.parseInt(
                                        JOptionPane.showInputDialog(null,
                                                        "Ingrese el dni"));
                        sueldoBase = Double.parseDouble(
                                        JOptionPane.showInputDialog(null,
                                                        "Ingrese el sueldo base"));

                        if (tipo == 1) {
                                Vendedor empleado = new Vendedor(
                                                dni,
                                                nombre,
                                                apellido,
                                                email,
                                                sueldoBase);
                                empleado.setTotalVentas(
                                                Integer.parseInt(JOptionPane
                                                                .showInputDialog(null,
                                                                                "Ingrese el total de ventas")));
                                empleado.setComision(
                                                Double.parseDouble(JOptionPane
                                                                .showInputDialog(null,
                                                                                "Ingrese la comision")));
                                empleados.add(empleado);
                        } else {
                                Administrativo empleado = new Administrativo(
                                                dni,
                                                nombre,
                                                apellido,
                                                email,
                                                sueldoBase);
                                empleado.setHorasExtras(
                                                Double.parseDouble(JOptionPane
                                                                .showInputDialog(null,
                                                                                "Ingrese las horas extras")));
                                empleado.setHorasMes(
                                                Double.parseDouble(JOptionPane
                                                                .showInputDialog(null,
                                                                                "Ingrese las horas mes")));
                                empleados.add(empleado);
                        }
                        i++;
                        opc = Integer.parseInt(
                                        JOptionPane.showInputDialog(null,
                                                        "Desea ingresar un empleado? 1- si 2- no"));
                }
        }
}
