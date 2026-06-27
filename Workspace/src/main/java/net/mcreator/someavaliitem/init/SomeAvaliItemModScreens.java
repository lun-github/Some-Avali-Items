/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.someavaliitem.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.someavaliitem.client.gui.ChipcutterguiScreen;

@EventBusSubscriber(Dist.CLIENT)
public class SomeAvaliItemModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(SomeAvaliItemModMenus.CHIPCUTTERGUI.get(), ChipcutterguiScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}