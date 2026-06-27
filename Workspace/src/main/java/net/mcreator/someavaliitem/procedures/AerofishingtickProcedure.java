package net.mcreator.someavaliitem.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;
import net.mcreator.someavaliitem.init.SomeAvaliItemModItems;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class AerofishingtickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double fish_timer = 0;
		double catch_factor = 0;
		if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROFISHROD.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == SomeAvaliItemModItems.AEROFISHROD.get())
				&& !world.getEntitiesOfClass(FishingHook.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(19 / 2d), e -> true).isEmpty()) {
			fish_timer = 400;
			catch_factor = 1 + (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LURE)) * 2;
			catch_factor = 1 + (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LURE)) * 2;
			if ((findEntityInWorldRange(world, FishingHook.class, x, y, z, 19)).isInLava()) {
				(findEntityInWorldRange(world, FishingHook.class, x, y, z, 19)).push(0, 0.03, 0);
			}
			if ((findEntityInWorldRange(world, FishingHook.class, x, y, z, 19)).isOnFire()) {
				{
					SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
					_vars.isAerofishing = true;
					_vars.markSyncDirty();
				}
			} else {
				{
					SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
					_vars.isAerofishing = false;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).isAerofishing) {
				if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).aerofishing_timer > 0) {
					{
						SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
						_vars.aerofishing_timer = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).aerofishing_timer - catch_factor;
						_vars.markSyncDirty();
					}
				} else {
					{
						SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
						_vars.aerofishing_timer = fish_timer + 20;
						_vars.markSyncDirty();
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 2);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.NEUTRAL, 1, 2, false);
						}
					}
					(findEntityInWorldRange(world, FishingHook.class, x, y, z, 19)).push(0, (-0.06), 0);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("FISH"), true);
				}
			} else {
				{
					SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
					_vars.aerofishing_timer = fish_timer;
					_vars.markSyncDirty();
				}
			}
		} else {
			{
				SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
				_vars.aerofishing_timer = fish_timer;
				_vars.markSyncDirty();
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}