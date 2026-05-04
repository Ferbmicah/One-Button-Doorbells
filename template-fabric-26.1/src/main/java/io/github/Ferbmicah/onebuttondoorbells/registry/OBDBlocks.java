package io.github.Ferbmicah.onebuttondoorbells.registry;

import io.github.Ferbmicah.onebuttondoorbells.OneButtonDoorbells;
import io.github.Ferbmicah.onebuttondoorbells.blocks.JukeButton;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.function.Function;

import static net.minecraft.world.level.block.Blocks.buttonProperties;

public class OBDBlocks {

	public static JukeButton CAT_BUTTON = register("cat_button", (p) -> new JukeButton(BlockSetType.OAK, 3560,p, SoundEvents.MUSIC_DISC_CAT.value()), buttonProperties(), true);

	public static JukeButton LAVA_CHICKEN_BUTTON = register("lava_chicken_button", (p) -> new JukeButton(BlockSetType.OAK, 2700,p, SoundEvents.MUSIC_DISC_LAVA_CHICKEN.value()), buttonProperties(), true);


	public static JukeButton PIGSTEP_BUTTON = register("pigstep_button", (p) -> new JukeButton(BlockSetType.OAK, 2960,p, SoundEvents.MUSIC_DISC_PIGSTEP.value()), buttonProperties(), true);


	private static JukeButton register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
		// Create a registry key for the block
		ResourceKey<Block> blockKey = keyOfBlock(name);
		// Create the block instance
		JukeButton block = (JukeButton) blockFactory.apply(settings.setId(blockKey));

		// Sometimes, you may not want to register an item for the block.
		// Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
		if (shouldRegisterItem) {
			// Items need to be registered with a different type of registry key, but the ID
			// can be the same.
			ResourceKey<Item> itemKey = keyOfItem(name);

			BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
			Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
		}

		return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
	}

	private static ResourceKey<Block> keyOfBlock(String name) {
		return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(OneButtonDoorbells.ID, name));
	}

	private static ResourceKey<Item> keyOfItem(String name) {
		return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(OneButtonDoorbells.ID, name));
	}

	public static void init()
	{

	}
}
