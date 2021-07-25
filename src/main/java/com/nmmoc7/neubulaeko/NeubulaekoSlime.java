package com.nmmoc7.neubulaeko;

import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

@Mod(NeubulaekoSlime.MOD_ID)
public class NeubulaekoSlime {
    public static final String MOD_ID = "neubulaeko_slime";
    public static final Logger LOGGER = LogManager.getLogger();

    public static boolean curiosLoaded;

    public NeubulaekoSlime() {
        curiosLoaded = ModList.get().isLoaded("curios");

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        if (curiosLoaded) {
            InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
                    () -> SlotTypePreset.CHARM.getMessageBuilder().build());
        }
    }
}
