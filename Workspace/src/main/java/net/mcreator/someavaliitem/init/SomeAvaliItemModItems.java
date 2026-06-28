/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.someavaliitem.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.capability.wrappers.FluidBucketWrapper;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.mcreator.someavaliitem.item.*;
import net.mcreator.someavaliitem.SomeAvaliItemMod;

public class SomeAvaliItemModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(SomeAvaliItemMod.MODID);
	public static final DeferredItem<Item> AEROGEL;
	public static final DeferredItem<Item> GRAPHITE;
	public static final DeferredItem<Item> AEROFISHROD;
	public static final DeferredItem<Item> THREAD;
	public static final DeferredItem<Item> GRAPHITEBLANK;
	public static final DeferredItem<Item> GRAPHITEPEACE;
	public static final DeferredItem<Item> BEBROCKPICKAXE;
	public static final DeferredItem<Item> SELICAGEL;
	public static final DeferredItem<Item> PORTALEMITTER;
	public static final DeferredItem<Item> HARDICE;
	public static final DeferredItem<Item> AMMONIAICE;
	public static final DeferredItem<Item> SAKO;
	public static final DeferredItem<Item> AMMONIA_BUCKET;
	public static final DeferredItem<Item> OBSIDIANCHUNK;
	public static final DeferredItem<Item> GRAPHITEROD;
	public static final DeferredItem<Item> AEROGELPACK;
	public static final DeferredItem<Item> AEROPICK;
	public static final DeferredItem<Item> AEROPICKHANDLE;
	public static final DeferredItem<Item> AEROPRINTER;
	public static final DeferredItem<Item> AEROSHARPER;
	public static final DeferredItem<Item> BLADEDRAWING;
	public static final DeferredItem<Item> REDSTONEWIRE;
	public static final DeferredItem<Item> TANTAL;
	public static final DeferredItem<Item> ADVANCEDMIRCOCHIP;
	public static final DeferredItem<Item> AEROAXE;
	public static final DeferredItem<Item> AEROAXEHANDLE;
	public static final DeferredItem<Item> AEROSHOVEL;
	public static final DeferredItem<Item> AEROHOE;
	public static final DeferredItem<Item> AEROSHEAR;
	public static final DeferredItem<Item> AEROBLADE;
	public static final DeferredItem<Item> CRYSTALORE;
	public static final DeferredItem<Item> FORMEDAEROGEL;
	public static final DeferredItem<Item> AEROSHOVELHANDLE;
	public static final DeferredItem<Item> AEROHOEHANDLE;
	public static final DeferredItem<Item> AEROSHEARHANDLE;
	public static final DeferredItem<Item> AEROBLADEHANDLE;
	public static final DeferredItem<Item> AEROIPER;
	public static final DeferredItem<Item> AEROIPERHANDLE;
	public static final DeferredItem<Item> STRANGEFEATHER;
	public static final DeferredItem<Item> AEROSPEAR;
	public static final DeferredItem<Item> AEROSPEARHANDLE;
	public static final DeferredItem<Item> AEROGELDUST;
	public static final DeferredItem<Item> AEROGELCAN;
	public static final DeferredItem<Item> REDSTONEBATTERY;
	public static final DeferredItem<Item> REDSTONEACCUMULATOR;
	public static final DeferredItem<Item> REDSTONEBATTERYEMPTY;
	public static final DeferredItem<Item> REDSTONEACCUMULATOREMPTY;
	public static final DeferredItem<Item> QUARZITE;
	public static final DeferredItem<Item> PADDIUM;
	public static final DeferredItem<Item> CADMIUM;
	public static final DeferredItem<Item> NIHONIUM;
	public static final DeferredItem<Item> PADDIUMNUGGET;
	public static final DeferredItem<Item> CADMIUMNUGGET;
	public static final DeferredItem<Item> NIHONIUMNUGGET;
	public static final DeferredItem<Item> TANTALNUGGET;
	public static final DeferredItem<Item> HRIOCRYSTAL;
	public static final DeferredItem<Item> PUREHRIOCRYSTAL;
	public static final DeferredItem<Item> HRIOCHIP;
	public static final DeferredItem<Item> HRIOPEACE;
	public static final DeferredItem<Item> DIAMATCHIP;
	public static final DeferredItem<Item> SIMPLEMICROCHIP;
	public static final DeferredItem<Item> MICROCHIP;
	public static final DeferredItem<Item> DISPLAY;
	public static final DeferredItem<Item> SINGLESOLARPANEL;
	public static final DeferredItem<Item> HEATEDGRAPHITEROD;
	public static final DeferredItem<Item> LEAF;
	public static final DeferredItem<Item> LEAFYMOSS;
	public static final DeferredItem<Item> DEBUGGER;
	public static final DeferredItem<Item> GRANITEBOOK;
	public static final DeferredItem<Item> GRANITEOF_SCIENCE;
	public static final DeferredItem<Item> AERONEEDLE;
	public static final DeferredItem<Item> REDCRYSTAL;
	public static final DeferredItem<Item> HOLOPROJECTOR;
	public static final DeferredItem<Item> QUARZCHIP;
	public static final DeferredItem<Item> QUARZITEDRAWING;
	public static final DeferredItem<Item> AEROKNIFE;
	public static final DeferredItem<Item> MARGIUMCHIP;
	public static final DeferredItem<Item> ROUGHDIAMATCRYSTAL;
	public static final DeferredItem<Item> ROUGHMARGIUMCRYSTAL;
	public static final DeferredItem<Item> SLIMECRYSTAL;
	public static final DeferredItem<Item> PORTABLEPRINTER;
	public static final DeferredItem<Item> PRINTEDPICKAXE;
	public static final DeferredItem<Item> PRINTEDSWORD;
	public static final DeferredItem<Item> PRINTEDAXE;
	public static final DeferredItem<Item> PRINTEDSHOVEL;
	public static final DeferredItem<Item> PRINTEDHOE;
	public static final DeferredItem<Item> PRINTEDSHEAR;
	public static final DeferredItem<Item> SMALLGRINDSTONE;
	public static final DeferredItem<Item> AEROSHIELD;
	public static final DeferredItem<Item> SHIELDEMMITER;
	public static final DeferredItem<Item> DESICCANTSILICAGEL;
	public static final DeferredItem<Item> ROUGHPADDIUMORE;
	public static final DeferredItem<Item> ROUGHCADMIUMORE;
	public static final DeferredItem<Item> ROUGHCRYSTALORE;
	public static final DeferredItem<Item> ROUGHNIHONIUMORE;
	public static final DeferredItem<Item> PADDIUMORE;
	public static final DeferredItem<Item> CADMIUMORE;
	public static final DeferredItem<Item> NIHONIUMORE;
	public static final DeferredItem<Item> HRIOORE;
	public static final DeferredItem<Item> DIAMATORE;
	public static final DeferredItem<Item> MARGIUMORE;
	public static final DeferredItem<Item> AEROMER;
	public static final DeferredItem<Item> AEROMERHANDLE;
	public static final DeferredItem<Item> AEROBLOCK;
	public static final DeferredItem<Item> QUARZITEROD;
	public static final DeferredItem<Item> DIAMATPEACE;
	public static final DeferredItem<Item> MARGIUMPEACE;
	public static final DeferredItem<Item> QUARZPEACE;
	public static final DeferredItem<Item> SLIMECRYSTALPEACE;
	public static final DeferredItem<Item> REDDOT;
	public static final DeferredItem<Item> CHIPCUTTER;
	public static final DeferredItem<Item> AEROHOOK;
	public static final DeferredItem<Item> HARPOON;
	public static final DeferredItem<Item> LAPISDOT;
	public static final DeferredItem<Item> GREENDOT;
	public static final DeferredItem<Item> ROMBA_SPAWN_EGG;
	public static final DeferredItem<Item> PENCIL;
	public static final DeferredItem<Item> AERONCIL;
	public static final DeferredItem<Item> HEATRESISTANCETHREAD;
	static {
		AEROGEL = REGISTRY.register("aerogel", AerogelItem::new);
		GRAPHITE = REGISTRY.register("graphite", GraphiteItem::new);
		AEROFISHROD = REGISTRY.register("aerofishrod", AerofishrodItem::new);
		THREAD = REGISTRY.register("thread", ThreadItem::new);
		GRAPHITEBLANK = REGISTRY.register("graphiteblank", GraphiteblankItem::new);
		GRAPHITEPEACE = REGISTRY.register("graphitepeace", GraphitepeaceItem::new);
		BEBROCKPICKAXE = REGISTRY.register("bebrockpickaxe", BebrockpickaxeItem::new);
		SELICAGEL = REGISTRY.register("selicagel", SelicagelItem::new);
		PORTALEMITTER = block(SomeAvaliItemModBlocks.PORTALEMITTER);
		HARDICE = block(SomeAvaliItemModBlocks.HARDICE);
		AMMONIAICE = block(SomeAvaliItemModBlocks.AMMONIAICE);
		SAKO = block(SomeAvaliItemModBlocks.SAKO);
		AMMONIA_BUCKET = REGISTRY.register("ammonia_bucket", AmmoniaItem::new);
		OBSIDIANCHUNK = REGISTRY.register("obsidianchunk", ObsidianchunkItem::new);
		GRAPHITEROD = REGISTRY.register("graphiterod", GraphiterodItem::new);
		AEROGELPACK = REGISTRY.register("aerogelpack", AerogelpackItem::new);
		AEROPICK = REGISTRY.register("aeropick", AeropickItem::new);
		AEROPICKHANDLE = REGISTRY.register("aeropickhandle", AeropickhandleItem::new);
		AEROPRINTER = REGISTRY.register("aeroprinter", AeroprinterItem::new);
		AEROSHARPER = REGISTRY.register("aerosharper", AerosharperItem::new);
		BLADEDRAWING = REGISTRY.register("bladedrawing", BladedrawingItem::new);
		REDSTONEWIRE = REGISTRY.register("redstonewire", RedstonewireItem::new);
		TANTAL = REGISTRY.register("tantal", TantalItem::new);
		ADVANCEDMIRCOCHIP = REGISTRY.register("advancedmircochip", AdvancedmircochipItem::new);
		AEROAXE = REGISTRY.register("aeroaxe", AeroaxeItem::new);
		AEROAXEHANDLE = REGISTRY.register("aeroaxehandle", AeroaxehandleItem::new);
		AEROSHOVEL = REGISTRY.register("aeroshovel", AeroshovelItem::new);
		AEROHOE = REGISTRY.register("aerohoe", AerohoeItem::new);
		AEROSHEAR = REGISTRY.register("aeroshear", AeroshearItem::new);
		AEROBLADE = REGISTRY.register("aeroblade", AerobladeItem::new);
		CRYSTALORE = block(SomeAvaliItemModBlocks.CRYSTALORE);
		FORMEDAEROGEL = REGISTRY.register("formedaerogel", FormedaerogelItem::new);
		AEROSHOVELHANDLE = REGISTRY.register("aeroshovelhandle", AeroshovelhandleItem::new);
		AEROHOEHANDLE = REGISTRY.register("aerohoehandle", AerohoehandleItem::new);
		AEROSHEARHANDLE = REGISTRY.register("aeroshearhandle", AeroshearhandleItem::new);
		AEROBLADEHANDLE = REGISTRY.register("aerobladehandle", AerobladehandleItem::new);
		AEROIPER = REGISTRY.register("aeroiper", AeroiperItem::new);
		AEROIPERHANDLE = REGISTRY.register("aeroiperhandle", AeroiperhandleItem::new);
		STRANGEFEATHER = REGISTRY.register("strangefeather", StrangefeatherItem::new);
		AEROSPEAR = REGISTRY.register("aerospear", AerospearItem::new);
		AEROSPEARHANDLE = REGISTRY.register("aerospearhandle", AerospearhandleItem::new);
		AEROGELDUST = REGISTRY.register("aerogeldust", AerogeldustItem::new);
		AEROGELCAN = REGISTRY.register("aerogelcan", AerogelcanItem::new);
		REDSTONEBATTERY = REGISTRY.register("redstonebattery", RedstonebatteryItem::new);
		REDSTONEACCUMULATOR = REGISTRY.register("redstoneaccumulator", RedstoneaccumulatorItem::new);
		REDSTONEBATTERYEMPTY = REGISTRY.register("redstonebatteryempty", RedstonebatteryemptyItem::new);
		REDSTONEACCUMULATOREMPTY = REGISTRY.register("redstoneaccumulatorempty", RedstoneaccumulatoremptyItem::new);
		QUARZITE = REGISTRY.register("quarzite", QuarziteItem::new);
		PADDIUM = REGISTRY.register("paddium", PaddiumItem::new);
		CADMIUM = REGISTRY.register("cadmium", CadmiumItem::new);
		NIHONIUM = REGISTRY.register("nihonium", NihoniumItem::new);
		PADDIUMNUGGET = REGISTRY.register("paddiumnugget", PaddiumnuggetItem::new);
		CADMIUMNUGGET = REGISTRY.register("cadmiumnugget", CadmiumnuggetItem::new);
		NIHONIUMNUGGET = REGISTRY.register("nihoniumnugget", NihoniumnuggetItem::new);
		TANTALNUGGET = REGISTRY.register("tantalnugget", TantalnuggetItem::new);
		HRIOCRYSTAL = REGISTRY.register("hriocrystal", HriocrystalItem::new);
		PUREHRIOCRYSTAL = REGISTRY.register("purehriocrystal", PurehriocrystalItem::new);
		HRIOCHIP = REGISTRY.register("hriochip", HriochipItem::new);
		HRIOPEACE = REGISTRY.register("hriopeace", HriopeaceItem::new);
		DIAMATCHIP = REGISTRY.register("diamatchip", DiamatchipItem::new);
		SIMPLEMICROCHIP = REGISTRY.register("simplemicrochip", SimplemicrochipItem::new);
		MICROCHIP = REGISTRY.register("microchip", MicrochipItem::new);
		DISPLAY = REGISTRY.register("display", DisplayItem::new);
		SINGLESOLARPANEL = REGISTRY.register("singlesolarpanel", SinglesolarpanelItem::new);
		HEATEDGRAPHITEROD = REGISTRY.register("heatedgraphiterod", HeatedgraphiterodItem::new);
		LEAF = REGISTRY.register("leaf", LeafItem::new);
		LEAFYMOSS = REGISTRY.register("leafymoss", LeafymossItem::new);
		DEBUGGER = REGISTRY.register("debugger", DebuggerItem::new);
		GRANITEBOOK = REGISTRY.register("granitebook", GranitebookItem::new);
		GRANITEOF_SCIENCE = REGISTRY.register("graniteof_science", GraniteofScienceItem::new);
		AERONEEDLE = REGISTRY.register("aeroneedle", AeroneedleItem::new);
		REDCRYSTAL = REGISTRY.register("redcrystal", RedcrystalItem::new);
		HOLOPROJECTOR = REGISTRY.register("holoprojector", HoloprojectorItem::new);
		QUARZCHIP = REGISTRY.register("quarzchip", QuarzchipItem::new);
		QUARZITEDRAWING = REGISTRY.register("quarzitedrawing", QuarzitedrawingItem::new);
		AEROKNIFE = REGISTRY.register("aeroknife", AeroknifeItem::new);
		MARGIUMCHIP = REGISTRY.register("margiumchip", MargiumchipItem::new);
		ROUGHDIAMATCRYSTAL = REGISTRY.register("roughdiamatcrystal", RoughdiamatcrystalItem::new);
		ROUGHMARGIUMCRYSTAL = REGISTRY.register("roughmargiumcrystal", RoughmargiumcrystalItem::new);
		SLIMECRYSTAL = REGISTRY.register("slimecrystal", SlimecrystalItem::new);
		PORTABLEPRINTER = REGISTRY.register("portableprinter", PortableprinterItem::new);
		PRINTEDPICKAXE = REGISTRY.register("printedpickaxe", PrintedpickaxeItem::new);
		PRINTEDSWORD = REGISTRY.register("printedsword", PrintedswordItem::new);
		PRINTEDAXE = REGISTRY.register("printedaxe", PrintedaxeItem::new);
		PRINTEDSHOVEL = REGISTRY.register("printedshovel", PrintedshovelItem::new);
		PRINTEDHOE = REGISTRY.register("printedhoe", PrintedhoeItem::new);
		PRINTEDSHEAR = REGISTRY.register("printedshear", PrintedshearItem::new);
		SMALLGRINDSTONE = REGISTRY.register("smallgrindstone", SmallgrindstoneItem::new);
		AEROSHIELD = REGISTRY.register("aeroshield", AeroshieldItem::new);
		SHIELDEMMITER = REGISTRY.register("shieldemmiter", ShieldemmiterItem::new);
		DESICCANTSILICAGEL = REGISTRY.register("desiccantsilicagel", DesiccantsilicagelItem::new);
		ROUGHPADDIUMORE = REGISTRY.register("roughpaddiumore", RoughpaddiumoreItem::new);
		ROUGHCADMIUMORE = REGISTRY.register("roughcadmiumore", RoughcadmiumoreItem::new);
		ROUGHCRYSTALORE = REGISTRY.register("roughcrystalore", RoughcrystaloreItem::new);
		ROUGHNIHONIUMORE = REGISTRY.register("roughnihoniumore", RoughnihoniumoreItem::new);
		PADDIUMORE = block(SomeAvaliItemModBlocks.PADDIUMORE);
		CADMIUMORE = block(SomeAvaliItemModBlocks.CADMIUMORE);
		NIHONIUMORE = block(SomeAvaliItemModBlocks.NIHONIUMORE);
		HRIOORE = block(SomeAvaliItemModBlocks.HRIOORE);
		DIAMATORE = block(SomeAvaliItemModBlocks.DIAMATORE);
		MARGIUMORE = block(SomeAvaliItemModBlocks.MARGIUMORE);
		AEROMER = REGISTRY.register("aeromer", AeromerItem::new);
		AEROMERHANDLE = REGISTRY.register("aeromerhandle", AeromerhandleItem::new);
		AEROBLOCK = block(SomeAvaliItemModBlocks.AEROBLOCK);
		QUARZITEROD = REGISTRY.register("quarziterod", QuarziterodItem::new);
		DIAMATPEACE = REGISTRY.register("diamatpeace", DiamatpeaceItem::new);
		MARGIUMPEACE = REGISTRY.register("margiumpeace", MargiumpeaceItem::new);
		QUARZPEACE = REGISTRY.register("quarzpeace", QuarzpeaceItem::new);
		SLIMECRYSTALPEACE = REGISTRY.register("slimecrystalpeace", SlimecrystalpeaceItem::new);
		REDDOT = REGISTRY.register("reddot", ReddotItem::new);
		CHIPCUTTER = block(SomeAvaliItemModBlocks.CHIPCUTTER);
		AEROHOOK = REGISTRY.register("aerohook", AerohookItem::new);
		HARPOON = REGISTRY.register("harpoon", HarpoonItem::new);
		LAPISDOT = REGISTRY.register("lapisdot", LapisdotItem::new);
		GREENDOT = REGISTRY.register("greendot", GreendotItem::new);
		ROMBA_SPAWN_EGG = REGISTRY.register("romba_spawn_egg", () -> new DeferredSpawnEggItem(SomeAvaliItemModEntities.ROMBA, -1, -1, new Item.Properties()));
		PENCIL = REGISTRY.register("pencil", PencilItem::new);
		AERONCIL = REGISTRY.register("aeroncil", AeroncilItem::new);
		HEATRESISTANCETHREAD = REGISTRY.register("heatresistancethread", HeatresistancethreadItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerItem(Capabilities.FluidHandler.ITEM, (stack, context) -> new FluidBucketWrapper(stack), AMMONIA_BUCKET.get());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class ItemsClientSideHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public static void clientLoad(FMLClientSetupEvent event) {
			event.enqueueWork(() -> {
				ItemProperties.register(AEROSHIELD.get(), ResourceLocation.parse("minecraft:blocking"), ItemProperties.getProperty(new ItemStack(Items.SHIELD), ResourceLocation.parse("minecraft:blocking")));
			});
		}
	}
}