package com.walker.respository;

import com.walker.entity.Coin;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@EnableAutoConfiguration //Pesquisar sobre essa annotation
public class CoinRepository {

    private static String INSERT = "insert into coin (name, price, quantity, datetime) values (?,?,?,?)";

    private JdbcTemplate jdbcTemplate;

    public CoinRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Coin insert (Coin coin) {
        Object[] attr = new Object[] {
                coin.getName(),
                coin.getPrice(),
                coin.getQuantity(),
                coin.getDatetime()
        };

        jdbcTemplate.update(INSERT, attr); //Inserindo bo banco de dados atráves do método update do jdbc

        return coin;
    }

}
