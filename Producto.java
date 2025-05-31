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

    // Getter
    public int getCodigo() {
        return codigo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public int getPrecio() {
        return precio;
    }

}
