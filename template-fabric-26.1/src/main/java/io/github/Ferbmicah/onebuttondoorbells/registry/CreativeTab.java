package io.github.Ferbmicah.onebuttondoorbells.registry;

import io.github.Ferbmicah.onebuttondoorbells.OneButtonDoorbells;
import io.github.Ferbmicah.onebuttondoorbells.blocks.JukeButton;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import static io.github.Ferbmicah.onebuttondoorbells.registry.OBDBlocks.CAT_BUTTON;
import static io.github.Ferbmicah.onebuttondoorbells.registry.OBDBlocks.LAVA_CHICKEN_BUTTON;
import static io.github.Ferbmicah.onebuttondoorbells.registry.OBDBlocks.PIGSTEP_BUTTON;

public class CreativeTab {

	public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(
		BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(OneButtonDoorbells.ID, "creative_tab")
	);
	public static final CreativeModeTab CUSTOM_CREATIVE_TAB = FabricCreativeModeTab.builder()
		.icon(() -> new ItemStack(CAT_BUTTON))
		.title(Component.translatable("One Button Doorbells"))
		.displayItems((params, output) -> {
			output.accept(PIGSTEP_BUTTON);
			output.accept(CAT_BUTTON);
			output.accept(LAVA_CHICKEN_BUTTON);

		})
		.build();

	public static void init() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_CREATIVE_TAB_KEY, CUSTOM_CREATIVE_TAB);
	}
}
