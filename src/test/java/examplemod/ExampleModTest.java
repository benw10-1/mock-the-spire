package examplemod;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.green.LegSweep;
import com.megacrit.cardcrawl.cards.green.WellLaidPlans;
import com.megacrit.cardcrawl.characters.AbstractPlayer.PlayerClass;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import mockthespire.MockTheSpire;

public class ExampleModTest extends MockTheSpire {
  @BeforeAll
  public static void setup() throws Exception {
    initializeClass();
  }
  @AfterAll
  public static void tearDown() {
    tearDownClass();
  }

  @Test
  public void testDefectDeck() throws Exception {
    initializeRun();

    AbstractDungeon.player.masterDeck.addToTop(new LegSweep());

    AbstractCard upgradedWellLaidPlans = new WellLaidPlans();
    upgradedWellLaidPlans.upgrade();

    AbstractDungeon.player.masterDeck.addToTop(upgradedWellLaidPlans);

    String deckString = ExampleMod.serializeDeck();

    Assertions.assertEquals("Defend|Defend|Defend|Defend|Defend|Leg Sweep|Neutralize|Strike|Strike|Strike|Strike|Strike|Survivor|Well-Laid Plans+|", deckString);
  }

  @Test
  public void testDeckFromJSON() throws Exception {
    initializeRun(PlayerClass.DEFECT);

    loadDeckJSONFile("test_deck.json");

    String deckString = ExampleMod.serializeDeck();

    // not asserting, just to see the output compared to the given JSON file
    System.out.println(deckString);
  }
}
