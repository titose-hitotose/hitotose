package titose.ameironotuioku.proxy;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import titose.ameironotuioku.init.entity.EntitySeat;
import titose.ameironotuioku.init.entity.Gakubuti01;
import titose.ameironotuioku.main.AmeiroNoTuioku;
import titose.ameironotuioku.main.Reference;

public class CommonProxy {

	 /* エンティティの登録、コンフィグ読込など
	    * Register Entity and Config. */
	    public void preInit() {
	    	 EntityRegistry.registerModEntity(new ResourceLocation( Reference.MOD_ID, "entity_seat"), EntitySeat.class,"entity_seat", 0,  AmeiroNoTuioku.instance, 128,5, false);
	    	 EntityRegistry.registerModEntity(new ResourceLocation( Reference.MOD_ID, "gakubuti01"), Gakubuti01.class,"gakubuti01", 1,  AmeiroNoTuioku.instance, 256,64, false);
	    }

	    /* レシピ・鉱石などの追加 Register Recipe and Ore. */
	    public void init() { }

	    /* 他Modとの連携 Cooperation with other Mod. */
	    public void postInit() { }

	    /* シングルプレイかどうか Single play or not? */
	    public boolean isSinglePlayer() {
	        return false;
	    }

	    /* サーバープレイかどうか Sever play or not? */
	    public boolean isDedicatedServer() {
	        return true;
	    }



}
