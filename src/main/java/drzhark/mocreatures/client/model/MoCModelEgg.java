package drzhark.mocreatures.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MoCModelEgg extends ModelBase {
  public ModelRenderer Egg;
  ModelRenderer Egg1;
  ModelRenderer Egg2;

  public MoCModelEgg() {
    this.Egg1 = new ModelRenderer(this, 0, 0);
    this.Egg1.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3);
    this.Egg1.setRotationPoint(0.0F, 20.0F, 0.0F);

    this.Egg2 = new ModelRenderer(this, 10, 0);
    this.Egg2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
    this.Egg2.setRotationPoint(0.5F, 19.5F, 0.5F);

    this.Egg3 = new ModelRenderer(this, 30, 0);
    this.Egg3.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
    this.Egg3.setRotationPoint(0.5F, 22.5F, 0.5F);

    this.Egg4 = new ModelRenderer(this, 24, 0);
    this.Egg4.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2);
    this.Egg4.setRotationPoint(-0.5F, 20.5F, 0.5F);

    this.Egg5 = new ModelRenderer(this, 18, 0);
    this.Egg5.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2);
    this.Egg5.setRotationPoint(2.5F, 20.5F, 0.5F);
  }

  ModelRenderer Egg3;

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.Egg1.render(f5);
    this.Egg2.render(f5);
    this.Egg3.render(f5);
    this.Egg4.render(f5);
    this.Egg5.render(f5);
  }

  ModelRenderer Egg4;
  ModelRenderer Egg5;

  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {}
}


/* Location:              C:\Users\mami\files\games\minecraft\sneakyrp\mocreatures-fix\DrZharks MoCreatures Mod-12.0.5-deobf.jar!\drzhark\mocreatures\client\model\MoCModelEgg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
