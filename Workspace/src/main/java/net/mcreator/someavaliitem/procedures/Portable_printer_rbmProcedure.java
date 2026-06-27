package net.mcreator.someavaliitem.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;
import net.mcreator.someavaliitem.init.SomeAvaliItemModItems;

public class Portable_printer_rbmProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!entity.isShiftKeyDown()) {
			if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).printer_state < 5) {
				{
					SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
					_vars.printer_state = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).printer_state + 1;
					_vars.markSyncDirty();
				}
			} else {
				{
					SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
					_vars.printer_state = 0;
					_vars.markSyncDirty();
				}
			}
		} else {
			if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).printer_state == 0) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(SomeAvaliItemModItems.PRINTEDSWORD.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).printer_state == 1) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(SomeAvaliItemModItems.PRINTEDPICKAXE.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).printer_state == 2) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(SomeAvaliItemModItems.PRINTEDAXE.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).printer_state == 3) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(SomeAvaliItemModItems.PRINTEDSHOVEL.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).printer_state == 4) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(SomeAvaliItemModItems.PRINTEDHOE.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).printer_state == 5) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(SomeAvaliItemModItems.PRINTEDSHEAR.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 200);
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
				});
			}
		}
	}
}