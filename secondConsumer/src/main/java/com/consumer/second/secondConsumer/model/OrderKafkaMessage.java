package com.consumer.second.secondConsumer.model;


public class OrderKafkaMessage {
    private String orderNumber;
    private String comment;


    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "OrderKafkaMessage{" +
                "orderNumber='" + orderNumber + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
