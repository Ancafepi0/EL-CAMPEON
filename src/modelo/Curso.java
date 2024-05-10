/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author UNIVALLE
 */
public class Curso {
    private int codigo;
    private String nombre;
    private ProgramaAcademico prog_aca;
    private Docente profe;

    public Curso() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ProgramaAcademico getProg_aca() {
        return prog_aca;
    }

    public void setProg_aca(ProgramaAcademico prog_aca) {
        this.prog_aca = prog_aca;
    }

    public Docente getProfe() {
        return profe;
    }

    public void setProfe(Docente profe) {
        this.profe = profe;
    }
    
}
