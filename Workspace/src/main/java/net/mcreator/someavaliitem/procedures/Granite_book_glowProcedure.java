package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class Granite_book_glowProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("exp") > 0) {
			return true;
		}
		return false;
	}
}