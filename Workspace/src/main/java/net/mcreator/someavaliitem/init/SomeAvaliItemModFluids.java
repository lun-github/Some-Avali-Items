/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.someavaliitem.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.someavaliitem.fluid.AmmoniaFluid;
import net.mcreator.someavaliitem.SomeAvaliItemMod;

public class SomeAvaliItemModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, SomeAvaliItemMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> AMMONIA = REGISTRY.register("ammonia", () -> new AmmoniaFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_AMMONIA = REGISTRY.register("flowing_ammonia", () -> new AmmoniaFluid.Flowing());

	@EventBusSubscriber(Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(AMMONIA.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_AMMONIA.get(), RenderType.translucent());
		}
	}
}