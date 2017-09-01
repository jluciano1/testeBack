package app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "\"tb_customer_account\"")
@XmlRootElement
public class CustomerAccount implements Serializable, Comparable<CustomerAccount> {

  private static final long serialVersionUID = 1L;
  
  @Id
  @Column(name = "id_customer", nullable = false, insertable=true, updatable=true)
  private java.lang.Integer id;
  
  @Column(name = "cpf_cnpj", nullable = true, unique = false, insertable=true, updatable=true)
  private java.lang.String cpf_cnpj;
  
  @Column(name = "nm_customer", nullable = true, unique = false, insertable=true, updatable=true)
  private java.lang.String nome;
  
  @Column(name = "is_active", nullable = true, unique = false, insertable=true, updatable=true)
  private java.lang.Boolean ativo;
  
  @Column(name = "vl_total", nullable = true, unique = false, insertable=true, updatable=true)
  private java.lang.Double saldo;
  
  public CustomerAccount(){
  }

  
  public java.lang.Integer getId(){
    return this.id;
  }
  
  public CustomerAccount setId(java.lang.Integer id){
    this.id = id;
    return this;
  }
  
  public java.lang.String getCpf_cnpj(){
    return this.cpf_cnpj;
  }
  
  public CustomerAccount setCpf_cnpj(java.lang.String cpf_cnpj){
    this.cpf_cnpj = cpf_cnpj;
    return this;
  }
  
  public java.lang.String getNome(){
    return this.nome;
  }
  
  public CustomerAccount setNome(java.lang.String nome){
    this.nome = nome;
    return this;
  }
  
  public java.lang.Boolean getAtivo(){
    return this.ativo;
  }
  
  public CustomerAccount setAtivo(java.lang.Boolean ativo){
    this.ativo = ativo;
    return this;
  }
  
  public java.lang.Double getSaldo(){
    return this.saldo;
  }
  
  public CustomerAccount setSaldo(java.lang.Double saldo){
    this.saldo = saldo;
    return this;
  }
  
  public int compareTo(CustomerAccount other) {
    if (this.saldo < other.saldo) {
        return -1;
    }
    if (this.saldo > other.saldo) {
        return 1;
    }
    return 0;
  }

}
