package net.mcreator.someavaliitem.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class HardiceBlock extends Block {
	public HardiceBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(1.25f, 1f).lightLevel(s -> 1).requiresCorrectToolForDrops().friction(0.85f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 14;
	}
}