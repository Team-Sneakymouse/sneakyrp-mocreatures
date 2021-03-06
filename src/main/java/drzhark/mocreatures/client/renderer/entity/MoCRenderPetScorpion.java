package drzhark.mocreatures.client.renderer.entity;
import drzhark.mocreatures.client.model.MoCModelScorpion;
import drzhark.mocreatures.entity.passive.MoCEntityPetScorpion;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class MoCRenderPetScorpion extends MoCRenderMoC<MoCEntityPetScorpion> {
  public MoCRenderPetScorpion(MoCModelScorpion modelbase, float f) {
    super(modelbase, f);
  }


  public void doRender(MoCEntityPetScorpion entityscorpion, double d, double d1, double d2, float f, float f1) {
    super.doRender(entityscorpion, d, d1, d2, f, f1);
  }


  protected void preRenderCallback(MoCEntityPetScorpion entityscorpion, float f) {
    boolean sitting = entityscorpion.getIsSitting();
    if (entityscorpion.climbing()) {
      rotateAnimal(entityscorpion);
    }
    if (sitting) {
      float factorY = 0.4F * entityscorpion.getEdad() / 100.0F;
      GL11.glTranslatef(0.0F, factorY, 0.0F);
    }
    if (!entityscorpion.getIsAdult()) {
      stretch(entityscorpion);
      if (entityscorpion.getRidingEntity() != null) {
        upsideDown(entityscorpion);
      }
    } else {
      adjustHeight(entityscorpion);
    }
  }

  protected void upsideDown(MoCEntityPetScorpion entityscorpion) {
    GL11.glRotatef(-90.0F, -1.0F, 0.0F, 0.0F);
    GL11.glTranslatef(-1.5F, -0.5F, -2.5F);
  }

  protected void adjustHeight(MoCEntityPetScorpion entityscorpion) {
    GL11.glTranslatef(0.0F, -0.1F, 0.0F);
  }

  protected void rotateAnimal(MoCEntityPetScorpion entityscorpion) {
    GL11.glRotatef(90.0F, -1.0F, 0.0F, 0.0F);
  }


  protected void stretch(MoCEntityPetScorpion entityscorpion) {
    float f = 1.1F;
    if (!entityscorpion.getIsAdult()) {
      f = entityscorpion.getEdad() * 0.01F;
    }
    GL11.glScalef(f, f, f);
  }


  protected ResourceLocation getEntityTexture(MoCEntityPetScorpion entityscorpion) {
    return entityscorpion.getTexture();
  }
}


/* Location:              C:\Users\mami\files\games\minecraft\sneakyrp\mocreatures-fix\DrZharks MoCreatures Mod-12.0.5-deobf.jar!\drzhark\mocreatures\client\renderer\entity\MoCRenderPetScorpion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
