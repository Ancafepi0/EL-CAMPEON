
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Curso;
import vista.VistaCurso;
import java.util.List;
import java.util.ArrayList;
import modelo.Docente;
import modelo.ProgramaAcademico;

public class ControlCurso implements ActionListener {
    private VistaCurso vista = new VistaCurso();
    private List <Curso> coleccion_curso = new ArrayList<>();
    private Curso un_curso;
    private List <Docente> coleccion_profesor = new ArrayList<>() ;
    //private Control_Programa programas;
    private List <ProgramaAcademico> coleccion_programa= new ArrayList<>();
    private int indice=-1;
    public ControlCurso() {
        vista.setVisible(true);
        vista.jbt_agregar.addActionListener(this);
        vista.jbt_actualizar.addActionListener(this);
        vista.jbt_borrar.addActionListener(this);
        vista.jbt_buscar.addActionListener(this);
        this.vista.jbt_cerrar.addActionListener(this);
        vista.cboDocente.addActionListener(this);
        vista.cboPrograma.addActionListener(this);
    }
    public void limpiar (){
        this.vista.jtf_codigo.setText("");
        this.vista.jtf_nombre.setText("");
        this.vista.cboDocente.setSelectedIndex(0);
        this.vista.cboPrograma.setSelectedIndex(0);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.jbt_agregar){
            un_curso= new Curso ();
            un_curso.setCodigo(Integer.parseInt(this.vista.jtf_codigo.getText()));
            un_curso.setNombre(this.vista.jtf_nombre.getText());
            un_curso.setProfe(this.coleccion_profesor.get(this.vista.cboDocente.getSelectedIndex()));
            un_curso.setProg_aca(this.coleccion_programa.get(this.vista.cboPrograma.getSelectedIndex()));
            this.coleccion_curso.add(un_curso);
            javax.swing.JOptionPane.showMessageDialog(vista, "CURSO AGREGADO", "NOTIFICACION DE AGREGAR", 1);
            limpiar();
        }
        if (e.getSource() == this.vista.jbt_actualizar){
            if (indice !=-1){
                this.coleccion_curso.get(indice).setCodigo(Integer.parseInt(this.vista.jtf_codigo.getText()));
                this.coleccion_curso.get(indice).setNombre(this.vista.jtf_nombre.getText());
                this.coleccion_curso.get(indice).setProfe(this.coleccion_profesor.get(this.vista.cboDocente.getSelectedIndex()));
                this.coleccion_curso.get(indice).setProg_aca(this.coleccion_programa.get(this.vista.cboPrograma.getSelectedIndex()));
                javax.swing.JOptionPane.showMessageDialog(vista, "CURSO ACTUALIZADO", "NOTIFICACION ACTUALIZADO", 1);
                limpiar();
            }else{
                javax.swing.JOptionPane.showMessageDialog(vista, "CURSO NO ACTUALIZADO", "NOTIFICACION ACTUALIZADO", 1);            
            }
        }
        if (e.getSource() == this.vista.jbt_borrar){
            if (indice !=-1){
                javax.swing.JOptionPane.showMessageDialog(vista, "CURSO BORRADO", "NOTIFICACION BORRADO", 1);
                this.coleccion_curso.remove(indice);
                limpiar();
            }else{
                javax.swing.JOptionPane.showMessageDialog(vista, "CURSO NO BORRADO", "NOTIFICACION BORRADO", 1);            
            }
            
        }
        if (e.getSource() == this.vista.jbt_buscar){
            indice = -1;
            for (int i = 0; i <this.coleccion_curso.size(); i++) {
                
                if (this.coleccion_curso.get(i).getCodigo() == Integer.parseInt(this.vista.jtf_codigo.getText())) {
                    this.vista.jtf_codigo.setText(Integer.toString(coleccion_curso.get(i).getCodigo()));
                    this.vista.jtf_nombre.setText(coleccion_curso.get(i).getNombre());
                    for (int j = 0; j < this.coleccion_profesor.size(); j++) {
                        if (this.coleccion_profesor.get(j).getCedula()== this.coleccion_curso.get(i).getProfe().getCedula()){
                            this.vista.cboDocente.setSelectedIndex(j);
                            break;
                        }
                        
                    }
                    for (int j = 0; j < this.coleccion_programa.size(); j++) {
                        if (this.coleccion_programa.get(j).getCodigo()== this.coleccion_curso.get(i).getProg_aca().getCodigo()){
                            this.vista.cboPrograma.setSelectedIndex(j);
                            break;
                        }
                        
                    }
 
                    indice = i;
                    break;
                }                
            }
            if (indice !=-1){
                javax.swing.JOptionPane.showMessageDialog(vista, "CURSO ENCONTRADO", "NOTIFICACION BUSQUEDA", 1);
            }else{
                javax.swing.JOptionPane.showMessageDialog(vista, "CURSO NO ENCONTRADO", "NOTIFICACION BUSQUEDA", 1);
                
            }
        }
        if (e.getSource() == this.vista.jbt_cerrar){
            this.vista.setVisible(false);
            limpiar();
        }
    }

    public VistaCurso getVista() {
        return vista;
    }

    public void setVista(VistaCurso vista) {
        this.vista = vista;
    }

    public List<Curso> getColeccion_curso() {
        return coleccion_curso;
    }

    public void setColeccion_curso(List<Curso> coleccion_curso) {
        this.coleccion_curso = coleccion_curso;
    }

    public Curso getUn_curso() {
        return un_curso;
    }

    public void setUn_curso(Curso un_curso) {
        this.un_curso = un_curso;
    }

    public List<ProgramaAcademico> getColeccion_programa() {
        return coleccion_programa;
    }

    public void setColeccion_programa(List<ProgramaAcademico> coleccion_programa) {
        this.coleccion_programa = coleccion_programa;
    }

    public List<Docente> getColeccion_profesor() {
        return coleccion_profesor;
    }

    public void setColeccion_profesor(List<Docente> coleccion_profesor) {
        this.coleccion_profesor = coleccion_profesor;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
}
