/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.someavaliitem.init;

import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;

@EventBusSubscriber
public class SomeAvaliItemModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == SomeAvaliItemModItems.HEATEDGRAPHITEROD.get())
			event.setBurnTime(6400);
	}
}