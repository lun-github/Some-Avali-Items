package net.mcreator.someavaliitem.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.someavaliitem.procedures.Aerotool_hand_tickProcedure;

import java.util.List;

public class AeroshearItem extends ShearsItem {
	public AeroshearItem() {
		super(new Item.Properties().durability(256).fireResistant());
	}

	@Override
	public int getEnchantmentValue() {
		return 1;
	}

	@Override
	public float getDestroySpeed(ItemStack stack, BlockState blockstate) {
		return 15f;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.some_avali_item.aeroshear.description_0"));
		list.add(Component.translatable("item.some_avali_item.aeroshear.description_1"));
		list.add(Component.translatable("item.some_avali_item.aeroshear.description_2"));
		list.add(Component.translatable("item.some_avali_item.aeroshear.description_3"));
		list.add(Component.translatable("item.some_avali_item.aeroshear.description_4"));
		list.add(Component.translatable("item.some_avali_item.aeroshear.description_5"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			Aerotool_hand_tickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}