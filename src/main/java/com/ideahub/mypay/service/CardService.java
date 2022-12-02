package com.ideahub.mypay.service;

import com.ideahub.mypay.model.Card;
import com.ideahub.mypay.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public Card saveCard(Card card) {
        card.setCardNumber(encodeCardDetails(card.getCardNumber()));
        card.setCardHolderName(encodeCardDetails(card.getCardHolderName()));
//        card.setCardCsv(Integer.parseInt(encodeCardDetails(String.valueOf(card.getCardCsv()))));
        return cardRepository.save(card);
    }
    public Card updateCardDetails(Card card, long cardId) {
        Card existingCard = cardRepository.findById(cardId).get();
        if (existingCard != null){
            existingCard.setCardCsv(card.getCardCsv());
            existingCard.setCardHolderName(encodeCardDetails(card.getCardHolderName()));
            existingCard.setCardNumber(encodeCardDetails(card.getCardNumber()));
            existingCard.setExpirationDate(card.getExpirationDate());
        }
        return cardRepository.save(existingCard);
    }

    public Card getCardDetails(long cardId) {
        Card card  = cardRepository.findById(cardId).get();
        card.setCardNumber(encodeCardDetails(card.getCardNumber()));
        return card;
    }

    public List<Card> getAllCards() {
        List<Card> cards = cardRepository.findAll();
        for (Card bankCard : cards) {
            bankCard.setCardNumber(encodeCardDetails(bankCard.getCardNumber()));
        }
        return cards;
    }
    //Encode card details
    private String encodeCardDetails(String cardInput) {
        return Base64.getEncoder().encodeToString(cardInput.getBytes());
    }

    //Decode card details
    private String decodeCardDetails(String encodedCard) {
        byte[] byteArray = Base64.getDecoder().decode(encodedCard);
        return new String(byteArray);
    }


}
