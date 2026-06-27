/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.someavaliitem.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import net.mcreator.someavaliitem.fluid.types.AmmoniaFluidType;
import net.mcreator.someavaliitem.SomeAvaliItemMod;

public class SomeAvaliItemModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, SomeAvaliItemMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> AMMONIA_TYPE = REGISTRY.register("ammonia", () -> new AmmoniaFluidType());
}