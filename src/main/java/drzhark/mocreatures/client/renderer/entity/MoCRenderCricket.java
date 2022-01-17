/*    */ package drzhark.mocreatures.client.renderer.entity;
/*    */ import drzhark.mocreatures.entity.ambient.MoCEntityCricket;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import org.lwjgl.opengl.GL11;
/*    */
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MoCRenderCricket extends MoCRenderMoC<MoCEntityCricket> {
/*    */   public MoCRenderCricket(ModelBase modelbase) {
/* 14 */     super(modelbase, 0.0F);
/*    */   }
/*    */
/*    */
/*    */   protected void preRenderCallback(MoCEntityCricket entitycricket, float par2) {
/* 19 */     rotateCricket(entitycricket);
/*    */   }
/*    */
/*    */   protected void rotateCricket(MoCEntityCricket entitycricket) {
/* 23 */     if (!entitycricket.onGround) {
/* 24 */       if (entitycricket.motionY > 0.5D) {
/* 25 */         GL11.glRotatef(35.0F, -1.0F, 0.0F, 0.0F);
/* 26 */       } else if (entitycricket.motionY < -0.5D) {
/* 27 */         GL11.glRotatef(-35.0F, -1.0F, 0.0F, 0.0F);
/*    */       } else {
/* 29 */         GL11.glRotatef((float)(entitycricket.motionY * 70.0D), -1.0F, 0.0F, 0.0F);
/*    */       }
/*    */     }
/*    */   }
/*    */
/*    */
/*    */   protected ResourceLocation getEntityTexture(MoCEntityCricket par1Entity) {
/* 36 */     return par1Entity.getTexture();
/*    */   }
/*    */ }


/* Location:              C:\Users\mami\files\games\minecraft\sneakyrp\mocreatures-fix\DrZharks MoCreatures Mod-12.0.5-deobf.jar!\drzhark\mocreatures\client\renderer\entity\MoCRenderCricket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
