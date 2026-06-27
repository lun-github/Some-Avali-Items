package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;

public class Granite_of_science_eatProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double mind_damage = 0;
		{
			SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
			_vars.iq_lvl = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl + 1;
			_vars.markSyncDirty();
		}
		if (entity instanceof Player _player)
			_player.giveExperiencePoints((int) (1 + 9 * (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl / 100)));
		mind_damage = 1 + Math.floor(entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl / 20);
		if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl >= 200) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 2);
		} else {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) mind_damage);
		}
		if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl == 200) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Your mind feel high intellegent, to understand \u00A7cGranite of Science\u00A7f."), true);
			if (!entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).is_iq_set) {
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("some_avali_item:graniteunderstanding"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
		} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl > 150) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Feel intellegent."), true);
		} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl > 100) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Feel very smart"), true);
		} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl > 80) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("feel smorter"), true);
		} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl > 60) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("fel smort"), true);
		} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl > 40) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("fel lef stopid"), true);
		} else if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl > 20) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("fil stouoped"), true);
		}
	}
}