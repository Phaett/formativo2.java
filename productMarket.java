package productmarket;

import java.util.Scanner;

public class productMarket {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int intentosMaximos = 3;
        int intentos = -1;
        int codigo = 0, precio = 0, cantidad = 0;
        String descripcion = "";

        while (intentos < intentosMaximos) {
            try {
                // C�digo
                System.out.print("Ingrese el c�digo del producto (entero): ");
                if (teclado.hasNextInt()) {
                    codigo = teclado.nextInt();
                    teclado.nextLine(); // Consumir el salto de l�nea
                } else {
                    throw new Exception("El c�digo debe ser un n�mero entero.");
                }

                // Descripci�n
                System.out.print("Ingrese la descripci�n del producto (solo texto): ");
                String entrada = teclado.nextLine();
                if(entrada.matches("[a-zA-Z������������\\s]+")){
                    descripcion = entrada;
                }
                else {
                    throw new Exception("La descripci�n debe contener solo letras y no estar vac�a.");
                }
                
                // Precio
                System.out.print("Ingrese el precio del producto: ");
                if (teclado.hasNextInt()) {
                    precio = teclado.nextInt();
                    teclado.nextLine(); // Consumir el salto de l�nea
                    if (precio <= 0) {
                        throw new Exception("El precio debe ser mayor a 0.");
                    }
                } else {
                    throw new Exception("El precio debe ser un n�mero entero.");
                }

                // Cantidad
                System.out.print("Ingrese la cantidad a comprar: ");
                if (teclado.hasNextInt()) {
                    cantidad = teclado.nextInt();
                    teclado.nextLine(); // Consumir el salto de l�nea
                    if (cantidad <= 0) {
                        throw new Exception("La cantidad debe ser mayor a 0.");
                    }
                } else {
                    throw new Exception("La cantidad debe ser un n�mero entero.");
                }

                // Si todo fue correcto, salir del ciclo
                break;

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                teclado.nextLine(); // Limpiar entrada incorrecta
                intentos++;
                if (intentos == intentosMaximos) {
                    System.out.println("Ha excedido el n�mero m�ximo de intentos.");
                    return;
                }
                System.out.println("Por favor intente nuevamente. Intento " + (intentos + 1) + " de " + intentosMaximos);
            }
        }

        //Llamado de hoja producto e inicio de app
        Producto p = new Producto(codigo, descripcion, precio);
        p.mostrarInfo(cantidad);
    }
}
