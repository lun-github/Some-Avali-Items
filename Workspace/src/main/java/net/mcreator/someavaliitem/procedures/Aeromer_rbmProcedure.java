package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.someavaliitem.init.SomeAvaliItemModBlocks;

public class Aeromer_rbmProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.UP
				&& (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR && !(entity.getY() == y + 1 && entity.getX() == x && entity.getZ() == z)) {
			world.setBlock(BlockPos.containing(x, y + 1, z), SomeAvaliItemModBlocks.AEROBLOCK.get().defaultBlockState(), 3);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 120);
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(10, _level, null, _stkprov -> {
				});
			}
		} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.DOWN
				&& (world.getBlockState(BlockPos.containing(x, y + -1, z))).getBlock() == Blocks.AIR && !(entity.getY() == y + -1 && entity.getX() == x && entity.getZ() == z)) {
			world.setBlock(BlockPos.containing(x, y + -1, z), SomeAvaliItemModBlocks.AEROBLOCK.get().defaultBlockState(), 3);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 120);
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(10, _level, null, _stkprov -> {
				});
			}
		} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.NORTH
				&& (world.getBlockState(BlockPos.containing(x, y, z + -1))).getBlock() == Blocks.AIR && !(entity.getZ() == z + -1 && entity.getX() == x && entity.getY() == y)) {
			world.setBlock(BlockPos.containing(x, y, z + -1), SomeAvaliItemModBlocks.AEROBLOCK.get().defaultBlockState(), 3);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 120);
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(10, _level, null, _stkprov -> {
				});
			}
		} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.SOUTH
				&& (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.AIR && !(entity.getZ() == z + 1 && entity.getX() == x && entity.getY() == y)) {
			world.setBlock(BlockPos.containing(x, y, z + 1), SomeAvaliItemModBlocks.AEROBLOCK.get().defaultBlockState(), 3);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 120);
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(10, _level, null, _stkprov -> {
				});
			}
		} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.WEST
				&& (world.getBlockState(BlockPos.containing(x + -1, y, z))).getBlock() == Blocks.AIR && !(entity.getX() == x + -1 && entity.getY() == y && entity.getZ() == z)) {
			world.setBlock(BlockPos.containing(x + -1, y, z), SomeAvaliItemModBlocks.AEROBLOCK.get().defaultBlockState(), 3);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 120);
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(10, _level, null, _stkprov -> {
				});
			}
		} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.EAST
				&& (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.AIR && !(entity.getX() == x + 1 && entity.getY() == y && entity.getZ() == z)) {
			world.setBlock(BlockPos.containing(x + 1, y, z), SomeAvaliItemModBlocks.AEROBLOCK.get().defaultBlockState(), 3);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 120);
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(10, _level, null, _stkprov -> {
				});
			}
		}
	}
}