package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.someavaliitem.init.SomeAvaliItemModItems;
import net.mcreator.someavaliitem.init.SomeAvaliItemModBlocks;

public class Aeropick_block_destroyedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean x_cord = false;
		boolean y_cord = false;
		boolean z_cord = false;
		double i_cord = 0;
		double j_cord = 0;
		double block_hit = 0;
		if (!entity.isShiftKeyDown()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROMER.get()) {
				if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.UP
						|| (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
								.getDirection()) == Direction.DOWN) {
					j_cord = 1;
					for (int index0 = 0; index0 < 3; index0++) {
						i_cord = 1;
						for (int index1 = 0; index1 < 3; index1++) {
							if (blockstate.getBlock() == SomeAvaliItemModBlocks.AEROBLOCK.get() || blockstate.getBlock() == (world.getBlockState(BlockPos.containing(x + i_cord, y, z + j_cord))).getBlock()) {
								{
									BlockPos _pos = BlockPos.containing(x + i_cord, y, z + j_cord);
									Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
									world.destroyBlock(_pos, false);
								}
								block_hit = block_hit + 1;
							}
							i_cord = i_cord - 1;
						}
						j_cord = j_cord - 1;
					}
				} else if ((entity.getDirection()) == Direction.NORTH || (entity.getDirection()) == Direction.SOUTH) {
					j_cord = 1;
					for (int index2 = 0; index2 < 3; index2++) {
						i_cord = 1;
						for (int index3 = 0; index3 < 3; index3++) {
							if (blockstate.getBlock() == SomeAvaliItemModBlocks.AEROBLOCK.get() || blockstate.getBlock() == (world.getBlockState(BlockPos.containing(x + j_cord, y + i_cord, z))).getBlock()) {
								{
									BlockPos _pos = BlockPos.containing(x + j_cord, y + i_cord, z);
									Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
									world.destroyBlock(_pos, false);
								}
								block_hit = block_hit + 1;
							}
							i_cord = i_cord - 1;
						}
						j_cord = j_cord - 1;
					}
				} else if ((entity.getDirection()) == Direction.WEST || (entity.getDirection()) == Direction.EAST) {
					j_cord = 1;
					for (int index4 = 0; index4 < 3; index4++) {
						i_cord = 1;
						for (int index5 = 0; index5 < 3; index5++) {
							if (blockstate.getBlock() == SomeAvaliItemModBlocks.AEROBLOCK.get() || blockstate.getBlock() == (world.getBlockState(BlockPos.containing(x, y + j_cord, z + i_cord))).getBlock()) {
								{
									BlockPos _pos = BlockPos.containing(x, y + j_cord, z + i_cord);
									Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
									world.destroyBlock(_pos, false);
								}
								block_hit = block_hit + 1;
							}
							i_cord = i_cord - 1;
						}
						j_cord = j_cord - 1;
					}
				}
				if (block_hit <= 4) {
					if (world instanceof ServerLevel _level) {
						itemstack.hurtAndBreak((int) block_hit, _level, null, _stkprov -> {
						});
					}
				} else {
					if (world instanceof ServerLevel _level) {
						itemstack.hurtAndBreak(4, _level, null, _stkprov -> {
						});
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROPICK.get()) {
				if (entity.getY() == y - 1) {
					{
						BlockPos _pos = BlockPos.containing(x, y - 1, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
		}
	}
}