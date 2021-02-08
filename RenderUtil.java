package dev.mrblackreal.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;

public class RenderUtil {

	public static void drawString(final double scale, final String text, final float xPos, final float yPos, final int color) {
		GlStateManager.pushMatrix();
		GlStateManager.scale(scale, scale, scale);
		Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(text, xPos, yPos, color);
		GlStateManager.popMatrix();
	}
}
