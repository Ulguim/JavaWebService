package com.javaeducation.course.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Orders implements Serializable{
    public Orders(){
        super();
        }

        private static final long serialVersionUID = 2L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        // Relacionamento entre pedidos e clientes
        @ManyToOne
        @JoinColumn(name = "client_id")
        private User client;

        private Long id;
        private Date moment;
        private OrderStatus orderStatus;


    public Orders(Long id, Date moment, OrderStatus orderStatus){
        super();
        this.id = id;
        this.moment = moment;
        this.orderStatus = orderStatus;
    }
    
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getMoment() {
        return this.moment;
    }
    public void setMoment(Date moment) {
        this.moment = moment;
    }
    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Orders)) {
            return false;
        }
        Orders orders = (Orders) o;
        return Objects.equals(id, orders.id) && Objects.equals(moment, orders.moment) && Objects.equals(orderStatus, orders.orderStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moment, orderStatus);
    }
    
}
enum OrderStatus {
    WAITING_PAYMENT,
    PAID,
    SHIPPED,
    DELIVERED,
    CANCELED;

}