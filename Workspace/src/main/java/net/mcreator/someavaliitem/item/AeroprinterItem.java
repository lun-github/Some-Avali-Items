package net.mcreator.someavaliitem.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class AeroprinterItem extends Item {
	public AeroprinterItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.RARE));
	}
}