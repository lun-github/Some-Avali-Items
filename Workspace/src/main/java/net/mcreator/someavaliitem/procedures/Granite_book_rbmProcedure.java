package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;
import net.mcreator.someavaliitem.init.SomeAvaliItemModItems;

public class Granite_book_rbmProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double additional_string = 0;
		double exp = 0;
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("exp") > 0) {
			if (entity.isShiftKeyDown()) {
				if (!entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).book_warn) {
					{
						SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
						_vars.book_warn = true;
						_vars.markSyncDirty();
					}
					if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).is_iq_set) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7cGranite book\u00A7f: Only Ultimate Mindformed Lifefrom, can do this trick... git gud chtr!"), false);
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7cGranite book\u00A7f: Only Ultimate Mindformed Lifefrom, can do this trick... if u dont, il destroy you!"), false);
					}
				} else {
					if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).iq_lvl >= 200) {
						exp = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("exp");
						if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).is_iq_set) {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A7cGranite book\u00A7f: A grand power has gain to \u00A7dWEAKY-PEAKEY PERSON!\u00A7f Go git gud mindo"), false);
							if (Math.ceil(exp * 1.1) > 0) {
								additional_string = Math.ceil(exp * 1.3);
							} else {
								additional_string = 0;
							}
						} else {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("\u00A7cGranite book\u00A7f: A grand power has gain to Ultimate Mindformed Lifefrom!"), false);
							if (Math.ceil(exp * 1.3) > 0) {
								additional_string = Math.ceil(exp * 1.3);
							} else {
								additional_string = 1;
							}
						}
						{
							final String _tagName = "exp";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
						}
						if (entity instanceof Player _player)
							_player.giveExperienceLevels((int) additional_string);
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(SomeAvaliItemModItems.GRANITEBOOK.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					} else {
						{
							SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
							_vars.mindblow_count = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).mindblow_count + 1;
							_vars.markSyncDirty();
						}
						{
							final String _tagName = "exp";
							final double _tagValue = (entity instanceof Player _plr ? _plr.experienceLevel : 0);
							CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7cGranite book\u00A7f: GET \u00A7dMIND\u00A74BLOW\u00A7fED LOL"), false);
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("some_avali_item:mindblow"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
						if (world instanceof Level _level && !_level.isClientSide())
							_level.explode(null, x, y, z, 50, Level.ExplosionInteraction.NONE);
					}
				}
			} else {
				if (entity instanceof Player _player)
					_player.giveExperienceLevels((int) itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("exp"));
				{
					final String _tagName = "exp";
					final double _tagValue = 0;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
		} else {
			{
				final String _tagName = "exp";
				final double _tagValue = (entity instanceof Player _plr ? _plr.experienceLevel : 0);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (entity instanceof Player _player)
				_player.giveExperienceLevels(-(entity instanceof Player _plr ? _plr.experienceLevel : 0));
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.enchantment_table.use")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.enchantment_table.use")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
	}
}