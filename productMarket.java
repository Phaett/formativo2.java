package productmarket;

import java.util.Scanner;

public class productMarket {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int intentosMaximos = 3;
        int intentos = 0;
        int codigo = 0, precio = 0, cantidad = 0;
        String descripcion = "";

        while (intentos < intentosMaximos) {
            try {
                // Código
                System.out.print("Ingrese el código del producto (entero): ");
                if (teclado.hasNextInt()) {
                    codigo = teclado.nextInt();
                    teclado.nextLine(); // Consumir el salto de línea
                } else {
                    throw new Exception("El código debe ser un número entero.");
                }

                // Descripción
                System.out.print("Ingrese la descripción del producto (solo texto): ");
                String entrada = teclado.nextLine();
                if(entrada.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+") && !entrada.isEmpty()){
                    descripcion = entrada;
                }
                else {
                    throw new Exception("La descripción debe contener solo letras y no estar vacía.");
                }
                
                // Precio
                System.out.print("Ingrese el precio del producto: ");
                if (teclado.hasNextInt()) {
                    precio = teclado.nextInt();
                    teclado.nextLine(); // Consumir el salto de línea
                    if (precio <= 0) {
                        throw new Exception("El precio debe ser mayor a 0.");
                    }
                } else {
                    throw new Exception("El precio debe ser un número entero.");
                }

                // Cantidad
                System.out.print("Ingrese la cantidad a comprar: ");
                if (teclado.hasNextInt()) {
                    cantidad = teclado.nextInt();
                    teclado.nextLine(); // Consumir el salto de línea
                    if (cantidad <= 0) {
                        throw new Exception("La cantidad debe ser mayor a 0.");
                    }
                } else {
                    throw new Exception("La cantidad debe ser un número entero.");
                }

                // Si todo fue correcto, salir del ciclo
                break;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                teclado.nextLine(); // Limpiar entrada incorrecta
                intentos++;
                if (intentos == intentosMaximos) {
                    System.out.println("Ha excedido el número máximo de intentos.");
                    return;
                }
                System.out.println("Por favor intente nuevamente. Intento " + (intentos + 1) + " de " + intentosMaximos);
            }
        }

        //Llamado a class producto
        Producto p = new Producto(codigo, descripcion, precio);
        System.out.println("=== Detalles del Producto ===");
        System.out.println("Codigo: " + p.getCodigo());
        System.out.println("Descripcion: " + p.getDescripcion());
        System.out.println("Precio unitario: $" + p.getPrecio());
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Total a pagar: $" + (precio * cantidad));
    }
}

