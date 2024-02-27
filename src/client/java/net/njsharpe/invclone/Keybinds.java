package net.njsharpe.invclone;

import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public final class Keybinds {

    public static KeyBinding MINUS_KEYBINDING = new KeyBinding("key.invclone.menu_open",
            InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_MINUS, "category.invclone");

}
