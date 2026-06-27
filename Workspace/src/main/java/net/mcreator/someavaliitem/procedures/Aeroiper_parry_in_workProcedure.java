package net.mcreator.someavaliitem.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;
import net.mcreator.someavaliitem.init.SomeAvaliItemModEntities;
import net.mcreator.someavaliitem.entity.AerogelbladeEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class Aeroiper_parry_in_workProcedure {
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
		if (!(getEntityGameType(entity) == GameType.CREATIVE || getEntityGameType(entity) == GameType.SPECTATOR)) {
			if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).parry_window > 0) {
				{
					SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
					_vars.parry_window = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).parry_window - 1;
					_vars.markSyncDirty();
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).parry_health) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.glass.break")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.glass.break")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					{
						SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
						_vars.parry_window = 20;
						_vars.markSyncDirty();
					}
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).parry_health + 1));
					if (entity instanceof Player _player) {
						_player.getAbilities().invulnerable = (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).parry_window > 0);
						_player.onUpdateAbilities();
					}
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = initArrowProjectile(new AerogelbladeEntity(SomeAvaliItemModEntities.AEROGELBLADE.get(), projectileLevel), entity, 10, true, false, true, AbstractArrow.Pickup.CREATIVE_ONLY);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				}
			} else {
				if (entity instanceof Player _player) {
					_player.getAbilities().invulnerable = false;
					_player.onUpdateAbilities();
				}
			}
		} else {
			if (entity instanceof Player _player) {
				_player.getAbilities().invulnerable = true;
				_player.onUpdateAbilities();
			}
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}

	private static AbstractArrow initArrowProjectile(AbstractArrow entityToSpawn, Entity shooter, float damage, boolean silent, boolean fire, boolean particles, AbstractArrow.Pickup pickup) {
		entityToSpawn.setOwner(shooter);
		entityToSpawn.setBaseDamage(damage);
		if (silent)
			entityToSpawn.setSilent(true);
		if (fire)
			entityToSpawn.igniteForSeconds(100);
		if (particles)
			entityToSpawn.setCritArrow(true);
		entityToSpawn.pickup = pickup;
		return entityToSpawn;
	}
}