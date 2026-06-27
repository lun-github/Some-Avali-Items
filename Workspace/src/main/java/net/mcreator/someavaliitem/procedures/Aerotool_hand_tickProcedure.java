package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;
import net.mcreator.someavaliitem.init.SomeAvaliItemModItems;

public class Aerotool_hand_tickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("sai:aerotool")))) {
			if (itemstack.getMaxDamage() - 16 <= itemstack.getDamageValue() && hasEntityInInventory(entity, new ItemStack(SomeAvaliItemModItems.AEROGELCAN.get()))) {
				if (world instanceof ServerLevel _level) {
					itemstack.hurtAndBreak((int) (itemstack.getMaxDamage() / 2d), _level, null, _stkprov -> {
					});
				}
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(SomeAvaliItemModItems.AEROGELCAN.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone.place")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone.place")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (itemstack.getMaxDamage() - 16 <= itemstack.getDamageValue()) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROPICK.get()) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack19 = new ItemStack(SomeAvaliItemModItems.AEROPICKHANDLE.get()).copy();
						_setstack19.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack19);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(SomeAvaliItemModItems.AEROPICKHANDLE.get(), 120);
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROAXE.get()) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack23 = new ItemStack(SomeAvaliItemModItems.AEROAXEHANDLE.get()).copy();
						_setstack23.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack23);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(SomeAvaliItemModItems.AEROAXEHANDLE.get(), 120);
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROSHOVEL.get()) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack27 = new ItemStack(SomeAvaliItemModItems.AEROSHOVELHANDLE.get()).copy();
						_setstack27.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack27);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(SomeAvaliItemModItems.AEROSHOVELHANDLE.get(), 120);
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROHOE.get()
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROHOE.get()) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROHOE.get()) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack35 = new ItemStack(SomeAvaliItemModItems.AEROHOEHANDLE.get()).copy();
							_setstack35.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack35);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROHOE.get()) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack38 = new ItemStack(SomeAvaliItemModItems.AEROHOEHANDLE.get()).copy();
							_setstack38.setCount(1);
							_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack38);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(SomeAvaliItemModItems.AEROHOEHANDLE.get(), 120);
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROSHEAR.get()) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack42 = new ItemStack(SomeAvaliItemModItems.AEROSHEARHANDLE.get()).copy();
						_setstack42.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack42);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(SomeAvaliItemModItems.AEROSHEARHANDLE.get(), 120);
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROBLADE.get()) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack46 = new ItemStack(SomeAvaliItemModItems.AEROBLADEHANDLE.get()).copy();
						_setstack46.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack46);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(SomeAvaliItemModItems.AEROBLADEHANDLE.get(), 120);
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROIPER.get()) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack50 = new ItemStack(SomeAvaliItemModItems.AEROIPERHANDLE.get()).copy();
						_setstack50.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack50);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(SomeAvaliItemModItems.AEROIPERHANDLE.get(), 120);
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROSPEAR.get()) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack54 = new ItemStack(SomeAvaliItemModItems.AEROSPEARHANDLE.get()).copy();
						_setstack54.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack54);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(SomeAvaliItemModItems.AEROSPEARHANDLE.get(), 120);
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROMER.get()) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack58 = new ItemStack(SomeAvaliItemModItems.AEROMERHANDLE.get()).copy();
						_setstack58.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack58);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(SomeAvaliItemModItems.AEROMERHANDLE.get(), 120);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(SomeAvaliItemModItems.FORMEDAEROGEL.get()));
					entityToSpawn.setPickUpDelay(5);
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if (itemstack.getDamageValue() != 0) {
				if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).aerotool_repair > 0) {
					{
						SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
						_vars.aerotool_repair = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).aerotool_repair - 1;
						_vars.markSyncDirty();
					}
				} else {
					{
						SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
						_vars.aerotool_repair = 120;
						_vars.markSyncDirty();
					}
					if (world instanceof ServerLevel _level) {
						itemstack.hurtAndBreak(-1, _level, null, _stkprov -> {
						});
					}
				}
			}
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}