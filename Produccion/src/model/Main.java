package model;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        GestorProduccion gestor = new GestorProduccion();

        // 1. Carga de insumos
        Botella b700 = new Botella(700, "BOT-E700", "Botella E700", 3000);
        Botella bGota = new Botella(750, "BOT-G750", "Botella Gota 750", 1500);

        Tapa tapaE = new Tapa("Negra E", "TAP-E-ORIG", "Tapa E.ORIGINAL", 2500);
        Tapa tapaGota = new Tapa("Blanca", "TAP-GOTA", "Tapa Blanca Licores", 2000);

        Etiqueta frontE = new Etiqueta("FRONTAL", "ET-F-EORIG", "Frontal E.original", 4000);
        Etiqueta contraE = new Etiqueta("CONTRA", "ET-C-EORIG", "Contra E.original", 4000);

        Etiqueta frontGota = new Etiqueta("FRONTAL", "ET-F-GCAC", "Frontal G.Cac", 2000);
        Etiqueta contraGota = new Etiqueta("CONTRA", "ET-C-GCAC", "Contra G.Cac", 2000);
        Etiqueta collerinGota = new Etiqueta("COLLERIN", "ET-COL-GOTA", "Collerin Gota", 2000);

        gestor.agregarInsumo(b700);
        gestor.agregarInsumo(bGota);
        gestor.agregarInsumo(tapaE);
        gestor.agregarInsumo(tapaGota);
        gestor.agregarInsumo(frontE);
        gestor.agregarInsumo(contraE);
        gestor.agregarInsumo(frontGota);
        gestor.agregarInsumo(contraGota);
        gestor.agregarInsumo(collerinGota);

        // 2. Carga de recetas
        ProductoTerminado prodEOriginal = new ProductoTerminado(
                "PT-E700", "E.original 700cc", 12,
                b700, tapaE, frontE, contraE, null
        );

        ProductoTerminado prodGotaCacique = new ProductoTerminado(
                "PT-GOTA750", "Gota Cacique 750cc", 12,
                bGota, tapaGota, frontGota, contraGota, collerinGota
        );

        gestor.agregarProducto(prodEOriginal);
        gestor.agregarProducto(prodGotaCacique);

        // 3. Abrir la ventana
        SwingUtilities.invokeLater(() -> {
            VentanaProduccion ventana = new VentanaProduccion(gestor);
            ventana.setVisible(true);
        });
    }
}