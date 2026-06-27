package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;

public class Granite_book_exp_countProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		String mindblow = "";
		if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).mindblow_count > 0) {
			mindblow = "\u00A7dMind\u00A74blow\u00A7fs: " + entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).mindblow_count;
		}
		return "\u00A77= RBM to store/unstore EXP in book =" + "\n" + "\u00A77= RBM + Shift to get more EXP!!! = (probably)" + "\n" + "\n"
				+ ("\u00A72EXP stored:\u00A76 " + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("exp")) + "\n" + mindblow;
	}
}