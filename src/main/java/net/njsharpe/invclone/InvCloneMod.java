package net.njsharpe.invclone;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvCloneMod implements ModInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvCloneMod.class);

    public static final String MOD_ID = "InvClone";

    @Override
    public void onInitialize() {
        LOGGER.info("Mod: {} Initialized!", MOD_ID);
    }

}
