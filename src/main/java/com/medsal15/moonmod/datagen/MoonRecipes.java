package com.medsal15.moonmod.datagen;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nonnull;

import com.medsal15.moonmod.MoonBlocks;
import com.medsal15.moonmod.MoonUtils;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;

public class MoonRecipes extends RecipeProvider {
    public MoonRecipes(PackOutput pOutput, CompletableFuture<Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    private static final int SMELTING_TIME = 200;

    @Override
    protected void buildRecipes(@Nonnull RecipeOutput output) {
        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(MoonBlocks.MOON_COBBLE), RecipeCategory.BUILDING_BLOCKS, MoonBlocks.MOON_STONE,
                        .1f, SMELTING_TIME)
                .unlockedBy("has_moon_cobble", has(MoonBlocks.MOON_COBBLE))
                .save(output, MoonUtils.namespaced("smelting/moon_cobble"));
    }
}
