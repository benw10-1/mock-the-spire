package examplemod;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

// Example implementation of some mod functionality that uses game information to do something
// TODO: add BaseMod hook support for mods
public class ExampleMod {
  public static String serializeDeck() {
    if (!CardCrawlGame.isInARun()) {
      return "Not in a run";
    }

    String[] cardNameList = new String[AbstractDungeon.player.masterDeck.group.size()];

    for (int i = 0; i < AbstractDungeon.player.masterDeck.group.size(); i++) {
      AbstractCard card = AbstractDungeon.player.masterDeck.group.get(i);
      
      cardNameList[i] = card.name;
    }

    // sort the list of card names
    java.util.Arrays.sort(cardNameList);

    StringBuilder deckString = new StringBuilder();

    for (String cardName : cardNameList) {
      deckString.append(cardName+"|");
    }

    return deckString.toString();
  }
}
