package net.mcreator.someavaliitem.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.someavaliitem.procedures.Aerotool_hand_tickProcedure;
import net.mcreator.someavaliitem.procedures.Aeroiper_parryProcedure;
import net.mcreator.someavaliitem.procedures.Aeroiper_hitProcedure;
import net.mcreator.someavaliitem.init.SomeAvaliItemModItems;

import java.util.List;

public class AeroiperItem extends ShieldItem {
	public AeroiperItem() {
		super(new Item.Properties().durability(256).fireResistant());
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
		return Ingredient.of(new ItemStack(SomeAvaliItemModItems.AEROGEL.get())).test(repairitem);
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		Aeroiper_hitProcedure.execute(entity.level(), entity, sourceentity);
		return retval;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		Aeroiper_parryProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.some_avali_item.aeroiper.description_0"));
		list.add(Component.translatable("item.some_avali_item.aeroiper.description_1"));
		list.add(Component.translatable("item.some_avali_item.aeroiper.description_2"));
		list.add(Component.translatable("item.some_avali_item.aeroiper.description_3"));
		list.add(Component.translatable("item.some_avali_item.aeroiper.description_4"));
		list.add(Component.translatable("item.some_avali_item.aeroiper.description_5"));
		list.add(Component.translatable("item.some_avali_item.aeroiper.description_6"));
		list.add(Component.translatable("item.some_avali_item.aeroiper.description_7"));
		list.add(Component.translatable("item.some_avali_item.aeroiper.description_8"));
		list.add(Component.translatable("item.some_avali_item.aeroiper.description_9"));
		list.add(Component.translatable("item.some_avali_item.aeroiper.description_10"));
		list.add(Component.translatable("item.some_avali_item.aeroiper.description_11"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			Aerotool_hand_tickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}