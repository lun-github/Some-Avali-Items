package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;

public class Granite_of_Science_infoProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String iq_string = "";
		if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl >= 200) {
			if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).is_iq_set) {
				iq_string = "Not so ultimate... maybe not mindform, but cheater";
			} else {
				iq_string = "Ultimate Mindform Lifefrom!";
			}
		} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl > 150) {
			iq_string = "Intellegent";
		} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl > 100) {
			iq_string = "Smart";
		} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl > 80) {
			iq_string = "smortest";
		} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl > 60) {
			iq_string = "smort";
		} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl > 40) {
			iq_string = "stopid";
		} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl > 20) {
			iq_string = "fo stoueped";
		} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl < 1) {
			iq_string = "\u00A7kstoueped";
		}
		return "\u00A77= " + iq_string + " \u00A77=";
	}
}