package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.someavaliitem.init.SomeAvaliItemModItems;

public class Aerohoe_block_rbmProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double x_cord = 0;
		double z_cord = 0;
		if (!entity.isShiftKeyDown() && ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROHOE.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROHOE.get())) {
			z_cord = 1;
			for (int index0 = 0; index0 < 3; index0++) {
				x_cord = 1;
				for (int index1 = 0; index1 < 3; index1++) {
					if ((world.getBlockState(BlockPos.containing(x + x_cord, y + 1, z + z_cord))).getBlock() == Blocks.AIR
							&& (world.getBlockState(BlockPos.containing(x + x_cord, y, z + z_cord))).is(BlockTags.create(ResourceLocation.parse("sai:hoe")))) {
						world.setBlock(BlockPos.containing(x + x_cord, y, z + z_cord), Blocks.FARMLAND.defaultBlockState(), 3);
					}
					x_cord = x_cord - 1;
				}
				z_cord = z_cord - 1;
			}
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
				});
			}
		}
	}
}