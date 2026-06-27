package net.mcreator.someavaliitem.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;

import net.mcreator.someavaliitem.init.SomeAvaliItemModItems;
import net.mcreator.someavaliitem.init.SomeAvaliItemModBlocks;

public class Ore_mineProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		double rnd = 0;
		double forutne = 0;
		rnd = Math.random();
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)) > 0) {
			forutne = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE));
		} else {
			forutne = 1;
		}
		forutne = forutne / 100;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)) > 0
				&& blockstate.getBlock() == SomeAvaliItemModBlocks.CRYSTALORE.get()) {
			for (int index0 = 0; index0 < (int) Math.round(forutne / 2); index0++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(SomeAvaliItemModItems.ROUGHCRYSTALORE.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)) > 0
				&& blockstate.getBlock() == SomeAvaliItemModBlocks.PADDIUMORE.get()) {
			if (rnd <= 0.1 + forutne * 10) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(SomeAvaliItemModItems.ROUGHPADDIUMORE.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)) > 0
				&& blockstate.getBlock() == SomeAvaliItemModBlocks.CADMIUMORE.get()) {
			if (rnd <= 0.1 + forutne * 10) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(SomeAvaliItemModItems.ROUGHCADMIUMORE.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)) > 0
				&& blockstate.getBlock() == SomeAvaliItemModBlocks.NIHONIUMORE.get()) {
			if (rnd <= 0.1 + forutne * 2) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(SomeAvaliItemModItems.ROUGHNIHONIUMORE.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)) > 0
				&& blockstate.getBlock() == SomeAvaliItemModBlocks.HRIOORE.get()) {
			if (rnd <= 0.1 + forutne * 1) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(SomeAvaliItemModItems.HRIOCRYSTAL.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)) > 0
				&& blockstate.getBlock() == SomeAvaliItemModBlocks.DIAMATORE.get()) {
			if (rnd <= 0.1 + forutne * 1) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(SomeAvaliItemModItems.ROUGHDIAMATCRYSTAL.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)) > 0
				&& blockstate.getBlock() == SomeAvaliItemModBlocks.MARGIUMORE.get()) {
			if (rnd <= 0.1 + forutne * 1) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(SomeAvaliItemModItems.ROUGHMARGIUMCRYSTAL.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}