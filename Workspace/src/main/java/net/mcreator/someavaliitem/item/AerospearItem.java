package net.mcreator.someavaliitem.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.network.chat.Component;

import net.mcreator.someavaliitem.procedures.Aerotool_hand_tickProcedure;
import net.mcreator.someavaliitem.procedures.Aerospear_sweepProcedure;
import net.mcreator.someavaliitem.procedures.Aerospear_rbmProcedure;
import net.mcreator.someavaliitem.init.SomeAvaliItemModItems;

import java.util.List;

public class AerospearItem extends SwordItem {
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

	public AerospearItem() {
		super(TOOL_TIER, new Item.Properties().attributes(SwordItem.createAttributes(TOOL_TIER, 11f, -3.1f)).fireResistant());
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		Aerospear_rbmProcedure.execute(entity);
		return ar;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.some_avali_item.aerospear.description_0"));
		list.add(Component.translatable("item.some_avali_item.aerospear.description_1"));
		list.add(Component.translatable("item.some_avali_item.aerospear.description_2"));
		list.add(Component.translatable("item.some_avali_item.aerospear.description_3"));
		list.add(Component.translatable("item.some_avali_item.aerospear.description_4"));
		list.add(Component.translatable("item.some_avali_item.aerospear.description_5"));
		list.add(Component.translatable("item.some_avali_item.aerospear.description_6"));
		list.add(Component.translatable("item.some_avali_item.aerospear.description_7"));
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity, InteractionHand hand) {
		boolean retval = super.onEntitySwing(itemstack, entity, hand);
		Aerospear_sweepProcedure.execute(entity);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			Aerotool_hand_tickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}