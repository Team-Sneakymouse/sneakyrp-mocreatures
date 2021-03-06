package drzhark.mocreatures.entity.monster;

import drzhark.mocreatures.MoCreatures;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class MoCEntityCaveOgre
  extends MoCEntityOgre {
  public MoCEntityCaveOgre(World world) {
    super(world);
  }


  public ResourceLocation getTexture() {
    return MoCreatures.proxy.getTexture("ogreblue.png");
  }






  public float getDestroyForce() {
    return MoCreatures.proxy.caveOgreStrength;
  }


  protected boolean isHarmedByDaylight() {
    return true;
  }


  // public boolean getCanSpawnHere() {
  //   return (!this.world.canBlockSeeSky(new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.posY),
  //         MathHelper.floor(this.posZ))) && this.posY < 50.0D && super.getCanSpawnHere());
  // }


  public float calculateMaxHealth() {
    return 50.0F;
  }


  protected Item getDropItem() {
    return Items.DIAMOND;
  }
}


/* Location:              C:\Users\mami\files\games\minecraft\sneakyrp\mocreatures-fix\DrZharks MoCreatures Mod-12.0.5-deobf.jar!\drzhark\mocreatures\entity\monster\MoCEntityCaveOgre.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
