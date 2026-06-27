package net.mcreator.someavaliitem.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.someavaliitem.init.SomeAvaliItemModFluids;

public class AmmoniaItem extends BucketItem {
	public AmmoniaItem() {
		super(SomeAvaliItemModFluids.AMMONIA.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}