package net.mcreator.someavaliitem.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class AerogelItem extends Item {
	public AerogelItem() {
		super(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON));
	}
}