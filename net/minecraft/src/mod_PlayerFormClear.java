package net.minecraft.src;

import java.util.Map;

public class mod_PlayerFormClear extends BaseMod {

	public String getVersion() {
		return "1.6.2-1";
	}

	public void load() {
	}

	public void addRenderer(Map map) {
		// �v���[���[�t�H�����̒u������
	    map.put(EntityPlayerSP.class, new RenderPlayerFormClear());
	}
}
