package drzhark.mocreatures.client.renderer.entity;
import drzhark.mocreatures.MoCreatures;
import drzhark.mocreatures.client.MoCClientProxy;
import drzhark.mocreatures.entity.aquatic.MoCEntityDolphin;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class MoCRenderDolphin extends RenderLiving<MoCEntityDolphin> {
  public MoCRenderDolphin(ModelBase modelbase, float f) {
    super(MoCClientProxy.mc.getRenderManager(), modelbase, f);
  }


  public void doRender(MoCEntityDolphin entitydolphin, double d, double d1, double d2, float f, float f1) {
    super.doRender(entitydolphin, d, d1, d2, f, f1);
    boolean flag = (MoCreatures.proxy.getDisplayPetName() && !entitydolphin.getPetName().isEmpty());
    boolean flag1 = MoCreatures.proxy.getDisplayPetHealth();

    if (entitydolphin.renderName()) {
      float f2 = 1.6F;
      float f3 = 0.01666667F * f2;
      float f4 = entitydolphin.getDistance(this.renderManager.renderViewEntity);
      if (f4 < 16.0F) {
        String s = "";
        s = s + entitydolphin.getPetName();
        float f5 = 0.1F;
        FontRenderer fontrenderer = getFontRendererFromRenderManager();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.0F, (float)d1 + f5, (float)d2);
        GL11.glNormal3f(0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glScalef(-f3, -f3, f3);
        GL11.glDisable(2896);
        Tessellator tessellator = Tessellator.getInstance();
        byte byte0 = -50;
        if (flag1) {
          GL11.glDisable(3553);
          if (!flag) {
            byte0 = (byte)(byte0 + 8);
          }
          tessellator.getBuffer().begin(7, DefaultVertexFormats.POSITION_COLOR);

          float f6 = entitydolphin.getHealth();

          float f7 = entitydolphin.getMaxHealth();
          float f8 = f6 / f7;
          float f9 = 40.0F * f8;
          tessellator.getBuffer().pos((-20.0F + f9), (-10 + byte0), 0.0D).color(0.7F, 0.0F, 0.0F, 1.0F).endVertex();
          tessellator.getBuffer().pos((-20.0F + f9), (-6 + byte0), 0.0D).color(0.7F, 0.0F, 0.0F, 1.0F).endVertex();
          tessellator.getBuffer().pos(20.0D, (-6 + byte0), 0.0D).color(0.7F, 0.0F, 0.0F, 1.0F).endVertex();
          tessellator.getBuffer().pos(20.0D, (-10 + byte0), 0.0D).color(0.7F, 0.0F, 0.0F, 1.0F).endVertex();
          tessellator.getBuffer().pos(-20.0D, (-10 + byte0), 0.0D).color(0.0F, 0.7F, 0.0F, 1.0F).endVertex();
          tessellator.getBuffer().pos(-20.0D, (-6 + byte0), 0.0D).color(0.0F, 0.7F, 0.0F, 1.0F).endVertex();
          tessellator.getBuffer().pos((f9 - 20.0F), (-6 + byte0), 0.0D).color(0.0F, 0.7F, 0.0F, 1.0F).endVertex();
          tessellator.getBuffer().pos((f9 - 20.0F), (-10 + byte0), 0.0D).color(0.0F, 0.7F, 0.0F, 1.0F).endVertex();
          tessellator.draw();
          GL11.glEnable(3553);
        }
        if (flag) {
          GL11.glDepthMask(false);
          GL11.glDisable(2929);
          GL11.glEnable(3042);
          GL11.glBlendFunc(770, 771);
          GL11.glDisable(3553);
          tessellator.getBuffer().begin(7, DefaultVertexFormats.POSITION_COLOR);
          int i = fontrenderer.getStringWidth(s) / 2;
          tessellator.getBuffer().pos((-i - 1), (-1 + byte0), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
          tessellator.getBuffer().pos((-i - 1), (8 + byte0), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
          tessellator.getBuffer().pos((i + 1), (8 + byte0), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
          tessellator.getBuffer().pos((i + 1), (-1 + byte0), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
          tessellator.draw();
          GL11.glEnable(3553);
          fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, byte0, 553648127);
          GL11.glEnable(2929);
          GL11.glDepthMask(true);
          fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, byte0, -1);
          GL11.glDisable(3042);
          GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
        GL11.glEnable(2896);
        GL11.glPopMatrix();
      }
    }
  }

  public void doRender2(MoCEntityDolphin entitydolphin, double d, double d1, double d2, float f, float f1) {
    super.doRender(entitydolphin, d, d1, d2, f, f1);
    if (entitydolphin.renderName()) {
      float f2 = 1.6F;
      float f3 = 0.01666667F * f2;
      float f4 = entitydolphin.getDistance(this.renderManager.renderViewEntity);
      String s = "";
      s = s + entitydolphin.getPetName();
      if (f4 < 12.0F && s.length() > 0) {
        FontRenderer fontrenderer = getFontRendererFromRenderManager();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.0F, (float)d1 + 0.3F, (float)d2);
        GL11.glNormal3f(0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glScalef(-f3, -f3, f3);
        GL11.glDisable(2896);
        GL11.glDepthMask(false);
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        Tessellator tessellator = Tessellator.getInstance();
        byte byte0 = -50;
        GL11.glDisable(3553);
        tessellator.getBuffer().begin(7, DefaultVertexFormats.POSITION_COLOR);
        int i = fontrenderer.getStringWidth(s) / 2;
        tessellator.getBuffer().pos((-i - 1), (-1 + byte0), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
        tessellator.getBuffer().pos((-i - 1), (8 + byte0), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
        tessellator.getBuffer().pos((i + 1), (8 + byte0), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
        tessellator.getBuffer().pos((i + 1), (-1 + byte0), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
        if (MoCreatures.proxy.getDisplayPetHealth()) {
          float f5 = entitydolphin.getHealth();
          float f6 = entitydolphin.getMaxHealth();
          float f7 = f5 / f6;
          float f8 = 40.0F * f7;
          tessellator.getBuffer().pos((-20.0F + f8), (-10 + byte0), 0.0D).color(0.7F, 0.0F, 0.0F, 1.0F).endVertex();
          tessellator.getBuffer().pos((-20.0F + f8), (-6 + byte0), 0.0D).color(0.7F, 0.0F, 0.0F, 1.0F).endVertex();
          tessellator.getBuffer().pos(20.0D, (-6 + byte0), 0.0D).color(0.7F, 0.0F, 0.0F, 1.0F).endVertex();
          tessellator.getBuffer().pos(20.0D, (-10 + byte0), 0.0D).color(0.7F, 0.0F, 0.0F, 1.0F).endVertex();
          tessellator.getBuffer().pos(-20.0D, (-10 + byte0), 0.0D).color(0.0F, 0.7F, 0.0F, 1.0F).endVertex();
          tessellator.getBuffer().pos(-20.0D, (-6 + byte0), 0.0D).color(0.0F, 0.7F, 0.0F, 1.0F).endVertex();
          tessellator.getBuffer().pos((f8 - 20.0F), (-6 + byte0), 0.0D).color(0.0F, 0.7F, 0.0F, 1.0F).endVertex();
          tessellator.getBuffer().pos((f8 - 20.0F), (-10 + byte0), 0.0D).color(0.0F, 0.7F, 0.0F, 1.0F).endVertex();
        }
        tessellator.draw();
        GL11.glEnable(3553);
        fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, byte0, 553648127);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, byte0, -1);
        GL11.glEnable(2896);
        GL11.glDisable(3042);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPopMatrix();
      }
    }
  }


  protected float handleRotationFloat(MoCEntityDolphin entitydolphin, float f) {
    stretch(entitydolphin);
    return entitydolphin.ticksExisted + f;
  }

  protected void stretch(MoCEntityDolphin entitydolphin) {
    GL11.glScalef(entitydolphin.getEdad() * 0.01F, entitydolphin.getEdad() * 0.01F, entitydolphin.getEdad() * 0.01F);
  }


  protected ResourceLocation getEntityTexture(MoCEntityDolphin entitydolphin) {
    return entitydolphin.getTexture();
  }
}


/* Location:              C:\Users\mami\files\games\minecraft\sneakyrp\mocreatures-fix\DrZharks MoCreatures Mod-12.0.5-deobf.jar!\drzhark\mocreatures\client\renderer\entity\MoCRenderDolphin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
