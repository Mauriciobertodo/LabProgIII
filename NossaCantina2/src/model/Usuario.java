
package model;

public class Usuario {
    
    private int id;
    private String nome;
    private int matricula;
    private String email;
    private String tipo_usuario;
    private int conta_usuario;
    private int senha;
    private int saldo_conta_usuario;

    public Usuario(String nome,int matricula, String email, String tipo_usuario, int conta_usuario, 
            int saldo_conta_usuario) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.tipo_usuario = tipo_usuario;
        this.conta_usuario = conta_usuario;
        this.saldo_conta_usuario = saldo_conta_usuario;
    }
    
    public Usuario(String nome, String tipo_usuario, int conta_usuario, 
            int saldo_conta_usuario) {
        this.nome = nome;
        this.tipo_usuario = tipo_usuario;
        this.conta_usuario = conta_usuario;
        this.saldo_conta_usuario = saldo_conta_usuario;
    }
    
    public int getId() {
        return id;
    }    
    public String getTipo_usuario() {
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
    public int getConta_usuario() {
        return conta_usuario;
    }
    public void setConta_usuario(int conta_usuario) {
        this.conta_usuario = conta_usuario;
    }
    public int getSaldo_conta_usuario() {
        return saldo_conta_usuario;
    }
    public void setSaldo_conta_usuario(int saldo_conta_usuario) {
        this.saldo_conta_usuario = saldo_conta_usuario;
    }
    
    @Override
    public String toString(){
        return("Nome: "+ nome 
                + "\nMatricula: " + matricula 
                + "\nConta: " + conta_usuario
                + "\nTipo:" + tipo_usuario);
    }
}
