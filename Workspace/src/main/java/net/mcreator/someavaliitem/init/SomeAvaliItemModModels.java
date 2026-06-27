/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.someavaliitem.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.someavaliitem.client.model.Modelharpoonl;
import net.mcreator.someavaliitem.client.model.Modelcleaner_drone_mojmaps;

@EventBusSubscriber(Dist.CLIENT)
public class SomeAvaliItemModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelcleaner_drone_mojmaps.LAYER_LOCATION, Modelcleaner_drone_mojmaps::createBodyLayer);
		event.registerLayerDefinition(Modelharpoonl.LAYER_LOCATION, Modelharpoonl::createBodyLayer);
	}
}