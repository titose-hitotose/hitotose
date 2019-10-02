package titose.ameironotuioku.init;

import java.util.LinkedList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import titose.ameironotuioku.init.blocks.Byuro01;
import titose.ameironotuioku.init.blocks.Dream03;
import titose.ameironotuioku.init.blocks.Dressaa01;
import titose.ameironotuioku.init.blocks.Fuku01;
import titose.ameironotuioku.init.blocks.Fuku02;
import titose.ameironotuioku.init.blocks.Fuku03;
import titose.ameironotuioku.init.blocks.Gaarand01;
import titose.ameironotuioku.init.blocks.Gakubuti01;
import titose.ameironotuioku.init.blocks.Gakubuti_block01;
import titose.ameironotuioku.init.blocks.Haabariumu01;
import titose.ameironotuioku.init.blocks.Haabariumu02;
import titose.ameironotuioku.init.blocks.Isu01;
import titose.ameironotuioku.init.blocks.Isu02;
import titose.ameironotuioku.init.blocks.Isu03;
import titose.ameironotuioku.init.blocks.Kazaridana01;
import titose.ameironotuioku.init.blocks.Kusari01;
import titose.ameironotuioku.init.blocks.Lamp02;
import titose.ameironotuioku.init.blocks.Lamp03;
import titose.ameironotuioku.init.blocks.Lamp04;
import titose.ameironotuioku.init.blocks.Misinn01;
import titose.ameironotuioku.init.blocks.Misinn02;
import titose.ameironotuioku.init.blocks.Mobiiru01;
import titose.ameironotuioku.init.blocks.Nagatukue01;
import titose.ameironotuioku.init.blocks.Orugooru01;
import titose.ameironotuioku.init.blocks.Pen01;
import titose.ameironotuioku.init.blocks.Pen02;
import titose.ameironotuioku.init.blocks.Pumpkin01;
import titose.ameironotuioku.init.blocks.Pumpkin02;
import titose.ameironotuioku.init.blocks.Saihoubako;
import titose.ameironotuioku.init.blocks.Taipu01;
import titose.ameironotuioku.init.blocks.Taipu02;
import titose.ameironotuioku.init.blocks.Tana01;
import titose.ameironotuioku.init.blocks.Tokei01;
import titose.ameironotuioku.init.blocks.Tukue01;
import titose.ameironotuioku.main.Reference;

public class AmeiroNoTuiokuBlocks {

	 /* 追加するブロックの宣言 Declare blocks to add. */

    public static Block gakubuti_block01;
    public static Block pumpkin01;
    public static Block tana01;
    public static Block pumpkin02;
    public static Block isu01;
    public static Block isu02;
    public static Block tokei01;
    public static Block gaarand01;
    public static Block lamp02;
    public static Block kusari01;
    public static Block haabariumu01;
    public static Block lamp03;
    public static Block haabariumu02;
    public static Block fuku02;
    public static Block fuku01;
    public static Block fuku03;
    public static Block saihoubako;
    public static Block taipu01;
    public static Block taipu02;
    public static Block orugooru01;
    public static Block nagatukue01;
    public static Block kazaridana01;
    public static Block tukue01;
    public static Block lamp04;
    public static Block misinn01;
    public static Block misinn02;
    public static Block byuro01;
    public static Block dream03;
    public static Block isu03;
    public static Block mobiiru01;
    public static Block pen01;
    public static Block pen02;
    public static Block dressaa01;
    public static Block gakubuti01;








