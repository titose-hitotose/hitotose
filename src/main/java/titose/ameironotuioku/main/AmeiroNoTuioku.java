package titose.ameironotuioku.main;

import java.util.logging.Logger;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import titose.ameironotuioku.init.entity.EntitySeat;
import titose.ameironotuioku.init.entity.Gakubuti01;
import titose.ameironotuioku.proxy.CommonProxy;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME,
version = Reference.MOD_VERSION)

public class AmeiroNoTuioku {

	 /* クラス(設計書)をインスタンス(製品)にする Change Class to Instance. */
    @Instance
    public static AmeiroNoTuioku instance;

    /* プロキシの登録 Register Proxy. */
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS,
                serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    /* エラーログの出力 Output Error log. */
    public static Logger logger;



    /* エンティティの登録、コンフィグ読込など
    * Register Entity and Config. */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();

        EntityRegistry.registerModEntity(new ResourceLocation( Reference.MOD_ID, "entity_seat"), EntitySeat.class,"entity_seat", 0,  AmeiroNoTuioku.instance, 128,5, false);
        EntityRegistry.registerModEntity(new ResourceLocation( Reference.MOD_ID, "gakubuti01"), Gakubuti01.class,"gakubuti01", 1,  AmeiroNoTuioku.instance, 256,64, false);


    }

    /* 他Modとの連携 Cooperation with other Mod. */
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();

    }


}

