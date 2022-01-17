/*    */ package drzhark.mocreatures;
/*    */ 
/*    */ import drzhark.mocreatures.entity.IMoCTameable;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.gameevent.PlayerEvent;
/*    */ 
/*    */ public class MoCPlayerTracker
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
/* 12 */     EntityPlayer player = event.player;
/* 13 */     if (player.getRidingEntity() != null && player.getRidingEntity() instanceof IMoCTameable) {
/* 14 */       IMoCTameable mocEntity = (IMoCTameable)player.getRidingEntity();
/* 15 */       mocEntity.setRiderDisconnecting(true);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\mami\files\games\minecraft\sneakyrp\mocreatures-fix\DrZharks MoCreatures Mod-12.0.5-deobf.jar!\drzhark\mocreatures\MoCPlayerTracker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */