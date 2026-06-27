package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;

public class Aeroblade_rbmProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem() && entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).damage_boost >= 30) {
			{
				SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
				_vars.damage_boost = 0;
				_vars.markSyncDirty();
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 200);
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(8, _level, null, _stkprov -> {
				});
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.extinguish")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.extinguish")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 3);
		}
	}
}