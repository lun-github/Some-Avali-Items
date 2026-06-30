package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

public class Aeroiper_hitProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity.getY() + 0.25 < sourceentity.getY()) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 8);
			sourceentity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FELL_OUT_OF_WORLD)), 1);
			if (entity.getY() + 0.25 < sourceentity.getY()) {
				sourceentity.push(0, 1.3, 0);
			} else {
				sourceentity.push(0, 1.2, 0);
			}
			if (sourceentity instanceof LivingEntity _entity)
				_entity.setHealth((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 3);
		}
		entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 4);
	}
}