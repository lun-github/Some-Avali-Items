package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.someavaliitem.init.SomeAvaliItemModItems;

public class Aerotool_rbmProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("sai:aerotool")))) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROPICKHANDLE.get()) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack4 = new ItemStack(SomeAvaliItemModItems.AEROPICK.get()).copy();
					_setstack4.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack4);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROAXEHANDLE.get()) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack7 = new ItemStack(SomeAvaliItemModItems.AEROAXE.get()).copy();
					_setstack7.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack7);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROSHOVELHANDLE.get()) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack10 = new ItemStack(SomeAvaliItemModItems.AEROSHOVEL.get()).copy();
					_setstack10.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack10);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROHOEHANDLE.get()) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack13 = new ItemStack(SomeAvaliItemModItems.AEROHOE.get()).copy();
					_setstack13.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack13);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROSHEARHANDLE.get()) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack16 = new ItemStack(SomeAvaliItemModItems.AEROSHEAR.get()).copy();
					_setstack16.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack16);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROBLADEHANDLE.get()) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack19 = new ItemStack(SomeAvaliItemModItems.AEROBLADE.get()).copy();
					_setstack19.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack19);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROIPERHANDLE.get()) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack22 = new ItemStack(SomeAvaliItemModItems.AEROIPER.get()).copy();
					_setstack22.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack22);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROSPEARHANDLE.get()) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack25 = new ItemStack(SomeAvaliItemModItems.AEROSPEAR.get()).copy();
					_setstack25.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack25);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROMERHANDLE.get()) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack28 = new ItemStack(SomeAvaliItemModItems.AEROMER.get()).copy();
					_setstack28.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack28);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.pickup")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}