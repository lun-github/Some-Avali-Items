package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;

public class Granite_book_hitProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).is_iq_set) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 3);
		}
	}
}