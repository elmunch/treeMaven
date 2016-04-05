/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entites;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author m.atallah
 */
@Entity
@Table(name = "TREENODESEQUENCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Treenodesequence.findAll", query = "SELECT t FROM Treenodesequence t"),
    @NamedQuery(name = "Treenodesequence.findByTreenodesequenceid", query = "SELECT t FROM Treenodesequence t WHERE t.treenodesequenceid = :treenodesequenceid"),
    @NamedQuery(name = "Treenodesequence.findByCurrentvalue", query = "SELECT t FROM Treenodesequence t WHERE t.currentvalue = :currentvalue")})
public class Treenodesequence implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TREENODESEQUENCEID")
    private BigDecimal treenodesequenceid;
    @Column(name = "CURRENTVALUE")
    private BigInteger currentvalue;
    @OneToMany(mappedBy = "treenodesequence")
    private Collection<Grouptable> grouptableCollection;
    @JoinColumn(name = "CODEGENERATORID", referencedColumnName = "CODEGENERATORID")
    @ManyToOne
    private Codegenerator codegeneratorid;

    public Treenodesequence() {
    }

    public Treenodesequence(BigDecimal treenodesequenceid) {
        this.treenodesequenceid = treenodesequenceid;
    }

    public BigDecimal getTreenodesequenceid() {
        return treenodesequenceid;
    }

    public void setTreenodesequenceid(BigDecimal treenodesequenceid) {
        this.treenodesequenceid = treenodesequenceid;
    }

    public BigInteger getCurrentvalue() {
        return currentvalue;
    }

    public void setCurrentvalue(BigInteger currentvalue) {
        this.currentvalue = currentvalue;
    }

    @XmlTransient
    public Collection<Grouptable> getGrouptableCollection() {
        return grouptableCollection;
    }

    public void setGrouptableCollection(Collection<Grouptable> grouptableCollection) {
        this.grouptableCollection = grouptableCollection;
    }

    public Codegenerator getCodegeneratorid() {
        return codegeneratorid;
    }

    public void setCodegeneratorid(Codegenerator codegeneratorid) {
        this.codegeneratorid = codegeneratorid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (treenodesequenceid != null ? treenodesequenceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Treenodesequence)) {
            return false;
        }
        Treenodesequence other = (Treenodesequence) object;
        if ((this.treenodesequenceid == null && other.treenodesequenceid != null) || (this.treenodesequenceid != null && !this.treenodesequenceid.equals(other.treenodesequenceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.Entites.Treenodesequence[ treenodesequenceid=" + treenodesequenceid + " ]";
    }
    
}
