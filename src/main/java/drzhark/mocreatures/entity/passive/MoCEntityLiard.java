package drzhark.mocreatures.entity.passive;

import drzhark.mocreatures.MoCreatures;
import drzhark.mocreatures.entity.IMoCTameable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class MoCEntityLiard
  extends MoCEntityBigCat {
  public MoCEntityLiard(World world) {
    super(world);
  }


  public void selectType() {
    if (getType() == 0) {
      setType(1);
    }
    super.selectType();
  }


  public ResourceLocation getTexture() {
    return MoCreatures.proxy.getTexture("bcliard.png");
  }


  public boolean processInteract(EntityPlayer player, EnumHand hand) {
    Boolean tameResult = processTameInteract(player, hand);
    if (tameResult != null) {
      return tameResult.booleanValue();
    }

    if (getIsRideable() && getIsAdult() && (!getIsChested() || !player.isSneaking()) && !isBeingRidden()) {
      if (!this.world.isRemote && player.startRiding((Entity)this)) {
        player.rotationYaw = this.rotationYaw;
        player.rotationPitch = this.rotationPitch;
        setSitting(false);
      }

      return true;
    }

    return super.processInteract(player, hand);
  }


  public String getOffspringClazz(IMoCTameable mate) {
    return "Liard";
  }


  public int getOffspringTypeInt(IMoCTameable mate) {
    return 1;
  }


  public boolean compatibleMate(Entity mate) {
    return false;
  }


  public float calculateMaxHealth() {
    return 30.0F;
  }


  public double calculateAttackDmg() {
    return 6.0D;
  }


  public double getAttackRange() {
    return 8.0D;
  }


  public int getMaxEdad() {
    return 100;
  }


  public boolean canAttackTarget(EntityLivingBase entity) {
    if (!getIsAdult() && getEdad() < getMaxEdad() * 0.8D) {
      return false;
    }
    if (entity instanceof MoCEntityLiard) {
      return false;
    }
    return (entity.height < 2.0F && entity.width < 2.0F);
  }
}


/* Location:              C:\Users\mami\files\games\minecraft\sneakyrp\mocreatures-fix\DrZharks MoCreatures Mod-12.0.5-deobf.jar!\drzhark\mocreatures\entity\passive\MoCEntityLiard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
