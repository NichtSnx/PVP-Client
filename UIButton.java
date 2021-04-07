package dev.mrblackreal.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;

public class UIButton extends GuiButton {

	public UIButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
		super(buttonId, x, y, widthIn, heightIn, buttonText);
        this.width = 200;
        this.height = 20;
        this.enabled = true;
        this.visible = true;
        this.id = buttonId;
        this.xPosition = x;
        this.yPosition = y;
        this.width = widthIn;
        this.height = heightIn;
        this.displayString = buttonText;
    }
	
	int animatedHeight = 2;
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		if(this.visible) {
			FontRenderer font = mc.fontRendererObj;
			this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
			if(this.hovered) {
				animatedHeight++;
				if(animatedHeight > height) {
					animatedHeight = height;
				}
			}else {
				animatedHeight--;
				if(animatedHeight < 0) {
					animatedHeight = 0;
				}
			}
			
			this.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, 0x40f4f4f4);
			this.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.animatedHeight, 0x50f5f5f5);
			
			this.mouseDragged(mc, mouseX, mouseY);
			int i = 14737632;
			
			this.drawCenteredString(font, this.displayString, this.xPosition + this.width/2, this.yPosition+(this.height-8) / 2, i);
		}
	}
}
