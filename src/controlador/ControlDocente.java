/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import modelo.Docente;
import vista.VistaDocente;

public class ControlDocente implements ActionListener {
    private Docente unDocente;
    private VistaDocente vista;
    private List <Docente> listaDocentes = new ArrayList <>();
    private int indice = -1;

    public ControlDocente (){
        this.vista = new VistaDocente ();
        this.vista.setVisible(true);
        
        this.vista.jbtn_guardarProfe.addActionListener(this);
        this.vista.jbtn_buscar.addActionListener(this);
        this.vista.jbtn_actualizar.addActionListener(this);
        this.vista.jbtn_borrar.addActionListener(this);
        this.vista.jbt_cerrar.addActionListener(this);
       
    }
    public void limpiar (){
        this.vista.jtf_cedula.setText("");
        this.vista.jtf_nombre.setText("");
        this.vista.jtf_apellido.setText("");
        this.vista.jtf_profesion.setText("");
       
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //BOTON GUARDAR
        if (e.getSource() == this.vista.jbtn_guardarProfe){
            unDocente = new Docente ();
            unDocente.setCedula(Integer.parseInt(this.vista.jtf_cedula.getText()));
            unDocente.setNombre(this.vista.jtf_nombre.getText());
            unDocente.setApellidos(this.vista.jtf_apellido.getText());
            unDocente.setProfesion(this.vista.jtf_profesion.getText());
            this.listaDocentes.add(unDocente);
            javax.swing.JOptionPane.showMessageDialog(this.vista, "SE INGRESO EL DOCENTE", "REGISTRO", 1);
            limpiar ();
            
            
        }
        // BOTON BUSCAR

        if (e.getSource() == this.vista.jbtn_buscar){
            for (int i = 0; i < this.listaDocentes.size(); i++) {
               
                if(this.listaDocentes.get(i).getCedula() == Integer.parseInt(this.vista.jtf_cedula.getText())){
                   this.vista.jtf_nombre.setText(this.listaDocentes.get(i).getNombre());
                   this.vista.jtf_apellido.setText(this.listaDocentes.get(i).getApellidos());
                   this.vista.jtf_profesion.setText(this.listaDocentes.get(i).getProfesion());
                   this.indice  = i;
                   break;
               }  
            }
           
            javax.swing.JOptionPane.showMessageDialog(this.vista, "NUMERO DE CEDULANO NO ENCONTRADO", "RESULTADO", 1);

        }
        // BOTON ACTUALIZAR
        if (e.getSource() == this.vista.jbtn_actualizar){

            if (this.indice != -1){
                this.listaDocentes.get(indice).setCedula(Integer.parseInt(this.vista.jtf_cedula.getText()));            
                this.listaDocentes.get(indice).setNombre(this.vista.jtf_nombre.getText());
                this.listaDocentes.get(indice).setApellidos(this.vista.jtf_apellido.getText());
                this.listaDocentes.get(indice).setProfesion(this.vista.jtf_profesion.getText());  
            }else{
                javax.swing.JOptionPane.showMessageDialog(this.vista, "NUMERO DE CEDULANO NO ENCONTRADO", "RESULTADO", 1);
            }
            limpiar ();
            
        }
        if (e.getSource() == this.vista.jbtn_borrar){
            if (indice != -1){
                this.listaDocentes.remove(indice);
                javax.swing.JOptionPane.showMessageDialog(vista, "DONCENTE BORRADO", "RESULTADO", 1);
                limpiar();
            } else{
                javax.swing.JOptionPane.showMessageDialog(vista, "NUMERO DE CEDULA NO EXISTENTE", "RESULTADO", 1);
            }
            
        }
        if (e.getSource() == this.vista.jbt_cerrar){
            this.vista.setVisible(false);
            limpiar();
        }
    }

    public Docente getUnDocente() {
        return unDocente;
    }

    public void setUnDocente(Docente unDocente) {
        this.unDocente = unDocente;
    }

    public VistaDocente getVista() {
        return vista;
    }

    public void setVista(VistaDocente vista) {
        this.vista = vista;
    }

    public List<Docente> getListaDocentes() {
        return listaDocentes;
    }

    public void setListaDocentes(List<Docente> listaDocentes) {
        this.listaDocentes = listaDocentes;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
}
