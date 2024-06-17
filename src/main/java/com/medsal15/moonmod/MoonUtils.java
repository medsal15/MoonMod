package com.medsal15.moonmod;

import net.minecraft.resources.ResourceLocation;

public class MoonUtils {
    public static String namespaced(String text) {
        return MoonMod.MODID + ":" + text;
    }

    public static ResourceLocation location(String loc) {
        return ResourceLocation.fromNamespaceAndPath(MoonMod.MODID, loc);
    }
}
