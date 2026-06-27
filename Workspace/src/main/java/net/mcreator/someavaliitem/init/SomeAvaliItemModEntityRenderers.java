/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.someavaliitem.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.someavaliitem.client.renderer.RombaRenderer;
import net.mcreator.someavaliitem.client.renderer.HookprojRenderer;

@EventBusSubscriber(Dist.CLIENT)
public class SomeAvaliItemModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(SomeAvaliItemModEntities.AEROGELBLADE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(SomeAvaliItemModEntities.HOOKPROJ.get(), HookprojRenderer::new);
		event.registerEntityRenderer(SomeAvaliItemModEntities.ROMBA.get(), RombaRenderer::new);
	}
}