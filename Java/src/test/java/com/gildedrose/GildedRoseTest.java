package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest 
{
    /*
        *test_ItemIsCorrect
        TEST CASE: Makes sure item is what it is supposed to be (name, sellIn, quality)
        UseCase: 
        @parm - N/A
    */
    @Test
    void test_ItemIsCorrect() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };

        GildedRose app = new GildedRose(items);

        //app.updateQuality();

        assertEquals("foo", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    /*
        *test_ItemQualityAndSellInDecrease
        TEST CASE: Makes sure item is quality is never negative, even after sellIn date is past 0
        UseCase: 
        @parm - N/A
    */
    @Test
    void test_ItemQualityAndSellInDecreases()
    {
        Item[] items = new Item[] { new Item("foo", 1, 1) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    /*
        *test_ItemQualityNeverNegative
        TEST CASE: Makes sure item is quality is never negative, even after sellIn date is past 0
        UseCase: 
        @parm - N/A
    */
    @Test
    void test_ItemQualityNeverNegative ()
    {
        Item[] items = new Item[] { new Item("foo", 0, 0) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    /*
        *test_ItemQualityDegradesTwiceAsFast
        TEST CASE: Makes sure item is quality is never negative, even after sellIn date is past 0
        UseCase: 
        @parm - N/A
    */
    @Test
    void test_ItemQualityDegradesTwiceAsFast ()
    {
        Item[] items = new Item[] { new Item("foo", 0, 10) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }



    /*
        *test_AgedBrieIncreaseQuality
        TEST CASE: Makes sure Aged Brie increases in quality the older it gets
        UseCase: 
        @parm - N/A
    */
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

    /*
        *test_AgedBrieQualityNotOver50
        TEST CASE: Makes sure Aged Brie increases in quality the older it gets
        UseCase: 
        @parm - N/A
    */
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

    /*
        *test_AgedBrieQualityDoubles
        TEST CASE: Makes sure Aged Brie doubles in quality after 0 sell in date
        UseCase: 
        @parm - N/A
    */
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
