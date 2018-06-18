/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.FiltroDao;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javafx.scene.control.CheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Filtro;

/**
 *
 * @author LN710Q
 */
public class Consulta {
    public JLabel lblNombre, lblCodigo, lblPrecio,lblCantidad, lblDisponibilidad;
    
    public JTextField nombre,codigo, precio, cantidad;
    public JComboBox tipo;
    public CheckBox disponibilidad;
    
   
    public JRadioButton no;
    public JRadioButton si;
    public JTable resultados;
    
    public JPanel table;
    
    public JButton buscar, eliminar, insertar, limpiar, actualizar;
    
    private static final int ANCHOC = 130, ALTOC = 30;
    
    DefaultTableModel tm;
    
    public Consulta(){
        super("Productos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        agregarLabels();
        formulario();
        llenarTabla();
        Container container = getContentPane();
        container.add(lblNombre);
        container.add(lblCodigo);
        container.add(lblPrecio);
        container.add(lblCantidad);
        container.add(lblDisponibilidad);
        
        container.add(nombre);
        container.add(codigo);
        container.add(precio);
        container.add(cantidad);
        container.add(tipo);
        
        container.add(si);
        container.add(no);
        container.add(buscar);
        container.add(insertar);
        container.add(actualizar);
        container.add(eliminar);
        container.add(limpiar);
        container.add(table);
        setSize(600,600);
        eventos();
    }
    
    public final void agregarLabels(){
        lblNombre = new JLabel("Nombre");
        lblCodigo= new JLabel("Codigo");
        lblPrecio = new JLabel("Precio");
        lblCantidad = new JLabel("Cantidad");
        lblDisponibilidad = new JLabel("Disponibilidad");
        
        lblNombre.setBounds(10, 10, ANCHOC, ALTOC);
        lblCodigo.setBounds(10,60,ANCHOC,ALTOC);
        lblPrecio.setBounds(10,100,ANCHOC,ALTOC);
        lblCantidad.setBounds(10,140,ANCHOC,ALTOC);
        lblDisponibilidad.setBounds(10,160 , ANCHOC, ALTOC);
    }
    
    public final void formulario(){
        nombre = new JTextField();
        codigo = new JTextField();
        precio = new JTextField();
        cantidad = new JTextField();
        disponibilidad = new CheckBox();
        si = new JRadioButton("si",true);
        no = new JRadioButton("no");
        resultados = new JTable();
        buscar = new JButton("Buscar");
        insertar = new JButton("Insertar");
        eliminar = new JButton("Eliminar");
        actualizar = new JButton("Actualizar");
        limpiar = new JButton("Limpiar");
        
        table = new JPanel();

        tipo.addItem("Tipo1");
        tipo.addItem("Tipo2");
        tipo.addItem("Tipo3");
        tipo.addItem("Tipo4");
        

        nombre.setBounds(140, 10, ANCHOC, ALTOC);
        codigo.setBounds(140, 60, ANCHOC, ALTOC);
        precio.setBounds(140, 110, ANCHOC, ALTOC);
        cantidad.setBounds(140, 160, ANCHOC, ALTOC);
        //disponibilidad
        si.setBounds(140,140,50,ALTOC);
        no.setBounds(210,140,50,ALTOC);
        
        buscar.setBounds(300, 10, ANCHOC,ALTOC);
        insertar.setBounds(10, 210, ANCHOC,ALTOC);
        actualizar.setBounds(150, 210, ANCHOC,ALTOC);
        eliminar.setBounds(300, 210, ANCHOC,ALTOC);
        limpiar.setBounds(450, 210, ANCHOC,ALTOC);
        resultados=new JTable();
        table.setBounds(10, 250, 500,200);
        table.add(new JScrollPane(resultados));
        
    }
    
        public void llenarTabla(){
        tm = new DefaultTableModel(){
            public Class<?> getColumnClass(int column){
                switch (column){
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Double.class;
                    case 3:
                        return int.class;
                  
                    default:
                        return Boolean.class;
                }
            }
          
            
        };
        
        tm.addColumn("Nombre");
        tm.addColumn("Codigo");
        tm.addColumn("Precio");
        tm.addColumn("Cantidad");
        tm.addColumn("Disponibilidad");
        
        
        FiltroDao fd = new FiltroDao();
        ArrayList<Filtro> filtros = fd.readAll();
        
        for (Filtro fi : filtros){
            tm.addRow(new Object[]{fi.getNombre(),fi.getCodigo(),fi.getPrecio(),fi.getCantidad(),fi.getDisponibilidad()});
        }
        
        resultados.setModel(tm);
    }
        
    public void eventos(){
        
        insertar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                FiltroDao fd = new FiltroDao();
                Filtro f = new Filtro(codigo.getText(),tipo.getSelectedItem().toString(),
                Integer.parseInt(cantidad.getText()),true);
                
                if(no.isSelected()){
                    f.setDisponibilidad(false);
                }
                
                if(fd.create(f)){
                    JOptionPane.showMessageDialog(null,"Filtro registrado con exito");
                    limpiarCampos();
                    llenarTabla();
                }else{
                    JOptionPane.showMessageDialog(null,"Ocurrio un problema al momento de crear el filtro");
                }
            }
        
        });
        
         actualizar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                FiltroDao fd = new FiltroDao();
                Filtro f = new Filtro(codigo.getText(),tipo.getSelectedItem().toString(),
                Integer.parseInt(cantidad.getText()),true);
                
                if(no.isSelected()){
                    f.setDisponibilidad(false);
                }
                
                if(fd.update(f)){
                    JOptionPane.showMessageDialog(null,"Filtro Modificado con exito");
                    limpiarCampos();
                    llenarTabla();
                }else{
                    JOptionPane.showMessageDialog(null,"Ocurrio un problema al momento de modificar el filtro");
                }
            }
        
        });
        
        eliminar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            FiltroDao fd = new FiltroDao();
            if(fd.delete(codigo.getText())){
                JOptionPane.showMessageDialog(null,"Filtro eliminado");
                limpiarCampos();
                llenarTabla();
            }else{
                JOptionPane.showMessageDialog(null,"Ocurrio un problema al momento de eliminar el filtro");
            }
        }
    });
    
    buscar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            FiltroDao fd = new FiltroDao();
            Filtro f = fd.read(codigo.getText());
            if(f == null){
                JOptionPane.showMessageDialog(null,"El filtro buscado no se ha encontrado");
            }else{
                nombre.setText(f.getCodigo());
                codigo.setSelectedItem(f.getCodigo());
                cantidad.setText(Integer.toString(f.getCantidad()));
                
                if(f.getDisponibilidad()){
                    si.setSelected(true);
                }else{
                    no.setSelected(true);
                }
            }
        }
    });
    
    limpiar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            limpiarCampos();
        }
    });
    }
    public void limpiarCampos(){
        nombre.setText("");
        codigo.setText("");
        precio.setText("");
        cantidad.setText("");
        
        tipo.setSelectedItem("FRAM");
      
    }
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                new Consulta().setVisible(true);
            }
            
        });
    }
    
    }    
}
