/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Victor
 */
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String endereco;
    private String telefone;
    private String email;
    private String senha;
    
    public Cliente(){
    }
    
    public Cliente(long id, String nome, String cpf, LocalDate dataNascimento, String endereco, String telefone, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco (String endereco) {
        this.endereco = endereco;
    }
    
    public String getTelefone () {
        return telefone;
    }
    
    public void setTelefone (String telefone) {
        this.telefone = telefone;
    }
    
    public String getEmail () {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha (String senha) {
        this.senha = senha;
    }
    
    @Override
    public String toString() {
        return nome + "(CPF: " + cpf + ")";
    }
    
    @Override
    public boolean equals (Object o){
        // Um cliente igual a outro se o CPF for o mesmo
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        
        if (cpf != null) {
            return cpf.equals(cliente.cpf);
        } else {
            return cliente.cpf == null;
        }
    }
    
    @Override
    public int hashCode() {
        return cpf != null ? cpf.hashCode() : 0;
    }
}
