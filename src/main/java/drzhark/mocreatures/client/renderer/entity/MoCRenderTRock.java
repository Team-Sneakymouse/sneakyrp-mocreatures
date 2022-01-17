/*    */ package drzhark.mocreatures.client.renderer.entity;
/*    */ 
/*    */ import drzhark.mocreatures.client.MoCClientProxy;
/*    */ import drzhark.mocreatures.entity.item.MoCEntityThrowableRock;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.BlockRendererDispatcher;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MoCRenderTRock
/*    */   extends Render<Entity> {
/*    */   public MoCRenderTRock() {
/* 20 */     super(MoCClientProxy.mc.getRenderManager());
/* 21 */     this.shadowSize = 0.5F;
/*    */   }
/*    */   
/*    */   public void renderMyRock(MoCEntityThrowableRock entitytrock, double par2, double par4, double par6, float par8, float partialTicks) {
/* 25 */     BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
/* 26 */     GlStateManager.pushMatrix();
/*    */     
/* 28 */     GlStateManager.translate(-0.5F, 0.0F, 0.5F);
/* 29 */     GlStateManager.translate((float)par2, (float)par4, (float)par6);
/* 30 */     GlStateManager.rotate((100 - entitytrock.acceleration) / 10.0F * 36.0F, 0.0F, -1.0F, 0.0F);
/* 31 */     int i = entitytrock.getBrightnessForRender();
/* 32 */     int j = i % 65536;
/* 33 */     int k = i / 65536;
/* 34 */     OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j / 1.0F, k / 1.0F);
/* 35 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 36 */     bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
/* 37 */     float lightLevel = entitytrock.getBrightness();
/* 38 */     blockrendererdispatcher.renderBlockBrightness(entitytrock.getState(), lightLevel);
/* 39 */     GlStateManager.popMatrix();
/*    */   }
/*    */ 
/*    */   
/*    */   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
/* 44 */     renderMyRock((MoCEntityThrowableRock)par1Entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */   
/*    */   protected ResourceLocation getMyTexture(MoCEntityThrowableRock trock) {
/* 48 */     return TextureMap.LOCATION_BLOCKS_TEXTURE;
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation getEntityTexture(Entity par1Entity) {
/* 53 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\mami\files\games\minecraft\sneakyrp\mocreatures-fix\DrZharks MoCreatures Mod-12.0.5-deobf.jar!\drzhark\mocreatures\client\renderer\entity\MoCRenderTRock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */