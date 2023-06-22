package com.javaeducation.course.entities;

import java.io.Serializable;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Serializable é uma interface que diz que os objetos dessa classe podem ser convertidos em bytes para serem gravados em arquivos, etc.
@Entity
// @Entity é uma anotação que diz que essa classe é uma entidade do banco de dados
@Table(name = "tb_user")
// @Table é uma anotação que diz que essa classe é uma tabela do banco de dados
public class User implements Serializable{
    // Numero de serie padrão para objetos serializaveis
    public User(){
        super();
        }
    private static final long serialVersionUID = 1L;
    @Id
    // generateValue diz que o id é auto incrementado
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    // Ao usar framework ORM, é necessário criar um construtor vazio
    public User(Long id, String name, String email, String phone, String password) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;

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

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = (prime * result)
            + ((email == null) ? 0 : email.hashCode()); 
        result = (prime * result)
            + ((id == null) ? 0 : id.hashCode());
        result = (prime * result);

            return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) 
            return true;
        if (obj == null) 
            return false;
        if (getClass() != obj.getClass()) 
            return false;

        User other = (User) obj;
        if (email == null) {
            if (other.email != null) 
                return false;
        } else if (!email.equals(other.email)) 
            return false;
        if (id == null) {
            if (other.id != null) 
                return false;
        } else if (!id.equals(other.id)) 
            return false;

        return true;
    }



}
