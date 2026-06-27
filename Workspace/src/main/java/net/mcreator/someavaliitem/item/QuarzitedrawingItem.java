package net.mcreator.someavaliitem.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class QuarzitedrawingItem extends Item {
	public QuarzitedrawingItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}
}