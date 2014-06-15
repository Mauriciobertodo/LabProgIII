
package model;

public class Usuario {
    
    private int id;
    private String nome;
    private int matricula;
    private String email;
    private int tipo_usuario;
    private int conta_usuario;
    private int senha;
    
    public Usuario(int id, String nome, int matricula, String email, int tipo_usuario, int conta_usuario, int senha){
        this.id = id;        
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.tipo_usuario = tipo_usuario;
        this.conta_usuario = conta_usuario;        
        this.senha = senha;
    }
    public Usuario(String nome, String email, int matricula){
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
    }
    public Usuario(int matricula, int senha){
        this.matricula = matricula;
        this.senha = senha;
    }
    
    public int getId() {
        return id;
    }    
    public int getTipo_usuario() {
        return tipo_usuario;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public int getSenha() {
        return senha;
    }
    public void setSenha(int senha) {
        this.senha = senha;
    }
    @Override
    public String toString(){
        return("Nome: "+ nome 
                + "\nMatricula: " + matricula 
                + "\nConta: " + conta_usuario 
                + "\nEmail: " + email);
    }
}
