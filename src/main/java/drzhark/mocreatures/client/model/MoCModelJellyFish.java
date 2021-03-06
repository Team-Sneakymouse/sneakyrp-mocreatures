package drzhark.mocreatures.client.model;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
@SideOnly(Side.CLIENT)
public class MoCModelJellyFish extends ModelBase { ModelRenderer Top;
  ModelRenderer Head;
  ModelRenderer HeadSmall;
  ModelRenderer Body;
  ModelRenderer BodyCenter;
  ModelRenderer BodyBottom;
  ModelRenderer Side1;
  ModelRenderer Side2;
  ModelRenderer Side3;
  ModelRenderer Side4;
  ModelRenderer LegSmall1;

  public MoCModelJellyFish() {
    this.textureWidth = 64;
    this.textureHeight = 16;

    this.Top = new ModelRenderer(this, 0, 10);
    this.Top.addBox(-2.5F, 0.0F, -2.5F, 5, 1, 5);
    this.Top.setRotationPoint(0.0F, 11.0F, 0.0F);

    this.Head = new ModelRenderer(this, 0, 0);
    this.Head.addBox(-4.0F, 0.0F, -4.0F, 8, 2, 8);
    this.Head.setRotationPoint(0.0F, 12.0F, 0.0F);

    this.HeadSmall = new ModelRenderer(this, 24, 0);
    this.HeadSmall.addBox(-2.0F, 0.0F, -2.0F, 4, 3, 4);
    this.HeadSmall.setRotationPoint(0.0F, 12.5F, 0.0F);

    this.Body = new ModelRenderer(this, 36, 0);
    this.Body.addBox(-3.5F, 0.0F, -3.5F, 7, 7, 7);
    this.Body.setRotationPoint(0.0F, 13.8F, 0.0F);

    this.BodyCenter = new ModelRenderer(this, 0, 0);
    this.BodyCenter.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2);
    this.BodyCenter.setRotationPoint(0.0F, 15.5F, 0.0F);

    this.BodyBottom = new ModelRenderer(this, 20, 10);
    this.BodyBottom.addBox(-2.0F, 0.0F, -2.0F, 4, 2, 4);
    this.BodyBottom.setRotationPoint(0.0F, 18.3F, 0.0F);

    this.Side1 = new ModelRenderer(this, 20, 10);
    this.Side1.addBox(-2.0F, 5.0F, 0.0F, 4, 2, 4);
    this.Side1.setRotationPoint(0.0F, 12.5F, 0.0F);
    setRotation(this.Side1, -0.7679449F, 0.0F, 0.0F);

    this.Side2 = new ModelRenderer(this, 20, 10);
    this.Side2.addBox(-4.0F, 5.0F, -2.0F, 4, 2, 4);
    this.Side2.setRotationPoint(0.0F, 12.5F, 0.0F);
    setRotation(this.Side2, 0.0F, 0.0F, -0.7679449F);

    this.Side3 = new ModelRenderer(this, 20, 10);
    this.Side3.addBox(0.0F, 5.0F, -2.0F, 4, 2, 4);
    this.Side3.setRotationPoint(0.0F, 12.5F, 0.0F);
    setRotation(this.Side3, 0.0F, 0.0F, 0.7679449F);

    this.Side4 = new ModelRenderer(this, 20, 10);
    this.Side4.addBox(-2.0F, 5.0F, -4.0F, 4, 2, 4);
    this.Side4.setRotationPoint(0.0F, 12.5F, 0.0F);
    setRotation(this.Side4, 0.7679449F, 0.0F, 0.0F);

    this.LegSmall1 = new ModelRenderer(this, 60, 2);
    this.LegSmall1.addBox(-1.0F, 0.0F, -1.0F, 1, 3, 1);
    this.LegSmall1.setRotationPoint(0.0F, 18.5F, 0.0F);

    this.LegC1 = new ModelRenderer(this, 15, 10);
    this.LegC1.addBox(-1.0F, 0.0F, -1.0F, 1, 4, 1);
    this.LegC1.setRotationPoint(-0.5F, 15.5F, -0.5F);
    setRotation(this.LegC1, -0.2602503F, 0.0F, 0.1487144F);

    this.LegC2 = new ModelRenderer(this, 15, 10);
    this.LegC2.addBox(-1.0F, 0.0F, 0.0F, 1, 4, 1);
    this.LegC2.setRotationPoint(0.5F, 15.5F, -0.5F);
    setRotation(this.LegC2, 0.1487144F, 1.747395F, 0.0F);

