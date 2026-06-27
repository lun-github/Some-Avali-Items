package net.mcreator.someavaliitem.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.someavaliitem.init.SomeAvaliItemModItems;

public class DebuggergiveprocedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(SomeAvaliItemModItems.DEBUGGER.get()).copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}