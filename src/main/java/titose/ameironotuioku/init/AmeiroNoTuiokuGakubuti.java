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
import titose.ameironotuioku.init.blocks.Gakubuti01;
import titose.ameironotuioku.main.Reference;

public class AmeiroNoTuiokuGakubuti {

	 /* 追加するブロックの宣言 Declare blocks to add. */

	 public static Block gakubuti01;


	 /* ブロックのインスタンスを生成 Instantiate blocks. */
	public static void init() {

		 gakubuti01 = new Gakubuti01().setRegistryName("gakubuti01")
	         		.setUnlocalizedName("gakubuti01").setCreativeTab(AmeiroNoTuiokuTabs.syouzyonohakoniwa);

	}

	 /* ブロックを登録する、ここから Register Blocks. From here. ↓*/

	  public static void register() {
		   registerBlock(gakubuti01);

	  }

	  /** ブロックの登録 Register Blocks. **/

	  public static void registerBlock(Block block) {
	        registerBlock(block, new ItemBlock(block));
	    }

	  /** アイテムブロックの登録 Register ItemBlocks. **/

	  public static void registerBlock(Block block, ItemBlock item) {
		  RegistrationHandler.BLOCKS.add(block);
	        item.setRegistryName(block.getRegistryName());
	        }

	  /* ドロップ時やインベントリにおける、アイテムブロックの描画を登録。ここから↓
	    * Register rendering of ItemBlocks in drop and inventory. From here↓*/

	  public static void registerRenders() {

		  registerRender(gakubuti01);

	  }

	  @SideOnly(Side.CLIENT)
	    private static void registerRender(Block block) {
	        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
	                new ModelResourceLocation(block.getRegistryName(),"inventory"));
	    }

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
