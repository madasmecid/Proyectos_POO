package model;

public abstract class Insumo {
    private String codigo;
    private String nombre;
    private int stockActual;

    public Insumo() {
    }

    public Insumo(String codigo, String nombre, int stockActual) {
        setCodigo(codigo);
        setNombre(nombre);
        setStockActual(stockActual);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código del insumo no puede estar vacío.");
        }
        this.codigo = codigo.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del insumo no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        if (stockActual < 0) {
            throw new IllegalArgumentException("El stock actual no puede ser negativo.");
        }
        this.stockActual = stockActual;
    }

    // Método defensivo para descontar unidades en producción
    public void descontarStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a descontar debe ser mayor a 0.");
        }
        if (cantidad > this.stockActual) {
            throw new IllegalStateException("Stock insuficiente para " + this.nombre + 
                                            ". Solicitado: " + cantidad + 
                                            ", Disponible: " + this.stockActual);
        }
        this.stockActual -= cantidad;
    }

    // Método para recepciones de mercadería en bodega
    public void aumentarStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a ingresar debe ser mayor a 0.");
        }
        this.stockActual += cantidad;
    }

    @Override
    public String toString() {
        return "[" + codigo + "] " + nombre + " | Stock: " + stockActual + " unidades";
    }
}