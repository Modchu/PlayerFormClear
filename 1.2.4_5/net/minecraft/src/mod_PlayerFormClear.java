package net.minecraft.src;

import java.util.Map;

import net.minecraft.client.Minecraft;

public class mod_PlayerFormClear extends BaseMod {

	public String getVersion() {
		return "1.2.3-1";
	}

	public void load() {
	}

	public void addRenderer(Map map) {
		// プレーヤーフォルムの置き換え
	    map.put(EntityPlayerSP.class, new RenderPlayerFormClear());
	}
}
