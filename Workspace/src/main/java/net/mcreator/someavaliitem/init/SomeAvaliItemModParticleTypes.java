/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.someavaliitem.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.someavaliitem.SomeAvaliItemMod;

public class SomeAvaliItemModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, SomeAvaliItemMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CUTTEDBLADEPARTICLE = REGISTRY.register("cuttedbladeparticle", () -> new SimpleParticleType(false));
}