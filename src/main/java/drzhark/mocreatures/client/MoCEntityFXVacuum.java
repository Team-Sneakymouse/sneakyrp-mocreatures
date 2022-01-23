package drzhark.mocreatures.client;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MoCEntityFXVacuum
  extends Particle
{
  private final float portalParticleScale;
  private final double portalPosX;
  private final double portalPosY;
  private final double portalPosZ;

  public MoCEntityFXVacuum(World par1World, double par2, double par4, double par6, double par8, double par10, double par12, float red, float green, float blue, int partTexture) {
    super(par1World, par2, par4, par6, par8, par10, par12);

    this.particleRed = red;
    this.particleGreen = green;
    this.particleBlue = blue;

    this.motionX = par8;
    this.motionY = par10;
    this.motionZ = par12;
    this.portalPosX = this.posX = par2;
    this.portalPosY = this.posY = par4;
    this.portalPosZ = this.posZ = par6;
    this.portalParticleScale = this.particleScale = this.rand.nextFloat() * 0.2F + 0.5F;
    setParticleTextureIndex(partTexture);
    this.particleMaxAge = (int)(Math.random() * 10.0D) + 30;
  }


  public void renderParticle(BufferBuilder worldRendererIn, Entity entityIn, float partialTicks, float par3, float par4, float par5, float par6, float par7) {
    float var8 = (this.particleAge + partialTicks) / this.particleMaxAge;
    var8 = 1.0F - var8;
    var8 *= var8;
    var8 = 1.0F - var8;
    this.particleScale = this.portalParticleScale * var8;
    super.renderParticle(worldRendererIn, entityIn, partialTicks, par3, par4, par5, par6, par7);
  }


  public int getBrightnessForRender(float par1) {
    int var2 = super.getBrightnessForRender(par1);
    float var3 = this.particleAge / this.particleMaxAge;
    var3 *= var3;
    var3 *= var3;
    int var4 = var2 & 0xFF;
    int var5 = var2 >> 16 & 0xFF;
    var5 += (int)(var3 * 15.0F * 16.0F);

    if (var5 > 240) {
      var5 = 240;
    }

    return var4 | var5 << 16;
  }













  public void onUpdate() {
    this.prevPosX = this.posX;
    this.prevPosY = this.posY;
    this.prevPosZ = this.posZ;
    float var1 = this.particleAge / this.particleMaxAge;
    float var2 = var1;
    var1 = -var1 + var1 * var1 * 2.0F;
    var1 = 1.0F - var1;
    this.posX = this.portalPosX + this.motionX * var1;
    this.posY = this.portalPosY + this.motionY * var1 + (1.0F - var2);
    this.posZ = this.portalPosZ + this.motionZ * var1;

    if (this.particleAge++ >= this.particleMaxAge)
      setExpired();
  }
}


/* Location:              C:\Users\mami\files\games\minecraft\sneakyrp\mocreatures-fix\DrZharks MoCreatures Mod-12.0.5-deobf.jar!\drzhark\mocreatures\client\MoCEntityFXVacuum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
