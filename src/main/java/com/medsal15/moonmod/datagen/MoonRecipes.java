package com.medsal15.moonmod.datagen;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nonnull;

import com.medsal15.moonmod.MoonBlocks;
import com.medsal15.moonmod.MoonItems;
import com.medsal15.moonmod.MoonUtils;
import com.medsal15.moonmod.datagen.tags.MoonItemTags;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class MoonRecipes extends RecipeProvider {
    public MoonRecipes(PackOutput pOutput, CompletableFuture<Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    private static final int SMELTING_TIME = 200;
    private static final int BLASTING_TIME = SMELTING_TIME / 2;

    @Override
    protected void buildRecipes(@Nonnull RecipeOutput output) {
        smeltRecipes(output);
        shapelessRecipes(output);
    }

    private void smeltRecipes(RecipeOutput output) {
        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(MoonItemTags.LUNARITE_ORES), RecipeCategory.MISC, MoonItems.LUNARITE_GEM, .1f,
                        SMELTING_TIME)
                .unlockedBy("has_lunarite_ore", has(MoonItemTags.LUNARITE_ORES))
                .save(output, MoonUtils.location("smelting/lunarite_ores"));
        SimpleCookingRecipeBuilder
                .blasting(Ingredient.of(MoonItemTags.LUNARITE_ORES), RecipeCategory.MISC, MoonItems.LUNARITE_GEM, .1f,
                        BLASTING_TIME)
                .unlockedBy("has_lunarite_ore", has(MoonItemTags.LUNARITE_ORES))
                .save(output, MoonUtils.location("blasting/lunarite_ores"));
    }

    private void shapelessRecipes(RecipeOutput output) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, MoonBlocks.LUNARITE_BLOCK)
                .requires(MoonItems.LUNARITE_GEM, 9)
                .unlockedBy("has_lunarite_gem", has(MoonItems.LUNARITE_GEM))
                .save(output, MoonUtils.location("packing/lunarite_block"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, new ItemStack(MoonItems.LUNARITE_GEM.get(), 9))
                .requires(MoonBlocks.LUNARITE_BLOCK)
                .unlockedBy("has_lunarite_block", has(MoonBlocks.LUNARITE_BLOCK))
                .save(output, MoonUtils.location("unpacking/lunarite_block"));
    }
}
