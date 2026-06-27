package net.mcreator.someavaliitem.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

import com.mojang.serialization.MapCodec;

public class SakoBlock extends FallingBlock {
	public static final MapCodec<SakoBlock> CODEC = simpleCodec(properties -> new SakoBlock());

	public MapCodec<SakoBlock> codec() {
		return CODEC;
	}

	public SakoBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.SAND).strength(0.3f, 1f).friction(0.65f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}