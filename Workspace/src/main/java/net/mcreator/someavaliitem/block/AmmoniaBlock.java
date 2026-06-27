package net.mcreator.someavaliitem.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.someavaliitem.init.SomeAvaliItemModFluids;

public class AmmoniaBlock extends LiquidBlock {
	public AmmoniaBlock() {
		super(SomeAvaliItemModFluids.AMMONIA.get(), BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}
}