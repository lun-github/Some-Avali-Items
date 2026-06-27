package net.mcreator.someavaliitem.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;
import net.mcreator.someavaliitem.init.SomeAvaliItemModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class StarteritemProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (!entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).start_item) {
			{
				SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
				_vars.start_item = true;
				_vars.markSyncDirty();
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(SomeAvaliItemModItems.STRANGEFEATHER.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}