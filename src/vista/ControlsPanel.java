/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controller.ChangeEvent;
import controller.ClickEvent;
import controller.InitialData;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.usuario;
import modelo.vehiculo;
import modelo.conductor;
import modelo.viaje;
/**
 *
 * @author casierrav
 */
public class ControlsPanel extends JPanel {
 
    private JLabel                       lblUsuario;
    private JComboBox<usuario>           cbxUsuarioList;
    private JLabel                       lblVehiculo;
    private JComboBox<vehiculo>          cbxVehiculoList;
    private JLabel                       lblName;
    private JTextField                   txtName;
    private JButton                      btnSearch;
    private JButton                      btnAddArtPiece;
    private JTable                       tblResults;
    
    /**
     * Constructor of the ControlsPanel class.
     * @param resultsPanel
     */
    public ControlsPanel(ResultsPanel resultsPanel){
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
    }
    
    
    /**
     * 
     */
    private void initComponents(){
        setLayout(new GridLayout(2,1));
        InitialData initialData = new InitialData();
        
        // Complete ArtPieces info
        this.setTblResults(initialData.getArtPieces());
        
        // Usuario selection
        this.lblUsuario = new JLabel("Usuarios");
        add(this.getLblUsuario());
        
        this.cbxUsuarioList = new JComboBox();
        this.cbxUsuarioList.setModel(new DefaultComboBoxModel<>(initialData.getUsuarioByCc.toArray(new usuario[initialData.getUsuarioByCc.size()])));
        this.cbxUsuarioList.setSelectedIndex(0);
        add(this.getCbxUsuarioList());
        
        ChangeEvent changeEvent = new ChangeEvent(this);
        this.getCbxUsuarioList().addActionListener(changeEvent);
        
        
        // Vehiculo selection
        this.lblVehiculo = new JLabel("Vehiculo");
        add(this.getLblVehiculo());
        
        this.cbxVehiculoList = new JComboBox();
        this.setCbxPresentationsList(initialData.getPresentations());
        add(this.getCbxVehiculoList());
        
        
        // Name patttern 
        this.lblName = new JLabel("Nombre de la Obra");
        add(this.getLblName());
        
        this.txtName = new JTextField();
        add(this.getTxtName());
        
        
        // Search button
        this.btnSearch = new JButton("Buscar");
        add(this.btnSearch);
        
        ClickEvent clickEvent = new ClickEvent(this);
        this.btnSearch.addActionListener(clickEvent);
        
        // Insert  button
        this.btnAddArtPiece = new JButton("Agregar Nueva Obra");
        add(this.getBtnAddArtPiece());
        this.getBtnAddArtPiece().addActionListener(clickEvent);
    }

    /**
     * @return the lblMuseums
     */
    public JLabel getLblUsuario() {
        return lblUsuario;
    }

    /**
     * @return the cbxMuseumsList
     */
    public JComboBox getCbxUsuarioList() {
        return cbxUsuarioList;
    }

    /**
     * @return the lblPresentations
     */
    public JLabel getLblVehiculo() {
        return lblVehiculo;
    }

    /**
     * @return the cbxPresentationsList
     */
    public JComboBox getCbxVehiculoList() {
        return cbxVehiculoList;
    }

    /**
     * @return the lblName
     */
    public JLabel getLblName() {
        return lblName;
    }

    /**
     * @return the txtName
     */
    public JTextField getTxtName() {
        return txtName;
    }

    /**
     * @return the btnSearch
     */
    public JButton getBtnSearch() {
        return btnSearch;
    }

    /**
     * @return the tblResults
     */
    public JTable getTblResults() {
        return tblResults;
    }

    /**
     * @param presentations
     */
    
    public void setCbxPresentationsList(ArrayList<vehiculo> vehiculos) {
        this.cbxVehiculoList.setModel(new DefaultComboBoxModel<>(vehiculos.toArray(new vehiculo[vehiculos.size()])));
        this.getCbxVehiculoList().setSelectedIndex(0);
    }

    /**
     * @param artPieces
     */
    public void setTblResults(ArrayList<ArtPieceModel> artPieces) {
        String[] headers = {"ID", "Nombre", "Tipo", "Costo", "Museo", "Exposición", "Presentación"};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers); 
        this.tblResults.setModel(tableModel);
        for(int i=0; i<artPieces.size(); i++){
            tableModel.addRow(artPieces.get(i).toArray() );
        }
    }

    /**
     * @return the btnAddArtPiece
     */
    public JButton getBtnAddArtPiece() {
        return btnAddArtPiece;
    }

   
}