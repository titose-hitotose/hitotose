package titose.ameironotuioku.init.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import titose.ameironotuioku.init.entity.EntitySeat;
import titose.ameironotuioku.util.CollisionHelper;

public class Isu01 extends Block{

	public static final PropertyDirection FACING;

	public Isu01() {
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

/*atarihanntei*/

	    private static final AxisAlignedBB BOUNDING_BOX_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.1D,0.5D,0.8D,0.7D,0.0D,0.2D);
		private static final AxisAlignedBB BOUNDING_BOX_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.7D,0.5D,0.2D,0.1D,0.0D,0.8D );
		private static final AxisAlignedBB BOUNDING_BOX_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.1D,0.5D,0.8D,0.7D,0.0D,0.2D);
		private static final AxisAlignedBB BOUNDING_BOX_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST,0.7D,0.5D,0.2D,0.1D,0.0D,0.8D );
		private static final AxisAlignedBB[] BOUNDING_BOX = { BOUNDING_BOX_SOUTH, BOUNDING_BOX_WEST, BOUNDING_BOX_NORTH, BOUNDING_BOX_EAST };

		@Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

			EnumFacing facing = state.getValue(FACING);
			return BOUNDING_BOX[facing.getHorizontalIndex()];

		}

/*burokku tunagaranai*/
	@Deprecated
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.BOWL;
    }
/*kokokara entity*/
	protected static final AxisAlignedBB SeatBB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.5D, 1.0D, 0.5D);

	 /*ブロックをクリックした時に呼び出される*/
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
            EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (worldIn.isRemote) {

            return true;
        }

        if (!playerIn.world.isRemote && playerIn != null && hand == EnumHand.MAIN_HAND && !playerIn.isSneaking()) {/*プレイヤーが存在しかつ右手かつスニーキングしてなかったら↓を実行*/
            /*先ほど指定した範囲に存在するEntityのリストを作成↓*/
            java.util.List<net.minecraft.entity.Entity> list = worldIn.getEntitiesWithinAABBExcludingEntity(playerIn, SeatBB);
            if (list.isEmpty()) {/*リストが空だった場合↓を実行*/
                /*Entityのインスタンスを作成*/
                EntitySeat seat = new EntitySeat(worldIn, pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D);
                /*Entityをスポーンさせる↓*/
                worldIn.spawnEntity(seat);
                if (playerIn.isRiding()) {/*プレイヤーが他のEntityに座っていたら…↓*/
                    /*降ろす！↓*/
                    playerIn.dismountRidingEntity();
                }
                /*プレイヤーを座らせる*/
                playerIn.startRiding(seat);
                return true;
            }
            return true;
        }
		return enableStats;
    }


}