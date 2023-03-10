package com.example.gjunrestaurant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "`order`")
@Data
public class Order implements Serializable {
    @Id
    @Column(name = "id")
    String ID;
    @Column(name = "date")
    String date;
    @Column(name = "time")
    String time;
    @Column(name = "totalPrice")
    Integer totalPrice;
    @Column(name = "paid")
    Boolean paid;

    public Order() {
        Date dateTime = new Date();
        // 處理ID格式
        SimpleDateFormat idDate = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat idTime = new SimpleDateFormat("HHmmss");
        String dateForID = idDate.format(dateTime);
        String timeForID = idTime.format(dateTime);
        this.ID = dateForID + timeForID;

        // 處理Date + Time
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String date = dateFormat.format(dateTime);
        String time = timeFormat.format(dateTime);
        this.date = date;
        this.time = time;
        this.totalPrice = 0;
        this.paid = false;
    }

    public Order(String date, String time, Integer totalPrice) {
        this.ID = ID;
        this.date = date;
        this.time = time;
        this.totalPrice = totalPrice;
        this.paid = false;
    }

}
