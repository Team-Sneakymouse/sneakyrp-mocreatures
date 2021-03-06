package drzhark.mocreatures.client.model;

import drzhark.mocreatures.entity.passive.MoCEntityHorse;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;














































@SideOnly(Side.CLIENT)
public class MoCModelNewHorse
  extends ModelBase
{
  ModelRenderer Head;
  ModelRenderer UMouth;
  ModelRenderer LMouth;
  ModelRenderer UMouth2;
  ModelRenderer LMouth2;
  ModelRenderer Unicorn;
  ModelRenderer Ear1;
  ModelRenderer Ear2;
  ModelRenderer MuleEarL;
  ModelRenderer MuleEarR;
  ModelRenderer Neck;
  ModelRenderer HeadSaddle;
  ModelRenderer Mane;
  ModelRenderer Body;
  ModelRenderer TailA;
  ModelRenderer TailB;
  ModelRenderer TailC;
  ModelRenderer Leg1A;
  ModelRenderer Leg1B;
  ModelRenderer Leg1C;
  ModelRenderer Leg2A;
  ModelRenderer Leg2B;
  ModelRenderer Leg2C;
  ModelRenderer Leg3A;
  ModelRenderer Leg3B;
  ModelRenderer Leg3C;
  ModelRenderer Leg4A;
  ModelRenderer Leg4B;
  ModelRenderer Leg4C;
  ModelRenderer Bag1;
  ModelRenderer Bag2;
  ModelRenderer Saddle;
  ModelRenderer SaddleB;
  ModelRenderer SaddleC;
  ModelRenderer SaddleL;
  ModelRenderer SaddleL2;
  ModelRenderer SaddleR;
  ModelRenderer SaddleR2;
  ModelRenderer SaddleMouthL;
  ModelRenderer SaddleMouthR;
  ModelRenderer SaddleMouthLine;
  ModelRenderer SaddleMouthLineR;
  ModelRenderer MidWing;
  ModelRenderer InnerWing;
  ModelRenderer OuterWing;
  ModelRenderer InnerWingR;
  ModelRenderer MidWingR;
  ModelRenderer OuterWingR;
  ModelRenderer ButterflyL;
  ModelRenderer ButterflyR;

  public MoCModelNewHorse() {
    this.textureWidth = 128;
    this.textureHeight = 128;

    this.Body = new ModelRenderer(this, 0, 34);
    this.Body.addBox(-5.0F, -8.0F, -19.0F, 10, 10, 24);
    this.Body.setRotationPoint(0.0F, 11.0F, 9.0F);







    this.TailA = new ModelRenderer(this, 44, 0);
    this.TailA.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 3);
    this.TailA.setRotationPoint(0.0F, 3.0F, 14.0F);
    setRotation(this.TailA, -1.134464F, 0.0F, 0.0F);

    this.TailB = new ModelRenderer(this, 38, 7);
    this.TailB.addBox(-1.5F, -2.0F, 3.0F, 3, 4, 7);
    this.TailB.setRotationPoint(0.0F, 3.0F, 14.0F);
    setRotation(this.TailB, -1.134464F, 0.0F, 0.0F);

    this.TailC = new ModelRenderer(this, 24, 3);
    this.TailC.addBox(-1.5F, -4.5F, 9.0F, 3, 4, 7);
    this.TailC.setRotationPoint(0.0F, 3.0F, 14.0F);
    setRotation(this.TailC, -1.40215F, 0.0F, 0.0F);

    this.Leg1A = new ModelRenderer(this, 78, 29);
    this.Leg1A.addBox(-2.5F, -2.0F, -2.5F, 4, 9, 5);
    this.Leg1A.setRotationPoint(4.0F, 9.0F, 11.0F);

    this.Leg1B = new ModelRenderer(this, 78, 43);
    this.Leg1B.addBox(-2.0F, 0.0F, -1.5F, 3, 5, 3);
    this.Leg1B.setRotationPoint(4.0F, 16.0F, 11.0F);

    this.Leg1C = new ModelRenderer(this, 78, 51);
    this.Leg1C.addBox(-2.5F, 5.1F, -2.0F, 4, 3, 4);
    this.Leg1C.setRotationPoint(4.0F, 16.0F, 11.0F);

    this.Leg2A = new ModelRenderer(this, 96, 29);
    this.Leg2A.addBox(-1.5F, -2.0F, -2.5F, 4, 9, 5);
    this.Leg2A.setRotationPoint(-4.0F, 9.0F, 11.0F);

    this.Leg2B = new ModelRenderer(this, 96, 43);
    this.Leg2B.addBox(-1.0F, 0.0F, -1.5F, 3, 5, 3);
    this.Leg2B.setRotationPoint(-4.0F, 16.0F, 11.0F);

    this.Leg2C = new ModelRenderer(this, 96, 51);
    this.Leg2C.addBox(-1.5F, 5.1F, -2.0F, 4, 3, 4);
    this.Leg2C.setRotationPoint(-4.0F, 16.0F, 11.0F);

    this.Leg3A = new ModelRenderer(this, 44, 29);
    this.Leg3A.addBox(-1.9F, -1.0F, -2.1F, 3, 8, 4);
    this.Leg3A.setRotationPoint(4.0F, 9.0F, -8.0F);

    this.Leg3B = new ModelRenderer(this, 44, 41);
    this.Leg3B.addBox(-1.9F, 0.0F, -1.6F, 3, 5, 3);
    this.Leg3B.setRotationPoint(4.0F, 16.0F, -8.0F);

    this.Leg3C = new ModelRenderer(this, 44, 51);
    this.Leg3C.addBox(-2.4F, 5.1F, -2.1F, 4, 3, 4);
    this.Leg3C.setRotationPoint(4.0F, 16.0F, -8.0F);

    this.Leg4A = new ModelRenderer(this, 60, 29);
    this.Leg4A.addBox(-1.1F, -1.0F, -2.1F, 3, 8, 4);
    this.Leg4A.setRotationPoint(-4.0F, 9.0F, -8.0F);

    this.Leg4B = new ModelRenderer(this, 60, 41);
    this.Leg4B.addBox(-1.1F, 0.0F, -1.6F, 3, 5, 3);
    this.Leg4B.setRotationPoint(-4.0F, 16.0F, -8.0F);

    this.Leg4C = new ModelRenderer(this, 60, 51);
    this.Leg4C.addBox(-1.6F, 5.1F, -2.1F, 4, 3, 4);
    this.Leg4C.setRotationPoint(-4.0F, 16.0F, -8.0F);

    this.Head = new ModelRenderer(this, 0, 0);
    this.Head.addBox(-2.5F, -10.0F, -1.5F, 5, 5, 7);
    this.Head.setRotationPoint(0.0F, 4.0F, -10.0F);
    setRotation(this.Head, 0.5235988F, 0.0F, 0.0F);

    this.UMouth = new ModelRenderer(this, 24, 18);
    this.UMouth.addBox(-2.0F, -10.0F, -7.0F, 4, 3, 6);
    this.UMouth.setRotationPoint(0.0F, 4.0F, -10.0F);
    setRotation(this.UMouth, 0.5235988F, 0.0F, 0.0F);

    this.LMouth = new ModelRenderer(this, 24, 27);
    this.LMouth.addBox(-2.0F, -7.0F, -6.5F, 4, 2, 5);
    this.LMouth.setRotationPoint(0.0F, 4.0F, -10.0F);
    setRotation(this.LMouth, 0.5235988F, 0.0F, 0.0F);

    this.UMouth2 = new ModelRenderer(this, 24, 18);
    this.UMouth2.addBox(-2.0F, -10.0F, -8.0F, 4, 3, 6);
    this.UMouth2.setRotationPoint(0.0F, 4.0F, -10.0F);
    setRotation(this.UMouth2, 0.4363323F, 0.0F, 0.0F);

    this.LMouth2 = new ModelRenderer(this, 24, 27);
    this.LMouth2.addBox(-2.0F, -7.0F, -5.5F, 4, 2, 5);
    this.LMouth2.setRotationPoint(0.0F, 4.0F, -10.0F);
    setRotation(this.LMouth2, 0.7853982F, 0.0F, 0.0F);

    this.Unicorn = new ModelRenderer(this, 24, 0);
    this.Unicorn.addBox(-0.5F, -18.0F, 2.0F, 1, 8, 1);
    this.Unicorn.setRotationPoint(0.0F, 4.0F, -10.0F);
    setRotation(this.Unicorn, 0.5235988F, 0.0F, 0.0F);

    this.Ear1 = new ModelRenderer(this, 0, 0);
    this.Ear1.addBox(0.45F, -12.0F, 4.0F, 2, 3, 1);
    this.Ear1.setRotationPoint(0.0F, 4.0F, -10.0F);
    setRotation(this.Ear1, 0.5235988F, 0.0F, 0.0F);

    this.Ear2 = new ModelRenderer(this, 0, 0);
    this.Ear2.addBox(-2.45F, -12.0F, 4.0F, 2, 3, 1);
    this.Ear2.setRotationPoint(0.0F, 4.0F, -10.0F);
    setRotation(this.Ear2, 0.5235988F, 0.0F, 0.0F);

    this.MuleEarL = new ModelRenderer(this, 0, 12);
    this.MuleEarL.addBox(-2.0F, -16.0F, 4.0F, 2, 7, 1);
    this.MuleEarL.setRotationPoint(0.0F, 4.0F, -10.0F);
    setRotation(this.MuleEarL, 0.5235988F, 0.0F, 0.2617994F);

    this.MuleEarR = new ModelRenderer(this, 0, 12);
    this.MuleEarR.addBox(0.0F, -16.0F, 4.0F, 2, 7, 1);
    this.MuleEarR.setRotationPoint(0.0F, 4.0F, -10.0F);
    setRotation(this.MuleEarR, 0.5235988F, 0.0F, -0.2617994F);

    this.Neck = new ModelRenderer(this, 0, 12);
    this.Neck.addBox(-2.05F, -9.8F, -2.0F, 4, 14, 8);
    this.Neck.setRotationPoint(0.0F, 4.0F, -10.0F);
    setRotation(this.Neck, 0.5235988F, 0.0F, 0.0F);

    this.Bag1 = new ModelRenderer(this, 0, 34);
    this.Bag1.addBox(-3.0F, 0.0F, 0.0F, 8, 8, 3);
    this.Bag1.setRotationPoint(-7.5F, 3.0F, 10.0F);
    setRotation(this.Bag1, 0.0F, 1.570796F, 0.0F);

    this.Bag2 = new ModelRenderer(this, 0, 47);
    this.Bag2.addBox(-3.0F, 0.0F, 0.0F, 8, 8, 3);
    this.Bag2.setRotationPoint(4.5F, 3.0F, 10.0F);
    setRotation(this.Bag2, 0.0F, 1.570796F, 0.0F);

    this.Saddle = new ModelRenderer(this, 80, 0);
    this.Saddle.addBox(-5.0F, 0.0F, -3.0F, 10, 1, 8);
    this.Saddle.setRotationPoint(0.0F, 2.0F, 2.0F);

    this.SaddleB = new ModelRenderer(this, 106, 9);
    this.SaddleB.addBox(-1.5F, -1.0F, -3.0F, 3, 1, 2);
    this.SaddleB.setRotationPoint(0.0F, 2.0F, 2.0F);

    this.SaddleC = new ModelRenderer(this, 80, 9);
    this.SaddleC.addBox(-4.0F, -1.0F, 3.0F, 8, 1, 2);
    this.SaddleC.setRotationPoint(0.0F, 2.0F, 2.0F);

    this.SaddleL2 = new ModelRenderer(this, 74, 0);
    this.SaddleL2.addBox(-0.5F, 6.0F, -1.0F, 1, 2, 2);
    this.SaddleL2.setRotationPoint(5.0F, 3.0F, 2.0F);

    this.SaddleL = new ModelRenderer(this, 70, 0);
    this.SaddleL.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1);
    this.SaddleL.setRotationPoint(5.0F, 3.0F, 2.0F);

    this.SaddleR2 = new ModelRenderer(this, 74, 4);
    this.SaddleR2.addBox(-0.5F, 6.0F, -1.0F, 1, 2, 2);
    this.SaddleR2.setRotationPoint(-5.0F, 3.0F, 2.0F);

    this.SaddleR = new ModelRenderer(this, 80, 0);
    this.SaddleR.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1);
    this.SaddleR.setRotationPoint(-5.0F, 3.0F, 2.0F);

    this.SaddleMouthL = new ModelRenderer(this, 74, 13);
    this.SaddleMouthL.addBox(1.5F, -8.0F, -4.0F, 1, 2, 2);
    this.SaddleMouthL.setRotationPoint(0.0F, 4.0F, -10.0F);
    setRotation(this.SaddleMouthL, 0.5235988F, 0.0F, 0.0F);

    this.SaddleMouthR = new ModelRenderer(this, 74, 13);
    this.SaddleMouthR.addBox(-2.5F, -8.0F, -4.0F, 1, 2, 2);
    this.SaddleMouthR.setRotationPoint(0.0F, 4.0F, -10.0F);
    setRotation(this.SaddleMouthR, 0.5235988F, 0.0F, 0.0F);

    this.SaddleMouthLine = new ModelRenderer(this, 44, 10);
    this.SaddleMouthLine.addBox(2.6F, -6.0F, -6.0F, 0, 3, 16);
    this.SaddleMouthLine.setRotationPoint(0.0F, 4.0F, -10.0F);

    this.SaddleMouthLineR = new ModelRenderer(this, 44, 5);
    this.SaddleMouthLineR.addBox(-2.6F, -6.0F, -6.0F, 0, 3, 16);
    this.SaddleMouthLineR.setRotationPoint(0.0F, 4.0F, -10.0F);

    this.Mane = new ModelRenderer(this, 58, 0);
    this.Mane.addBox(-1.0F, -11.5F, 5.0F, 2, 16, 4);
    this.Mane.setRotationPoint(0.0F, 4.0F, -10.0F);


    setRotation(this.Mane, 0.5235988F, 0.0F, 0.0F);

    this.HeadSaddle = new ModelRenderer(this, 80, 12);
    this.HeadSaddle.addBox(-2.5F, -10.1F, -7.0F, 5, 5, 12, 0.2F);
    this.HeadSaddle.setRotationPoint(0.0F, 4.0F, -10.0F);
    setRotation(this.HeadSaddle, 0.5235988F, 0.0F, 0.0F);

    this.MidWing = new ModelRenderer(this, 82, 68);
    this.MidWing.addBox(1.0F, 0.1F, 1.0F, 12, 2, 11);
    this.MidWing.setRotationPoint(5.0F, 3.0F, -6.0F);
    setRotation(this.MidWing, 0.0F, 0.0872665F, 0.0F);

    this.InnerWing = new ModelRenderer(this, 0, 96);
    this.InnerWing.addBox(0.0F, 0.0F, 0.0F, 7, 2, 11);
    this.InnerWing.setRotationPoint(5.0F, 3.0F, -6.0F);
    setRotation(this.InnerWing, 0.0F, -0.3490659F, 0.0F);

    this.OuterWing = new ModelRenderer(this, 0, 68);
    this.OuterWing.addBox(0.0F, 0.0F, 0.0F, 22, 2, 11);
    this.OuterWing.setRotationPoint(17.0F, 3.0F, -6.0F);
    setRotation(this.OuterWing, 0.0F, -0.3228859F, 0.0F);

    this.InnerWingR = new ModelRenderer(this, 0, 110);
    this.InnerWingR.addBox(-7.0F, 0.0F, 0.0F, 7, 2, 11);
    this.InnerWingR.setRotationPoint(-5.0F, 3.0F, -6.0F);
    setRotation(this.InnerWingR, 0.0F, 0.3490659F, 0.0F);

    this.MidWingR = new ModelRenderer(this, 82, 82);
    this.MidWingR.addBox(-13.0F, 0.1F, 1.0F, 12, 2, 11);
    this.MidWingR.setRotationPoint(-5.0F, 3.0F, -6.0F);
    setRotation(this.MidWingR, 0.0F, -0.0872665F, 0.0F);

    this.OuterWingR = new ModelRenderer(this, 0, 82);
    this.OuterWingR.addBox(-22.0F, 0.0F, 0.0F, 22, 2, 11);
    this.OuterWingR.setRotationPoint(-17.0F, 3.0F, -6.0F);
    setRotation(this.OuterWingR, 0.0F, 0.3228859F, 0.0F);

    this.ButterflyL = new ModelRenderer(this, 0, 98);
    this.ButterflyL.addBox(-1.0F, 0.0F, -14.0F, 26, 0, 30);
    this.ButterflyL.setRotationPoint(4.5F, 3.0F, -2.0F);
    setRotation(this.ButterflyL, 0.0F, 0.0F, -0.78539F);

    this.ButterflyR = new ModelRenderer(this, 0, 68);
    this.ButterflyR.addBox(-25.0F, 0.0F, -14.0F, 26, 0, 30);
    this.ButterflyR.setRotationPoint(-4.5F, 3.0F, -2.0F);
    setRotation(this.ButterflyR, 0.0F, 0.0F, 0.78539F);
  }



  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    MoCEntityHorse entityhorse = (MoCEntityHorse)entity;


    int type = entityhorse.getType();
    int vanishingInt = entityhorse.getVanishC();
    int wingflapInt = entityhorse.wingFlapCounter;
    boolean flapwings = (entityhorse.wingFlapCounter != 0);
    boolean shuffling = (entityhorse.shuffleCounter != 0);
    boolean saddled = entityhorse.getIsRideable();
    boolean wings = (entityhorse.isFlyer() && !entityhorse.getIsGhost() && type < 45);

    boolean eating = entityhorse.getIsSitting();

    boolean standing = (entityhorse.standCounter != 0 && entityhorse.getRidingEntity() == null);
    boolean openMouth = (entityhorse.mouthCounter != 0);
    boolean moveTail = (entityhorse.tailCounter != 0);

    boolean rider = entityhorse.isBeingRidden();
    boolean floating = (entityhorse.getIsGhost() || (entityhorse.isFlyer() && entityhorse.isOnAir()));


    setRotationAngles(f, f1, f2, f3, f4, f5, eating, rider, floating, standing, saddled, moveTail, wings, flapwings, shuffling, type);

    if (!entityhorse.getIsGhost() && vanishingInt == 0) {
      if (saddled) {
        this.HeadSaddle.render(f5);
        this.Saddle.render(f5);
        this.SaddleB.render(f5);
        this.SaddleC.render(f5);
        this.SaddleL.render(f5);
        this.SaddleL2.render(f5);
        this.SaddleR.render(f5);
        this.SaddleR2.render(f5);
        this.SaddleMouthL.render(f5);
        this.SaddleMouthR.render(f5);
        if (rider) {
          this.SaddleMouthLine.render(f5);
          this.SaddleMouthLineR.render(f5);
        }
      }


      if (type == 65 || type == 66 || type == 67) {

        this.MuleEarL.render(f5);
        this.MuleEarR.render(f5);
      } else {
        this.Ear1.render(f5);
        this.Ear2.render(f5);
      }

      this.Neck.render(f5);
      this.Head.render(f5);
      if (openMouth) {
        this.UMouth2.render(f5);
        this.LMouth2.render(f5);
      } else {
        this.UMouth.render(f5);
        this.LMouth.render(f5);
      }
      this.Mane.render(f5);
      this.Body.render(f5);
      this.TailA.render(f5);
      this.TailB.render(f5);
      this.TailC.render(f5);

      this.Leg1A.render(f5);
      this.Leg1B.render(f5);
      this.Leg1C.render(f5);

      this.Leg2A.render(f5);
      this.Leg2B.render(f5);
      this.Leg2C.render(f5);

      this.Leg3A.render(f5);
      this.Leg3B.render(f5);
      this.Leg3C.render(f5);

      this.Leg4A.render(f5);
      this.Leg4B.render(f5);
      this.Leg4C.render(f5);

      if (entityhorse.isUnicorned()) {
        this.Unicorn.render(f5);
      }

      if (entityhorse.getIsChested()) {
        this.Bag1.render(f5);
        this.Bag2.render(f5);
      }

      if (entityhorse.isFlyer() && type < 45) {
        this.MidWing.render(f5);
        this.InnerWing.render(f5);
        this.OuterWing.render(f5);
        this.InnerWingR.render(f5);
        this.MidWingR.render(f5);
        this.OuterWingR.render(f5);
      } else if (type > 44 && type < 60) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        float transparency = 0.7F;
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.2F, 1.2F, 1.2F, transparency);
        GL11.glScalef(1.3F, 1.0F, 1.3F);
        this.ButterflyL.render(f5);
        this.ButterflyR.render(f5);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
      }
    } else {
      float transparency;






      if (vanishingInt != 0) {

        transparency = 1.0F - vanishingInt / 100.0F;
      } else {
        transparency = entityhorse.tFloat();
      }

      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(0.8F, 0.8F, 0.8F, transparency);
      GL11.glScalef(1.3F, 1.0F, 1.3F);

      this.Ear1.render(f5);
      this.Ear2.render(f5);

      this.Neck.render(f5);
      this.Head.render(f5);
      if (openMouth) {
        this.UMouth2.render(f5);
        this.LMouth2.render(f5);
      } else {
        this.UMouth.render(f5);
        this.LMouth.render(f5);
      }

      this.Mane.render(f5);
      this.Body.render(f5);
      this.TailA.render(f5);
      this.TailB.render(f5);
      this.TailC.render(f5);

      this.Leg1A.render(f5);
      this.Leg1B.render(f5);
      this.Leg1C.render(f5);

      this.Leg2A.render(f5);
      this.Leg2B.render(f5);
      this.Leg2C.render(f5);

      this.Leg3A.render(f5);
      this.Leg3B.render(f5);
      this.Leg3C.render(f5);

      this.Leg4A.render(f5);
      this.Leg4B.render(f5);
      this.Leg4C.render(f5);

      if (type == 39 || type == 40 || type == 28) {
        this.MidWing.render(f5);
        this.InnerWing.render(f5);
        this.OuterWing.render(f5);
        this.InnerWingR.render(f5);
        this.MidWingR.render(f5);
        this.OuterWingR.render(f5);
      }
      if (type >= 50 && type < 60) {
        this.ButterflyL.render(f5);
        this.ButterflyR.render(f5);
      }

      if (saddled) {
        this.HeadSaddle.render(f5);
        this.Saddle.render(f5);
        this.SaddleB.render(f5);
        this.SaddleC.render(f5);
        this.SaddleL.render(f5);
        this.SaddleL2.render(f5);
        this.SaddleR.render(f5);
        this.SaddleR2.render(f5);
        this.SaddleMouthL.render(f5);
        this.SaddleMouthR.render(f5);
        if (rider) {
          this.SaddleMouthLine.render(f5);
          this.SaddleMouthLineR.render(f5);
        }
      }


      GL11.glDisable(3042);
      GL11.glPopMatrix();

      if (type == 21 || type == 22) {

        float wingTransparency = 0.0F;
        if (wingflapInt != 0) {
          wingTransparency = 1.0F - wingflapInt / 25.0F;
        }
        if (wingTransparency > transparency) {
          wingTransparency = transparency;
        }
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(0.8F, 0.8F, 0.8F, wingTransparency);
        GL11.glScalef(1.3F, 1.0F, 1.3F);
        this.ButterflyL.render(f5);
        this.ButterflyR.render(f5);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
      }
    }
  }


  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }


  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, boolean eating, boolean rider, boolean floating, boolean standing, boolean saddled, boolean tail, boolean wings, boolean flapwings, boolean shuffle, int type) {
    float RLegXRot = MathHelper.cos(f * 0.6662F + 3.141593F) * 0.8F * f1;
    float LLegXRot = MathHelper.cos(f * 0.6662F) * 0.8F * f1;
    float HeadXRot = f4 / 57.29578F;
    if (f3 > 20.0F) {
      f3 = 20.0F;
    }
    if (f3 < -20.0F) {
      f3 = -20.0F;
    }





    if (shuffle) {
      HeadXRot += MathHelper.cos(f2 * 0.4F) * 0.15F;
    } else if (f1 > 0.2F && !floating) {
      HeadXRot += MathHelper.cos(f * 0.4F) * 0.15F * f1;
    }

    this.Head.rotationPointY = 4.0F;
    this.Head.rotationPointZ = -10.0F;
    this.Head.rotateAngleX = 0.5235988F + HeadXRot;
    this.Head.rotateAngleY = f3 / 57.29578F;
    this.TailA.rotationPointY = 3.0F;
    this.TailB.rotationPointZ = 14.0F;
    this.Bag2.rotationPointY = 3.0F;
    this.Bag2.rotationPointZ = 10.0F;
    this.Body.rotateAngleX = 0.0F;

    if (standing && !shuffle) {

      this.Head.rotationPointY = -6.0F;
      this.Head.rotationPointZ = -1.0F;
      this.Head.rotateAngleX = 0.2617994F + HeadXRot;

      this.Head.rotateAngleY = f3 / 57.29578F;
      this.TailA.rotationPointY = 9.0F;
      this.TailB.rotationPointZ = 18.0F;
      this.Bag2.rotationPointY = 5.5F;
      this.Bag2.rotationPointZ = 15.0F;
      this.Body.rotateAngleX = -0.7853981F;
    }
    else if (eating && !shuffle) {

      this.Head.rotationPointY = 11.0F;
      this.Head.rotationPointZ = -10.0F;
      this.Head.rotateAngleX = 2.18166F;
      this.Head.rotateAngleY = 0.0F;
    }


    this.Ear1.rotationPointY = this.Head.rotationPointY;
    this.Ear2.rotationPointY = this.Head.rotationPointY;
    this.MuleEarL.rotationPointY = this.Head.rotationPointY;
    this.MuleEarR.rotationPointY = this.Head.rotationPointY;
    this.Neck.rotationPointY = this.Head.rotationPointY;
    this.UMouth.rotationPointY = this.Head.rotationPointY;
    this.UMouth2.rotationPointY = this.Head.rotationPointY;
    this.LMouth.rotationPointY = this.Head.rotationPointY;
    this.LMouth2.rotationPointY = this.Head.rotationPointY;
    this.Mane.rotationPointY = this.Head.rotationPointY;
    this.Unicorn.rotationPointY = this.Head.rotationPointY;

    this.Ear1.rotationPointZ = this.Head.rotationPointZ;
    this.Ear2.rotationPointZ = this.Head.rotationPointZ;
    this.MuleEarL.rotationPointZ = this.Head.rotationPointZ;
    this.MuleEarR.rotationPointZ = this.Head.rotationPointZ;
    this.Neck.rotationPointZ = this.Head.rotationPointZ;
    this.UMouth.rotationPointZ = this.Head.rotationPointZ;
    this.UMouth2.rotationPointZ = this.Head.rotationPointZ;
    this.LMouth.rotationPointZ = this.Head.rotationPointZ;
    this.LMouth2.rotationPointZ = this.Head.rotationPointZ;
    this.Mane.rotationPointZ = this.Head.rotationPointZ;
    this.Unicorn.rotationPointZ = this.Head.rotationPointZ;

    this.Ear1.rotateAngleX = this.Head.rotateAngleX;
    this.Ear2.rotateAngleX = this.Head.rotateAngleX;
    this.MuleEarL.rotateAngleX = this.Head.rotateAngleX;
    this.MuleEarR.rotateAngleX = this.Head.rotateAngleX;
    this.Neck.rotateAngleX = this.Head.rotateAngleX;
    this.UMouth.rotateAngleX = this.Head.rotateAngleX;
    this.Head.rotateAngleX -= 0.0872664F;
    this.LMouth.rotateAngleX = this.Head.rotateAngleX;
    this.Head.rotateAngleX += 0.261799F;
    this.Mane.rotateAngleX = this.Head.rotateAngleX;
    this.Unicorn.rotateAngleX = this.Head.rotateAngleX;

    this.Ear1.rotateAngleY = this.Head.rotateAngleY;
    this.Ear2.rotateAngleY = this.Head.rotateAngleY;
    this.MuleEarL.rotateAngleY = this.Head.rotateAngleY;
    this.MuleEarR.rotateAngleY = this.Head.rotateAngleY;
    this.Neck.rotateAngleY = this.Head.rotateAngleY;
    this.UMouth.rotateAngleY = this.Head.rotateAngleY;
    this.LMouth.rotateAngleY = this.Head.rotateAngleY;
    this.UMouth2.rotateAngleY = this.Head.rotateAngleY;
    this.LMouth2.rotateAngleY = this.Head.rotateAngleY;
    this.Mane.rotateAngleY = this.Head.rotateAngleY;
    this.Unicorn.rotateAngleY = this.Head.rotateAngleY;


    this.Bag1.rotateAngleX = RLegXRot / 5.0F;
    this.Bag2.rotateAngleX = -RLegXRot / 5.0F;

    if (wings) {
      this.InnerWing.rotateAngleX = this.Body.rotateAngleX;
      this.MidWing.rotateAngleX = this.Body.rotateAngleX;
      this.OuterWing.rotateAngleX = this.Body.rotateAngleX;
      this.InnerWingR.rotateAngleX = this.Body.rotateAngleX;
      this.MidWingR.rotateAngleX = this.Body.rotateAngleX;
      this.OuterWingR.rotateAngleX = this.Body.rotateAngleX;

      if (standing) {
        this.InnerWing.rotationPointY = -5.0F;
        this.InnerWing.rotationPointZ = 4.0F;
      } else {
        this.InnerWing.rotationPointY = 3.0F;
        this.InnerWing.rotationPointZ = -6.0F;
      }





      float WingRot = 0.0F;
      if (flapwings) {
        WingRot = MathHelper.cos(f2 * 0.3F + 3.141593F) * 1.2F;

      }
      else {

        WingRot = MathHelper.cos(f * 0.5F) * 0.1F;
      }








      if (floating) {
        this.OuterWing.rotateAngleY = -0.3228859F + WingRot / 2.0F;
        this.OuterWingR.rotateAngleY = 0.3228859F - WingRot / 2.0F;
      } else {

        WingRot = 1.0471976F;
        this.OuterWing.rotateAngleY = -1.5707963F;
        this.OuterWingR.rotateAngleY = 1.5707963F;
      }

      this.InnerWingR.rotationPointY = this.InnerWing.rotationPointY;
      this.InnerWingR.rotationPointZ = this.InnerWing.rotationPointZ;











      this.InnerWing.rotationPointX += MathHelper.cos(WingRot) * 12.0F;
      this.InnerWingR.rotationPointX -= MathHelper.cos(WingRot) * 12.0F;

      this.MidWing.rotationPointY = this.InnerWing.rotationPointY;
      this.MidWingR.rotationPointY = this.InnerWing.rotationPointY;
      this.InnerWing.rotationPointY += MathHelper.sin(WingRot) * 12.0F;
      this.InnerWingR.rotationPointY += MathHelper.sin(WingRot) * 12.0F;

      this.MidWing.rotationPointZ = this.InnerWing.rotationPointZ;
      this.MidWingR.rotationPointZ = this.InnerWing.rotationPointZ;
      this.OuterWing.rotationPointZ = this.InnerWing.rotationPointZ;
      this.OuterWingR.rotationPointZ = this.InnerWing.rotationPointZ;

      this.MidWing.rotateAngleZ = WingRot;
      this.InnerWing.rotateAngleZ = WingRot;
      this.OuterWing.rotateAngleZ = WingRot;

      this.InnerWingR.rotateAngleZ = -WingRot;
      this.MidWingR.rotateAngleZ = -WingRot;
      this.OuterWingR.rotateAngleZ = -WingRot;
    }





















    if ((type > 44 && type < 60) || type == 21) {












      float f2a = f2 % 100.0F;
      float WingRot = 0.0F;

      if (type != 21) {

        if (flapwings)
        {
          WingRot = MathHelper.cos(f2 * 0.9F) * 0.9F;



        }
        else if (floating)
        {
          WingRot = MathHelper.cos(f2 * 0.6662F) * 0.5F;
        }
        else if ((((f2a > 40.0F) ? 1 : 0) & ((f2a < 60.0F) ? 1 : 0)) != 0)
        {
          WingRot = MathHelper.cos(f2 * 0.15F) * 1.2F;


        }


      }
      else {


        WingRot = MathHelper.cos(f2 * 0.1F);
      }













      if (standing) {
        this.ButterflyL.rotationPointY = -2.5F;
        this.ButterflyL.rotationPointZ = 6.5F;
      } else {
        this.ButterflyL.rotationPointY = 3.0F;
        this.ButterflyL.rotationPointZ = -2.0F;
      }

      this.ButterflyR.rotationPointY = this.ButterflyL.rotationPointY;
      this.ButterflyR.rotationPointZ = this.ButterflyL.rotationPointZ;
      this.ButterflyL.rotateAngleX = this.Body.rotateAngleX;
      this.ButterflyR.rotateAngleX = this.Body.rotateAngleX;





      float baseAngle = 0.52359F;
      if (type == 21) {
        baseAngle = 0.0F;
      }
      this.ButterflyL.rotateAngleZ = -baseAngle + WingRot;
      this.ButterflyR.rotateAngleZ = baseAngle - WingRot;
    }






    float RLegXRotB = RLegXRot;
    float LLegXRotB = LLegXRot;
    float RLegXRotC = RLegXRot;
    float LLegXRotC = LLegXRot;

    if (floating) {
      RLegXRot = 0.2617994F;
      LLegXRot = RLegXRot;
      RLegXRotB = 0.7853981F;
      RLegXRotC = RLegXRotB;
      LLegXRotB = RLegXRotB;
      LLegXRotC = RLegXRotB;
    }

    if (standing) {
      this.Leg3A.rotationPointY = -2.0F;
      this.Leg3A.rotationPointZ = -2.0F;
      this.Leg4A.rotationPointY = this.Leg3A.rotationPointY;
      this.Leg4A.rotationPointZ = this.Leg3A.rotationPointZ;

      RLegXRot = -1.0471976F + MathHelper.cos(f2 * 0.4F + 3.141593F);
      LLegXRot = -1.0471976F + MathHelper.cos(f2 * 0.4F);

      RLegXRotB = 0.7853981F;
      LLegXRotB = RLegXRotB;

      RLegXRotC = -0.2617994F;
      LLegXRotC = 0.2617994F;

      this.Leg3A.rotationPointY += MathHelper.sin(1.5707963F + RLegXRot) * 7.0F;
      this.Leg3A.rotationPointZ += MathHelper.cos(4.712389F + RLegXRot) * 7.0F;


      this.Leg4A.rotationPointY += MathHelper.sin(1.5707963F + LLegXRot) * 7.0F;
      this.Leg4A.rotationPointZ += MathHelper.cos(4.712389F + LLegXRot) * 7.0F;

      this.Leg1A.rotationPointY += MathHelper.sin(1.5707963F + RLegXRotC) * 7.0F;
      this.Leg1A.rotationPointZ += MathHelper.cos(4.712389F + RLegXRotC) * 7.0F;


      this.Leg2B.rotationPointY = this.Leg1B.rotationPointY;
      this.Leg2B.rotationPointZ = this.Leg1B.rotationPointZ;

      this.Leg1A.rotateAngleX = RLegXRotC;
      this.Leg1B.rotateAngleX = LLegXRotC;
      this.Leg1C.rotateAngleX = this.Leg1B.rotateAngleX;

      this.Leg2A.rotateAngleX = RLegXRotC;
      this.Leg2B.rotateAngleX = LLegXRotC;
      this.Leg2C.rotateAngleX = this.Leg2B.rotateAngleX;

      this.Leg3A.rotateAngleX = RLegXRot;
      this.Leg3B.rotateAngleX = RLegXRotB;
      this.Leg3C.rotateAngleX = RLegXRotB;

      this.Leg4A.rotateAngleX = LLegXRot;
      this.Leg4B.rotateAngleX = LLegXRotB;
      this.Leg4C.rotateAngleX = LLegXRotB;

    }
    else {


      this.Leg3A.rotationPointY = 9.0F;
      this.Leg3A.rotationPointZ = -8.0F;
      this.Leg4A.rotationPointY = this.Leg3A.rotationPointY;
      this.Leg4A.rotationPointZ = this.Leg3A.rotationPointZ;

      if (!floating && f1 > 0.2F) {

        float RLegXRot2 = MathHelper.cos((f + 0.1F) * 0.6662F + 3.141593F) * 0.8F * f1;
        float LLegXRot2 = MathHelper.cos((f + 0.1F) * 0.6662F) * 0.8F * f1;
        if (RLegXRot > RLegXRot2)
        {
          RLegXRotB = RLegXRot + 0.9599311F;
        }


        if (RLegXRot < RLegXRot2)
        {
          RLegXRotC = RLegXRot + 0.2617994F;
        }


        if (LLegXRot > LLegXRot2)
        {
          LLegXRotB = LLegXRot + 0.9599311F;
        }
        if (LLegXRot < LLegXRot2)
        {
          LLegXRotC = LLegXRot + 0.2617994F;
        }
      }


      this.Leg1A.rotationPointY += MathHelper.sin(1.5707963F + LLegXRot) * 7.0F;
      this.Leg1A.rotationPointZ += MathHelper.cos(4.712389F + LLegXRot) * 7.0F;


      this.Leg2A.rotationPointY += MathHelper.sin(1.5707963F + RLegXRot) * 7.0F;
      this.Leg2A.rotationPointZ += MathHelper.cos(4.712389F + RLegXRot) * 7.0F;


      this.Leg3A.rotationPointY += MathHelper.sin(1.5707963F + RLegXRot) * 7.0F;
      this.Leg3A.rotationPointZ += MathHelper.cos(4.712389F + RLegXRot) * 7.0F;


      this.Leg4A.rotationPointY += MathHelper.sin(1.5707963F + LLegXRot) * 7.0F;
      this.Leg4A.rotationPointZ += MathHelper.cos(4.712389F + LLegXRot) * 7.0F;

      this.Leg1A.rotateAngleX = LLegXRot;
      this.Leg1B.rotateAngleX = LLegXRotC;
      this.Leg1C.rotateAngleX = LLegXRotC;

      this.Leg2A.rotateAngleX = RLegXRot;
      this.Leg2B.rotateAngleX = RLegXRotC;
      this.Leg2C.rotateAngleX = RLegXRotC;

      this.Leg3A.rotateAngleX = RLegXRot;
      this.Leg3B.rotateAngleX = RLegXRotB;
      this.Leg3C.rotateAngleX = RLegXRotB;

      this.Leg4A.rotateAngleX = LLegXRot;
      this.Leg4B.rotateAngleX = LLegXRotB;
      this.Leg4C.rotateAngleX = LLegXRotB;
    }


    if (type == 60 && shuffle) {
      this.Leg3A.rotationPointY = 9.0F;
      this.Leg3A.rotationPointZ = -8.0F;
      this.Leg4A.rotationPointY = this.Leg3A.rotationPointY;
      this.Leg4A.rotationPointZ = this.Leg3A.rotationPointZ;

      if (!floating) {



        RLegXRot = MathHelper.cos(f2 * 0.4F);
        if (RLegXRot > 0.1F) {
          RLegXRot = 0.3F;
        }

        LLegXRot = MathHelper.cos(f2 * 0.4F + 3.141593F);
        if (LLegXRot > 0.1F) {
          LLegXRot = 0.3F;
        }
      }

















      this.Leg1A.rotationPointY += MathHelper.sin(1.5707963F + LLegXRot) * 7.0F;
      this.Leg1A.rotationPointZ += MathHelper.cos(4.712389F + LLegXRot) * 7.0F;


      this.Leg2A.rotationPointY += MathHelper.sin(1.5707963F + RLegXRot) * 7.0F;
      this.Leg2A.rotationPointZ += MathHelper.cos(4.712389F + RLegXRot) * 7.0F;


      this.Leg3A.rotationPointY += MathHelper.sin(1.5707963F + LLegXRot) * 7.0F;
      this.Leg3A.rotationPointZ += MathHelper.cos(4.712389F + LLegXRot) * 7.0F;


      this.Leg4A.rotationPointY += MathHelper.sin(1.5707963F + RLegXRot) * 7.0F;
      this.Leg4A.rotationPointZ += MathHelper.cos(4.712389F + RLegXRot) * 7.0F;

      this.Leg1A.rotateAngleX = LLegXRot;
      this.Leg1B.rotateAngleX = LLegXRotB;
      this.Leg1C.rotateAngleX = LLegXRotB;

      this.Leg3A.rotateAngleX = LLegXRot;
      this.Leg3B.rotateAngleX = LLegXRotB;
      this.Leg3C.rotateAngleX = LLegXRotB;

      this.Leg2A.rotateAngleX = RLegXRot;
      this.Leg2B.rotateAngleX = RLegXRotB;
      this.Leg2C.rotateAngleX = RLegXRotB;

      this.Leg4A.rotateAngleX = RLegXRot;
      this.Leg4B.rotateAngleX = RLegXRotB;
      this.Leg4C.rotateAngleX = RLegXRotB;
    }


    this.Leg1C.rotationPointY = this.Leg1B.rotationPointY;
    this.Leg1C.rotationPointZ = this.Leg1B.rotationPointZ;
    this.Leg2C.rotationPointY = this.Leg2B.rotationPointY;
    this.Leg2C.rotationPointZ = this.Leg2B.rotationPointZ;
    this.Leg3C.rotationPointY = this.Leg3B.rotationPointY;
    this.Leg3C.rotationPointZ = this.Leg3B.rotationPointZ;
    this.Leg4C.rotationPointY = this.Leg4B.rotationPointY;
    this.Leg4C.rotationPointZ = this.Leg4B.rotationPointZ;

















    if (saddled) {

      if (standing) {
        this.Saddle.rotationPointY = 0.5F;
        this.Saddle.rotationPointZ = 11.0F;
      } else {

        this.Saddle.rotationPointY = 2.0F;
        this.Saddle.rotationPointZ = 2.0F;
      }


      this.SaddleB.rotationPointY = this.Saddle.rotationPointY;
      this.SaddleC.rotationPointY = this.Saddle.rotationPointY;
      this.SaddleL.rotationPointY = this.Saddle.rotationPointY;
      this.SaddleR.rotationPointY = this.Saddle.rotationPointY;
      this.SaddleL2.rotationPointY = this.Saddle.rotationPointY;
      this.SaddleR2.rotationPointY = this.Saddle.rotationPointY;
      this.Bag1.rotationPointY = this.Bag2.rotationPointY;

      this.SaddleB.rotationPointZ = this.Saddle.rotationPointZ;
      this.SaddleC.rotationPointZ = this.Saddle.rotationPointZ;
      this.SaddleL.rotationPointZ = this.Saddle.rotationPointZ;
      this.SaddleR.rotationPointZ = this.Saddle.rotationPointZ;
      this.SaddleL2.rotationPointZ = this.Saddle.rotationPointZ;
      this.SaddleR2.rotationPointZ = this.Saddle.rotationPointZ;
      this.Bag1.rotationPointZ = this.Bag2.rotationPointZ;

      this.Saddle.rotateAngleX = this.Body.rotateAngleX;
      this.SaddleB.rotateAngleX = this.Body.rotateAngleX;
      this.SaddleC.rotateAngleX = this.Body.rotateAngleX;

      this.SaddleMouthLine.rotationPointY = this.Head.rotationPointY;
      this.SaddleMouthLineR.rotationPointY = this.Head.rotationPointY;
      this.HeadSaddle.rotationPointY = this.Head.rotationPointY;
      this.SaddleMouthL.rotationPointY = this.Head.rotationPointY;
      this.SaddleMouthR.rotationPointY = this.Head.rotationPointY;

      this.SaddleMouthLine.rotationPointZ = this.Head.rotationPointZ;
      this.SaddleMouthLineR.rotationPointZ = this.Head.rotationPointZ;
      this.HeadSaddle.rotationPointZ = this.Head.rotationPointZ;
      this.SaddleMouthL.rotationPointZ = this.Head.rotationPointZ;
      this.SaddleMouthR.rotationPointZ = this.Head.rotationPointZ;

      this.SaddleMouthLine.rotateAngleX = HeadXRot;
      this.SaddleMouthLineR.rotateAngleX = HeadXRot;
      this.HeadSaddle.rotateAngleX = this.Head.rotateAngleX;
      this.SaddleMouthL.rotateAngleX = this.Head.rotateAngleX;
      this.SaddleMouthR.rotateAngleX = this.Head.rotateAngleX;
      this.HeadSaddle.rotateAngleY = this.Head.rotateAngleY;
      this.SaddleMouthL.rotateAngleY = this.Head.rotateAngleY;
      this.SaddleMouthLine.rotateAngleY = this.Head.rotateAngleY;
      this.SaddleMouthR.rotateAngleY = this.Head.rotateAngleY;
      this.SaddleMouthLineR.rotateAngleY = this.Head.rotateAngleY;

      if (rider) {
        this.SaddleL.rotateAngleX = -1.0471976F;
        this.SaddleL2.rotateAngleX = -1.0471976F;
        this.SaddleR.rotateAngleX = -1.0471976F;
        this.SaddleR2.rotateAngleX = -1.0471976F;

        this.SaddleL.rotateAngleZ = 0.0F;
        this.SaddleL2.rotateAngleZ = 0.0F;
        this.SaddleR.rotateAngleZ = 0.0F;
        this.SaddleR2.rotateAngleZ = 0.0F;
      } else {

        this.SaddleL.rotateAngleX = RLegXRot / 3.0F;
        this.SaddleL2.rotateAngleX = RLegXRot / 3.0F;
        this.SaddleR.rotateAngleX = RLegXRot / 3.0F;
        this.SaddleR2.rotateAngleX = RLegXRot / 3.0F;

        this.SaddleL.rotateAngleZ = RLegXRot / 5.0F;
        this.SaddleL2.rotateAngleZ = RLegXRot / 5.0F;
        this.SaddleR.rotateAngleZ = -RLegXRot / 5.0F;
        this.SaddleR2.rotateAngleZ = -RLegXRot / 5.0F;
      }
    }




    float tailMov = -1.3089F + f1 * 1.5F;
    if (tailMov > 0.0F) {
      tailMov = 0.0F;
    }

    if (tail) {
      this.TailA.rotateAngleY = MathHelper.cos(f2 * 0.7F);
      tailMov = 0.0F;
    } else {
      this.TailA.rotateAngleY = 0.0F;
    }
    this.TailB.rotateAngleY = this.TailA.rotateAngleY;
    this.TailC.rotateAngleY = this.TailA.rotateAngleY;

    this.TailB.rotationPointY = this.TailA.rotationPointY;
    this.TailC.rotationPointY = this.TailA.rotationPointY;
    this.TailB.rotationPointZ = this.TailA.rotationPointZ;
    this.TailC.rotationPointZ = this.TailA.rotationPointZ;

    this.TailA.rotateAngleX = tailMov;
    this.TailB.rotateAngleX = tailMov;
    this.TailC.rotateAngleX = -0.2618F + tailMov;
  }
}


/* Location:              C:\Users\mami\files\games\minecraft\sneakyrp\mocreatures-fix\DrZharks MoCreatures Mod-12.0.5-deobf.jar!\drzhark\mocreatures\client\model\MoCModelNewHorse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
