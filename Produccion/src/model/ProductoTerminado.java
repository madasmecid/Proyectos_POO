package model;

public class ProductoTerminado {
    private String codigoProducto;
    private String nombre;
    private int unidadesPorCaja;
    
    // Insumos que componen la receta (BOM)
    private Botella botella;
    private Tapa tapa;
    private Etiqueta etiquetaFrontal;
    private Etiqueta contraEtiqueta;
    private Etiqueta collerin; // Opcional (null si no utiliza)

    public ProductoTerminado() {
    }

    public ProductoTerminado(String codigoProducto, String nombre, int unidadesPorCaja, 
                             Botella botella, Tapa tapa, Etiqueta etiquetaFrontal, 
                             Etiqueta contraEtiqueta, Etiqueta collerin) {
        setCodigoProducto(codigoProducto);
        setNombre(nombre);
        setUnidadesPorCaja(unidadesPorCaja);
        setBotella(botella);
        setTapa(tapa);
        setEtiquetaFrontal(etiquetaFrontal);
        setContraEtiqueta(contraEtiqueta);
        setCollerin(collerin); // Puede ser null
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        if (codigoProducto == null || codigoProducto.trim().isEmpty()) {
            throw new IllegalArgumentException("El código de producto no puede estar vacío.");
        }
        this.codigoProducto = codigoProducto.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public int getUnidadesPorCaja() {
        return unidadesPorCaja;
    }

    public void setUnidadesPorCaja(int unidadesPorCaja) {
        if (unidadesPorCaja <= 0) {
            throw new IllegalArgumentException("Las unidades por caja deben ser mayores a 0.");
        }
        this.unidadesPorCaja = unidadesPorCaja;
    }

    public Botella getBotella() {
        return botella;
    }

    public void setBotella(Botella botella) {
        if (botella == null) {
            throw new IllegalArgumentException("La botella base no puede ser nula.");
        }
        this.botella = botella;
    }

    public Tapa getTapa() {
        return tapa;
    }

    public void setTapa(Tapa tapa) {
        if (tapa == null) {
            throw new IllegalArgumentException("La tapa no puede ser nula.");
        }
        this.tapa = tapa;
    }

    public Etiqueta getEtiquetaFrontal() {
        return etiquetaFrontal;
    }

    public void setEtiquetaFrontal(Etiqueta etiquetaFrontal) {
        if (etiquetaFrontal == null) {
            throw new IllegalArgumentException("La etiqueta frontal no puede ser nula.");
        }
        this.etiquetaFrontal = etiquetaFrontal;
    }

    public Etiqueta getContraEtiqueta() {
        return contraEtiqueta;
    }

    public void setContraEtiqueta(Etiqueta contraEtiqueta) {
        if (contraEtiqueta == null) {
            throw new IllegalArgumentException("La contra etiqueta no puede ser nula.");
        }
        this.contraEtiqueta = contraEtiqueta;
    }

    public Etiqueta getCollerin() {
        return collerin;
    }

    public void setCollerin(Etiqueta collerin) {
        // Permitido que sea null cuando el producto no lleva collerín
        this.collerin = collerin;
    }

    public boolean tieneCollerin() {
        return this.collerin != null;
    }

    @Override
    public String toString() {
        return "Producto: " + nombre + " [" + codigoProducto + "] (Caja x" + unidadesPorCaja + " botellas)" +
               "\n  - Botella: " + botella.getNombre() +
               "\n  - Tapa: " + tapa.getNombre() +
               "\n  - Frontal: " + etiquetaFrontal.getNombre() +
               "\n  - Contra: " + contraEtiqueta.getNombre() +
               (tieneCollerin() ? ("\n  - Collerín: " + collerin.getNombre()) : "\n  - Collerín: No aplica");
    }
}