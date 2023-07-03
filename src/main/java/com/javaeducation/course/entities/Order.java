package com.javaeducation.course.entities;

import java.io.Serializable;

import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javaeducation.course.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{
    

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        // Relacionamento entre pedidos e clientes
        private Long id;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT-3")
        private Instant moment;
    
        private Integer orderStatus;

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "client_id")
        private User client;


    public Order(){
        super();
      
    }

    public Order(Long id, Instant moment, OrderStatus orderStatus , User client){
        super();
        this.id = id;
        this.moment = moment;
        // this.orderStatus = orderStatus;
        setOrderStatus(orderStatus);
        this.client = client;
    }
    
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Instant getMoment() {
        return this.moment;
    }
    public void setMoment(Instant moment) {
        this.moment = moment;
    }
    public OrderStatus getOrderStatus() {
        return OrderStatus.valueof(this.orderStatus) ;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        // get code é um método da classe OrderStatus usado para retornar o código do enum
        this.orderStatus = orderStatus.getCode();
    }
    


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Order)) {
            return false;
        }
        Order orders = (Order) o;
        return Objects.equals(id, orders.id) && Objects.equals(moment, orders.moment) && Objects.equals(orderStatus, orders.orderStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moment, orderStatus);
    }
    
}
