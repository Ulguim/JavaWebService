package com.javaeducation.course.enums;


public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);
     

    // Codigo de cada enum
    private int code;
    private OrderStatus(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }
    public static OrderStatus valueof(int code){
        for(OrderStatus value : OrderStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        // Caso não encontre o código
        throw new IllegalArgumentException("Status not found");
    }
}