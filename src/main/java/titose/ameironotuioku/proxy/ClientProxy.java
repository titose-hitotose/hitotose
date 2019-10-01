package titose.ameironotuioku.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import titose.ameironotuioku.init.AmeiroNoTuiokuBlocks;
import titose.ameironotuioku.init.AmeiroNoTuiokuItems;
import titose.ameironotuioku.init.client.renderer.entity.RenderGakubuti01;
import titose.ameironotuioku.init.entity.EntitySeat;
import titose.ameironotuioku.init.entity.Gakubuti01;
import titose.ameironotuioku.main.AmeiroNoTuioku;
import titose.ameironotuioku.main.Reference;

public class ClientProxy extends CommonProxy{

	public static boolean rendering = false;
	public static Entity renderEntity = null;
	public static Entity backupEntity = null;

	/* エンティティの登録、コンフィグ読込など
	* Register Entity and Config. */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void preInit() {
		 EntityRegistry.registerModEntity(new ResourceLocation( Reference.MOD_ID, "entity_seat"), EntitySeat.class,"entity_seat", 0,  AmeiroNoTuioku.instance, 128,5, false);
		 EntityRegistry.registerModEntity(new ResourceLocation( Reference.MOD_ID, "gakubuti01"), Gakubuti01.class,"gakubuti01",1,  AmeiroNoTuioku.instance, 256,64, false);

		 RenderingRegistry.registerEntityRenderingHandler(Gakubuti01.class, (IRenderFactory) manager -> new RenderGakubuti01(manager, Minecraft.getMinecraft().getRenderItem()));

	}



	/* レシピ・鉱石などの追加 Register Recipe and Ore. */
	@Override
	public void init() { }

	/* 他Modとの連携 Cooperation with other Mod. */
	@Override
	public void postInit() { }

	/* シングルプレイかどうか Single play or not? */
	@Override
	public boolean isSinglePlayer() {
		return Minecraft.getMinecraft().isSingleplayer();
	}

	/* サーバープレイかどうか Sever play or not? */
	@Override
	public boolean isDedicatedServer() {
		return false;
	}


    /* ------------------------------------------------------------------------
     * ここから From here. ↓ */

	/* ドロップ時やインベントリにおける、アイテムやアイテムブロックの描画を登録する【内部クラス】
	 * Register rendering of Items and ItemBlocks in drop and inventory. 【Inner Classs】 */
	@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
	public static class RegistrationHandler {

		@SubscribeEvent
		public static void registerModels(ModelRegistryEvent event) {
			AmeiroNoTuiokuBlocks.registerRenders();
			AmeiroNoTuiokuItems.registerRenders();

		}

	}




}
