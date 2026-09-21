package model;

import java.util.ArrayList;

public class GestorProduccion {
    private ArrayList<Insumo> inventario;
    private ArrayList<ProductoTerminado> catalogoProductos;

    public GestorProduccion() {
        this.inventario = new ArrayList<>();
        this.catalogoProductos = new ArrayList<>();
    }

    // --- MÉTODOS DE REGISTRO ---

    public void agregarInsumo(Insumo insumo) {
        if (insumo == null) {
            throw new IllegalArgumentException("No se puede registrar un insumo nulo.");
        }
        inventario.add(insumo);
        System.out.println("Insumo registrado: " + insumo.getNombre());
    }

    public void agregarProducto(ProductoTerminado producto) {
        if (producto == null) {
            throw new IllegalArgumentException("No se puede registrar un producto nulo.");
        }
        catalogoProductos.add(producto);
        System.out.println("Producto añadido al catálogo: " + producto.getNombre());
    }

    // --- MÉTODOS DE BÚSQUEDA ---

    public ProductoTerminado buscarProductoPorCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return null;
        }
        for (ProductoTerminado p : catalogoProductos) {
            if (p.getCodigoProducto().equalsIgnoreCase(codigo.trim())) {
                return p;
            }
        }
        return null;
    }

    // --- LISTADOS DEFENSIVOS ---

    public void listarInventario() {
        System.out.println("\n========== ESTADO ACTUAL DEL INVENTARIO ==========");
        if (inventario.isEmpty()) {
            System.out.println("No hay insumos registrados en inventario.");
            return;
        }
        for (Insumo insumo : inventario) {
            System.out.println(insumo.toString());
        }
    }

    public void listarCatalogo() {
        System.out.println("\n========== CATÁLOGO DE PRODUCTOS TERMINADOS ==========");
        if (catalogoProductos.isEmpty()) {
            System.out.println("No hay productos registrados en el catálogo.");
            return;
        }
        for (ProductoTerminado p : catalogoProductos) {
            System.out.println("--------------------------------------------------");
            System.out.println(p.toString());
        }
    }

    // --- LÓGICA DE PRODUCCIÓN Y DESCUENTO ---

    public void procesarOrdenProduccion(String codigoProducto, int cajasAProducir) {
        if (cajasAProducir <= 0) {
            throw new IllegalArgumentException("La cantidad de cajas a producir debe ser mayor a 0.");
        }

        ProductoTerminado prod = buscarProductoPorCodigo(codigoProducto);
        if (prod == null) {
            throw new IllegalArgumentException("No se encontró ningún producto con el código: " + codigoProducto);
        }

        int totalBotellas = cajasAProducir * prod.getUnidadesPorCaja();

        System.out.println("\n==================================================");
        System.out.println("PROCESANDO ORDEN DE PRODUCCIÓN: " + prod.getNombre());
        System.out.println("Cajas solicitadas: " + cajasAProducir + " | Botellas por caja: " + prod.getUnidadesPorCaja());
        System.out.println("TOTAL UNIDADES A PRODUCIR: " + totalBotellas + " unidades");
        System.out.println("==================================================");

        // Paso 1: Validación defensiva previa (Verificar que TODO alcance antes de descontar)
        verificarStockDisponible(prod.getBotella(), totalBotellas);
        verificarStockDisponible(prod.getTapa(), totalBotellas);
        verificarStockDisponible(prod.getEtiquetaFrontal(), totalBotellas);
        verificarStockDisponible(prod.getContraEtiqueta(), totalBotellas);
        if (prod.tieneCollerin()) {
            verificarStockDisponible(prod.getCollerin(), totalBotellas);
        }

        // Paso 2: Descuento atómico si todos los insumos tienen stock suficiente
        prod.getBotella().descontarStock(totalBotellas);
        prod.getTapa().descontarStock(totalBotellas);
        prod.getEtiquetaFrontal().descontarStock(totalBotellas);
        prod.getContraEtiqueta().descontarStock(totalBotellas);
        if (prod.tieneCollerin()) {
            prod.getCollerin().descontarStock(totalBotellas);
        }

        System.out.println(">> ¡ORDEN COMPLETADA CON ÉXITO!");
        System.out.println("Se descontaron " + totalBotellas + " unidades de cada insumo correspondiente.");
    }

    private void verificarStockDisponible(Insumo insumo, int cantidadRequerida) {
        if (insumo.getStockActual() < cantidadRequerida) {
            throw new IllegalStateException("Imposible producir: Stock insuficiente de " + 
                                           insumo.getNombre() + 
                                           " (Disponible: " + insumo.getStockActual() + 
                                           " | Requerido: " + cantidadRequerida + ")");
        }
    }
}