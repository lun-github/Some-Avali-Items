package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;
import net.mcreator.someavaliitem.init.SomeAvaliItemModMobEffects;

public class Aeromer_hitProcedure {
	public static void execute(LevelAccessor world, double y, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		double damageBonus = 0;
		{
			SomeAvaliItemModVariables.PlayerVariables _vars = sourceentity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
			_vars.aeromer_fall_y2 = y;
			_vars.markSyncDirty();
		}
		damageBonus = Math.round((sourceentity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).aeromer_fall_y1 - sourceentity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).aeromer_fall_y2) / 4);
		if (damageBonus >= 5) {
			damageBonus = 5;
		}
		if (damageBonus > 0) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(SomeAvaliItemModMobEffects.HEAVYINJURY, 200, (int) (damageBonus - 1), true, true));
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(4, _level, null, _stkprov -> {
				});
			}
		}
		{
			SomeAvaliItemModVariables.PlayerVariables _vars = sourceentity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
			_vars.aeromer_fall_y1 = y;
			_vars.markSyncDirty();
		}
	}
}