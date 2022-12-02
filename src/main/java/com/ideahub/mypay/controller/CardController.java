package com.ideahub.mypay.controller;

import com.ideahub.mypay.model.Card;
import com.ideahub.mypay.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("/save")
    public ResponseEntity<Card> saveCard(@RequestBody Card card){
        Card newCard = cardService.saveCard(card);
        return new ResponseEntity<>(newCard, HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/get/{id}")
    public Card getCardById(@PathVariable("id") long cardId) {
        return cardService.getCardDetails(cardId);
    }
}
