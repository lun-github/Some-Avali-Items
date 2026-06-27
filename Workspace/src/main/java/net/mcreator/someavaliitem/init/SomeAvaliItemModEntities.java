/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.someavaliitem.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.someavaliitem.entity.RombaEntity;
import net.mcreator.someavaliitem.entity.HookprojEntity;
import net.mcreator.someavaliitem.entity.AerogelbladeEntity;
import net.mcreator.someavaliitem.SomeAvaliItemMod;

@EventBusSubscriber
public class SomeAvaliItemModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, SomeAvaliItemMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<AerogelbladeEntity>> AEROGELBLADE = register("aerogelblade",
			EntityType.Builder.<AerogelbladeEntity>of(AerogelbladeEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<HookprojEntity>> HOOKPROJ = register("hookproj",
			EntityType.Builder.<HookprojEntity>of(HookprojEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<RombaEntity>> ROMBA = register("romba",
			EntityType.Builder.<RombaEntity>of(RombaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(16).setUpdateInterval(3)

					.sized(0.5f, 0.5f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		RombaEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(ROMBA.get(), RombaEntity.createAttributes().build());
	}
}