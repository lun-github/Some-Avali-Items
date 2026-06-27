package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;

public class Hook_block_hitProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
			_vars.harpon_x = x;
			_vars.harpon_y = y;
			_vars.harpon_z = z;
			_vars.ishooked = true;
			_vars.markSyncDirty();
		}
	}
}