
public class Matricula {
    public static void main(String[] args) {
        System.out.println("Sistema de Matrícula");
        Aluno aluno1 = new Aluno("Isabella", "CiC", "isabella.cic@uesc.br", 20241);
        System.out.println("Nome do aluno 1: " + aluno1.getNome());
        System.out.println("Curso do aluno 1: " + aluno1.getCurso());
        System.out.println("Email do aluno 1: " + aluno1.getEmail());
        System.out.println("Matrícula do aluno 1: " + aluno1.getMatricula());
        
        Aluno aluno2 = new Aluno("Artur", "CiC", "artur.cic@uesc.br", 20241);
        System.out.println("Nome do aluno 2: " + aluno2.getNome());
        System.out.println("Curso do aluno 2: " + aluno2.getCurso());
        System.out.println("Email do aluno 2: " + aluno2.getEmail());
        System.out.println("Matrícula do aluno 2: " + aluno2.getMatricula());

        aluno1 = new Aluno(aluno1, "Economia", 20251);
        System.out.println("Novo nome do aluno 1: " + aluno1.getNome());
        System.out.println("Novo curso do aluno 1: " + aluno1.getCurso());
        System.out.println("Nova matrícula do aluno 1: " + aluno1.getMatricula());
    }   
}
