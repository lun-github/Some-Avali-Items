/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.someavaliitem.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.someavaliitem.client.particle.CuttedbladeparticleParticle;

@EventBusSubscriber(Dist.CLIENT)
public class SomeAvaliItemModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(SomeAvaliItemModParticleTypes.CUTTEDBLADEPARTICLE.get(), CuttedbladeparticleParticle::provider);
	}
}