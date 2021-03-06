package drzhark.mocreatures.client.renderer.entity;
import drzhark.mocreatures.client.MoCClientProxy;
import drzhark.mocreatures.entity.aquatic.MoCEntityFishy;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class MoCRenderFishy extends RenderLiving<MoCEntityFishy> {
  public MoCRenderFishy(ModelBase modelbase, float f) {
    super(MoCClientProxy.mc.getRenderManager(), modelbase, f);
  }


  public void doRender(MoCEntityFishy entityfishy, double d, double d1, double d2, float f, float f1) {
    if (entityfishy.getType() == 0) {
      entityfishy.selectType();
    }
    super.doRender(entityfishy, d, d1, d2, f, f1);
  }


  protected void preRenderCallback(MoCEntityFishy entityfishy, float f) {
    GL11.glTranslatef(0.0F, 0.3F, 0.0F);
  }


  protected float handleRotationFloat(MoCEntityFishy entityfishy, float f) {
    if (!entityfishy.getIsAdult()) {
      stretch(entityfishy);
    }
    return entityfishy.ticksExisted + f;
  }

  protected void stretch(MoCEntityFishy entityfishy) {
    GL11.glScalef(entityfishy.getEdad() * 0.01F, entityfishy.getEdad() * 0.01F, entityfishy.getEdad() * 0.01F);
  }


  protected ResourceLocation getEntityTexture(MoCEntityFishy entityfishy) {
    return entityfishy.getTexture();
  }
}


/* Location:              C:\Users\mami\files\games\minecraft\sneakyrp\mocreatures-fix\DrZharks MoCreatures Mod-12.0.5-deobf.jar!\drzhark\mocreatures\client\renderer\entity\MoCRenderFishy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
