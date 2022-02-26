package com.community.dao;

import org.springframework.stereotype.Repository;

@Repository("Hibernate")
public class AlphaDaoImpl implements AlphaDao {
    @Override
    public String select() {
        return "Hibernate";
    }
}
