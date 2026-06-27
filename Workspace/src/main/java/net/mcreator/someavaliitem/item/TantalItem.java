package net.mcreator.someavaliitem.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class TantalItem extends Item {
	public TantalItem() {
		super(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON));
	}
}