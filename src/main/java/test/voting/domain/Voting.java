/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.voting.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import org.hibernate.annotations.GenericGenerator;
/**
 *
 * @author Dima
 */
@Entity
public class Voting implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    private long id;
    
    @Column(nullable = false)
    private String tittle; 
    
    @OneToMany(cascade = CascadeType.ALL)
    @OrderColumn(name="order_id")
    private List<Option> options=new ArrayList<>();
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VotingState state=VotingState.NOT_PUBLISHED;

    public Voting() {
    }

    public Voting(String tittle, List<Option> options) {
        this.tittle = tittle;
        this.options=options;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public VotingState getState() {
        return state;
    }

    public void setState(VotingState state) {
        this.state = state;
    }
    
    @Override
    public String toString() {
        return "Voting{" + "id=" + id + ", tittle=" + tittle + ", options=" + options + ", role=" + state + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Voting other = (Voting) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.tittle, other.tittle)) {
            return false;
        }
        if (!Objects.equals(this.options, other.options)) {
            return false;
        }
        if (this.state != other.state) {
            return false;
        }
        return true;
    }
}
