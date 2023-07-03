package com.javaeducation.course.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.Table;

import java.io.Serializable;

import java.util.HashSet;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "tb_category")
public class Category implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // @OneToMany(mappedBy = "category")

    // Set para evitar repetição de categorias e hashset para garantir a ordem
    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private Set <Product> products = new HashSet<Product>();

    public Category(){
        super();
    }
    
    public Category(Long id, String name){
        super();
        this.id = id;
        this.name = name;
    }
    
  

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return this.products;
    }


    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Order)) {
            return false;
        }
        Category categories = (Category) o;
        return Objects.equals(id, categories.id) && Objects.equals(name, categories.name);
    }
 

   @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
