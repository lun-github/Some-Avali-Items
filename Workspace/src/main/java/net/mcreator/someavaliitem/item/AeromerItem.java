package net.mcreator.someavaliitem.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.someavaliitem.procedures.Aerotool_hand_tickProcedure;
import net.mcreator.someavaliitem.procedures.Aeropick_block_destroyedProcedure;
import net.mcreator.someavaliitem.procedures.Aeromer_rbmProcedure;
import net.mcreator.someavaliitem.procedures.Aeromer_inv_tickProcedure;
import net.mcreator.someavaliitem.procedures.Aeromer_hitProcedure;
import net.mcreator.someavaliitem.init.SomeAvaliItemModItems;

import java.util.List;

public class AeromerItem extends PickaxeItem {
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

	public AeromerItem() {
		super(TOOL_TIER, new Item.Properties().attributes(DiggerItem.createAttributes(TOOL_TIER, 5f, -3.4f)).fireResistant());
	}

	@Override
	public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
		boolean retval = super.mineBlock(itemstack, world, blockstate, pos, entity);
		Aeropick_block_destroyedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate, entity, itemstack);
		return retval;
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		Aeromer_hitProcedure.execute(entity.level(), entity.getY(), entity, sourceentity, itemstack);
		return retval;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.some_avali_item.aeromer.description_0"));
		list.add(Component.translatable("item.some_avali_item.aeromer.description_1"));
		list.add(Component.translatable("item.some_avali_item.aeromer.description_2"));
		list.add(Component.translatable("item.some_avali_item.aeromer.description_3"));
		list.add(Component.translatable("item.some_avali_item.aeromer.description_4"));
		list.add(Component.translatable("item.some_avali_item.aeromer.description_5"));
		list.add(Component.translatable("item.some_avali_item.aeromer.description_6"));
		list.add(Component.translatable("item.some_avali_item.aeromer.description_7"));
		list.add(Component.translatable("item.some_avali_item.aeromer.description_8"));
		list.add(Component.translatable("item.some_avali_item.aeromer.description_9"));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		Aeromer_rbmProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			Aerotool_hand_tickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
		Aeromer_inv_tickProcedure.execute(entity.getY(), entity);
	}
}