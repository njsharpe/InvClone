package net.njsharpe.invclone.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class InventorySelectionScreen extends Screen {

    private final Screen parent;

    private ButtonWidget button;

    public InventorySelectionScreen() {
        this(null);
    }

    public InventorySelectionScreen(Screen parent) {
        super(Text.literal("Select an Inventory"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        this.button = ButtonWidget
                .builder(Text.literal("Click Me!"), button -> {
                    System.out.println("Clicked! " + System.currentTimeMillis());
                })
                .dimensions(this.width / 2 - 205, 20, 200, 20)
                .tooltip(Tooltip.of(Text.literal("Example tooltip???")))
                .build();

        this.addDrawableChild(this.button);
    }

    @Override
    public void close() {
        if(this.client != null && this.parent != null) {
            this.client.setScreen(this.parent);
            return;
        }
        super.close();
    }

}
