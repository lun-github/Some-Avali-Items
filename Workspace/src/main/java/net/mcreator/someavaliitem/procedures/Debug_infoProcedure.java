package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;

public class Debug_infoProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		String mess = "";
		mess = "NaN";
		mess = (" X" + entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).harpon_x) + "" + (" Y" + entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).harpon_y)
				+ (" Z" + entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).harpon_z);
		if (entity.isShiftKeyDown()) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(mess), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(mess), true);
		}
	}
}