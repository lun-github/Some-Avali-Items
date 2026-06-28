package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;
import net.mcreator.someavaliitem.init.SomeAvaliItemModItems;

public class Aerohook_rbmProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double y_cord = 0;
		if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).hookAutoDetach > 0) {
			{
				SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
				_vars.hookAutoDetach = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).hookAutoDetach - 1;
				_vars.markSyncDirty();
			}
		} else {
			{
				SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
				_vars.hookAutoDetach = 0;
				_vars.ishooked = false;
				_vars.markSyncDirty();
			}
		}
		if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).ishooked == true && entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).hookAutoDetach > 0) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)), 1);
			y_cord = ((entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).harpon_y - y) * 1) / 3;
			if (y_cord <= 2) {
				y_cord = y_cord + 1;
			}
			entity.push((((entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).harpon_x - x) * 1) / 3), y_cord, (((entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).harpon_z - z) * 1) / 3));
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
			if (!(getEntityGameType(entity) == GameType.CREATIVE)) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(SomeAvaliItemModItems.HARPOON.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 0);
			{
				SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
				_vars.hookAutoDetach = 0;
				_vars.ishooked = false;
				_vars.markSyncDirty();
			}
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}