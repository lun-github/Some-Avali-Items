package net.mcreator.someavaliitem.item;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.*;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.someavaliitem.init.SomeAvaliItemModItems;

import java.util.List;

@EventBusSubscriber
public class BebrockpickaxeItem extends PickaxeItem {
	private static final Tier TOOL_TIER = new Tier() {
		@Override
		public int getUses() {
			return 0;
		}

		@Override
		public float getSpeed() {
			return 30f;
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
			return Ingredient.of();
		}
	};

	public BebrockpickaxeItem() {
		super(TOOL_TIER, new Item.Properties().attributes(DiggerItem.createAttributes(TOOL_TIER, 4f, -2.6f)).fireResistant());
	}

	@SubscribeEvent
	public static void handleToolDamage(ModifyDefaultComponentsEvent event) {
		event.modify(SomeAvaliItemModItems.BEBROCKPICKAXE.get(), builder -> builder.remove(DataComponents.MAX_DAMAGE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.some_avali_item.bebrockpickaxe.description_0"));
	}
}