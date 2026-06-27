package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class Aeroshovel_block_destroyedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double y_cord = 0;
		if (!entity.isShiftKeyDown()) {
			while ((world.getBlockState(BlockPos.containing(x, y + y_cord, z))).is(BlockTags.create(ResourceLocation.parse("sai:loose")))) {
				{
					BlockPos _pos = BlockPos.containing(x, y + y_cord, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
				y_cord = y_cord + 1;
			}
			if (y_cord <= 8) {
				if (world instanceof ServerLevel _level) {
					itemstack.hurtAndBreak((int) y_cord, _level, null, _stkprov -> {
					});
				}
			} else {
				if (world instanceof ServerLevel _level) {
					itemstack.hurtAndBreak(8, _level, null, _stkprov -> {
					});
				}
			}
		}
	}
}