package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;

public class Aeroiper_parryProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
			{
				SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
				_vars.parry_window = 10;
				_vars.parry_health = entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1;
				_vars.markSyncDirty();
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.chain.hit")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.chain.hit")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(4, _level, null, _stkprov -> {
				});
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 10);
		}
	}
}