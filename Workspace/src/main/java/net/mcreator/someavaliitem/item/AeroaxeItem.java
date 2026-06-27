package net.mcreator.someavaliitem.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.network.chat.Component;

import net.mcreator.someavaliitem.procedures.Aerotool_hand_tickProcedure;
import net.mcreator.someavaliitem.procedures.Aeroaxe_hitProcedure;
import net.mcreator.someavaliitem.init.SomeAvaliItemModItems;

import java.util.List;

public class AeroaxeItem extends AxeItem {
	private static final Tier TOOL_TIER = new Tier() {
		@Override
		public int getUses() {
			return 256;
		}

		@Override
		public float getSpeed() {
			return 15f;
		}

		@Override
		public float getAttackDamageBonus() {
			return 0;
		}

		@Override
		public TagKey<Block> getIncorrectBlocksForDrops() {
			return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
		}

		@Override
		public int getEnchantmentValue() {
			return 1;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.of(new ItemStack(SomeAvaliItemModItems.AEROGEL.get()));
		}
	};

	public AeroaxeItem() {
		super(TOOL_TIER, new Item.Properties().attributes(DiggerItem.createAttributes(TOOL_TIER, 10f, -3.1f)).fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		Aeroaxe_hitProcedure.execute(entity.level(), entity, itemstack);
		return retval;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.some_avali_item.aeroaxe.description_0"));
		list.add(Component.translatable("item.some_avali_item.aeroaxe.description_1"));
		list.add(Component.translatable("item.some_avali_item.aeroaxe.description_2"));
		list.add(Component.translatable("item.some_avali_item.aeroaxe.description_3"));
		list.add(Component.translatable("item.some_avali_item.aeroaxe.description_4"));
		list.add(Component.translatable("item.some_avali_item.aeroaxe.description_5"));
		list.add(Component.translatable("item.some_avali_item.aeroaxe.description_6"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			Aerotool_hand_tickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}