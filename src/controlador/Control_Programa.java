
package controlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import vista.Vista_Programa;
import modelo.ProgramaAcademico;
import java.util.List;
import java.util.ArrayList;

public class Control_Programa implements ActionListener {
    private Vista_Programa vista;
    private ProgramaAcademico un_programa;
    private List<ProgramaAcademico> coleccion_program = new ArrayList<>();
    private int indice = -1;
    
    public Control_Programa(){
        this.vista = new Vista_Programa();
        this.vista.setVisible(true);
        this.vista.jbt_agregar.addActionListener(this);
        this.vista.jbt_actualizar.addActionListener(this);
        this.vista.jbt_buscar.addActionListener(this);
        this.vista.jbt_borrar.addActionListener(this);
        this.vista.jbt_cerrar.addActionListener(this);
        
    }
    public void limpiar(){
        this.vista.jtf_nombre.setText("");
        this.vista.jtf_codigo.setText("");
    }
    
    @Override
    public void actionPerformed (ActionEvent e){
        if (e.getSource() == this.vista.jbt_agregar){
            un_programa= new ProgramaAcademico();
            un_programa.setCodigo(Integer.parseInt(this.vista.jtf_codigo.getText()));
            un_programa.setNombre(this.vista.jtf_nombre.getText());
            coleccion_program.add(un_programa);
            javax.swing.JOptionPane.showMessageDialog(vista, "PROGRAMA AGREGADO CON EXITO", "RESULTADO DE AGREGAR", 1);
            limpiar();
        }
        if(e.getSource() == this.vista.jbt_buscar){
            indice = -1;
            for (int i = 0; i < this.coleccion_program.size(); i++) {
                if (coleccion_program.get(i).getCodigo() == Integer.parseInt(this.vista.jtf_codigo.getText())){
                    this.vista.jtf_nombre.setText(this.coleccion_program.get(i).getNombre());
                    javax.swing.JOptionPane.showMessageDialog(vista, "PROGRAMA ENCONTRADO", "RESULTADO DE BUSQUEDA", 1);
                    indice = i;
                    break;
                }               
            }
            if (indice == -1){
                javax.swing.JOptionPane.showMessageDialog(vista, "PROGRAMA NO ENCONTRADO", "RESULTADO DE BUSQUEDA", 1);              
            }
        }
        if (e.getSource() == this.vista.jbt_actualizar){
            if (indice != -1){
                this.coleccion_program.get(indice).setCodigo(Integer.parseInt(this.vista.jtf_codigo.getText()));
                this.coleccion_program.get(indice).setNombre(this.vista.jtf_nombre.getText());
                javax.swing.JOptionPane.showMessageDialog(vista, "PROGRAMA  ACTUALIZADO", "NOTIFICACION DE ACTUALIZACION", 1);
            }else{
                javax.swing.JOptionPane.showMessageDialog(vista, "PROGRAMA NO ACTUALIZADO", "NOTIFICACION DE ACTUALIZACION", 1);                
            }
            limpiar();
        }
        if (e.getSource() == this.vista.jbt_borrar){
            if (indice != 1){
                this.coleccion_program.remove(indice);
                javax.swing.JOptionPane.showMessageDialog(vista, "PROGRAMA BORRADO", "CONFIRMACION DE BOORADP", 1);
            }else{
                javax.swing.JOptionPane.showMessageDialog(vista, "PROGRAMA BORRADO", "CONFIRMACION DE BORRADO", 1);
            }
            limpiar();
        }
        if (e.getSource() == this.vista.jbt_cerrar){
            this.vista.setVisible(false);
            limpiar();
        }   
    }

    public Vista_Programa getVista() {
        return vista;
    }

    public void setVista(Vista_Programa vista) {
        this.vista = vista;
    }

    public ProgramaAcademico getUn_programa() {
        return un_programa;
    }

    public void setUn_programa(ProgramaAcademico un_programa) {
        this.un_programa = un_programa;
    }

    public List<ProgramaAcademico> getColeccion_program() {
        return coleccion_program;
    }

    public void setColeccion_program(List<ProgramaAcademico> coleccion_program) {
        this.coleccion_program = coleccion_program;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
}
