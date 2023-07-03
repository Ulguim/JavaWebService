package com.javaeducation.course.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
     // todo: Integrar com imgur
    private String imgID;

    // transient para que a variavel não seja persistida no banco de dados
    // @Transient
    @ManyToMany
    //Tabela de associação entre produtos e categorias
    //@JoinColumn(name = "product_id"),inverseJoinColumns = @JoinColumn(name = "category_id") id de produto e id de categoria
    @JoinTable(name = "tb_product_category",joinColumns = @JoinColumn(name = "product_id"),inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public Product() {
        super();
    }

    public Product(Long id, String name, String description, Double price, String imgID){
    super();
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.imgID = imgID;

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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgID() {
        return this.imgID;
    }

    public void setImgID(String imgID) {
        this.imgID = imgID;
    }
    
    public Set<Category> getCategories(){
        return this.categories; 
    }


     @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && Objects.equals(imgID, product.imgID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, imgID);
    }
}
   
