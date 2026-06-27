package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class IqlevelprocedureProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		String player_string = "";
		if ((StringArgumentType.getString(arguments, "type")).equals("get")) {
			if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).is_iq_set) {
				player_string = "WeaQ: " + entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl;
			} else {
				player_string = "IQ: " + entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl;
			}
		} else if ((StringArgumentType.getString(arguments, "type")).equals("set")) {
			{
				SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
				_vars.iq_lvl = DoubleArgumentType.getDouble(arguments, "level");
				_vars.markSyncDirty();
			}
			if (DoubleArgumentType.getDouble(arguments, "level") == 0) {
				player_string = "IQ set to: " + entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl;
			} else {
				if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).is_iq_set) {
					player_string = "IQ set to: " + entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl;
				} else {
					player_string = "IQ set to: " + entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl + " ... weak";
				}
				{
					SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
					_vars.is_iq_set = true;
					_vars.markSyncDirty();
				}
			}
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(player_string), false);
	}
}