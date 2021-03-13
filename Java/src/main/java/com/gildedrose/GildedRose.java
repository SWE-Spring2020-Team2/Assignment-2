package com.gildedrose;

class GildedRose 
{
    Item[] items;


    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() 
    {
        //Loop Through All Items in the Array to Check for All The Things
        for (int i = 0; i < items.length; i++) 
        {
            //
            CheckItemQuality(i);

            //
            DegradeSellInDate(i);

            //
            HandleQuality(items[i]);

            //Handle our Expired Items
            HandleExpired (items[i]);

        }
        
    }

    private void CheckItemQuality(int i) 
    {
        //
        if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) 
        {
            //
            DegradeQuality (items[i], 1);
        } 
        else 
        {
            if (items[i].quality < 50) 
            {
                //
                IncreaseQuality(items[i], 1);

                //
                IncreaseStagePassQuality(i);
            }
        }
    }


    private void IncreaseStagePassQuality(int i) 
    {
        //Make sure its actually the Stage Pass
        if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) 
        {
            //If Within 10 Days Date
            if (items[i].sellIn < 11) 
            {
                if (items[i].quality < 50) 
                {
                    IncreaseQuality(items[i], 1);
                }
            }

            //If Within 5 Days Date
            if (items[i].sellIn < 6) 
            {
                if (items[i].quality < 50) 
                {
                    IncreaseQuality(items[i], 1);
                }
            }
        }
    }

    private void IncreaseQuality (Item item, int number)
    {
        item.quality = item.quality + number;
    }

    private void DegradeQuality (Item item, int number)
    {
        if (item.quality > 0) 
        {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) 
            {
                item.quality = item.quality - number;
            }
        }
    }

    private void DegradeSellInDate (int i) 
    {
        //For everything thats not Sulfuras, decrease SellIn Date
        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros"))
        {
            items[i].sellIn = items[i].sellIn - 1;
        }
    }

    private void HandleQuality (Item item)
    {
        //*Conjured Mana Cake
        if (item.name.equals("Conjured Mana Cake"))
        {
            //Checking for when to decrease quality
            if (item.sellIn > 0)
                DegradeQuality(item, 1);
        }
    }

    private void HandleExpired (Item item)
    {
        //check to see if item is expired & quality not over 50
        if (item.sellIn <= 0)
        {
            //*Aged Brie
            if (item.name.equals("Aged Brie") && item.quality < 50)
            {
                IncreaseQuality(item, 1);    //AgedBrie Increases in Quality
            }

            //*Backstage Passes Set to 0
            else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
            {
                item.quality = 0;
            }

            //*Sulfuras
            else if(item.name.equals("Sulfuras, Hand of Ragnaros"))
            {
                //functionally useless
            }


            //*Conjured Mana Cake
            else if (item.name.equals("Conjured Mana Cake"))
            {
                //Checking for when to decrease quality
                if (item.sellIn <= 0)
                    DegradeQuality(item, 3);
            
            }

            //* Everything Else
            else
            {
                if (item.quality <= 0)
                    item.quality = 0;
                else
                DegradeQuality(item, 1);
            }
                
        }
    }
}