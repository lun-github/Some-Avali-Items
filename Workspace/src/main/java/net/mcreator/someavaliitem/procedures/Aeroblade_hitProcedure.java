package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;

public class Aeroblade_hitProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		{
			SomeAvaliItemModVariables.PlayerVariables _vars = sourceentity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
			_vars.damage_boost = sourceentity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).damage_boost + 20;
			_vars.markSyncDirty();
		}
		if (sourceentity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).damage_boost > 0) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 2 * Math.round(sourceentity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).damage_boost / 10));
		}
	}
}