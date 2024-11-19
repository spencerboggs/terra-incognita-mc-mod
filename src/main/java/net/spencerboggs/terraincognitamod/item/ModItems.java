package net.spencerboggs.terraincognitamod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.spencerboggs.terraincognitamod.TerraIncognitaMod;

import java.util.function.Function;

public class ModItems {
    public static final Item BANANA = registerItem("banana", Item::new, new Item.Settings());

    public static Item registerItem(String name, Function<Item.Settings, Item> item, Item.Settings settings) {
        final RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TerraIncognitaMod.MOD_ID, name));
        return Items.register(key, item, settings);
    }

    public static void registerModItems() {
        TerraIncognitaMod.LOGGER.info("Registering mod items for " + TerraIncognitaMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(BANANA);
        });


    }
}
