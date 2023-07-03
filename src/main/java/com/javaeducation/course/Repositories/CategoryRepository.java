package com.javaeducation.course.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaeducation.course.entities.Category;


// JpaRepository é uma interface que já tem implementações padrão para operações de acesso a dados
public interface CategoryRepository  extends JpaRepository<Category,Long>{
    
}
