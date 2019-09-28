package titose.ameironotuioku.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class AmeiroNoTuiokuTabs {

	public static final CreativeTabs syouzyonohakoniwa = new CreativeTabs("syouzyonohakoniwa") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(AmeiroNoTuiokuBlocks.gakubuti_block01);
		}

	};

	public static final CreativeTabs isyoubako = new CreativeTabs("isyoubako") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(AmeiroNoTuiokuBlocks.fuku02);
		}

	};


}
