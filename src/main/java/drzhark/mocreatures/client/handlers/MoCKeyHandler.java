/*    */ package drzhark.mocreatures.client.handlers;
/*    */ 
/*    */ import drzhark.guiapi.GuiModScreen;
/*    */ import drzhark.guiapi.ModSettingScreen;
/*    */ import drzhark.mocreatures.client.MoCClientProxy;
/*    */ import drzhark.mocreatures.entity.IMoCEntity;
/*    */ import drzhark.mocreatures.network.MoCMessageHandler;
/*    */ import drzhark.mocreatures.network.message.MoCMessageEntityDive;
/*    */ import drzhark.mocreatures.network.message.MoCMessageEntityJump;
/*    */ import net.minecraft.client.entity.EntityPlayerSP;
/*    */ import net.minecraft.client.settings.KeyBinding;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraftforge.fml.client.FMLClientHandler;
/*    */ import net.minecraftforge.fml.client.registry.ClientRegistry;
/*    */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.gameevent.InputEvent;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import org.lwjgl.input.Keyboard;
/*    */ import org.lwjgl.input.Mouse;
/*    */ 
/*    */ public class MoCKeyHandler {
/*    */   int keyCount;
/*    */   private ModSettingScreen localScreen;
/* 24 */   static KeyBinding diveBinding = new KeyBinding("MoCreatures Dive", 44, "key.categories.movement");
/* 25 */   static KeyBinding guiBinding = new KeyBinding("MoCreatures GUI", 100, "key.categories.misc");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public MoCKeyHandler() {
/* 33 */     ClientRegistry.registerKeyBinding(diveBinding);
/* 34 */     ClientRegistry.registerKeyBinding(guiBinding);
/* 35 */     this.localScreen = MoCClientProxy.instance.MoCScreen;
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onInput(InputEvent event) {
/* 40 */     int keyPressed = Mouse.getEventButton() + -100;
/* 41 */     if (keyPressed == -101) {
/* 42 */       keyPressed = Keyboard.getEventKey();
/*    */     }
/*    */     
/* 45 */     EntityPlayerSP entityPlayerSP = MoCClientProxy.mc.player;
/* 46 */     if (entityPlayerSP == null) {
/*    */       return;
/*    */     }
/* 49 */     if ((FMLClientHandler.instance().getClient()).ingameGUI.getChatGUI().getChatOpen()) {
/*    */       return;
/*    */     }
/* 52 */     if (Keyboard.getEventKeyState() && entityPlayerSP.getRidingEntity() != null) {
/* 53 */       Keyboard.enableRepeatEvents(true);
/*    */     }
/*    */ 
/*    */     
/* 57 */     boolean kbJump = (MoCClientProxy.mc.gameSettings.keyBindJump.getKeyCode() >= 0) ? Keyboard.isKeyDown(MoCClientProxy.mc.gameSettings.keyBindJump.getKeyCode()) : ((keyPressed == MoCClientProxy.mc.gameSettings.keyBindJump.getKeyCode()));
/* 58 */     boolean kbDive = (diveBinding.getKeyCode() >= 0) ? Keyboard.isKeyDown(diveBinding.getKeyCode()) : ((keyPressed == diveBinding.getKeyCode()));
/* 59 */     boolean kbGui = (guiBinding.getKeyCode() >= 0) ? Keyboard.isKeyDown(guiBinding.getKeyCode()) : ((keyPressed == guiBinding.getKeyCode()));
/*    */ 
/*    */     
/* 62 */     if (kbGui && ((EntityPlayer)entityPlayerSP).world.isRemote) {
/* 63 */       if (MoCClientProxy.mc.inGameHasFocus && this.localScreen == null) {
/* 64 */         GuiModScreen.show(MoCClientProxy.instance.MoCScreen.theWidget);
/*    */       } else {
/* 66 */         this.localScreen = null;
/*    */       } 
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 73 */     if (kbJump && entityPlayerSP != null && entityPlayerSP.getRidingEntity() != null && entityPlayerSP.getRidingEntity() instanceof IMoCEntity) {
/*    */ 
/*    */       
/* 76 */       ((IMoCEntity)entityPlayerSP.getRidingEntity()).makeEntityJump();
/* 77 */       MoCMessageHandler.INSTANCE.sendToServer((IMessage)new MoCMessageEntityJump());
/*    */     } 
/*    */     
/* 80 */     if (kbDive && entityPlayerSP != null && entityPlayerSP.getRidingEntity() != null && entityPlayerSP.getRidingEntity() instanceof IMoCEntity) {
/*    */ 
/*    */       
/* 83 */       ((IMoCEntity)entityPlayerSP.getRidingEntity()).makeEntityDive();
/* 84 */       MoCMessageHandler.INSTANCE.sendToServer((IMessage)new MoCMessageEntityDive());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\mami\files\games\minecraft\sneakyrp\mocreatures-fix\DrZharks MoCreatures Mod-12.0.5-deobf.jar!\drzhark\mocreatures\client\handlers\MoCKeyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */