package com.rup.pokescape.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Type {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Integer id;
    private String Type;

    public Type() {};

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
