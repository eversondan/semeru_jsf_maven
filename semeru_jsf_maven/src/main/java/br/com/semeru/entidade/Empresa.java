/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.semeru.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author everson
 */
@Entity
@Table(name = "empresa", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nome"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByEmpresaId", query = "SELECT e FROM Empresa e WHERE e.empresaId = :empresaId"),
    @NamedQuery(name = "Empresa.findByNome", query = "SELECT e FROM Empresa e WHERE e.nome = :nome"),
    @NamedQuery(name = "Empresa.findByNomeFantasia", query = "SELECT e FROM Empresa e WHERE e.nomeFantasia = :nomeFantasia"),
    @NamedQuery(name = "Empresa.findByCnpj", query = "SELECT e FROM Empresa e WHERE e.cnpj = :cnpj"),
    @NamedQuery(name = "Empresa.findByEndereco", query = "SELECT e FROM Empresa e WHERE e.endereco = :endereco")})
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "empresa_id", nullable = false)
    private Long empresaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nome", nullable = false, length = 2147483647)
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nome_fantasia", nullable = false, length = 2147483647)
    private String nomeFantasia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "cnpj", nullable = false, length = 2147483647)
    private String cnpj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "endereco", nullable = false, length = 2147483647)
    private String endereco;

    public Empresa() {
    }

    public Empresa(Long empresaId) {
        this.empresaId = empresaId;
    }

    public Empresa(Long empresaId, String nome, String nomeFantasia, String cnpj, String endereco) {
        this.empresaId = empresaId;
        this.nome = nome;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public Long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Long empresaId) {
        this.empresaId = empresaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empresaId != null ? empresaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.empresaId == null && other.empresaId != null) || (this.empresaId != null && !this.empresaId.equals(other.empresaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.semeru.entidade.Empresa[ empresaId=" + empresaId + " ]";
    }
    
}
