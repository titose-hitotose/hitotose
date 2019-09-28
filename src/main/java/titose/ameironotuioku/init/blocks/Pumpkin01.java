package titose.ameironotuioku.init.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Pumpkin01 extends Block{

	public static final PropertyDirection FACING;

	public Pumpkin01() {
		super(Material.WEB);
		setHardness(1.5F);
		setResistance(1.0F);
		disableStats();
		setLightOpacity(1);
		setHarvestLevel("axe",0);
		//デフォルトの向きを北向きにする
		setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}
    @Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
    @Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

    @Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
	  //getOppositeでプレイヤーの対角を取得
		worldIn.setBlockState(pos, getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()));
	}

	//ItemStackのmetadataからIBlockStateを生成。設置時に呼ばれる。
    @Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
	}

	//IBlockStateからItemStackのmetadataを生成。ドロップ時とテクスチャ・モデル参照時に呼ばれる。
    @Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();
	}
	//初期BlockStateの生成。
    @Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer (this, new IProperty[]{FACING});
	}

	//向きをセット

	static {
		FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	}

	@Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

	public AxisAlignedBB getBoundingBox(IBlockState state,IBlockAccess source,BlockPos pos) {
		return new AxisAlignedBB(0.2D,1.0D,0.2D,0.8D,0.0D,0.8D);

	}

	@Deprecated
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.BOWL;
    }
}