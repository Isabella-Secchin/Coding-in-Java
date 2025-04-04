public class Aluno {
    private String nome;
    private String curso;
    private String email;
    private String matricula;
    private static int ano = 0;
    private static int id = 1;

    public Aluno(String nome, String curso, String email, int ano){
        this.nome = nome;
        this.curso = curso;
        this.email = email;
        this.matricula = String.format("%d%04d", ano, id);
        id++;
    }

    public Aluno(Aluno aluno, String novoCurso, int ano){
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
        this.curso = novoCurso;
        this.matricula = String.format("%d%04d", ano, id);
        id++;
    }

    public String getNome(){
        return nome;
    }
    public String getCurso(){
        return curso;
    }
    public String getEmail(){
        return email;
    }
    public String getMatricula(){
        return matricula;
    }

    public boolean igualA(Aluno outro){
        return nome.equals(outro.nome) && curso.equals(outro.curso) && email.equals(outro.email) && matricula.equals(outro.matricula);
    }
    public static boolean igualA(Aluno aluno1, Aluno aluno2){
        return aluno1.nome.equals(aluno2.nome) && aluno1.curso.equals(aluno2.curso) && aluno1.email.equals(aluno2.email) && aluno1.matricula.equals(aluno2.matricula);
    }
}