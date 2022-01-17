/*    */ package drzhark.mocreatures.entity.aquatic;
/*    */ 
/*    */ import drzhark.mocreatures.MoCreatures;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MoCEntityAngler
/*    */   extends MoCEntitySmallFish {
/*    */   public MoCEntityAngler(World world) {
/* 10 */     super(world);
/* 11 */     setType(3);
/*    */   }
/*    */ 
/*    */   
/*    */   public ResourceLocation getTexture() {
/* 16 */     return MoCreatures.proxy.getTexture("smallfish_angler.png");
/*    */   }
/*    */ 
/*    */   
/*    */   protected int getEggNumber() {
/* 21 */     return 82;
/*    */   }
/*    */ }


/* Location:              C:\Users\mami\files\games\minecraft\sneakyrp\mocreatures-fix\DrZharks MoCreatures Mod-12.0.5-deobf.jar!\drzhark\mocreatures\entity\aquatic\MoCEntityAngler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */