package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class Hook_entity_hitProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		entity.setDeltaMovement(new Vec3(Math.round(((entity.getX() - sourceentity.getX()) * (-1)) / 4), Math.round(((entity.getY() - sourceentity.getY()) * (-1)) / 4), Math.round(((entity.getZ() - sourceentity.getZ()) * (-1)) / 4)));
	}
}