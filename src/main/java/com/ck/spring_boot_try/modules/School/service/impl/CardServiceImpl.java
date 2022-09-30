package com.ck.spring_boot_try.modules.School.service.impl;

import com.ck.spring_boot_try.modules.School.entity.Card;
import com.ck.spring_boot_try.modules.School.service.CardService;
import com.ck.spring_boot_try.modules.School.repository.CardRepository;
import com.ck.spring_boot_try.modules.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public Result<Card> editCard(Card card) {
        cardRepository.saveAndFlush(card);
        return new Result<Card>(Result.ResultStatus.SUCCESS.status,"edit over",card);
    }

    @Override
    public Card getCardByCardId(int cardId) {
        return cardRepository.findById(cardId).get();
    }

    @Override
    public List<Card> getCards() {
        return cardRepository.findAll();
    }

    @Override
    public Result<Object> deleteCardByCardId(int cardId) {
        cardRepository.deleteById(cardId);
        return new Result<Object>(Result.ResultStatus.SUCCESS.status,"delete over");
    }
}
