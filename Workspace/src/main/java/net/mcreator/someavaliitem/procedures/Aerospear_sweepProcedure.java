package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class Aerospear_sweepProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("" + (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null))), false);
	}
}