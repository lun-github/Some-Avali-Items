package net.mcreator.someavaliitem.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.network.chat.Component;

import net.mcreator.someavaliitem.init.SomeAvaliItemModItems;

import java.util.List;

public class AerofishrodItem extends FishingRodItem {
	public AerofishrodItem() {
		super(new Item.Properties().durability(256).fireResistant());
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
		return Ingredient.of(new ItemStack(SomeAvaliItemModItems.AEROGEL.get())).test(repairitem);
	}

	@Override
	public int getEnchantmentValue() {
		return 2;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.some_avali_item.aerofishrod.description_0"));
		list.add(Component.translatable("item.some_avali_item.aerofishrod.description_1"));
		list.add(Component.translatable("item.some_avali_item.aerofishrod.description_2"));
		list.add(Component.translatable("item.some_avali_item.aerofishrod.description_3"));
	}
}