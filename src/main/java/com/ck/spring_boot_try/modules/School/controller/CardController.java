package com.ck.spring_boot_try.modules.School.controller;

import com.ck.spring_boot_try.modules.School.entity.Card;
import com.ck.spring_boot_try.modules.School.service.CardService;
import com.ck.spring_boot_try.modules.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping(value = "/edit", consumes = "application/Json")
    public Result<Card> editCard(@RequestBody Card card) {
        return cardService.editCard(card);
    }

    public Card getCardByCardId(int cardId) {
        return cardService.getCardByCardId(cardId);
    }

    public List<Card> getCards() {
        return cardService.getCards();
    }

    public Result<Object> deleteCardByCardId(int cardId) {
        return cardService.deleteCardByCardId(cardId);
    }
}
