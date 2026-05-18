package vista;

import modelo.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;

public class UsaGUIVenta extends JFrame {

    private ArrayList<Venta> datosVentas = new ArrayList<>();
    private ArrayList<Cliente> datosClientes = new ArrayList<>();

    private static final String ARCHIVO_VENTAS = "ventas.dat";
    private static final String ARCHIVO_CLIENTES = "clientes.dat";

    // Colores corporativos
    private static final Color COLOR_PRIMARY    = new Color(30, 80, 160);
    private static final Color COLOR_SIDEBAR_BG = new Color(22, 40, 80);   // azul oscuro sidebar
    private static final Color COLOR_BTN_NORMAL = new Color(45, 90, 175);  // botón normal
    private static final Color COLOR_BTN_HOVER  = new Color(60, 120, 220); // botón hover
    private static final Color COLOR_SECONDARY  = new Color(240, 245, 255);
    private static final Color COLOR_ACCENT     = new Color(220, 53, 69);
    private static final Color COLOR_SUCCESS    = new Color(40, 167, 69);
    private static final Color COLOR_HEADER_TEXT = Color.WHITE;
    private static final Font FONT_TITLE = new Font("Segoe UI", Font.BOLD, 22);
    private static final Font FONT_MENU  = new Font("Segoe UI", Font.PLAIN, 14);
    private static final Font FONT_BTN   = new Font("Segoe UI", Font.BOLD, 13);

    private JTextArea areaResultado;
    private JLabel lblEstado;
    private int contadorVentas = 1;

    public UsaGUIVenta() {
        initComponents();
    }


    private void initComponents() {
        setTitle("Gestión de Ventas - Paquetes Turísticos | Eq. Droko");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 720);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(COLOR_PRIMARY);
        header.setBorder(new EmptyBorder(14, 20, 14, 20));
        JLabel lblTitulo = new JLabel("✈  Gestión de Ventas de Paquetes Turísticos");
        lblTitulo.setFont(FONT_TITLE);
        lblTitulo.setForeground(COLOR_HEADER_TEXT);
        JLabel lblEquipo = new JLabel("Equipo Droko | POO 2026-1");
        lblEquipo.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        lblEquipo.setForeground(new Color(180, 210, 255));
        header.add(lblTitulo, BorderLayout.WEST);
        header.add(lblEquipo, BorderLayout.EAST);
        add(header, BorderLayout.NORTH);

