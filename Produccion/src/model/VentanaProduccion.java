package model;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class VentanaProduccion extends JFrame {

    private GestorProduccion gestor;

    // Componentes de la interfaz
    private JComboBox<String> cbProductos;
    private JTextField txtCajas;
    private JTextArea txtInventario;
    private JButton btnCalcular;

    public VentanaProduccion(GestorProduccion gestor) {
        this.gestor = gestor;

        // Configuración de la ventana principal
        setTitle("Calculadora de Producción - Planta Envasado");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setLayout(new BorderLayout(10, 10));

        // 1. Panel Superior (Formulario de Entrada)
        JPanel panelEntrada = new JPanel(new GridLayout(3, 2, 10, 10));
        panelEntrada.setBorder(BorderFactory.createTitledBorder("Orden de Fabricación"));

        panelEntrada.add(new JLabel(" Seleccione Producto:"));
        cbProductos = new JComboBox<>(new String[]{
            "PT-E700 (E.original 700cc)",
            "PT-GOTA750 (Gota Cacique 750cc)"
        });
        panelEntrada.add(cbProductos);

        panelEntrada.add(new JLabel(" Cajas a Producir:"));
        txtCajas = new JTextField();
        panelEntrada.add(txtCajas);

        panelEntrada.add(new JLabel("")); // Espacio vacío para alinear
        btnCalcular = new JButton("Procesar Orden y Descontar");
        panelEntrada.add(btnCalcular);

        add(panelEntrada, BorderLayout.NORTH);

        // 2. Panel Central (Visor de Inventario en tiempo real)
        txtInventario = new JTextArea();
        txtInventario.setEditable(false);
        txtInventario.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(txtInventario);
        scroll.setBorder(BorderFactory.createTitledBorder("Inventario Actual en Bodega"));
        add(scroll, BorderLayout.CENTER);

        // 3. Evento del Botón
        btnCalcular.addActionListener((ActionEvent e) -> {
            ejecutarOrdenProduccion();
        });

        // Mostrar estado inicial del inventario
        actualizarPantallaInventario();
    }

    private void ejecutarOrdenProduccion() {
        String textoCajas = txtCajas.getText().trim();

        if (textoCajas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una cantidad de cajas.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int cajas = Integer.parseInt(textoCajas);

            // Obtener el código seleccionado del JComboBox
            String seleccion = (String) cbProductos.getSelectedItem();
            String codigoProd = seleccion.startsWith("PT-E700") ? "PT-E700" : "PT-GOTA750";

            // Llamar a la lógica de negocio defensiva que ya construiste
            gestor.procesarOrdenProduccion(codigoProd, cajas);

            // Si pasa sin lanzar excepción, se informa y se refresca el stock
            JOptionPane.showMessageDialog(this, 
                    "¡Orden completada!\nSe procesaron " + cajas + " cajas exitosamente.", 
                    "Producción Exitosa", JOptionPane.INFORMATION_MESSAGE);

            txtCajas.setText("");
            actualizarPantallaInventario();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La cantidad de cajas debe ser un número entero válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalStateException | IllegalArgumentException ex) {
            // Captura las excepciones de stock insuficiente sin que el programa se caiga
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Stock Insuficiente / Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarPantallaInventario() {
        // Redirigir el listado al área de texto visual
        StringBuilder sb = new StringBuilder();
        sb.append("=================== ESTADO ACTUAL DEL INVENTARIO ===================\n\n");
        // Para simplificar la visualización rápida:
        sb.append("Consulte la consola o inspeccione los insumos actualizados.\n");
        txtInventario.setText(sb.toString());
    }
}