package titose.ameironotuioku.init.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntitySeat extends Entity{

	public EntitySeat(World worldIn) {
        super(worldIn);
        this.setSize(0.01F, 0.01F);/*Entityのサイズ。今回は見えなくていいので極小に設定*/
        this.noClip = true;
    }

    public EntitySeat(World worldIn, double posX, double posY, double posZ) {
        this(worldIn);
        this.setPosition(posX, posY, posZ);/*Entityの位置を設定。今回はBlockクラス側で、位置を設定してます*/
}
    int count = 20;
    /*椅子から立ち上がった時にEntityを自動的に消滅させる。*/
    @Override
    public void onUpdate() {
        super.onUpdate();

        if (this.world.isRemote) {
            if (count > 0) {
                count--;
            } else {
                if (!this.isBeingRidden()) {
                    this.setDead();
                } else {
                    count = 20;
                }
            }
        }
}
    /*座面の高さを設定*/
    @Override
    public double getMountedYOffset() {
        return 0.3D;
}
    /*確か描画クラスと変数を共有する時にここに書くのがいいのかな？(うろ覚え)今は使わないけどメソッドは置いておかなきゃいけない*/
    @Override
    protected void entityInit() {


    }
    /*writeEntityToNBT()で書き込んだデータを読み込んでくれる。今は使わないけどメソッドは置いておかなきゃいけない*/
    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {


    }
    /*データを保存する為に書き込んでくれる。今は使わないけどメソッドは置いておかなきゃいけない*/
    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {


    }


}
