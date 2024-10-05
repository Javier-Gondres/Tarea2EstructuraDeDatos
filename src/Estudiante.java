public class Estudiante {

    int matricula;
    String nombre;
    double indiceAcademico;

    @Override
    public String toString(){
        return matricula + "-" + nombre + "-" + indiceAcademico;
    }
}
