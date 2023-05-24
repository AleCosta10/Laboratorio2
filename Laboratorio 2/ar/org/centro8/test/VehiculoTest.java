package ar.org.centro8.test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import ar.org.centro8.entities.Moto;
import ar.org.centro8.entities.Auto;
import ar.org.centro8.entities.Vehiculo;

public class VehiculoTest {

        public static void main(String[] args) {
                List<Vehiculo> list = new ArrayList();
                list.add(new Auto("Peugeot", "206", 4, 200000.00));
                list.add(new Moto("Honda", "Titan", "125c", 60000.00));
                list.add(new Auto("Peugeot", "208", 5, 250000.00));
                list.add(new Moto("Yamaha", "YBR", "160c", 80500.50));
                list.stream().forEach(System.out::println);

                System.out.println();
                System.out.println("****************************************************************");

                Vehiculo precioMaximo = list
                                .stream()
                                .max(Comparator.comparingDouble(Vehiculo::getPrecio))
                                .get();

                System.out.println("Vehículo más caro: " + precioMaximo.getMarca() + " " + precioMaximo.getModelo());

                Vehiculo precioMinimo = list
                                .stream()
                                .min(Comparator.comparingDouble(Vehiculo::getPrecio))
                                .get();
                System.out.println("Vehículo más barato: " + precioMinimo.getMarca() + " "
                                + precioMinimo.getModelo());

                list
                                .stream()
                                .filter(p -> p.getModelo().toLowerCase().startsWith("y".toLowerCase()))

                                .forEach(v -> System.out.println(
                                                "Vehiculo que contiene en el modelo la letra 'Y': " + v.getMarca()
                                                                + " " + v.getModelo() + " " + "$" + v.PrecioDecimal()));

                System.out.println();
                System.out.println("****************************************************************");

                System.out.println("Vehículos ordenados por precio de mayor a menor:");
                list
                                .stream()
                                .sorted(Comparator.comparingDouble(Vehiculo::getPrecio).reversed())
                                .forEach(r -> System.out.println(r.getMarca() + " " + r.getModelo()));

                System.out.println();
                System.out.println("****************************************************************");

                System.out.println("Vehículos ordenados por orden natural (marca, modelo, precio):");
                list
                                .stream()
                                .sorted(Comparator.comparing(Vehiculo::getMarca))
                                .forEach(System.out::println);

                System.out.println("..");

        }

}
