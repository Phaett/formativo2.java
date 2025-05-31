package productmarket;


class Producto {
    private int codigo;
    private String descripcion;
    private int precio;

    // Constructor
    public Producto(int codigo, String descripcion, int precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Mostrar datos
    public void mostrarInfo(int cantidad) {
        System.out.println("=== Detalles del Producto ===");
        System.out.println("Código: " + codigo);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Precio unitario: $" + precio);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Total a pagar: $" + (precio * cantidad));
    }
}
