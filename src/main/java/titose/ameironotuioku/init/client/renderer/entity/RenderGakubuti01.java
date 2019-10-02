package titose.ameironotuioku.init.client.renderer.entity;

import javax.annotation.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ModelManager;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderItemFrame;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.storage.MapData;
import titose.ameironotuioku.init.entity.Gakubuti01;

public class RenderGakubuti01 extends RenderItemFrame{

	 private static final ResourceLocation MAP_BACKGROUND_TEXTURES = new ResourceLocation("textures/map/map_background.png");
	    private final Minecraft mc = Minecraft.getMinecraft();
	    private final ModelResourceLocation itemFrameModel = new ModelResourceLocation("ameironotuioku:gakubuti01", "facing=south");
    private final ModelResourceLocation mapModel = new ModelResourceLocation("ameironotuioku:gakubuti01_map", "map");
	    private final RenderItem itemRenderer;

	    public RenderGakubuti01(RenderManager renderManagerIn, RenderItem itemRendererIn)
	    {
	        super(renderManagerIn, itemRendererIn);
	        this.itemRenderer = itemRendererIn;
	    }

	    public void doRender(EntityItemFrame entity, double x, double y, double z, float entityYaw, float partialTicks) {
	        this.doRender((Gakubuti01) entity, x, y, z, entityYaw, partialTicks);
	    }


	    public void doRender(Gakubuti01 entity, double x, double y, double z, float entityYaw, float partialTicks)
	    {
	        GlStateManager.pushMatrix();
	        BlockPos blockpos = entity.getHangingPosition();
	        double d0 = (double)blockpos.getX() - entity.posX + x;
	        double d1 = (double)blockpos.getY() - entity.posY + y;
	        double d2 = (double)blockpos.getZ() - entity.posZ + z;
	        GlStateManager.translate(d0 + 0.5D, d1 + 0.5D, d2 + 0.5D);
	        GlStateManager.rotate(180.0F - entity.rotationYaw, 0.0F, 1.0F, 0.0F);
	        this.renderManager.renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
	        BlockRendererDispatcher blockrendererdispatcher = this.mc.getBlockRendererDispatcher();
	        ModelManager modelmanager = blockrendererdispatcher.getBlockModelShapes().getModelManager();
	        IBakedModel ibakedmodel;

	        if (entity.getDisplayedItem().getItem() instanceof net.minecraft.item.ItemMap)
	        {
	            ibakedmodel = modelmanager.getModel(this.mapModel);
	        }
	        else
	        {
	            ibakedmodel = modelmanager.getModel(this.itemFrameModel);
	        }

	        GlStateManager.pushMatrix();
	        GlStateManager.translate(-0.5F, -0.5F, -0.5F);

	        if (this.renderOutlines)
	        {
	            GlStateManager.enableColorMaterial();
	            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
	        }

	        blockrendererdispatcher.getBlockModelRenderer().renderModelBrightnessColor(ibakedmodel, 1.0F, 1.0F, 1.0F, 1.0F);

	        if (this.renderOutlines)
	        {
	            GlStateManager.disableOutlineMode();
	            GlStateManager.disableColorMaterial();
	        }

	        GlStateManager.popMatrix();
	        GlStateManager.translate(0.0F, 0.0F, 0.4375F);
	        this.renderItem(entity);
	        GlStateManager.popMatrix();
	        this.renderName(entity, x + (double)((float)entity.facingDirection.getFrontOffsetX() * 0.3F), y - 0.25D, z + (double)((float)entity.facingDirection.getFrontOffsetZ() * 0.3F));
	    }

	    @Nullable
	    protected ResourceLocation getEntityTexture(Gakubuti01 entity)
	    {
	        return null;
	    }

	    private void renderItem(Gakubuti01 itemFrame)
	    {
	        ItemStack itemstack = itemFrame.getDisplayedItem();

	        if (!itemstack.isEmpty())
	        {
	            GlStateManager.pushMatrix();
	            GlStateManager.disableLighting();
	            boolean flag = itemstack.getItem() instanceof net.minecraft.item.ItemMap;
	            int i = flag ? itemFrame.getRotation() % 4 * 2 : itemFrame.getRotation();
	            GlStateManager.rotate((float)i * 360.0F / 8.0F, 0.0F, 0.0F, 1.0F);

	            net.minecraftforge.client.event.RenderItemInFrameEvent event = new net.minecraftforge.client.event.RenderItemInFrameEvent(itemFrame, this);
	            if (!net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event))
	            {
	            if (flag)
	            {
	                this.renderManager.renderEngine.bindTexture(MAP_BACKGROUND_TEXTURES);
	                GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	                GlStateManager.scale(0.0078125F, 0.0078125F, 0.0078125F);
	                GlStateManager.translate(-64.0F, -64.0F, 0.0F);
	                MapData mapdata = ((net.minecraft.item.ItemMap) itemstack.getItem()).getMapData(itemstack, itemFrame.world);
	                GlStateManager.translate(0.0F, 0.0F, -1.0F);

	                if (mapdata != null)
	                {
	                    this.mc.entityRenderer.getMapItemRenderer().renderMap(mapdata, true);
	                }
	            }
	            else
	            {
	                GlStateManager.scale(0.5F, 0.5F, 0.5F);
	                GlStateManager.pushAttrib();
	                RenderHelper.enableStandardItemLighting();
	                this.itemRenderer.renderItem(itemstack, ItemCameraTransforms.TransformType.FIXED);
	                RenderHelper.disableStandardItemLighting();
	                GlStateManager.popAttrib();
	            }
	            }

	            GlStateManager.enableLighting();
	            GlStateManager.popMatrix();
	        }
	    }

	    protected void renderName(Gakubuti01 entity, double x, double y, double z)
	    {
	        if (Minecraft.isGuiEnabled() && !entity.getDisplayedItem().isEmpty() && entity.getDisplayedItem().hasDisplayName() && this.renderManager.pointedEntity == entity)
	        {
	            double d0 = entity.getDistanceSq(this.renderManager.renderViewEntity);
	            float f = entity.isSneaking() ? 32.0F : 64.0F;

	            if (d0 < (double)(f * f))
	            {
	                String s = entity.getDisplayedItem().getDisplayName();
	                this.renderLivingLabel(entity, s, x, y, z, 64);
	            }
	        }
	    }



}
