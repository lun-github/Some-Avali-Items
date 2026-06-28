package net.mcreator.someavaliitem.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleOptions;

import net.mcreator.someavaliitem.procedures.Heavy_injury_tickProcedure;
import net.mcreator.someavaliitem.procedures.Heavy_injury_deadProcedure;
import net.mcreator.someavaliitem.procedures.Heavy_injury_addedProcedure;
import net.mcreator.someavaliitem.init.SomeAvaliItemModParticleTypes;

public class HeavyinjuryMobEffect extends MobEffect {
	public HeavyinjuryMobEffect() {
		super(MobEffectCategory.NEUTRAL, -26368);
	}

	@Override
	public ParticleOptions createParticleOptions(MobEffectInstance mobEffectInstance) {
		return (SimpleParticleType) (SomeAvaliItemModParticleTypes.CUTTEDBLADEPARTICLE.get());
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		Heavy_injury_addedProcedure.execute(entity.level(), entity, amplifier);
	}

	@Override
	public void onMobHurt(LivingEntity entity, int amplifier, DamageSource damagesource, float damage) {
		Heavy_injury_tickProcedure.execute(entity.level(), entity, amplifier);
	}

	@Override
	public void onMobRemoved(LivingEntity entity, int amplifier, Entity.RemovalReason reason) {
		if (reason == Entity.RemovalReason.KILLED) {
			Heavy_injury_deadProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
		}
	}
}