package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.Component;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;

public class Aerohook_rbmProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).ishooked == true) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("" + entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).ishooked)), false);
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)), 1);
			entity.push((((entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).harpon_x - x) * 1) / 3), (((entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).harpon_y - y) * 1) / 3 + 1),
					(((entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).harpon_z - z) * 1) / 3));
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)), -2);
			{
				SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
				_vars.ishooked = false;
				_vars.markSyncDirty();
			}
		}
	}
}