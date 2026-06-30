/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.someavaliitem.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.someavaliitem.SomeAvaliItemMod;

@EventBusSubscriber
public class SomeAvaliItemModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SomeAvaliItemMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SAI = REGISTRY.register("sai",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.some_avali_item.sai")).icon(() -> new ItemStack(SomeAvaliItemModItems.AEROGEL.get())).displayItems((parameters, tabData) -> {
				tabData.accept(SomeAvaliItemModItems.STRANGEFEATHER.get());
				tabData.accept(SomeAvaliItemModItems.AEROBLADE.get());
				tabData.accept(SomeAvaliItemModItems.AEROIPER.get());
				tabData.accept(SomeAvaliItemModItems.AEROSPEAR.get());
				tabData.accept(SomeAvaliItemModItems.AEROPICK.get());
				tabData.accept(SomeAvaliItemModItems.AEROMER.get());
				tabData.accept(SomeAvaliItemModItems.AEROAXE.get());
				tabData.accept(SomeAvaliItemModItems.AEROSHOVEL.get());
				tabData.accept(SomeAvaliItemModItems.AEROHOE.get());
				tabData.accept(SomeAvaliItemModItems.AEROSHEAR.get());
				tabData.accept(SomeAvaliItemModItems.AEROHOOK.get());
				tabData.accept(SomeAvaliItemModItems.HARPOON.get());
				tabData.accept(SomeAvaliItemModItems.AEROFISHROD.get());
				tabData.accept(SomeAvaliItemModItems.AEROKNIFE.get());
				tabData.accept(SomeAvaliItemModItems.AEROSHIELD.get());
				tabData.accept(SomeAvaliItemModItems.PORTABLEPRINTER.get());
				tabData.accept(SomeAvaliItemModItems.SMALLGRINDSTONE.get());
				tabData.accept(SomeAvaliItemModItems.AERONEEDLE.get());
				tabData.accept(SomeAvaliItemModBlocks.CHIPCUTTER.get().asItem());
				tabData.accept(SomeAvaliItemModBlocks.PORTALEMITTER.get().asItem());
				tabData.accept(SomeAvaliItemModBlocks.HARDICE.get().asItem());
				tabData.accept(SomeAvaliItemModBlocks.AMMONIAICE.get().asItem());
				tabData.accept(SomeAvaliItemModBlocks.SAKO.get().asItem());
				tabData.accept(SomeAvaliItemModItems.SELICAGEL.get());
				tabData.accept(SomeAvaliItemModItems.DESICCANTSILICAGEL.get());
				tabData.accept(SomeAvaliItemModItems.FORMEDAEROGEL.get());
				tabData.accept(SomeAvaliItemModItems.AEROGELDUST.get());
				tabData.accept(SomeAvaliItemModItems.AEROGEL.get());
				tabData.accept(SomeAvaliItemModItems.AEROGELPACK.get());
				tabData.accept(SomeAvaliItemModItems.GRAPHITEPEACE.get());
				tabData.accept(SomeAvaliItemModItems.GRAPHITEBLANK.get());
				tabData.accept(SomeAvaliItemModItems.GRAPHITE.get());
				tabData.accept(SomeAvaliItemModItems.GRAPHITEROD.get());
				tabData.accept(SomeAvaliItemModItems.HEATEDGRAPHITEROD.get());
				tabData.accept(SomeAvaliItemModItems.REDSTONEBATTERYEMPTY.get());
				tabData.accept(SomeAvaliItemModItems.REDSTONEBATTERY.get());
				tabData.accept(SomeAvaliItemModItems.REDSTONEACCUMULATOREMPTY.get());
				tabData.accept(SomeAvaliItemModItems.REDSTONEACCUMULATOR.get());
				tabData.accept(SomeAvaliItemModItems.QUARZITE.get());
				tabData.accept(SomeAvaliItemModItems.QUARZITEROD.get());
				tabData.accept(SomeAvaliItemModBlocks.PADDIUMORE.get().asItem());
				tabData.accept(SomeAvaliItemModItems.ROUGHPADDIUMORE.get());
				tabData.accept(SomeAvaliItemModItems.PADDIUMNUGGET.get());
				tabData.accept(SomeAvaliItemModItems.PADDIUM.get());
				tabData.accept(SomeAvaliItemModBlocks.CADMIUMORE.get().asItem());
				tabData.accept(SomeAvaliItemModItems.ROUGHCADMIUMORE.get());
				tabData.accept(SomeAvaliItemModItems.CADMIUMNUGGET.get());
				tabData.accept(SomeAvaliItemModItems.CADMIUM.get());
				tabData.accept(SomeAvaliItemModBlocks.NIHONIUMORE.get().asItem());
				tabData.accept(SomeAvaliItemModItems.ROUGHNIHONIUMORE.get());
				tabData.accept(SomeAvaliItemModItems.NIHONIUMNUGGET.get());
				tabData.accept(SomeAvaliItemModItems.NIHONIUM.get());
				tabData.accept(SomeAvaliItemModItems.TANTALNUGGET.get());
				tabData.accept(SomeAvaliItemModItems.TANTAL.get());
				tabData.accept(SomeAvaliItemModBlocks.CRYSTALORE.get().asItem());
				tabData.accept(SomeAvaliItemModItems.QUARZPEACE.get());
				tabData.accept(SomeAvaliItemModItems.ROUGHCRYSTALORE.get());
				tabData.accept(SomeAvaliItemModBlocks.HRIOORE.get().asItem());
				tabData.accept(SomeAvaliItemModItems.HRIOPEACE.get());
				tabData.accept(SomeAvaliItemModItems.HRIOCHIP.get());
				tabData.accept(SomeAvaliItemModItems.HRIOCRYSTAL.get());
				tabData.accept(SomeAvaliItemModItems.PUREHRIOCRYSTAL.get());
				tabData.accept(SomeAvaliItemModBlocks.DIAMATORE.get().asItem());
				tabData.accept(SomeAvaliItemModItems.DIAMATPEACE.get());
				tabData.accept(SomeAvaliItemModItems.DIAMATCHIP.get());
				tabData.accept(SomeAvaliItemModItems.ROUGHDIAMATCRYSTAL.get());
				tabData.accept(SomeAvaliItemModBlocks.MARGIUMORE.get().asItem());
				tabData.accept(SomeAvaliItemModItems.MARGIUMPEACE.get());
				tabData.accept(SomeAvaliItemModItems.MARGIUMCHIP.get());
				tabData.accept(SomeAvaliItemModItems.ROUGHMARGIUMCRYSTAL.get());
				tabData.accept(SomeAvaliItemModItems.QUARZCHIP.get());
				tabData.accept(SomeAvaliItemModItems.REDCRYSTAL.get());
				tabData.accept(SomeAvaliItemModItems.SLIMECRYSTALPEACE.get());
				tabData.accept(SomeAvaliItemModItems.SLIMECRYSTAL.get());
				tabData.accept(SomeAvaliItemModItems.OBSIDIANCHUNK.get());
				tabData.accept(SomeAvaliItemModItems.SIMPLEMICROCHIP.get());
				tabData.accept(SomeAvaliItemModItems.MICROCHIP.get());
				tabData.accept(SomeAvaliItemModItems.ADVANCEDMIRCOCHIP.get());
				tabData.accept(SomeAvaliItemModItems.REDSTONEWIRE.get());
				tabData.accept(SomeAvaliItemModItems.AEROGELCAN.get());
				tabData.accept(SomeAvaliItemModItems.AEROSHARPER.get());
				tabData.accept(SomeAvaliItemModItems.AEROPRINTER.get());
				tabData.accept(SomeAvaliItemModItems.DISPLAY.get());
				tabData.accept(SomeAvaliItemModItems.HOLOPROJECTOR.get());
				tabData.accept(SomeAvaliItemModItems.THREAD.get());
				tabData.accept(SomeAvaliItemModItems.HEATRESISTANCETHREAD.get());
				tabData.accept(SomeAvaliItemModItems.SINGLESOLARPANEL.get());
				tabData.accept(SomeAvaliItemModItems.PENCIL.get());
				tabData.accept(SomeAvaliItemModItems.AERONCIL.get());
				tabData.accept(SomeAvaliItemModItems.LEAF.get());
				tabData.accept(SomeAvaliItemModItems.LEAFYMOSS.get());
				tabData.accept(SomeAvaliItemModItems.GRANITEOF_SCIENCE.get());
				tabData.accept(SomeAvaliItemModItems.GRANITEBOOK.get());
				tabData.accept(SomeAvaliItemModItems.BLADEDRAWING.get());
				tabData.accept(SomeAvaliItemModItems.QUARZITEDRAWING.get());
				tabData.accept(SomeAvaliItemModItems.AMMONIA_BUCKET.get());
				tabData.accept(SomeAvaliItemModItems.REDDOT.get());
				tabData.accept(SomeAvaliItemModItems.LAPISDOT.get());
				tabData.accept(SomeAvaliItemModItems.GREENDOT.get());
				tabData.accept(SomeAvaliItemModItems.LEATHERPEACE.get());
				tabData.accept(SomeAvaliItemModItems.MEATCHUNK.get());
				tabData.accept(SomeAvaliItemModItems.MEATCHUNKCOOKED.get());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(SomeAvaliItemModItems.BEBROCKPICKAXE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(SomeAvaliItemModItems.ROMBA_SPAWN_EGG.get());
		}
	}
}