package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;

public class Aerohook_rbm_altProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double deHookTimer = 0;
		deHookTimer = 40;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), (int) deHookTimer);
		{
			SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
			_vars.hookAutoDetach = deHookTimer;
			_vars.markSyncDirty();
		}
	}
}