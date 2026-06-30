package net.mcreator.someavaliitem.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class MeatchunkItem extends Item {
	public MeatchunkItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).saturationModifier(1f).build()));
	}
}