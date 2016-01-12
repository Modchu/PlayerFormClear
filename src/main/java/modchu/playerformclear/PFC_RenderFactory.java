package modchu.playerformclear;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class PFC_RenderFactory implements IRenderFactory {
	private RenderPlayerFormClear renderPlayerFormClear;

	public PFC_RenderFactory() {
		if (renderPlayerFormClear != null); else renderPlayerFormClear = new RenderPlayerFormClear();
	}

	@Override
	public Render createRenderFor(RenderManager manager) {
		return getRender();
	}

	public Render getRender() {
		return renderPlayerFormClear;
	}

}
