package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;

public class Heated_graphite_rod_hand_tickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).graphite_hot > 0) {
			{
				SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
				_vars.graphite_hot = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).graphite_hot - 1;
				_vars.markSyncDirty();
			}
		} else {
			{
				SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
				_vars.graphite_hot = 60;
				_vars.markSyncDirty();
			}
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.ON_FIRE)), 1);
		}
	}
}