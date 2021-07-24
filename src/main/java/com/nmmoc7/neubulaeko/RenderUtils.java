package com.nmmoc7.neubulaeko;

import org.lwjgl.opengl.GL11;

/**
 * @author DustW
 */
public class RenderUtils {
    /** 不 要 在 服 务 端 调 用
     *  允许材质半透明
     */
    public static void openBlendA() {
        /* 允许透明 */
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    }

    /** 不 要 在 服 务 端 调 用 */
    public static void closeBlend() {
        GL11.glDisable(GL11.GL_BLEND);
    }
}
