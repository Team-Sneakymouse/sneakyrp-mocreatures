package drzhark.mocreatures.client.renderer.entity;

import drzhark.mocreatures.MoCreatures;
import drzhark.mocreatures.client.model.MoCModelKitty;
import drzhark.mocreatures.entity.passive.MoCEntityKitty;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class MoCRenderKitty
  extends MoCRenderMoC<MoCEntityKitty> {
  protected ResourceLocation getEntityTexture(MoCEntityKitty entitykitty) {
    return entitykitty.getTexture();
  }
  public MoCModelKitty pussy1;
  public MoCRenderKitty(ModelBase modelkitty, float f) {
    super(modelkitty, f);
    this.pussy1 = (MoCModelKitty)modelkitty;
  }


  public void doRender(MoCEntityKitty entitykitty, double d, double d1, double d2, float f, float f1) {
    super.doRender(entitykitty, d, d1, d2, f, f1);
    boolean flag2 = MoCreatures.proxy.getDisplayPetIcons();
    if (entitykitty.renderName()) {
      float f2 = 1.6F;
      float f3 = 0.01666667F * f2;
      float f4 = entitykitty.getDistance(this.renderManager.renderViewEntity);
      if (f4 < 12.0F) {
        float f5 = 0.2F;
        if (this.pussy1.isSitting) {
          f5 = 0.4F;
        }

        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.0F, (float)d1 - f5, (float)d2);
        GL11.glNormal3f(0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glScalef(-f3, -f3, f3);
        GL11.glDisable(2896);
        Tessellator tessellator = Tessellator.getInstance();

        if (flag2 && entitykitty.getIsEmo()) {
          bindTexture(entitykitty.getEmoteIcon());
          int i = -90;
          int k = 32;
          int l = k / 2 * -1;
          float f9 = 0.0F;
          float f11 = 1.0F / k;
          float f12 = 1.0F / k;
          tessellator.getBuffer().begin(7, DefaultVertexFormats.POSITION_TEX);
          tessellator.getBuffer().pos(l, (i + k), f9).tex(0.0D, (k * f12)).endVertex();
          tessellator.getBuffer().pos((l + k), (i + k), f9).tex((k * f11), (k * f12)).endVertex();
          tessellator.getBuffer().pos((l + k), i, f9).tex((k * f11), 0.0D).endVertex();
          tessellator.getBuffer().pos(l, i, f9).tex(0.0D, 0.0D).endVertex();
          tessellator.draw();
        }

        GL11.glEnable(2896);
        GL11.glPopMatrix();
      }
    }
  }

  public void doRender2(MoCEntityKitty entitykitty, double d, double d1, double d2, float f, float f1) {
    super.doRender(entitykitty, d, d1, d2, f, f1);
  }


  protected float handleRotationFloat(MoCEntityKitty entitykitty, float f) {
    if (!entitykitty.getIsAdult()) {
      stretch(entitykitty);
    }
    return entitykitty.ticksExisted + f;
  }

  protected void onMaBack(MoCEntityKitty entitykitty) {
    GL11.glRotatef(90.0F, 0.0F, 0.0F, -1.0F);

    if (!entitykitty.world.isRemote && entitykitty.getRidingEntity() != null) {
      GL11.glTranslatef(-1.5F, 0.2F, -0.2F);
    } else {
      GL11.glTranslatef(0.1F, 0.2F, -0.2F);
    }
  }


  protected void onTheSide(MoCEntityKitty entityliving) {
    GL11.glRotatef(90.0F, 0.0F, 0.0F, -1.0F);
    GL11.glTranslatef(0.2F, 0.0F, -0.2F);
  }


  protected void preRenderCallback(MoCEntityKitty entitykitty, float f) {
    this.pussy1.isSitting = entitykitty.getIsSitting();
    this.pussy1.isSwinging = entitykitty.getIsSwinging();
    this.pussy1.swingProgress = entitykitty.swingProgress;
    this.pussy1.kittystate = entitykitty.getKittyState();
    if (entitykitty.getKittyState() == 20) {
      onTheSide(entitykitty);
    }
    if (entitykitty.climbingTree()) {
      rotateAnimal(entitykitty);
    }
    if (entitykitty.upsideDown()) {
      upsideDown(entitykitty);
    }
    if (entitykitty.onMaBack()) {
      onMaBack(entitykitty);
    }
  }

  protected void rotateAnimal(MoCEntityKitty entitykitty) {
    if (!entitykitty.onGround) {
      GL11.glRotatef(90.0F, -1.0F, 0.0F, 0.0F);
    }
  }

  protected void stretch(MoCEntityKitty entitykitty) {
    GL11.glScalef(entitykitty.getEdad() * 0.01F, entitykitty.getEdad() * 0.01F, entitykitty.getEdad() * 0.01F);
  }

  protected void upsideDown(MoCEntityKitty entitykitty) {
    GL11.glRotatef(180.0F, 0.0F, 0.0F, -1.0F);
    GL11.glTranslatef(-0.35F, 0.0F, -0.55F);
  }
}


/* Location:              C:\Users\mami\files\games\minecraft\sneakyrp\mocreatures-fix\DrZharks MoCreatures Mod-12.0.5-deobf.jar!\drzhark\mocreatures\client\renderer\entity\MoCRenderKitty.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
