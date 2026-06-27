/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.someavaliitem.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.someavaliitem.block.*;
import net.mcreator.someavaliitem.SomeAvaliItemMod;

public class SomeAvaliItemModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(SomeAvaliItemMod.MODID);
	public static final DeferredBlock<Block> PORTALEMITTER;
	public static final DeferredBlock<Block> HARDICE;
	public static final DeferredBlock<Block> AMMONIAICE;
	public static final DeferredBlock<Block> SAKO;
	public static final DeferredBlock<Block> AMMONIA;
	public static final DeferredBlock<Block> CRYSTALORE;
	public static final DeferredBlock<Block> PADDIUMORE;
	public static final DeferredBlock<Block> CADMIUMORE;
	public static final DeferredBlock<Block> NIHONIUMORE;
	public static final DeferredBlock<Block> HRIOORE;
	public static final DeferredBlock<Block> DIAMATORE;
	public static final DeferredBlock<Block> MARGIUMORE;
	public static final DeferredBlock<Block> AEROBLOCK;
	public static final DeferredBlock<Block> CHIPCUTTER;
	static {
		PORTALEMITTER = REGISTRY.register("portalemitter", PortalemitterBlock::new);
		HARDICE = REGISTRY.register("hardice", HardiceBlock::new);
		AMMONIAICE = REGISTRY.register("ammoniaice", AmmoniaiceBlock::new);
		SAKO = REGISTRY.register("sako", SakoBlock::new);
		AMMONIA = REGISTRY.register("ammonia", AmmoniaBlock::new);
		CRYSTALORE = REGISTRY.register("crystalore", CrystaloreBlock::new);
		PADDIUMORE = REGISTRY.register("paddiumore", PaddiumoreBlock::new);
		CADMIUMORE = REGISTRY.register("cadmiumore", CadmiumoreBlock::new);
		NIHONIUMORE = REGISTRY.register("nihoniumore", NihoniumoreBlock::new);
		HRIOORE = REGISTRY.register("hrioore", HriooreBlock::new);
		DIAMATORE = REGISTRY.register("diamatore", DiamatoreBlock::new);
		MARGIUMORE = REGISTRY.register("margiumore", MargiumoreBlock::new);
		AEROBLOCK = REGISTRY.register("aeroblock", AeroblockBlock::new);
		CHIPCUTTER = REGISTRY.register("chipcutter", ChipcutterBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}