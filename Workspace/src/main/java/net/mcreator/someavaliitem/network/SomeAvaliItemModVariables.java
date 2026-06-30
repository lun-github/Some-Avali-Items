package net.mcreator.someavaliitem.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.mcreator.someavaliitem.SomeAvaliItemMod;

import java.util.function.Supplier;

@EventBusSubscriber
public class SomeAvaliItemModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, SomeAvaliItemMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		SomeAvaliItemMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@SubscribeEvent
	public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
	}

	@SubscribeEvent
	public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
	}

	@SubscribeEvent
	public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
	}

	@SubscribeEvent
	public static void onPlayerTickUpdateSyncPlayerVariables(PlayerTickEvent.Post event) {
		if (event.getEntity() instanceof ServerPlayer player && player.getData(PLAYER_VARIABLES)._syncDirty) {
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
			player.getData(PLAYER_VARIABLES)._syncDirty = false;
		}
	}

	@SubscribeEvent
	public static void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
		PlayerVariables clone = new PlayerVariables();
		clone.start_item = original.start_item;
		clone.mindblow_count = original.mindblow_count;
		clone.printer_state = original.printer_state;
		if (!event.isWasDeath()) {
			clone.aerofishing_timer = original.aerofishing_timer;
			clone.isAerofishing = original.isAerofishing;
			clone.aerotool_repair = original.aerotool_repair;
			clone.parry_window = original.parry_window;
			clone.parry_health = original.parry_health;
			clone.damage_boost = original.damage_boost;
			clone.graphite_hot = original.graphite_hot;
			clone.iq_lvl = original.iq_lvl;
			clone.book_warn = original.book_warn;
			clone.is_iq_set = original.is_iq_set;
			clone.is_alive = original.is_alive;
			clone.quarz_peace_droped = original.quarz_peace_droped;
			clone.harpon_x = original.harpon_x;
			clone.harpon_y = original.harpon_y;
			clone.harpon_z = original.harpon_z;
			clone.ishooked = original.ishooked;
			clone.hookAutoDetach = original.hookAutoDetach;
			clone.aeromer_fall_y1 = original.aeromer_fall_y1;
			clone.aeromer_fall_y2 = original.aeromer_fall_y2;
		}
		event.getEntity().setData(PLAYER_VARIABLES, clone);
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		boolean _syncDirty = false;
		public double aerofishing_timer = 600.0;
		public boolean isAerofishing = false;
		public double aerotool_repair = 0.0;
		public double parry_window = 0.0;
		public double parry_health = 2.0;
		public double damage_boost = 0;
		public boolean start_item = false;
		public double graphite_hot = 0;
		public double iq_lvl = 0;
		public boolean book_warn = false;
		public double mindblow_count = 0;
		public double printer_state = 0;
		public boolean is_iq_set = false;
		public boolean is_alive = false;
		public double quarz_peace_droped = 0;
		public double harpon_x = 0;
		public double harpon_y = 0;
		public double harpon_z = 0;
		public boolean ishooked = false;
		public double hookAutoDetach = 0;
		public double aeromer_fall_y1 = 0;
		public double aeromer_fall_y2 = 0;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("aerofishing_timer", aerofishing_timer);
			nbt.putBoolean("isAerofishing", isAerofishing);
			nbt.putDouble("aerotool_repair", aerotool_repair);
			nbt.putDouble("parry_window", parry_window);
			nbt.putDouble("parry_health", parry_health);
			nbt.putDouble("damage_boost", damage_boost);
			nbt.putBoolean("start_item", start_item);
			nbt.putDouble("graphite_hot", graphite_hot);
			nbt.putDouble("iq_lvl", iq_lvl);
			nbt.putBoolean("book_warn", book_warn);
			nbt.putDouble("mindblow_count", mindblow_count);
			nbt.putDouble("printer_state", printer_state);
			nbt.putBoolean("is_iq_set", is_iq_set);
			nbt.putBoolean("is_alive", is_alive);
			nbt.putDouble("quarz_peace_droped", quarz_peace_droped);
			nbt.putDouble("harpon_x", harpon_x);
			nbt.putDouble("harpon_y", harpon_y);
			nbt.putDouble("harpon_z", harpon_z);
			nbt.putBoolean("ishooked", ishooked);
			nbt.putDouble("hookAutoDetach", hookAutoDetach);
			nbt.putDouble("aeromer_fall_y1", aeromer_fall_y1);
			nbt.putDouble("aeromer_fall_y2", aeromer_fall_y2);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			aerofishing_timer = nbt.getDouble("aerofishing_timer");
			isAerofishing = nbt.getBoolean("isAerofishing");
			aerotool_repair = nbt.getDouble("aerotool_repair");
			parry_window = nbt.getDouble("parry_window");
			parry_health = nbt.getDouble("parry_health");
			damage_boost = nbt.getDouble("damage_boost");
			start_item = nbt.getBoolean("start_item");
			graphite_hot = nbt.getDouble("graphite_hot");
			iq_lvl = nbt.getDouble("iq_lvl");
			book_warn = nbt.getBoolean("book_warn");
			mindblow_count = nbt.getDouble("mindblow_count");
			printer_state = nbt.getDouble("printer_state");
			is_iq_set = nbt.getBoolean("is_iq_set");
			is_alive = nbt.getBoolean("is_alive");
			quarz_peace_droped = nbt.getDouble("quarz_peace_droped");
			harpon_x = nbt.getDouble("harpon_x");
			harpon_y = nbt.getDouble("harpon_y");
			harpon_z = nbt.getDouble("harpon_z");
			ishooked = nbt.getBoolean("ishooked");
			hookAutoDetach = nbt.getDouble("hookAutoDetach");
			aeromer_fall_y1 = nbt.getDouble("aeromer_fall_y1");
			aeromer_fall_y2 = nbt.getDouble("aeromer_fall_y2");
		}

		public void markSyncDirty() {
			_syncDirty = true;
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SomeAvaliItemMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}