/**
* This codebase is Team 2's version of the Gilded Rose Refactoring Kata done 
* as assignment 2 for SWE 6733 - Emerging Software Engineering Processes
*
* @author  SWE 6733 - Team 2
* @version 1.1
* @since   2021-03-14 
*/
package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest 
{

    @Test
    public void test_ItemIsCorrect() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };

        GildedRose app = new GildedRose(items);

        //app.updateQuality();

        assertEquals("foo", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void test_ItemQualityAndSellInDecreases()
    {
        Item[] items = new Item[] { new Item("foo", 1, 1) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void test_ItemQualityNeverNegative ()
    {
        Item[] items = new Item[] { new Item("foo", 0, 0) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void test_ItemQualityDegradesTwiceAsFast ()
    {
        Item[] items = new Item[] { new Item("foo", 0, 10) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    public void test_AgedBrieIncreaseQuality ()
    {
        //App constructor
        Item[] items = new Item[] {new Item ("Aged Brie", 5, 3)};
        GildedRose app = new GildedRose(items);

        //function call for actually doing the thing
        app.updateQuality();

        //requirement test
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void test_AgedBrieQualityNotOver50 ()
    {
        //App constructor
        Item[] items = new Item[] {new Item ("Aged Brie", 5, 50)};
        GildedRose app = new GildedRose(items);

        //function call for actually doing the thing
        app.updateQuality();

        //requirement test
        assertEquals(4, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void test_AgedBrieQualityDoubles ()
    {
        //App constructor
        Item[] items = new Item[] {new Item ("Aged Brie", 0, 2)};
        GildedRose app = new GildedRose(items);

        //function call for actually doing the thing
        app.updateQuality();

        //requirement test
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void test_BackstageQualityIncrease ()
    {
        //App constructor
        Item[] items = new Item[] {new Item ("Backstage passes to a TAFKAL80ETC concert", 20, 30)};
        GildedRose app = new GildedRose(items);

        //function call for actually doing the thing
        app.updateQuality();

        //requirement test
        assertEquals(19, app.items[0].sellIn);
        assertEquals(31, app.items[0].quality);
    }

    @Test
    public void test_BackstageQualityIncreaseBy2WhenInside10 ()
    {
        //App constructor
        Item[] items = new Item[] {new Item ("Backstage passes to a TAFKAL80ETC concert", 10, 30)};
        GildedRose app = new GildedRose(items);

        //function call for actually doing the thing
        app.updateQuality();

        //requirement test
        assertEquals(9, app.items[0].sellIn);
        assertEquals(32, app.items[0].quality);
    }

    @Test
    public void test_BackstageQualityIncreaseBy3WhenInside5 ()
    {
        //App constructor
        Item[] items = new Item[] {new Item ("Backstage passes to a TAFKAL80ETC concert", 5, 30)};
        GildedRose app = new GildedRose(items);

        //function call for actually doing the thing
        app.updateQuality();

        //requirement test
        assertEquals(4, app.items[0].sellIn);
        assertEquals(33, app.items[0].quality);
    }

    @Test
    public void test_BackstageQualityDropTo0AfterDate()
    {
        //App constructor
        Item[] items = new Item[] {new Item ("Backstage passes to a TAFKAL80ETC concert", 0, 30)};
        GildedRose app = new GildedRose(items);

        //function call for actually doing the thing
        app.updateQuality();

        //requirement test
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void test_SulfurasLegendaryNeverChange()
    {
        //App constructor
        Item[] items = new Item[] {new Item ("Sulfuras, Hand of Ragnaros", 50, 80)};
        GildedRose app = new GildedRose(items);

        //function call for actually doing the thing
        app.updateQuality();

        //requirement test
        assertEquals(50, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }


    @Test
    public void test_ConjuredDegradesTwiceAsFastBeforeSell()
    {
        //App constructor
        Item[] items = new Item[] {new Item ("Conjured Mana Cake", 2,10)};
        GildedRose app = new GildedRose(items);

        //function call for actually doing the thing
        app.updateQuality();

        //requirement test
        assertEquals(1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    public void test_ConjuredDegradesQuadAsFastAfterSell()
    {
        //App constructor
        Item[] items = new Item[] {new Item ("Conjured Mana Cake", 0, 10)};
        GildedRose app = new GildedRose(items);

        //function call for actually doing the thing
        app.updateQuality();

        //requirement test
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }
}
