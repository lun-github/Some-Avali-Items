package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;

public class Portable_printer_hand_tickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		String printer_string = "";
		if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).printer_state == 0) {
			printer_string = "Sword";
		} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).printer_state == 1) {
			printer_string = "Pickaxe";
		} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).printer_state == 2) {
			printer_string = "Axe";
		} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).printer_state == 3) {
			printer_string = "Shovel";
		} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).printer_state == 4) {
			printer_string = "Hoe";
		} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).printer_state == 5) {
			printer_string = "Shear";
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A7fPrinter: \u00A76" + printer_string)), true);
	}
}