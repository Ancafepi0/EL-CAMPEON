/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Menu;

/**
 *
 * @author Anca
 */
public class ControlMenu implements ActionListener {
    private Menu vista;
    private ControlDocente control_docente;
    private ControlCurso control_curso;
    private Control_Programa control_programa;
    
    public ControlMenu() {
        vista= new Menu ();
        vista.jbt_curso.addActionListener(this);
        vista.jbt_docente.addActionListener(this);
        vista.jbt_programa.addActionListener(this);
        vista.setVisible(true);
        control_docente= new ControlDocente();
        control_docente.getVista().setVisible(false);
        control_curso = new ControlCurso();
        control_curso.getVista().setVisible(false);
        control_programa = new Control_Programa();  
        control_programa.getVista().setVisible(false);
        
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.jbt_curso){
            control_curso.getVista().setVisible(true);
            control_curso.setColeccion_profesor(control_docente.getListaDocentes());
            control_curso.setColeccion_programa(control_programa.getColeccion_program());
            control_curso.getVista().cboDocente.removeAllItems();
            for (int i = 0; i < control_docente.getListaDocentes().size(); i++) {
                control_curso.getVista().cboDocente.addItem(control_docente.getListaDocentes().get(i).getNombre());
                
            }
            control_curso.getVista().cboPrograma.removeAllItems();
            for (int i = 0; i < control_programa.getColeccion_program().size(); i++) {
                control_curso.getVista().cboPrograma.addItem(control_programa.getColeccion_program().get(i).getNombre());                
            }
        }
        if (e.getSource() == this.vista.jbt_docente){
            control_docente.getVista().setVisible(true);
        }
        if (e.getSource() == this.vista.jbt_programa){
            control_programa.getVista().setVisible(true);
        }
    }
}
