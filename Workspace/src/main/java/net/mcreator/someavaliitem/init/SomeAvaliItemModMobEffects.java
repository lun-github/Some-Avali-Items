/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.someavaliitem.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.someavaliitem.potion.SuppressionMobEffect;
import net.mcreator.someavaliitem.potion.HeavyinjuryMobEffect;
import net.mcreator.someavaliitem.SomeAvaliItemMod;

public class SomeAvaliItemModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, SomeAvaliItemMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> HEAVYINJURY = REGISTRY.register("heavyinjury", () -> new HeavyinjuryMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SUPPRESSION = REGISTRY.register("suppression", () -> new SuppressionMobEffect());
}