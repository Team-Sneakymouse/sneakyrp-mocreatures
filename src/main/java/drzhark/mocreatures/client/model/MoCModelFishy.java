package drzhark.mocreatures.client.model;

import drzhark.mocreatures.entity.aquatic.MoCEntityFishy;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class MoCModelFishy
  extends ModelBase {
  public ModelRenderer Body;
  public ModelRenderer UpperFin;
  public ModelRenderer LowerFin;
  public ModelRenderer RightFin;
  public ModelRenderer LeftFin;
  public ModelRenderer Tail;

  public MoCModelFishy() {
    this.Body = new ModelRenderer(this, 0, 0);
    this.Body.addBox(0.0F, 0.0F, -3.5F, 1, 5, 5, 0.0F);
    this.Body.setRotationPoint(0.0F, 18.0F, -1.0F);
    this.Body.rotateAngleX = 0.7853981F;
    this.Tail = new ModelRenderer(this, 12, 0);
    this.Tail.addBox(0.0F, 0.0F, 0.0F, 1, 3, 3, 0.0F);
    this.Tail.setRotationPoint(0.0F, 20.5F, 3.0F);
    this.Tail.rotateAngleX = 0.7853981F;
  }


  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5);
    MoCEntityFishy smallFish = (MoCEntityFishy)entity;
    float yOffset = smallFish.getAdjustedYOffset();
    float xOffset = smallFish.getAdjustedXOffset();
    float zOffset = smallFish.getAdjustedZOffset();
    GL11.glPushMatrix();
    GL11.glTranslatef(xOffset, yOffset, zOffset);
    this.Body.render(f5);
    this.Tail.render(f5);
    GL11.glPopMatrix();
  }

  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
    this.Tail.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
  }
}


/* Location:              C:\Users\mami\files\games\minecraft\sneakyrp\mocreatures-fix\DrZharks MoCreatures Mod-12.0.5-deobf.jar!\drzhark\mocreatures\client\model\MoCModelFishy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
