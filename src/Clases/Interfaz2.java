/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexiones.Procedimientos;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ricardo
 */
public class Interfaz2 extends javax.swing.JFrame {

    static ResultSet res;
    int cont;

    public void cargarViaje() {
        DefaultTableModel modelo = (DefaultTableModel) tablaProgramacion.getModel();
        modelo.setRowCount(0);
        res = Conexiones.Conexion.Consulta("select V.Id_Viaje,V.EstadoOrigen,V.CiudadOrigen,V.EstadoDestino,V.CiudadDestino,V.Fecha,V.Hora_Partida,TV.Id_Tripulacion,CV.Id_Autobus from Viaje as V join Trip_Viaje as TV on V.Id_Viaje=TV.Id_Viaje join Camion_Viaje as CV on CV.Id_Viaje=V.Id_Viaje");
        try {
            while (res.next()) {
                Vector v = new Vector();
                v.add(res.getInt(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                v.add(res.getString(5));
                v.add(res.getString(6));
                v.add(res.getString(7));
                v.add(res.getInt(8));
                v.add(res.getInt(9));
                modelo.addRow(v);
                tablaProgramacion.setModel(modelo);
            }
        } catch (SQLException e) {
        }
    }

    public void cargarEmpleados() {
        DefaultTableModel modelo4 = (DefaultTableModel) tablaEmpleados.getModel();
        modelo4.setRowCount(0);
        res = Conexiones.Conexion.Consulta("select * from Empleado");
        try {
            while (res.next()) {
                Vector v = new Vector();
                v.add(res.getInt(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getInt(4));
                v.add(res.getInt(5));
                modelo4.addRow(v);
                tablaEmpleados.setModel(modelo4);
            }
        } catch (SQLException e) {
        }
    }

    public void cargarAutobus() {
        DefaultTableModel modelo2 = (DefaultTableModel) tablaAutobus.getModel();
        modelo2.setRowCount(0);
        res = Conexiones.Conexion.Consulta("select * from Autobus");
        try {
            while (res.next()) {
                Vector v = new Vector();
                v.add(res.getInt(1));
                v.add(res.getString(2));
                v.add(res.getInt(3));
                v.add(res.getInt(4));
                v.add(res.getString(5));
                v.add(res.getInt(6));
                modelo2.addRow(v);
                tablaAutobus.setModel(modelo2);
            }
        } catch (SQLException e) {
        }
    }

    public void cargarTipoDeAutobus() {
        res = Conexiones.Conexion.Consulta("select * from TipoAutobus");
        try {
            while (res.next()) {
                comboTipoAutobus.addItem("" + res.getInt(1));
            }
        } catch (SQLException e) {
        }
    }

    public void cargarTipoDeEmpleados() {
        res = Conexiones.Conexion.Consulta("select * from TipoEmpleado");
        try {
            while (res.next()) {
                comboTipoEmpleado.addItem("" + res.getInt(1));
            }
        } catch (SQLException e) {
        }
    }

    public void cargarTripulaciones() {
        res = Conexiones.Conexion.Consulta("select * from Tripulacion");
        try {
            while (res.next()) {
                comboTripulacion.addItem("" + res.getInt(1));
            }
        } catch (SQLException e) {
        }
    }

    public void cargarAutobuses() {
        res = Conexiones.Conexion.Consulta("select * from Autobus");
        try {
            while (res.next()) {
                comboAutobus.addItem("" + res.getInt(1));
            }
        } catch (SQLException e) {
        }
    }

    public void cargarAgencias() {
        res = Conexiones.Conexion.Consulta("select * from Agencia");
        try {
            while (res.next()) {
                comboAgencia.addItem("" + res.getInt(1));
            }
        } catch (SQLException e) {
        }
    }

    public void cargarEmpleadosACombo() {
        res = Conexiones.Conexion.Consulta("select * from Empleado where Tipo_Empleado=1");
        try {
            while (res.next()) {
                comboChofer.addItem("" + res.getInt(1));
            }
        } catch (SQLException e) {
        }
        res = Conexiones.Conexion.Consulta("select * from Empleado where Tipo_Empleado=2");
        try {
            while (res.next()) {
                comboCopiloto.addItem("" + res.getInt(1));
            }
        } catch (SQLException e) {
        }
        res = Conexiones.Conexion.Consulta("select * from Empleado where Tipo_Empleado=3");
        try {
            while (res.next()) {
                comboTerramoza.addItem("" + res.getInt(1));
            }
        } catch (SQLException e) {
        }
    }

    public void cargarTripulacion() {
        DefaultTableModel modelo3 = (DefaultTableModel) tablaTripulacion.getModel();
        modelo3.setRowCount(0);
        res = Conexiones.Conexion.Consulta("select * from Tripulacion");
        try {
            while (res.next()) {
                Vector v = new Vector();
                v.add(res.getInt(1));
                v.add(res.getInt(2));
                v.add(res.getInt(3));
                v.add(res.getInt(4));
                modelo3.addRow(v);
                tablaTripulacion.setModel(modelo3);
            }
        } catch (SQLException e) {
        }
    }
    
    public void cargarCamiones(){
        DefaultTableModel modelo4 = (DefaultTableModel) tablaCamiones.getModel();
        modelo4.setRowCount(0);
        res = Conexiones.Conexion.Consulta("select * from CamionCarga");
        try {
            while (res.next()) {
                Vector v = new Vector();
                v.add(res.getInt(1));
                v.add(res.getString(2));
                v.add(res.getInt(3));
                modelo4.addRow(v);
                tablaCamiones.setModel(modelo4);
            }
        } catch (SQLException e) {
        }
    }

    public Interfaz2() {
        initComponents();
        cargarViaje();
        cargarAutobus();
        cargarEmpleadosACombo();
        cargarTipoDeAutobus();
        cargarTipoDeEmpleados();
        cargarAgencias();
        cargarEmpleados();
        cargarTripulacion();
        cargarTripulaciones();
        cargarAutobuses();
        cargarCamiones();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        tabbedPane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textEdoOrigen = new javax.swing.JTextField();
        textCdOrigen = new javax.swing.JTextField();
        textFecha = new javax.swing.JTextField();
        textEdoDestino = new javax.swing.JTextField();
        textCdDestino = new javax.swing.JTextField();
        textHora = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProgramacion = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        comboAutobus = new javax.swing.JComboBox<>();
        comboTripulacion = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        textMarca = new javax.swing.JTextField();
        textAsientos = new javax.swing.JTextField();
        textCapacidad = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaAutobus = new javax.swing.JTable();
        comboTipoAutobus = new javax.swing.JComboBox<>();
        comboProgramable = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        comboChofer = new javax.swing.JComboBox<>();
        comboCopiloto = new javax.swing.JComboBox<>();
        comboTerramoza = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaTripulacion = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        comboTipoEmpleado = new javax.swing.JComboBox<>();
        comboAgencia = new javax.swing.JComboBox<>();
        textNombre = new javax.swing.JTextField();
        textApellidos = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        textMarca2 = new javax.swing.JTextField();
        textCapacidad2 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaCamiones = new javax.swing.JTable();
        barraMenu = new javax.swing.JMenuBar();
        botonInicio = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu1.setText("jMenu1");

        jMenuItem3.setText("jMenuItem3");

        jMenu2.setText("jMenu2");

        jMenuItem4.setText("jMenuItem4");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Programación de Viajes");

        jLabel2.setText("Ciudad de Origen:");

        jLabel3.setText("Estado de Origen:");

        jLabel4.setText("Fecha:");

        jLabel5.setText("Ciudad de Destino:");

        jLabel6.setText("Estado de Destino:");

        jLabel7.setText("Hora de Partida:");

        textEdoOrigen.setMinimumSize(new java.awt.Dimension(120, 25));
        textEdoOrigen.setPreferredSize(new java.awt.Dimension(120, 25));
        textEdoOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEdoOrigenActionPerformed(evt);
            }
        });
        textEdoOrigen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textEdoOrigenKeyPressed(evt);
            }
        });

        textCdOrigen.setMinimumSize(new java.awt.Dimension(120, 25));
        textCdOrigen.setPreferredSize(new java.awt.Dimension(120, 25));
        textCdOrigen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textCdOrigenKeyPressed(evt);
            }
        });

        textFecha.setMinimumSize(new java.awt.Dimension(120, 25));
        textFecha.setPreferredSize(new java.awt.Dimension(120, 25));
        textFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textFechaKeyPressed(evt);
            }
        });

        textEdoDestino.setMinimumSize(new java.awt.Dimension(120, 25));
        textEdoDestino.setPreferredSize(new java.awt.Dimension(120, 25));
        textEdoDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEdoDestinoActionPerformed(evt);
            }
        });
        textEdoDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textEdoDestinoKeyPressed(evt);
            }
        });

        textCdDestino.setMinimumSize(new java.awt.Dimension(120, 25));
        textCdDestino.setPreferredSize(new java.awt.Dimension(120, 25));
        textCdDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textCdDestinoKeyPressed(evt);
            }
        });

        textHora.setMinimumSize(new java.awt.Dimension(120, 25));
        textHora.setPreferredSize(new java.awt.Dimension(120, 25));

        tablaProgramacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Estado Origen", "Ciudad Origen", "Estado Destino", "Ciudad Destino", "Fecha", "Hora Salida", "Tripulación", "Autobus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProgramacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProgramacionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProgramacion);

        jLabel23.setText("Autobus");

        jLabel24.setText("Tripulación");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 108, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(214, 214, 214))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textCdOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(textEdoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboTripulacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textEdoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(comboAutobus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textHora, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textCdDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel23)))
                                .addGap(100, 100, 100))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(textEdoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(textCdDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(textHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textEdoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textCdOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(textFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboAutobus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTripulacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        tabbedPane.addTab("Programación de Viajes", jPanel2);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Registro de Autobuses");

        jLabel9.setText("Marca:");

        jLabel10.setText("Asientos Disponibles:");

        jLabel11.setText("Capacidad:");

        jLabel12.setText("Estado programable");

        jLabel13.setText("Tipo de autobus");

        textMarca.setMinimumSize(new java.awt.Dimension(120, 25));
        textMarca.setPreferredSize(new java.awt.Dimension(120, 25));
        textMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMarcaActionPerformed(evt);
            }
        });
        textMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textMarcaKeyPressed(evt);
            }
        });

        textAsientos.setMinimumSize(new java.awt.Dimension(120, 25));
        textAsientos.setPreferredSize(new java.awt.Dimension(120, 25));
        textAsientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAsientosActionPerformed(evt);
            }
        });
        textAsientos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textAsientosKeyPressed(evt);
            }
        });

        textCapacidad.setMinimumSize(new java.awt.Dimension(120, 25));
        textCapacidad.setPreferredSize(new java.awt.Dimension(120, 25));

        tablaAutobus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Marca", "Asientos Disponibles", "Capacidad", "Estado Programable", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaAutobus.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaAutobus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAutobusMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaAutobus);

        comboProgramable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        comboProgramable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProgramableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboTipoAutobus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboProgramable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8))
                .addGap(172, 172, 172))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(textMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboProgramable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(textAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTipoAutobus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        tabbedPane.addTab("Registro de Autobuses", jPanel3);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setText("Registro de Tripulación");

        jLabel15.setText("Chofer");

        jLabel16.setText("Copiloto");

        jLabel17.setText("Terramoza");

        tablaTripulacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Tripulación", "ID Chofer", "ID Copiloto", "ID Terramoza"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaTripulacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTripulacionMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaTripulacion);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(comboCopiloto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(153, 153, 153)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboTerramoza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(139, 139, 139))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCopiloto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTerramoza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Registro de Tripulacion", jPanel4);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setText("Registro de Empleados");

        jLabel19.setText("Nombre:");

        jLabel20.setText("Apellidos:");

        jLabel21.setText("Tipo de Empeleado");

        jLabel22.setText("Agencia");

        textNombre.setMinimumSize(new java.awt.Dimension(120, 25));
        textNombre.setPreferredSize(new java.awt.Dimension(120, 25));
        textNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textNombreKeyPressed(evt);
            }
        });

        textApellidos.setMinimumSize(new java.awt.Dimension(120, 25));
        textApellidos.setPreferredSize(new java.awt.Dimension(120, 25));

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellidos", "Tipo de Empleado", "Agencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tablaEmpleados);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(138, 138, 138)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(comboTipoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(229, 229, 229))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(textApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboTipoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Registro de Empleados", jPanel5);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel25.setText("Registro de Camiones de Carga");

        jLabel26.setText("Marca:");

        jLabel27.setText("Capacidad:");

        textMarca2.setMinimumSize(new java.awt.Dimension(120, 25));
        textMarca2.setPreferredSize(new java.awt.Dimension(120, 25));
        textMarca2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMarca2ActionPerformed(evt);
            }
        });

        textCapacidad2.setMinimumSize(new java.awt.Dimension(120, 25));
        textCapacidad2.setPreferredSize(new java.awt.Dimension(120, 25));

        tablaCamiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Marca", "Capacidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCamiones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCamionesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tablaCamiones);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(184, 184, 184))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(textMarca2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textCapacidad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(211, 211, 211))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(textMarca2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCapacidad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Registro de Camiones de Carga", jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );

        botonInicio.setText("Inicio");
        barraMenu.add(botonInicio);

        jMenu4.setText("Opciones");

        jMenuItem5.setText("Guardar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuItem6.setText("Actualizar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        barraMenu.add(jMenu4);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        switch (tabbedPane.getSelectedIndex()) {
            case 0:
                if (textEdoOrigen.getText().isEmpty() || textCdOrigen.getText().isEmpty()
                        || textEdoDestino.getText().isEmpty() || textCdDestino.getText().isEmpty()
                        || textFecha.getText().isEmpty() || textHora.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Hay campos vacios\nIntentelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
                    textEdoOrigen.requestFocus();
                    textCdOrigen.requestFocus();
                    textEdoDestino.requestFocus();
                    textCdDestino.requestFocus();
                    textFecha.requestFocus();
                    textHora.requestFocus();
                } else {
                    try {
                        Procedimientos.ingresarViaje(textCdOrigen.getText(), textEdoOrigen.getText(),
                                textCdDestino.getText(), textEdoDestino.getText(), textFecha.getText(),
                                textHora.getText(), comboTripulacion.getSelectedItem().toString(), comboAutobus.getSelectedItem().toString());
                        textEdoOrigen.setText("");
                        textCdOrigen.setText("");
                        textEdoDestino.setText("");
                        textCdDestino.setText("");
                        textFecha.setText("");
                        textHora.setText("");
                        textEdoDestino.requestFocus();
                        cargarViaje();
                    } catch (SQLException e) {
                        System.out.println("error1" + e.getMessage());
                    }
                }
                break;
            case 1:
                if (textAsientos.getText().isEmpty() || textCapacidad.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Hay campos vacios\nIntentelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
                    textAsientos.requestFocus();
                    textCapacidad.requestFocus();
                } else {
                    try {
                        Procedimientos.ingresarAutobus(textMarca.getText(), textAsientos.getText(),
                                textCapacidad.getText(), comboProgramable.getSelectedItem().toString(), comboTipoAutobus.getSelectedItem().toString());
                        textMarca.setText("");
                        textAsientos.setText("");
                        textCapacidad.setText("");
                        comboProgramable.setSelectedIndex(0);
                        cargarAutobus();
                        cargarAutobuses();
                    } catch (SQLException e) {
                        System.out.println("error2" + e.getMessage());
                    }
                }
                break;
            case 2:
                try {
                    Procedimientos.ingresarTripulacion(comboChofer.getSelectedItem().toString(), comboCopiloto.getSelectedItem().toString(),
                            comboTerramoza.getSelectedItem().toString());
                    cargarTripulacion();
                    cargarTripulaciones();
                } catch (SQLException e) {
                    System.out.println("error3" + e.getMessage());
                }
                break;
            case 3:
                if (textNombre.getText().isEmpty() || textApellidos.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Hay campos vacios\nIntentelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
                    textNombre.requestFocus();
                    textApellidos.requestFocus();
                } else {
                    try {
                        Procedimientos.ingresarEmpleado(textNombre.getText(), textApellidos.getText(),
                                comboTipoEmpleado.getSelectedItem().toString(), comboAgencia.getSelectedItem().toString());
                        textNombre.setText("");
                        textApellidos.setText("");
                        comboTipoEmpleado.setSelectedIndex(0);
                        comboAgencia.setSelectedIndex(0);
                        cargarEmpleados();
                        cargarEmpleadosACombo();
                    } catch (SQLException e) {
                        System.out.println("error4" + e.getMessage());
                    }
                }
                break;
            case 4:
                if (textMarca2.getText().isEmpty() || textCapacidad2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Hay campos vacios\nIntentelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
                    textMarca2.requestFocus();
                    textCapacidad2.requestFocus();
                } else {
                    try {
                        Procedimientos.ingresarCamion(textMarca2.getText(), textCapacidad2.getText());
                        textMarca2.setText("");
                        textCapacidad2.setText("");
                        cargarCamiones();
                    } catch (SQLException e) {
                        System.out.println("error4" + e.getMessage());
                    }
                }               
            default:
                break;
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void textAsientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAsientosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textAsientosActionPerformed

    private void textMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMarcaActionPerformed

    private void textEdoDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEdoDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEdoDestinoActionPerformed

    private void textEdoOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEdoOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEdoOrigenActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        switch (tabbedPane.getSelectedIndex()) {
            case 0:
                try {
                    int r = tablaProgramacion.getSelectedRow();
                    String id = tablaProgramacion.getModel().getValueAt(r, 0).toString();
                    Procedimientos.actualizarViaje(id, textCdOrigen.getText(), textEdoOrigen.getText(),
                            textCdDestino.getText(), textEdoDestino.getText(), textFecha.getText(),
                            textHora.getText(), comboTripulacion.getSelectedItem().toString(), comboAutobus.getSelectedItem().toString());
                    textEdoOrigen.setText("");
                    textCdOrigen.setText("");
                    textEdoDestino.setText("");
                    textCdDestino.setText("");
                    textFecha.setText("");
                    textHora.setText("");
                    textEdoDestino.requestFocus();
                    comboTripulacion.setSelectedIndex(0);
                    comboAutobus.setSelectedIndex(0);
                    cargarViaje();
                } catch (Exception e) {

                }
                break;
            case 1:
                try {
                    int r = tablaAutobus.getSelectedRow();
                    String id = tablaAutobus.getModel().getValueAt(r, 0).toString();
                    PreparedStatement pps = Conexiones.Conexion.getConexion().prepareStatement("update Autobus set Marca='"
                            + textMarca.getText() + "',AsientosDisponibles=" + textAsientos.getText() + ",Capacidad=" + textCapacidad.getText()
                            + ",Programable='" + comboProgramable.getSelectedItem().toString() + "',Tipo_Autobus=" + comboTipoAutobus.getSelectedItem().toString() + " where Id_Autobus=" + id);
                    pps.executeUpdate();
                    pps.close();
                    textMarca.setText("");
                    textAsientos.setText("");
                    textCapacidad.setText("");
                    comboProgramable.setSelectedIndex(0);
                    comboTipoAutobus.setSelectedIndex(0);
                    cargarAutobus();
                } catch (Exception e) {
                    System.out.println("error en actualizar");
                }
                break;
            case 2:
                try {
                    int r = tablaTripulacion.getSelectedRow();
                    String id = tablaTripulacion.getModel().getValueAt(r, 0).toString();
                    PreparedStatement pps = Conexiones.Conexion.getConexion().prepareStatement("update Tripulacion set Id_Chofer="
                            + comboChofer.getSelectedItem().toString() + ",Id_Copiloto=" + comboCopiloto.getSelectedItem().toString()
                            + ",Id_Terramoza=" + comboTerramoza.getSelectedItem().toString() + " where Id_Tripulacion=" + id);
                    pps.executeUpdate();
                    pps.close();
                    comboChofer.setSelectedIndex(0);
                    comboCopiloto.setSelectedIndex(0);
                    comboTerramoza.setSelectedIndex(0);
                    cargarTripulacion();
                } catch (Exception e) {
                    System.out.println("error en actualizar");
                }
                break;
            case 3:
                try {
                    int r = tablaEmpleados.getSelectedRow();
                    String id = tablaEmpleados.getModel().getValueAt(r, 0).toString();
                    PreparedStatement pps = Conexiones.Conexion.getConexion().prepareStatement("update Empleado set Nombre='"
                            + textNombre.getText() + "',Apellidos='" + textApellidos.getText() + "',Tipo_Empleado=" + comboTipoEmpleado.getSelectedItem().toString()
                            + ",Id_Agencia=" + comboAgencia.getSelectedItem().toString() + " where Id_Empleado=" + id);
                    pps.executeUpdate();
                    pps.close();
                    textNombre.setText("");
                    textApellidos.setText("");
                    comboTipoEmpleado.setSelectedIndex(0);
                    comboAgencia.setSelectedIndex(0);
                    cargarEmpleados();
                } catch (Exception e) {
                    System.out.println("error en actualizar");
                }
                break;
            case 4:
                try {
                    int r = tablaCamiones.getSelectedRow();
                    String id = tablaCamiones.getModel().getValueAt(r, 0).toString();
                    PreparedStatement pps = Conexiones.Conexion.getConexion().prepareStatement("update CamionCarga set Marca='"
                            + textMarca2.getText() + "',Capacidad="+textCapacidad2.getText()+" where Id_Camion=" + id);
                    pps.executeUpdate();
                    pps.close();
                    textMarca2.setText("");
                    textCapacidad2.setText("");
                    cargarCamiones();
                } catch (Exception e) {
                    System.out.println("error en actualizar");
                }
                break;
            default:
                break;
        }

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void comboProgramableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProgramableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProgramableActionPerformed

    private void tablaAutobusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAutobusMouseClicked
        int r = tablaAutobus.getSelectedRow();
        textMarca.setText(tablaAutobus.getModel().getValueAt(r, 1).toString());
        textAsientos.setText(tablaAutobus.getModel().getValueAt(r, 2).toString());
        textCapacidad.setText(tablaAutobus.getModel().getValueAt(r, 3).toString());
        if (tablaAutobus.getModel().getValueAt(r, 4).toString().equals("SI")) {
            comboProgramable.setSelectedIndex(0);
        } else {
            comboProgramable.setSelectedIndex(1);
        }
        comboTipoAutobus.setSelectedItem((String) tablaAutobus.getModel().getValueAt(r, 5).toString());
    }//GEN-LAST:event_tablaAutobusMouseClicked

    private void tablaTripulacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTripulacionMouseClicked
        int r = tablaTripulacion.getSelectedRow();
        comboChofer.setSelectedItem((String) tablaTripulacion.getModel().getValueAt(r, 1).toString());
        comboCopiloto.setSelectedItem((String) tablaTripulacion.getModel().getValueAt(r, 2).toString());
        comboTerramoza.setSelectedItem((String) tablaTripulacion.getModel().getValueAt(r, 3).toString());
    }//GEN-LAST:event_tablaTripulacionMouseClicked

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
        int r = tablaEmpleados.getSelectedRow();
        textNombre.setText(tablaEmpleados.getModel().getValueAt(r, 1).toString());
        textApellidos.setText(tablaEmpleados.getModel().getValueAt(r, 2).toString());
        comboTipoEmpleado.setSelectedItem((String) tablaEmpleados.getModel().getValueAt(r, 3).toString());
        comboAgencia.setSelectedItem((String) tablaEmpleados.getModel().getValueAt(r, 4).toString());
    }//GEN-LAST:event_tablaEmpleadosMouseClicked

    private void tablaProgramacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProgramacionMouseClicked
        int r = tablaProgramacion.getSelectedRow();
        textEdoOrigen.setText(tablaProgramacion.getModel().getValueAt(r, 1).toString());
        textCdOrigen.setText(tablaProgramacion.getModel().getValueAt(r, 2).toString());
        textEdoDestino.setText(tablaProgramacion.getModel().getValueAt(r, 3).toString());
        textCdDestino.setText(tablaProgramacion.getModel().getValueAt(r, 4).toString());
        textFecha.setText(tablaProgramacion.getModel().getValueAt(r, 5).toString());
        textHora.setText(tablaProgramacion.getModel().getValueAt(r, 6).toString());
        comboTripulacion.setSelectedItem(tablaProgramacion.getModel().getValueAt(r, 7).toString());
        comboAutobus.setSelectedItem(tablaProgramacion.getModel().getValueAt(r, 8).toString());

    }//GEN-LAST:event_tablaProgramacionMouseClicked

    private void textEdoOrigenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textEdoOrigenKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            textCdOrigen.requestFocus();
        }
    }//GEN-LAST:event_textEdoOrigenKeyPressed

    private void textCdOrigenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCdOrigenKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            textEdoDestino.requestFocus();
        }
    }//GEN-LAST:event_textCdOrigenKeyPressed

    private void textEdoDestinoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textEdoDestinoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            textCdDestino.requestFocus();
        }
    }//GEN-LAST:event_textEdoDestinoKeyPressed

    private void textCdDestinoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCdDestinoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            textFecha.requestFocus();
        }
    }//GEN-LAST:event_textCdDestinoKeyPressed

    private void textFechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFechaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            textHora.requestFocus();
        }
    }//GEN-LAST:event_textFechaKeyPressed

    private void textMarcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMarcaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            textAsientos.requestFocus();
        }
    }//GEN-LAST:event_textMarcaKeyPressed

    private void textAsientosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAsientosKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            textCapacidad.requestFocus();
        }
    }//GEN-LAST:event_textAsientosKeyPressed

    private void textNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNombreKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            textApellidos.requestFocus();
        }
    }//GEN-LAST:event_textNombreKeyPressed

    private void textMarca2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMarca2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMarca2ActionPerformed

    private void tablaCamionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCamionesMouseClicked
        int r = tablaCamiones.getSelectedRow();
        textMarca2.setText(tablaCamiones.getModel().getValueAt(r, 1).toString());
        textCapacidad2.setText(tablaCamiones.getModel().getValueAt(r, 2).toString());
    }//GEN-LAST:event_tablaCamionesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenu botonInicio;
    private javax.swing.JComboBox<String> comboAgencia;
    private javax.swing.JComboBox<String> comboAutobus;
    private javax.swing.JComboBox<String> comboChofer;
    private javax.swing.JComboBox<String> comboCopiloto;
    private javax.swing.JComboBox<String> comboProgramable;
    private javax.swing.JComboBox<String> comboTerramoza;
    private javax.swing.JComboBox<String> comboTipoAutobus;
    private javax.swing.JComboBox<String> comboTipoEmpleado;
    private javax.swing.JComboBox<String> comboTripulacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tablaAutobus;
    private javax.swing.JTable tablaCamiones;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTable tablaProgramacion;
    private javax.swing.JTable tablaTripulacion;
    private javax.swing.JTextField textApellidos;
    private javax.swing.JTextField textAsientos;
    private javax.swing.JTextField textCapacidad;
    private javax.swing.JTextField textCapacidad2;
    private javax.swing.JTextField textCdDestino;
    private javax.swing.JTextField textCdOrigen;
    private javax.swing.JTextField textEdoDestino;
    private javax.swing.JTextField textEdoOrigen;
    private javax.swing.JTextField textFecha;
    private javax.swing.JTextField textHora;
    private javax.swing.JTextField textMarca;
    private javax.swing.JTextField textMarca2;
    private javax.swing.JTextField textNombre;
    // End of variables declaration//GEN-END:variables
}