        // Panel izquierdo - menú
        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));
        panelMenu.setBackground(COLOR_SIDEBAR_BG);
        panelMenu.setBorder(new EmptyBorder(16, 10, 16, 10));
        panelMenu.setPreferredSize(new Dimension(235, 0));

        JLabel lblMenu = new JLabel("MENÚ PRINCIPAL");
        lblMenu.setFont(new Font("Segoe UI", Font.BOLD, 11));
        lblMenu.setForeground(new Color(150, 185, 255));
        lblMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelMenu.add(lblMenu);
        panelMenu.add(Box.createVerticalStrut(10));

        String[] opciones = {
            "1. Nueva Venta", "2. Todas las Ventas",
            "3. Buscar por Número", "4. Buscar por Posición",
            "5. Buscar por Estado", "6. Guardar Ventas (.dat)",
            "7. Cargar Ventas (.dat)", "8. Actualizar Venta",
            "9. Guardar Clientes (.dat)", "10. Cargar Clientes (.dat)"
        };
        Color[] colores = {
            COLOR_SUCCESS,    COLOR_BTN_NORMAL, COLOR_BTN_NORMAL, COLOR_BTN_NORMAL,
            COLOR_BTN_NORMAL, new Color(80, 100, 130), new Color(80, 100, 130),
            new Color(200, 120, 0), new Color(80, 100, 130), new Color(80, 100, 130)
        };
        int[] ids = {1,2,3,4,5,6,7,8,9,10};

        for (int i = 0; i < opciones.length; i++) {
            JButton btn = crearBotonMenu(opciones[i], colores[i]);
            final int id = ids[i];
            btn.addActionListener(e -> manejarOpcion(id));
            panelMenu.add(btn);
            panelMenu.add(Box.createVerticalStrut(6));
        }

        panelMenu.add(Box.createVerticalGlue());
        JButton btnSalir = crearBotonMenu("Salir", COLOR_ACCENT);
        btnSalir.addActionListener(e -> {
            int r = JOptionPane.showConfirmDialog(this, "¿Desea salir de la aplicación?",
                    "Confirmar salida", JOptionPane.YES_NO_OPTION);
            if (r == JOptionPane.YES_OPTION) System.exit(0);
        });
        panelMenu.add(btnSalir);

        add(panelMenu, BorderLayout.WEST);

        // Panel derecho - resultado
        JPanel panelDerecho = new JPanel(new BorderLayout());
        panelDerecho.setBackground(Color.WHITE);

        JLabel lblResultadoTitulo = new JLabel("  Resultado");
        lblResultadoTitulo.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblResultadoTitulo.setForeground(COLOR_PRIMARY);
        lblResultadoTitulo.setBorder(new EmptyBorder(8, 8, 4, 8));

        areaResultado = new JTextArea();
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 13));
        areaResultado.setEditable(false);
        areaResultado.setBackground(new Color(248, 250, 255));
        areaResultado.setBorder(new EmptyBorder(8, 10, 8, 10));
        areaResultado.setText("Bienvenido al Sistema de Gestion de Ventas de Paquetes Turisticos.\n" +
                "Equipo Droko - POO 2026-1\n\nSeleccione una opcion del menu para comenzar.");

        JScrollPane scroll = new JScrollPane(areaResultado);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(210, 220, 240)));

        lblEstado = new JLabel("  Listo");
        lblEstado.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblEstado.setForeground(new Color(80, 100, 140));
        lblEstado.setBorder(new CompoundBorder(
                new MatteBorder(1, 0, 0, 0, new Color(200, 210, 230)),
                new EmptyBorder(6, 10, 6, 10)));
        lblEstado.setBackground(COLOR_SECONDARY);
        lblEstado.setOpaque(true);

        panelDerecho.add(lblResultadoTitulo, BorderLayout.NORTH);
        panelDerecho.add(scroll, BorderLayout.CENTER);
        panelDerecho.add(lblEstado, BorderLayout.SOUTH);

        add(panelDerecho, BorderLayout.CENTER);
    }

    private JButton crearBotonMenu(String texto, Color color) {
        JButton btn = new JButton(texto);
        btn.setFont(FONT_BTN);
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(new EmptyBorder(9, 12, 9, 12));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { btn.setBackground(color.brighter()); }
            public void mouseExited(MouseEvent e) { btn.setBackground(color); }
        });
        return btn;
    }

    private void manejarOpcion(int opcion) {
        switch (opcion) {
            case 1: crearNuevaVenta(); break;
            case 2: mostrarResultado(consultarTodasVentas(datosVentas)); break;
            case 3: consultarPorNumero(); break;
            case 4: consultarPorPosicion(); break;
            case 5: consultarPorEstado(); break;
            case 6: generarArchivoObjetosVentas(datosVentas); break;
            case 7: recuperarVentasDesdeArchivoObjetos(); break;
            case 8: actualizarVentaGUI(); break;
            case 9: generarArchivoObjetosClientes(datosClientes); break;
            case 10: recuperarClientesDesdeArchivoObjetos(); break;
        }
    }

    // ======================== LÓGICA DE NEGOCIO ========================

    public int generarNumeroVenta(ArrayList<Venta> datosVentas) {
        return contadorVentas++;
    }

    public ArrayList<Venta> crearNuevaVenta(ArrayList<Venta> datosVentas) {
        // Datos del cliente
        JPanel panelCliente = new JPanel(new GridLayout(0, 2, 6, 6));
        panelCliente.setBorder(new TitledBorder("Datos del Cliente"));

        String[] tiposId = {"C - Cédula", "N - NIT"};
        JComboBox<String> cmbTipoId = new JComboBox<>(tiposId);
        JTextField txtNumId = new JTextField();
        JCheckBox chkEmpresa = new JCheckBox("¿Es empresa?");
        JTextField txtNombre = new JTextField();
        JTextField txtEmail = new JTextField();
        JTextField txtTelefono = new JTextField();
        JTextField txtContacto = new JTextField();
        JTextField txtDescuento = new JTextField("0.0");

        panelCliente.add(new JLabel("Tipo identificación:")); panelCliente.add(cmbTipoId);
        panelCliente.add(new JLabel("Número identificación:")); panelCliente.add(txtNumId);
        panelCliente.add(new JLabel("")); panelCliente.add(chkEmpresa);
        panelCliente.add(new JLabel("Nombre / Razón social:")); panelCliente.add(txtNombre);
        panelCliente.add(new JLabel("Email:")); panelCliente.add(txtEmail);
        panelCliente.add(new JLabel("Teléfono:")); panelCliente.add(txtTelefono);
        panelCliente.add(new JLabel("Nombre contacto:")); panelCliente.add(txtContacto);
        panelCliente.add(new JLabel("% Descuento (0-70):")); panelCliente.add(txtDescuento);

        int r = JOptionPane.showConfirmDialog(this, panelCliente,
                "Nueva Venta - Datos del Cliente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (r != JOptionPane.OK_OPTION) return datosVentas;

        try {
            char tipoId = cmbTipoId.getSelectedIndex() == 0 ? 'C' : 'N';
            String numId = txtNumId.getText().trim();
            if (numId.isEmpty()) { JOptionPane.showMessageDialog(this, "Número de identificación requerido."); return datosVentas; }
            if (tipoId == 'C' && numId.length() < 6) { JOptionPane.showMessageDialog(this, "Cédula mínimo 6 dígitos."); return datosVentas; }
            if (tipoId == 'N' && numId.length() != 9) { JOptionPane.showMessageDialog(this, "NIT debe tener 9 dígitos."); return datosVentas; }
            boolean esEmpresa = chkEmpresa.isSelected();
            String nombre = txtNombre.getText().trim();
            if (nombre.isEmpty()) { JOptionPane.showMessageDialog(this, "Nombre requerido."); return datosVentas; }
            String email = txtEmail.getText().trim();
            String telefono = txtTelefono.getText().trim();
            String contacto = txtContacto.getText().trim();
            if (contacto.isEmpty()) contacto = nombre;
            double descuento = Double.parseDouble(txtDescuento.getText().trim());

            Cliente cliente = new Cliente(tipoId, numId, esEmpresa, nombre, email, telefono, contacto, descuento);

            // Paquetes
            ArrayList<PaqueteTuristico> paquetes = new ArrayList<>();
            boolean agregarMas = true;
            while (agregarMas) {
                PaqueteTuristico paquete = crearPaquete();
                if (paquete != null) paquetes.add(paquete);
                int resp = JOptionPane.showConfirmDialog(this, "¿Agregar otro paquete?",
                        "Paquetes", JOptionPane.YES_NO_OPTION);
                agregarMas = (resp == JOptionPane.YES_OPTION);
            }

            if (paquetes.isEmpty()) {
                JOptionPane.showMessageDialog(this, "La venta debe tener al menos un paquete.");
                return datosVentas;
            }

            int numero = generarNumeroVenta(datosVentas);
            Venta nuevaVenta = new Venta(numero, cliente, paquetes);
            datosVentas.add(nuevaVenta);
            mostrarResultado("✅ Venta #" + numero + " creada exitosamente.\n\n" + nuevaVenta.toString());
            actualizarEstado("Venta #" + numero + " creada. Total ventas: " + datosVentas.size());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en formato de número: " + e.getMessage());
        }
        return datosVentas;
    }

    private PaqueteTuristico crearPaquete() {
        String[] categorias = {"Único", "Múltiple"};
        String cat = (String) JOptionPane.showInputDialog(this, "Categoría del paquete:",
                "Nuevo Paquete", JOptionPane.PLAIN_MESSAGE, null, categorias, categorias[0]);
        if (cat == null) return null;

        JPanel panel = new JPanel(new GridLayout(0, 2, 6, 6));
        JTextField txtCodigo = new JTextField();
        JTextField txtNombre = new JTextField();
        JTextField txtTipologia = new JTextField("Recreación");
        JTextField txtDescripcion = new JTextField();
        JTextField txtOrigen = new JTextField("Cali");
        JTextField txtTarifa = new JTextField();
        JTextField txtUnidades = new JTextField("1");
        JCheckBox chkHotel = new JCheckBox("Hotel incluido", true);
        JCheckBox chkAlim = new JCheckBox("Alimentación incluida", true);
        JCheckBox chkAlimTodo = new JCheckBox("Alimentación completa", true);
        JCheckBox chkVuelo = new JCheckBox("Vuelo incluido", true);
        JCheckBox chkAsist = new JCheckBox("Asistencia incluida", false);

        panel.add(new JLabel("Código:")); panel.add(txtCodigo);
        panel.add(new JLabel("Nombre (mín 10 car.):")); panel.add(txtNombre);
        panel.add(new JLabel("Tipología turismo:")); panel.add(txtTipologia);
        panel.add(new JLabel("Descripción:")); panel.add(txtDescripcion);
        panel.add(new JLabel("Origen:")); panel.add(txtOrigen);
        panel.add(new JLabel("Tarifa día ($):")); panel.add(txtTarifa);
        panel.add(new JLabel("Cantidad unidades:")); panel.add(txtUnidades);
        panel.add(new JLabel("")); panel.add(chkHotel);
        panel.add(new JLabel("")); panel.add(chkAlim);
        panel.add(new JLabel("")); panel.add(chkAlimTodo);
        panel.add(new JLabel("")); panel.add(chkVuelo);
        panel.add(new JLabel("")); panel.add(chkAsist);

        int r = JOptionPane.showConfirmDialog(this, panel, "Datos del Paquete " + cat,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (r != JOptionPane.OK_OPTION) return null;

        try {
            String codigo = txtCodigo.getText().trim();
            String nombre = txtNombre.getText().trim();
            if (nombre.length() < 10) { JOptionPane.showMessageDialog(this, "Nombre mínimo 10 caracteres."); return null; }
            String tipologia = txtTipologia.getText().trim();
            String descripcion = txtDescripcion.getText().trim();
            String origen = txtOrigen.getText().trim();
            int tarifa = Integer.parseInt(txtTarifa.getText().trim());
            if (tarifa <= 0) { JOptionPane.showMessageDialog(this, "Tarifa debe ser mayor a 0."); return null; }
            int unidades = Integer.parseInt(txtUnidades.getText().trim());

            // Destinos
            ArrayList<Destino> destinos = new ArrayList<>();
            int numDestinos = cat.equals("Único") ? 1 :
                    Integer.parseInt(JOptionPane.showInputDialog(this, "¿Cuántos destinos?", "2"));
            for (int i = 0; i < numDestinos; i++) {
                Destino d = crearDestino(i + 1);
                if (d != null) destinos.add(d);
            }
            if (destinos.isEmpty()) { JOptionPane.showMessageDialog(this, "Debe ingresar al menos un destino."); return null; }

            if (cat.equals("Único")) {
                String hotel = JOptionPane.showInputDialog(this, "Nombre del hotel:");
                String desayuno = chkAlim.isSelected() ?
                        JOptionPane.showInputDialog(this, "Tipo desayuno (Buffet, Americano, etc.):") : null;
                return new PaqueteTuristicoUnico(codigo, nombre, tipologia, descripcion, origen,
                        destinos, chkHotel.isSelected(), chkAlim.isSelected(), chkAlimTodo.isSelected(),
                        chkVuelo.isSelected(), chkAsist.isSelected(), tarifa, unidades, hotel, desayuno);
            } else {
                String obsequio = JOptionPane.showInputDialog(this, "Obsequio del paquete:");
                return new PaqueteTuristicoMultiple(codigo, nombre, tipologia, descripcion, origen,
                        destinos, chkHotel.isSelected(), chkAlim.isSelected(), chkAlimTodo.isSelected(),
                        chkVuelo.isSelected(), chkAsist.isSelected(), tarifa, unidades, obsequio);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error numérico: " + e.getMessage());
            return null;
        }
    }

    private Destino crearDestino(int numero) {
        JPanel panel = new JPanel(new GridLayout(0, 2, 6, 6));
        JTextField txtLugar = new JTextField();
        JTextField txtDias = new JTextField("1");
        JTextField txtAtractivos = new JTextField("Separados por coma");
        JCheckBox chkIncluidos = new JCheckBox("¿Atractivos incluidos?", true);
        panel.add(new JLabel("Nombre lugar:")); panel.add(txtLugar);
        panel.add(new JLabel("Días permanencia (mín 1):")); panel.add(txtDias);
        panel.add(new JLabel("Atractivos:")); panel.add(txtAtractivos);
        panel.add(new JLabel("")); panel.add(chkIncluidos);
        int r = JOptionPane.showConfirmDialog(this, panel, "Destino #" + numero,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (r != JOptionPane.OK_OPTION) return null;
        try {
            String lugar = txtLugar.getText().trim();
            int dias = Integer.parseInt(txtDias.getText().trim());
            LinkedList<String> atr = new LinkedList<>();
            for (String a : txtAtractivos.getText().split(",")) {
                String at = a.trim();
                if (!at.isEmpty() && !at.equals("Separados por coma")) atr.add(at);
            }
            return new Destino(lugar, dias, atr, chkIncluidos.isSelected());
        } catch (NumberFormatException e) { return null; }
    }

    public String consultarTodasVentas(ArrayList<Venta> datosVentas) {
        if (datosVentas.isEmpty()) return "No hay ventas registradas.";
        StringBuilder sb = new StringBuilder("=== TODAS LAS VENTAS (" + datosVentas.size() + ") ===\n\n");
        for (Venta v : datosVentas) sb.append(v.toString()).append("\n");
        return sb.toString();
    }

    public String consultarVentaDadoNumero(ArrayList<Venta> datosVentas, int numeroVenta) {
        for (Venta v : datosVentas) {
            if (v.getNumero() == numeroVenta) return v.toString();
        }
        return "No se encontró venta con número " + numeroVenta;
    }

    public String consultarVentaDadaPosicion(ArrayList<Venta> datosVentas, char posicionVenta) {
        if (datosVentas.isEmpty()) return "No hay ventas registradas.";
        if (posicionVenta == 'P') return "=== PRIMERA VENTA ===\n\n" + datosVentas.get(0).toString();
        if (posicionVenta == 'U') return "=== ÚLTIMA VENTA ===\n\n" + datosVentas.get(datosVentas.size() - 1).toString();
        return "Posición no válida. Use P (primera) o U (última).";
    }

    public String consultarVentasDadoEstado(ArrayList<Venta> datosVentas, char estadoVenta) {
        StringBuilder sb = new StringBuilder();
        String estadoNombre = estadoVenta == 'A' ? "Activas" : estadoVenta == 'C' ? "Canceladas" : "Con Pago";
        sb.append("=== VENTAS ").append(estadoNombre.toUpperCase()).append(" ===\n\n");
        int count = 0;
        for (Venta v : datosVentas) {
            if (v.getEstado() == estadoVenta) {
                sb.append(v.toString()).append("\n");
                count++;
            }
        }
        if (count == 0) sb.append("No hay ventas con estado: ").append(estadoNombre);
        return sb.toString();
    }

    public String consultarVentasDadaCategoriaPaquete(ArrayList<Venta> datosVentas, String categoriaPaquete) {
        StringBuilder sb = new StringBuilder("=== VENTAS CON PAQUETES " + categoriaPaquete.toUpperCase() + " ===\n\n");
        int count = 0;
        for (Venta v : datosVentas) {
            boolean tiene = false;
            for (PaqueteTuristico p : v.getSusPaquetesTuristicos()) {
                if (p.getCategoria().equalsIgnoreCase(categoriaPaquete)) { tiene = true; break; }
            }
            if (tiene) { sb.append(v.toString()).append("\n"); count++; }
        }
        if (count == 0) sb.append("No hay ventas con paquetes de categoría: ").append(categoriaPaquete);
        return sb.toString();
    }

    public void actualizarVenta(ArrayList<Venta> datosVentas, int numeroVenta, char operacion) {
        for (Venta v : datosVentas) {
            if (v.getNumero() == numeroVenta) {
                v.setEstado(operacion == 'C' ? 'C' : 'P');
                v.setFechaHoraActualizacion(LocalDateTime.now());
                mostrarResultado("✅ Venta #" + numeroVenta + " actualizada.\n\n" + v.toString());
                actualizarEstado("Venta #" + numeroVenta + " " + (operacion == 'C' ? "cancelada" : "pagada"));
                return;
            }
        }
        mostrarResultado("❌ No se encontró venta con número " + numeroVenta);
    }

    public void generarArchivoObjetosVentas(ArrayList<Venta> datosVentas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_VENTAS))) {
            oos.writeObject(datosVentas);
            mostrarResultado("✅ Archivo de ventas generado exitosamente.\nArchivo: " + ARCHIVO_VENTAS +
                    "\nVentas guardadas: " + datosVentas.size());
            actualizarEstado("Archivo " + ARCHIVO_VENTAS + " generado.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void recuperarVentasDesdeArchivoObjetos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_VENTAS))) {
            datosVentas.clear();
            datosVentas = (ArrayList<Venta>) ois.readObject();
            // Actualizar contador
            for (Venta v : datosVentas) if (v.getNumero() >= contadorVentas) contadorVentas = v.getNumero() + 1;
            mostrarResultado("✅ Ventas recuperadas desde archivo.\nVentas cargadas: " + datosVentas.size() +
                    "\n\n" + consultarTodasVentas(datosVentas));
            actualizarEstado("Ventas cargadas desde " + ARCHIVO_VENTAS);
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar ventas: " + e.getMessage());
        }
    }

    public void generarArchivoObjetosClientes(ArrayList<Cliente> datosClientes) {
        // Construir colección sin repetidos desde ventas
        ArrayList<Cliente> clientesSinRepetir = new ArrayList<>();
        for (Venta v : datosVentas) {
            Cliente c = v.getSuCliente();
            boolean existe = false;
            for (Cliente ex : clientesSinRepetir) {
                if (ex.getNumeroIdentificacion().equals(c.getNumeroIdentificacion())) { existe = true; break; }
            }
            if (!existe) clientesSinRepetir.add(c);
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CLIENTES))) {
            oos.writeObject(clientesSinRepetir);
            mostrarResultado("✅ Archivo de clientes generado.\nArchivo: " + ARCHIVO_CLIENTES +
                    "\nClientes guardados: " + clientesSinRepetir.size());
            actualizarEstado("Archivo " + ARCHIVO_CLIENTES + " generado.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar clientes: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void recuperarClientesDesdeArchivoObjetos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_CLIENTES))) {
            datosClientes.clear();
            datosClientes = (ArrayList<Cliente>) ois.readObject();
            StringBuilder sb = new StringBuilder("✅ Clientes recuperados: " + datosClientes.size() + "\n\n");
            for (Cliente c : datosClientes) sb.append(c.toString()).append("\n");
            mostrarResultado(sb.toString());
            actualizarEstado("Clientes cargados desde " + ARCHIVO_CLIENTES);
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar clientes: " + e.getMessage());
        }
    }

    // ======================== MÉTODOS GUI ========================

    private void crearNuevaVenta() { crearNuevaVenta(datosVentas); }

    private void consultarPorNumero() {
        String input = JOptionPane.showInputDialog(this, "Número de venta:");
        if (input == null) return;
        try {
            int num = Integer.parseInt(input.trim());
            mostrarResultado(consultarVentaDadoNumero(datosVentas, num));
        } catch (NumberFormatException e) { JOptionPane.showMessageDialog(this, "Número inválido."); }
    }

    private void consultarPorPosicion() {
        String[] opciones = {"P - Primera", "U - Última"};
        String sel = (String) JOptionPane.showInputDialog(this, "Seleccione posición:",
                "Consultar por Posición", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        if (sel == null) return;
        mostrarResultado(consultarVentaDadaPosicion(datosVentas, sel.charAt(0)));
    }

    private void consultarPorEstado() {
        String[] opciones = {"A - Activa", "C - Cancelada/Anulada", "P - Pago Asociado"};
        String sel = (String) JOptionPane.showInputDialog(this, "Seleccione estado:",
                "Consultar por Estado", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        if (sel == null) return;
        mostrarResultado(consultarVentasDadoEstado(datosVentas, sel.charAt(0)));
    }

    private void actualizarVentaGUI() {
        String input = JOptionPane.showInputDialog(this, "Número de venta a actualizar:");
        if (input == null) return;
        try {
            int num = Integer.parseInt(input.trim());
            String[] ops = {"C - Cancelar", "P - Pagar"};
            String op = (String) JOptionPane.showInputDialog(this, "Operación:",
                    "Actualizar Venta", JOptionPane.PLAIN_MESSAGE, null, ops, ops[0]);
            if (op == null) return;
            actualizarVenta(datosVentas, num, op.charAt(0));
        } catch (NumberFormatException e) { JOptionPane.showMessageDialog(this, "Número inválido."); }
    }

    private void mostrarResultado(String texto) {
        areaResultado.setText(texto);
        areaResultado.setCaretPosition(0);
    }

    private void actualizarEstado(String msg) {
        lblEstado.setText("  " + msg);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { /* usar default */ }
        SwingUtilities.invokeLater(() -> new UsaGUIVenta().setVisible(true));
    }
}