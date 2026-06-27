package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

public class Aeroaxe_hitProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (Math.random() <= 0.5 + (entity.getPersistentData().getDouble("sai_wound") / 30) / 100) {
			entity.getPersistentData().putDouble("sai_wound", (entity.getPersistentData().getDouble("sai_wound") + 40));
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
				});
			}
		}
	}
}