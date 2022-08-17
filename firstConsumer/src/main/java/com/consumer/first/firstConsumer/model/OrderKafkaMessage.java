package com.consumer.first.firstConsumer.model;

public class OrderKafkaMessage {
    private String orderNumber;
    private String comment;

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "OrderKafkaMessage{" +
                "orderNumber='" + orderNumber + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
