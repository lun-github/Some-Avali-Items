package net.mcreator.someavaliitem.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class AerosharperItem extends Item {
	public AerosharperItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON));
	}
}