/**
* This codebase is Team 2's version of the Gilded Rose Refactoring Kata done 
* as assignment 2 for SWE 6733 - Emerging Software Engineering Processes
*
* @author  SWE 6733 - Team 2
* @version 1.1
* @since   2021-03-14 
*/

package com.gildedrose;

class GildedRose 
{
    //* Class Variables
    Item[] items;


    /**
     * ! Class Constructor Method
     * @param items input item array
     * @return nothing
     */
    public GildedRose(Item[] items) 
    {
        this.items = items;
    }

    /**
     * ! The Base UpdateQuality Method:
     * This function is the catch-all for updating the Quality of all of our inventory items. It Calls the various child functions for updates
     * @param nothing
     * @return nothing
     */
    public void updateQuality() 
    {
        //First we need to Loop through All Items in the Array to check for All the things
        for (int i = 0; i < items.length; i++) 
        {
            //This Specfically is for checking if the item needs its quality increased or decreases
            CheckItemQuality(i);

            //Catch all function for Decreasing the SellInDate for all Items
            DegradeSellInDate(i);

            //This function handles the Quality of our various items
            //HandleQuality(items[i]);

            //Handles our Expired Items
            HandleExpired (items[i]);

        }
        
    }

    /**
     * ! The IncreaseQuality Method:
     * This function is generalized IncreaseQuality method that takes in the item, and how much to increase the Quality by.
     * @param item to increase
     * @param number to increase quality by
     * @return nothing
     */
    private void IncreaseQuality (Item item, int number)
    {
        item.quality = item.quality + number;   //could do inline here, but this is easier to understand in general
    }

    /**
     * ! The DecreaseQuality Method:
     * This function is generalized DecreaseQuality method that takes in the item, and how much to decrease the Quality by.
     * @param item to decrease
     * @param number to decrease quality by
     * @return nothing
     */
    private void DegradeQuality (Item item, int number)
    {
        if (item.quality > 0)   //check to make sure quality doesnt go below 0
        {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros"))    //We do this check here just to doubly make sure we dont decrease the quality of Sulfuras legendary item, as it cannot be decreases
            {
                item.quality = item.quality - number; //could do inline here, but this is easier to understand in general
            }
        }
    }

    /**
     * ! The DegradeSellInDate Method:
     * This function is generalized DegradeSellInDtae method that takes in the the itemNumber and decreases its sellInDate by 1 for each update Cycle
     * @param i item number
     * @return nothing
     */
    private void DegradeSellInDate (int i) 
    {
        //For everything thats not Sulfuras, decrease SellIn Date
        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros"))
        {
            items[i].sellIn = items[i].sellIn - 1;
        }
    }

    /**
     * ! The Check ItemQuality Method:
     * This function is another catch-all, but for Checking the Quality of all of our inventory items. When it figures out what item it is, it will either call DegradeQuality, IncreaseQuality, or IncreaseStagePassQuality if its a stage pass.
     * @param i itemNumber
     * @return nothing
     */
    private void CheckItemQuality(int i) 
    {
        //First we need to sort out that the Item is not one that DoesntDegrade (such as AgedBrie & the Backstage Passes)
        if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) 
        {
            //Call to Degrade by 1
            DegradeQuality (items[i], 1);
        } 
        else 
        {
            if (items[i].quality < 50) 
            {
                //Call to Increase by 1
                IncreaseQuality(items[i], 1);

                //Call to Increase StagePass (this is a unique function because Stage Passes increase Quality at different rates)
                IncreaseStagePassQuality(i);
            }
        }
    }

    /**
     * ! The IncreaseStagePassQuality Method:
     * This function is unique method as Stage Passes increase in quality at unique rates depending on their Date
     * @param i itemNumber
     * @return nothing
     */
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
                    IncreaseQuality(items[i], 1);   //Call to IncreaseQuality
                }
            }

            //If Within 5 Days Date
            if (items[i].sellIn < 6) 
            {
                if (items[i].quality < 50) 
                {
                    IncreaseQuality(items[i], 1);   //Call to IncreaseQuality (but because the item is also within the above if, we only need to increase once)
                }
            }
        }
    }

    /**
     * ! The HandleExpired Method:
     * This function is our general method for determining when to decrease quality
     * @param item item to check for quality checks
     * @return nothing
     */
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
                item.quality = 0;   //Backstage Passes are useless when sellIn date has passed
            }

            //*Sulfuras, functionally useless, but here for future extension
            //else if(item.name.equals("Sulfuras, Hand of Ragnaros"))
            //{
            //}


            //*Conjured Mana Cake
            else if (item.name.equals("Conjured Mana Cake"))
            {
                //Checking for when to decrease quality
                if (item.sellIn <= 0)
                    DegradeQuality(item, 3);

                if (item.sellIn > 0)
                    DegradeQuality(item, 1);
            
            }

            //* Everything Else
            else
            {
                if (item.quality <= 0)  //Force no-negative quality
                    item.quality = 0;
                else
                    DegradeQuality(item, 1);    //General Call to DegradeQuality
            }
                
        }
    }
}