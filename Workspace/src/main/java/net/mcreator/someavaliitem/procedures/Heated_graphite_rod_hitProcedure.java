package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

public class Heated_graphite_rod_hitProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.igniteForSeconds(4);
		if (entity.isOnFire()) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.IN_FIRE)), 2);
		}
	}
}