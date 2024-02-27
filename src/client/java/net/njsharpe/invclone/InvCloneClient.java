package net.njsharpe.invclone;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.njsharpe.invclone.screen.InventorySelectionScreen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvCloneClient implements ClientModInitializer {

    private final static Logger LOGGER = LoggerFactory.getLogger(InvCloneClient.class);

    @Override
    public void onInitializeClient() {
        KeyBindingHelper.registerKeyBinding(Keybinds.MINUS_KEYBINDING);
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (Keybinds.MINUS_KEYBINDING.wasPressed()) {
                if(!(client.currentScreen instanceof InventorySelectionScreen)) {
                    LOGGER.info("Opening Inventory Selection Screen");
                    client.setScreen(new InventorySelectionScreen());
                }
            }
        });
    }

}
