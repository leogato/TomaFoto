/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freelancersteam.www.java.tomafoto.vistas;

import com.freelancersteam.www.java.tomafoto.util.TablaUtil;

import com.freelancersteam.www.java.tomafoto.dominio.Asistencia;
import com.freelancersteam.www.java.tomafoto.dominio.Empleado;
import com.freelancersteam.www.java.tomafoto.util.OrdenarAsistenciaPorId;
import com.freelancersteam.www.java.tomafoto.dominio.dao.EmpleadoDao;
import com.freelancersteam.www.java.tomafoto.dominio.dao.imp.AsistenciaDaoImp;
import com.freelancersteam.www.java.tomafoto.dominio.dao.imp.EmpleadoDaoImp;
import com.freelancersteam.www.java.tomafoto.util.ReporteAsitenciaJRDataSource;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Leo
 */
public class ListadoPersonal extends javax.swing.JDialog {
    Set<Asistencia> conjunto;
    DefaultTableModel modelo;
    private Set<Asistencia> conjuntoAsistencia2=null;
    /**
     * Creates new form ListadoPersonal
     */
    public ListadoPersonal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //las fechas por defectos desabikitada porque rbtn  en fecha  actual
        dateInicio.setDate(new Date());
        dateFin.setDate(new Date());
        deshabilitarFechas();
        // por defecto el cmbBusqueda esta en Todos los empleados entonces inactivo txtbusqueda ybtnbusq
        inactivarBusqueda();
        rdbHoy.requestFocus();
        // pantalla se localice en el centro  de la pantalla
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelTranslucidoComplete21 = new org.edisoncor.gui.panel.PanelTranslucidoComplete2();
        labelMetric1 = new org.edisoncor.gui.label.LabelMetric();
        cmbBusqueda = new org.edisoncor.gui.comboBox.ComboBoxRound();
        txtBusqueda = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        panelShadow1 = new org.edisoncor.gui.panel.PanelShadow();
        rdbHoy = new javax.swing.JRadioButton();
        rdbMes = new javax.swing.JRadioButton();
        rdbFecha = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        dateInicio = new com.toedter.calendar.JDateChooser();
        dateFin = new com.toedter.calendar.JDateChooser();
        btnBuscar = new org.edisoncor.gui.button.ButtonIpod();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAsistencia = new org.jdesktop.swingx.JXTable();
        btnImprimir = new org.edisoncor.gui.button.ButtonIpod();
        btnIreport = new org.edisoncor.gui.button.ButtonIpod();
        btnSalir = new org.edisoncor.gui.button.ButtonIpod();
        btnBusquedaPersonal = new org.edisoncor.gui.button.ButtonIcon();
        buttonIpod1 = new org.edisoncor.gui.button.ButtonIpod();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelTranslucidoComplete21.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GESTOR DE ASISTENCIAS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 28))); // NOI18N
        panelTranslucidoComplete21.setOpaque(false);

        labelMetric1.setText("Busqueda");

        cmbBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODO LOS EMPLEADOS", "LEGAJO" }));
        cmbBusqueda.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        cmbBusqueda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbBusquedaItemStateChanged(evt);
            }
        });
        cmbBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBusquedaActionPerformed(evt);
            }
        });

        panelShadow1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FILTRO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        panelShadow1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rdbHoy);
        rdbHoy.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        rdbHoy.setSelected(true);
        rdbHoy.setText("Hoy");
        rdbHoy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbHoyActionPerformed(evt);
            }
        });
        panelShadow1.add(rdbHoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        buttonGroup1.add(rdbMes);
        rdbMes.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        rdbMes.setText("Mes Actual");
        rdbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbMesActionPerformed(evt);
            }
        });
        panelShadow1.add(rdbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        rdbFecha.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdbFecha);
        rdbFecha.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        rdbFecha.setText("Entre las Fechas");
        rdbFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbFechaActionPerformed(evt);
            }
        });
        panelShadow1.add(rdbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setText("Y");
        panelShadow1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, -1, -1));

        dateInicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dateInicio.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        dateInicio.setMaxSelectableDate(new Date());
        panelShadow1.add(dateInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 130, -1));

        dateFin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dateFin.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        dateFin.setMaxSelectableDate(new Date());
        panelShadow1.add(dateFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 130, -1));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freelancersteam/www/java/tomafoto/images/BUSCAR2.jpg"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblAsistencia.setBackground(new java.awt.Color(204, 204, 204));
        tblAsistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LEGAJO", "EMPLEADO", "ESTADO", "FECHA", "HORA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAsistencia.setGridColor(new java.awt.Color(255, 255, 255));
        tblAsistencia.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tblAsistencia.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblAsistencia.setShowGrid(false);
        jScrollPane1.setViewportView(tblAsistencia);

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freelancersteam/www/java/tomafoto/images/Informe.jpg"))); // NOI18N
        btnImprimir.setText("INFORME");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnIreport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freelancersteam/www/java/tomafoto/images/PDF1.png"))); // NOI18N
        btnIreport.setText("PDF");
        btnIreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIreportActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freelancersteam/www/java/tomafoto/images/SALIR.jpg"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnBusquedaPersonal.setBackground(java.awt.SystemColor.controlDkShadow);
        btnBusquedaPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freelancersteam/www/java/tomafoto/images/binoculares.jpg"))); // NOI18N
        btnBusquedaPersonal.setText("buttonIcon1");
        btnBusquedaPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaPersonalActionPerformed(evt);
            }
        });

        buttonIpod1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/freelancersteam/www/java/tomafoto/images/modificar.png"))); // NOI18N
        buttonIpod1.setText("Modificar");

        javax.swing.GroupLayout panelTranslucidoComplete21Layout = new javax.swing.GroupLayout(panelTranslucidoComplete21);
        panelTranslucidoComplete21.setLayout(panelTranslucidoComplete21Layout);
        panelTranslucidoComplete21Layout.setHorizontalGroup(
            panelTranslucidoComplete21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucidoComplete21Layout.createSequentialGroup()
                .addGroup(panelTranslucidoComplete21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTranslucidoComplete21Layout.createSequentialGroup()
                        .addGroup(panelTranslucidoComplete21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTranslucidoComplete21Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(cmbBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBusquedaPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTranslucidoComplete21Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(228, 228, 228)
                                .addComponent(btnIreport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(228, 228, 228)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 52, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTranslucidoComplete21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelTranslucidoComplete21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTranslucidoComplete21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonIpod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panelTranslucidoComplete21Layout.setVerticalGroup(
            panelTranslucidoComplete21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucidoComplete21Layout.createSequentialGroup()
                .addGroup(panelTranslucidoComplete21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTranslucidoComplete21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBusquedaPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTranslucidoComplete21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(panelTranslucidoComplete21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelTranslucidoComplete21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTranslucidoComplete21Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTranslucidoComplete21Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(buttonIpod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTranslucidoComplete21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTranslucidoComplete21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnIreport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTranslucidoComplete21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTranslucidoComplete21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIreportActionPerformed
             // validar el empleado
   EmpleadoDao empleados = new EmpleadoDaoImp();
   List<Empleado> lisaEmpleado = empleados.listarEmpleado();
   boolean encontrado = false;
   Empleado e = null ;
   for ( Empleado empleado : lisaEmpleado) {
       if (empleado.getLegajo()==Integer.parseInt(txtBusqueda.getText())) {
           encontrado = true;
           e =empleado;
           break;
       }
   } 
                                       
    }//GEN-LAST:event_btnIreportActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
      // este conjunto auxiliar contindra los datos q se mostrara a la tabla
      Set<Asistencia> conjuntoAsistencia= new HashSet<Asistencia>();
     // Set<Asistencia> conjuntoAsistencia= null;
         
        if (cmbBusqueda.getSelectedIndex()==1) {
           //busqueda empleado por legajo
            EmpleadoDaoImp empleados = new EmpleadoDaoImp();
            Empleado  e = empleados.getEmpleado(Integer.parseInt(txtBusqueda.getText()));
           
            if (e!=null) {
              // si exite el empleado entonces extraigo su conjunto de asistenica
              conjuntoAsistencia= e.getAsistencias();
                      
            }else{
            JOptionPane.showMessageDialog(this, "No existe el empleado","Error",JOptionPane.ERROR_MESSAGE);

            }
        } else {
              // Busqueda asistencias de todos los empleados
              AsistenciaDaoImp asistencias = new AsistenciaDaoImp();
              List<Asistencia> listaAsistencia = asistencias.listarAsistencia();
              conjuntoAsistencia = new HashSet<Asistencia>(listaAsistencia);
              //System.out.println(conjuntoAsistencia.size());

            }
           
            //filtrao por año
            conjuntoAsistencia = com.freelancersteam.www.java.tomafoto.util.AsistenciaUtil.getAsistenciasFiltradoPorAño(conjuntoAsistencia, dateInicio.getDate(), dateFin.getDate());
             
            //filtrado por mes
            conjuntoAsistencia = com.freelancersteam.www.java.tomafoto.util.AsistenciaUtil.getAsistenciasFiltradoPorMes(conjuntoAsistencia, dateInicio.getDate(), dateFin.getDate());
                        
              //filtrado por dia
            conjuntoAsistencia = com.freelancersteam.www.java.tomafoto.util.AsistenciaUtil.getAsistenciasFiltradoPorDia(conjuntoAsistencia, dateInicio.getDate(), dateFin.getDate());
            
           
           // creo un conjunto nuevo pero agregandolo un comparador para que ordene por idAsistencia a los datos
           conjunto = new TreeSet<Asistencia>(new OrdenarAsistenciaPorId());
           conjunto.addAll(conjuntoAsistencia);
           //muestro en la tabla
           TablaUtil.prepararTablaAsistencia(modelo, tblAsistencia); 
           TablaUtil.cargarModeloAsistencia(modelo,conjunto , tblAsistencia);
                      
    }//GEN-LAST:event_btnBuscarActionPerformed
   
    private void btnBusquedaPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaPersonalActionPerformed
        // instanceo la ventana a donde quiero ir
        BusquedaPersonal ventanaPersonal = new BusquedaPersonal(null, true);
        if (ventanaPersonal.isBotonSeleccionado()) {
            // si el usuario selecciono un empleado
            txtBusqueda.setText(String.valueOf(ventanaPersonal.getLegajo()));
            //borro el contenido anterior de la tabla 
            com.freelancersteam.www.java.tomafoto.util.TablaUtil.prepararTablaAsistencia(modelo, tblAsistencia);
            // el foco estar en el radiobotn hoy
            rdbHoy.requestFocus();
        }
    }//GEN-LAST:event_btnBusquedaPersonalActionPerformed

    private void rdbFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbFechaActionPerformed
        if (rdbFecha.isSelected())
        {
            habilitarFechas();
            
        }
    }//GEN-LAST:event_rdbFechaActionPerformed

    private void rdbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbMesActionPerformed
        if (rdbMes.isSelected())
        {
            dateInicio.setDate(new Date(new Date().getYear(),new Date().getMonth(),1));
            dateFin.setDate(new Date());
            deshabilitarFechas();
            
        }
    }//GEN-LAST:event_rdbMesActionPerformed

    private void rdbHoyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbHoyActionPerformed
        if (rdbHoy.isSelected())
        {
            dateInicio.setDate(new Date());
            dateFin.setDate(new Date());
            deshabilitarFechas();
            
        }
    }//GEN-LAST:event_rdbHoyActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       this.dispose();
       
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cmbBusquedaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbBusquedaItemStateChanged
     
   
    }//GEN-LAST:event_cmbBusquedaItemStateChanged

    private void inactivarBusqueda(){
         // dejar no editable el txtbusqueda y no activo el boton busqueda
        txtBusqueda.setEditable(false);
        //borro el contendido de la caja de texto
        txtBusqueda.setText("");
        txtBusqueda.setBackground(Color.DARK_GRAY);
      
        btnBusquedaPersonal.setEnabled(false);
    }
    private void activarBusqueda(){
       txtBusqueda.setEditable(true);
       //obtnego el foco
       txtBusqueda.requestFocus();
       //cambio el color
       txtBusqueda.setBackground(Color.white);
       btnBusquedaPersonal.setEnabled(true);
         
    }
    private void cmbBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBusquedaActionPerformed
       if (cmbBusqueda.getSelectedIndex()==1) {
            // busqueda de empleado por legajo
            activarBusqueda();
        } else {
              // todos los empleados
                inactivarBusqueda();
            }
        
        
        
    }//GEN-LAST:event_cmbBusquedaActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // GENERAR LA VISTA PREVIA CON IREPORT
        
        List<Asistencia> listaAsistencia = new ArrayList<Asistencia>(conjunto);
        ReporteAsitenciaJRDataSource dataSource = new ReporteAsitenciaJRDataSource();
        dataSource.setListAsistencia(listaAsistencia); 
           JasperPrint jPrintt;
           JDialog reporte = new JDialog();
            reporte.setSize(900, 700);
            reporte.setLocationRelativeTo(null);
            reporte.setTitle("INFORME");
           //  JasperReport lreporte = (JasperReport) JRLoader.loadObject("reportes/reporteAsistencia.jasper");
        try {
            // jPrint = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("reportes/reporteAsistencia.jasper"),null, new JRBeanCollectionDataSource(listaAs));
            jPrintt = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("com/freelancersteam/www/java/tomafoto/reportes/reporteAsistencia.jasper"),null, dataSource);
            JRViewer jv = new JRViewer(jPrintt);
            reporte.getContentPane().add(jv);
            reporte.setVisible(true);
        
        } catch (JRException ex) {
            Logger.getLogger(Camara.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(ListadoPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListadoPersonal dialog = new ListadoPersonal(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonIpod btnBuscar;
    private org.edisoncor.gui.button.ButtonIcon btnBusquedaPersonal;
    private org.edisoncor.gui.button.ButtonIpod btnImprimir;
    private org.edisoncor.gui.button.ButtonIpod btnIreport;
    private org.edisoncor.gui.button.ButtonIpod btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.edisoncor.gui.button.ButtonIpod buttonIpod1;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbBusqueda;
    private com.toedter.calendar.JDateChooser dateFin;
    private com.toedter.calendar.JDateChooser dateInicio;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.label.LabelMetric labelMetric1;
    private org.edisoncor.gui.panel.PanelShadow panelShadow1;
    private org.edisoncor.gui.panel.PanelTranslucidoComplete2 panelTranslucidoComplete21;
    private javax.swing.JRadioButton rdbFecha;
    private javax.swing.JRadioButton rdbHoy;
    private javax.swing.JRadioButton rdbMes;
    private org.jdesktop.swingx.JXTable tblAsistencia;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtBusqueda;
    // End of variables declaration//GEN-END:variables
private void habilitarFechas()
{
    dateInicio.setEnabled(true);
    dateFin.setEnabled(true);
    
}
private void deshabilitarFechas()
{
    dateInicio.setEnabled(false);
    dateFin.setEnabled(false);
}
}