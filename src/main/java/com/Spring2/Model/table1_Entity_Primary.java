package com.Spring2.Model;

import java.io.Serializable;

//@Component
public class table1_Entity_Primary implements Serializable
{
    public table1_Entity_Primary()
    {

    }

    public table1_Entity_Primary(String aData_key, String aData_value)
    {
        this.data_key = aData_key;
        this.data_value = aData_value;
    }

    private String data_key = "";

    private String data_value = "";
    
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        table1_Entity_Primary that = (table1_Entity_Primary) o;

        if (!data_key.equals(that.data_key)) return false;
        return data_value.equals(that.data_value);
    }

    @Override
    public int hashCode() {
        int result = data_key.hashCode();
        result = 31 * result + data_value.hashCode();
        return result;
    }
}
