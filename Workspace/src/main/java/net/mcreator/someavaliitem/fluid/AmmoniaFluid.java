package net.mcreator.someavaliitem.fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.someavaliitem.init.SomeAvaliItemModItems;
import net.mcreator.someavaliitem.init.SomeAvaliItemModFluids;
import net.mcreator.someavaliitem.init.SomeAvaliItemModFluidTypes;
import net.mcreator.someavaliitem.init.SomeAvaliItemModBlocks;

public abstract class AmmoniaFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> SomeAvaliItemModFluidTypes.AMMONIA_TYPE.get(), () -> SomeAvaliItemModFluids.AMMONIA.get(), () -> SomeAvaliItemModFluids.FLOWING_AMMONIA.get())
			.explosionResistance(100f).bucket(() -> SomeAvaliItemModItems.AMMONIA_BUCKET.get()).block(() -> (LiquidBlock) SomeAvaliItemModBlocks.AMMONIA.get());

	private AmmoniaFluid() {
		super(PROPERTIES);
	}

	public static class Source extends AmmoniaFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends AmmoniaFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}