package modchu.playerformclear;import java.lang.reflect.Field;import java.util.Map;import net.minecraft.client.Minecraft;import net.minecraft.client.entity.EntityPlayerSP;import net.minecraftforge.fml.client.registry.RenderingRegistry;import net.minecraftforge.fml.common.Mod;import net.minecraftforge.fml.common.Mod.EventHandler;import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;@Mod(modid="PlayerFormClear", name="PlayerFormClear", version=PlayerFormClear.version)public class PlayerFormClear {	private PFC_RenderFactory pfc_renderFactory;	protected final static String version = "1.9-3c";	public static final boolean isRelease = true;	public String getVersion() {		return version;	}	@EventHandler	public void loadComplete(FMLLoadCompleteEvent event) {		//System.err.println("PlayerFormClear loadComplete 1");		pfc_renderFactory = new PFC_RenderFactory();		//1.8.9以下		//RenderingRegistry.registerEntityRenderingHandler(EntityPlayerSP.class, pfc_renderFactory.getRender());		// 1.9		RenderingRegistry.registerEntityRenderingHandler(EntityPlayerSP.class, pfc_renderFactory);		Field f = null;		Class c = null;		try {			c = Class.forName("net.minecraft.client.renderer.entity.RenderManager");			//System.err.println("PlayerFormClear loadComplete 2 c="+c);			if (c != null) {				String var2 = isRelease ? "field_178636_l" : "skinMap";				f = c.getDeclaredField(var2);				//System.err.println("PlayerFormClear loadComplete 3 f="+f);				if (f != null); else {					f = c.getField(var2);					//System.err.println("PlayerFormClear loadComplete 4 f="+f);				}				if (f != null) {					f.setAccessible(true);					Map skinMap = (Map) f.get(Minecraft.getMinecraft().getRenderManager());					//System.err.println("PlayerFormClear loadComplete 5 skinMap="+skinMap);					//System.err.println("PlayerFormClear loadComplete 6 pfc_renderFactory.getRender()="+pfc_renderFactory.getRender());					skinMap.put("default", pfc_renderFactory.getRender());					skinMap.put("slim", pfc_renderFactory.getRender());				} else {					System.err.println("PlayerFormClear get field_178636_l error !!");				}			} else {				System.err.println("PlayerFormClear get RenderManager class error !!");			}		} catch (Exception e) {			e.printStackTrace();		}		//System.err.println("PlayerFormClear loadComplete end.");	}}