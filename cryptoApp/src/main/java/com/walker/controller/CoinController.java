package com.walker.controller;

import com.walker.entity.Coin;
import com.walker.respository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping(value = "/coin")
public class CoinController {

    @Autowired
    private CoinRepository coinRepository;

    @PostMapping()
    public ResponseEntity post(@RequestBody Coin coin) {

        try {
            coin.setDatetime(new Timestamp(System.currentTimeMillis()));
            return new ResponseEntity<>(coinRepository.insert(coin), HttpStatus.CREATED);

        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