    /* ブロックのインスタンスを生成 Instantiate blocks. */
    public static void init() {

        gakubuti_block01 = new Gakubuti_block01().setRegistryName("gakubuti_block01")
        		.setUnlocalizedName("gakubuti_block01").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	pumpkin01 = new Pumpkin01().setRegistryName("pumpkin01")
    			.setUnlocalizedName("pumpkin01").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	tana01 = new Tana01().setRegistryName("tana01")
    			.setUnlocalizedName("tana01").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	pumpkin02 = new Pumpkin02().setRegistryName("pumpkin02")
    			.setUnlocalizedName("pumpkin02").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	isu01 = new Isu01().setRegistryName("isu01")
    			.setUnlocalizedName("isu01").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	isu02 = new Isu02().setRegistryName("isu02")
    			.setUnlocalizedName("isu02").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	tokei01 = new Tokei01().setRegistryName("tokei01")
    			.setUnlocalizedName("tokei01").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	gaarand01 = new Gaarand01().setRegistryName("gaarand01")
    			.setUnlocalizedName("gaarand01").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	lamp02 = new Lamp02().setRegistryName("lamp02")
    			.setUnlocalizedName("lamp02").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	kusari01 = new Kusari01().setRegistryName("kusari01")
    			.setUnlocalizedName("kusari01").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	haabariumu01 = new Haabariumu01().setRegistryName("haabariumu01")
    			.setUnlocalizedName("haabariumu01").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	lamp03 = new Lamp03().setRegistryName("lamp03")
    			.setUnlocalizedName("lamp03").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	haabariumu02 = new Haabariumu02().setRegistryName("haabariumu02")
    			.setUnlocalizedName("haabariumu02").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	fuku02 = new Fuku02().setRegistryName("fuku02")
    			.setUnlocalizedName("fuku02").setCreativeTab(AmeiroNoTuiokuTabs.isyoubako);
    	fuku01 = new Fuku01().setRegistryName("fuku01")
    			.setUnlocalizedName("fuku01").setCreativeTab(AmeiroNoTuiokuTabs.isyoubako);
    	fuku03 = new Fuku03().setRegistryName("fuku03")
    			.setUnlocalizedName("fuku03").setCreativeTab(AmeiroNoTuiokuTabs.isyoubako);
    	saihoubako = new Saihoubako().setRegistryName("saihoubako")
    			.setUnlocalizedName("saihoubako").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	taipu01 = new Taipu01().setRegistryName("taipu01")
    			.setUnlocalizedName("taipu01").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	taipu02 = new Taipu02().setRegistryName("taipu02")
    			.setUnlocalizedName("taipu02").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	orugooru01 = new Orugooru01().setRegistryName("orugooru01")
    			.setUnlocalizedName("orugooru01").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	nagatukue01 = new Nagatukue01().setRegistryName("nagatukue01")
    			.setUnlocalizedName("nagatukue01").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	kazaridana01 = new Kazaridana01().setRegistryName("kazaridana01")
    			.setUnlocalizedName("kazaridana01").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	tukue01 = new Tukue01().setRegistryName("tukue01")
    			.setUnlocalizedName("tukue01").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	lamp04 = new Lamp04().setRegistryName("lamp04")
    			.setUnlocalizedName("lamp04").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	misinn01 = new Misinn01().setRegistryName("misinn01")
    			.setUnlocalizedName("misinn01").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	misinn02 = new Misinn02().setRegistryName("misinn02")
    			.setUnlocalizedName("misinn02").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	byuro01 = new Byuro01().setRegistryName("byuro01")
    			.setUnlocalizedName("byuro01").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	dream03 = new Dream03().setRegistryName("dream03")
    			.setUnlocalizedName("dream03").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	isu03 = new Isu03().setRegistryName("isu03")
    			.setUnlocalizedName("isu03").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	mobiiru01 = new Mobiiru01().setRegistryName("mobiiru01")
    			.setUnlocalizedName("mobiiru01").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	pen01 = new Pen01().setRegistryName("pen01")
    			.setUnlocalizedName("pen01").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	pen02 = new Pen02().setRegistryName("pen02")
    			.setUnlocalizedName("pen02").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	dressaa01 = new Dressaa01().setRegistryName("dressaa01")
    			.setUnlocalizedName("dressaa01").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);
    	gakubuti01 = new Gakubuti01().setRegistryName("gakubuti01")
        		.setUnlocalizedName("gakubuti01").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);




    }


    /* ブロックを登録する、ここから Register Blocks. From here. ↓*/
    public static void register() {
        registerBlockNotItem(gakubuti_block01);
        registerBlockNotItem(pumpkin01);
        registerBlockNotItem(tana01);
        registerBlockNotItem(pumpkin02);
        registerBlockNotItem(isu01);
        registerBlockNotItem(isu02);
        registerBlockNotItem(tokei01);
        registerBlockNotItem(gaarand01);
        registerBlockNotItem(lamp02);
        registerBlockNotItem(kusari01);
        registerBlockNotItem(haabariumu01);
        registerBlockNotItem(lamp03);
        registerBlockNotItem(haabariumu02);
        registerBlockNotItem(fuku02);
        registerBlockNotItem(fuku01);
        registerBlockNotItem(fuku03);
        registerBlockNotItem(saihoubako);
        registerBlockNotItem(taipu01);
        registerBlockNotItem(taipu02);
        registerBlockNotItem(orugooru01);
        registerBlockNotItem(nagatukue01);
        registerBlockNotItem(kazaridana01);
        registerBlockNotItem(tukue01);
        registerBlockNotItem(lamp04);
        registerBlockNotItem(misinn01);
        registerBlockNotItem(misinn02);
        registerBlockNotItem(byuro01);
        registerBlockNotItem(dream03);
        registerBlockNotItem(isu03);
        registerBlockNotItem(mobiiru01);
        registerBlockNotItem(pen01);
        registerBlockNotItem(pen02);
        registerBlockNotItem(dressaa01);
        registerBlockNotItem(gakubuti01);



    }


    /** ブロックの登録 Register Blocks. **/
    public static void registerBlockNotItem(Block block) {
        registerBlockNotItem(block, new ItemBlock(block));
    }

    /** アイテムブロックの登録 Register ItemBlocks. **/
    public static void registerBlockNotItem(Block block, ItemBlock item) {
        RegistrationHandler.BLOCKS.add(block);
        item.setRegistryName(block.getRegistryName());
    }

    /*ここまで So far↑ */


    /* ドロップ時やインベントリにおける、アイテムブロックの描画を登録。ここから↓
    * Register rendering of ItemBlocks in drop and inventory. From here↓*/
    public static void registerRenders() {
        registerRender(gakubuti_block01);
        registerRender(pumpkin01);
        registerRender(tana01);
        registerRender(pumpkin02);
        registerRender(isu01);
        registerRender(isu02);
        registerRender(tokei01);
        registerRender(gaarand01);
        registerRender(lamp02);
        registerRender(kusari01);
        registerRender(haabariumu01);
        registerRender(lamp03);
        registerRender(haabariumu02);
        registerRender(fuku02);
        registerRender(fuku01);
        registerRender(fuku03);
        registerRender(saihoubako);
        registerRender(taipu01);
        registerRender(taipu02);
        registerRender(orugooru01);
        registerRender(nagatukue01);
        registerRender(kazaridana01);
        registerRender(tukue01);
        registerRender(lamp04);
        registerRender(misinn01);
        registerRender(misinn02);
        registerRender(byuro01);
        registerRender(dream03);
        registerRender(isu03);
        registerRender(mobiiru01);
        registerRender(pen01);
        registerRender(pen02);
        registerRender(dressaa01);
        registerRender(gakubuti01);


    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(Block block) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
                new ModelResourceLocation(block.getRegistryName(),"inventory"));
    }


    /*ここまで So far↑ */


    /* ------------------------------------------------------------------------
     * ここから From here. ↓ */

    /* ブロックの登録を行う【内部クラス】
     * Register blocks 【Inner Class】 */
    @Mod.EventBusSubscriber(modid = Reference.MOD_ID)
    public static class RegistrationHandler {

        public static final List<Block> BLOCKS = new LinkedList<>();

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Block> event) {

            AmeiroNoTuiokuBlocks.init();
            AmeiroNoTuiokuBlocks.register();
            BLOCKS.stream().forEach(block -> event.getRegistry().register(block));
        }
    }

}
