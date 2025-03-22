package com.Spring2.Model;

import java.util.Date;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

//@Component
@Entity
@Table(name="table1")
@IdClass(table1_Entity_Primary.class)
@Access(AccessType.FIELD) // フィールドレベルでのアクセスを指定
public class table1_Entity {
    @Id
    @Column(name="data_key")
    private String data_key = "";

    @Id
    @Column(name="data_value")
    private String data_value = "";

    @Column(name="insert_date")
    private Date insert_date;

    public String getData_key()
    {
        return this.data_key;
    }

    public void setData_key(String key)
    {
        this.data_key = key;
    }

    public String getData_value()
    {
        return this.data_value;
    }

    public void setData_value(String value)
    {
        this.data_value = value;
    }

    public Date getInsert_date()
    {
        return this.insert_date;
    }

    public void setInsert_date(Date date)
    {
        this.insert_date = date;
    }
}