    this.LegC3 = new ModelRenderer(this, 15, 10);
    this.LegC3.addBox(-1.0F, 0.0F, 0.0F, 1, 4, 1);
    this.LegC3.setRotationPoint(-0.5F, 15.5F, 0.5F);
    setRotation(this.LegC3, 0.1115358F, 0.3717861F, 0.2230717F);

    this.Leg1 = new ModelRenderer(this, 0, 10);
    this.Leg1.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1);
    this.Leg1.setRotationPoint(0.0F, 20.0F, 2.5F);

    this.Leg2 = new ModelRenderer(this, 0, 10);
    this.Leg2.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1);
    this.Leg2.setRotationPoint(0.0F, 20.0F, -2.5F);

    this.Leg3 = new ModelRenderer(this, 0, 10);
    this.Leg3.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1);
    this.Leg3.setRotationPoint(2.5F, 20.0F, 0.0F);

    this.Leg4 = new ModelRenderer(this, 0, 10);
    this.Leg4.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1);
    this.Leg4.setRotationPoint(-2.5F, 20.0F, 0.0F);

    this.Leg5 = new ModelRenderer(this, 0, 10);
    this.Leg5.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1);
    this.Leg5.setRotationPoint(2.0F, 20.0F, 2.0F);
    setRotation(this.Leg5, 0.0F, 0.7853982F, 0.0F);

    this.Leg6 = new ModelRenderer(this, 0, 10);
    this.Leg6.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1);
    this.Leg6.setRotationPoint(2.0F, 20.0F, -2.0F);
    setRotation(this.Leg6, 0.0F, 0.7853982F, 0.0F);

    this.Leg7 = new ModelRenderer(this, 0, 10);
    this.Leg7.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1);
    this.Leg7.setRotationPoint(-2.0F, 20.0F, -2.0F);
    setRotation(this.Leg7, 0.0F, 0.7853982F, 0.0F);

    this.Leg8 = new ModelRenderer(this, 60, 0);
    this.Leg8.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1);
    this.Leg8.setRotationPoint(0.0F, 18.5F, 0.0F);

    this.Leg9 = new ModelRenderer(this, 0, 10);
    this.Leg9.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1);
    this.Leg9.setRotationPoint(-2.0F, 20.0F, 2.0F);
    setRotation(this.Leg9, 0.0F, 0.7853982F, 0.0F);
  }
  ModelRenderer LegC1; ModelRenderer LegC2; ModelRenderer LegC3; ModelRenderer Leg1; ModelRenderer Leg2; ModelRenderer Leg3; ModelRenderer Leg4; ModelRenderer Leg5; ModelRenderer Leg6; ModelRenderer Leg7; ModelRenderer Leg8; ModelRenderer Leg9;

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    setRotationAngles(f, f1, f2, f3, f4, f5);






















    this.Top.render(f5);
    this.Head.render(f5);
    this.HeadSmall.render(f5);
    this.Body.render(f5);
    this.BodyCenter.render(f5);
    this.BodyBottom.render(f5);
    this.Side1.render(f5);
    this.Side2.render(f5);
    this.Side3.render(f5);
    this.Side4.render(f5);
    this.LegSmall1.render(f5);
    this.LegC1.render(f5);
    this.LegC2.render(f5);
    this.LegC3.render(f5);
    this.Leg1.render(f5);
    this.Leg2.render(f5);
    this.Leg3.render(f5);
    this.Leg4.render(f5);
    this.Leg5.render(f5);
    this.Leg6.render(f5);
    this.Leg7.render(f5);
    this.Leg8.render(f5);
    this.Leg9.render(f5);
  }




  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
    float f6 = f1 * 2.0F;
    if (f6 > 1.0F) {
      f6 = 1.0F;
    }

    this.LegSmall1.rotateAngleX = f6;
    this.LegC1.rotateAngleX = f6;
    this.LegC2.rotateAngleX = f6;
    this.LegC3.rotateAngleX = f6;
    this.Leg1.rotateAngleX = f6;
    this.Leg2.rotateAngleX = f6;
    this.Leg3.rotateAngleX = f6;
    this.Leg4.rotateAngleX = f6;
    this.Leg5.rotateAngleX = f6;
    this.Leg6.rotateAngleX = f6;
    this.Leg7.rotateAngleX = f6;
    this.Leg8.rotateAngleX = f6;
    this.Leg9.rotateAngleX = f6;
  }

  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  } }


/* Location:              C:\Users\mami\files\games\minecraft\sneakyrp\mocreatures-fix\DrZharks MoCreatures Mod-12.0.5-deobf.jar!\drzhark\mocreatures\client\model\MoCModelJellyFish.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
