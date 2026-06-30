package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;

public class Aeromer_inv_tickProcedure {
	public static void execute(double y, Entity entity) {
		if (entity == null)
			return;
		if (entity.getDeltaMovement().y() > -0.1) {
			{
				SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
				_vars.aeromer_fall_y1 = y;
				_vars.markSyncDirty();
			}
		}
	}
}