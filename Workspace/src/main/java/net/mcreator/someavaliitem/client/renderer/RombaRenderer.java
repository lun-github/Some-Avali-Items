package net.mcreator.someavaliitem.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.someavaliitem.entity.RombaEntity;
import net.mcreator.someavaliitem.client.model.Modelcleaner_drone_mojmaps;

public class RombaRenderer extends MobRenderer<RombaEntity, Modelcleaner_drone_mojmaps<RombaEntity>> {
	public RombaRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcleaner_drone_mojmaps<RombaEntity>(context.bakeLayer(Modelcleaner_drone_mojmaps.LAYER_LOCATION)), 0.2f);
	}

	@Override
	public ResourceLocation getTextureLocation(RombaEntity entity) {
		return ResourceLocation.parse("some_avali_item:textures/entities/cleanerdrone.png");
	}
}