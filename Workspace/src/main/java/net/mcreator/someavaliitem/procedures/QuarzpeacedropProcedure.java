package net.mcreator.someavaliitem.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.someavaliitem.network.SomeAvaliItemModVariables;
import net.mcreator.someavaliitem.init.SomeAvaliItemModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class QuarzpeacedropProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double drop_rate = 0;
		drop_rate = 40 - Math.round(entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).quarz_peace_droped / 20);
		if (drop_rate < 1) {
			drop_rate = 1;
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DIORITE && Math.random() * 100 <= drop_rate) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(SomeAvaliItemModItems.QUARZPEACE.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			{
				SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
				_vars.quarz_peace_droped = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).quarz_peace_droped + 20;
				_vars.markSyncDirty();
			}
		} else {
			{
				SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
				_vars.quarz_peace_droped = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).quarz_peace_droped - 1;
				_vars.markSyncDirty();
			}
		}
		if (entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES).quarz_peace_droped <= 0) {
			{
				SomeAvaliItemModVariables.PlayerVariables _vars = entity.getData(SomeAvaliItemModVariables.PLAYER_VARIABLES);
				_vars.quarz_peace_droped = 0;
				_vars.markSyncDirty();
			}
		}
	}
}