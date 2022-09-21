package com.ck.spring_boot_try.modules.School.service;

import com.ck.spring_boot_try.modules.School.entity.Card;
import com.ck.spring_boot_try.utils.Result;

import java.util.List;

public interface CardService {
    Result<Card> editCard(Card card);

    Card getCardByCardId(int cardId);

    List<Card> getCards();

    Result<Object> deleteCardByCardId(int cardId);
}
