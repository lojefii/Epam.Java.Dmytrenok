package nau.advanced.practice6.strategy.cards.strategies;

import nau.advanced.practice6.strategy.cards.Card;
import nau.advanced.practice6.strategy.cards.CardDealingStrategy;
import nau.advanced.practice6.strategy.cards.Deck;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ClassicPokerCardDealingStrategy implements CardDealingStrategy {
    private int cardsForPlayer = 5;
    @Override
    public Map<String, ArrayList<Card>> dealStacks(Deck deck, int players) {
        Map<String, ArrayList<Card>> stacks = new TreeMap<>();

        for (int i = 0; i < players; i++) {
            stacks.put("Player " + i + 1, new ArrayList<>());
        }

        stacks.put("Remaining", new ArrayList<>());

        for (int i = 0; i < cardsForPlayer; i++) {
            for (int j = 0; j < players; j++) {
                stacks.get("Player " + j + 1).add(deck.dealCard());
            }
        }

        while (deck.size() != 0) {
            stacks.get("Remaining").add(deck.dealCard());
        }
        return stacks;
    }
}