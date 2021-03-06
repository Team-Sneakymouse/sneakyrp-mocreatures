package drzhark.mocreatures.network;

import drzhark.mocreatures.client.MoCClientProxy;
import drzhark.mocreatures.entity.IMoCEntity;
import drzhark.mocreatures.entity.IMoCTameable;
import drzhark.mocreatures.entity.monster.MoCEntityGolem;
import drzhark.mocreatures.entity.monster.MoCEntityOgre;
import drzhark.mocreatures.entity.passive.MoCEntityHorse;
import drzhark.mocreatures.network.message.MoCMessageAnimation;
import drzhark.mocreatures.network.message.MoCMessageAppear;
import drzhark.mocreatures.network.message.MoCMessageAttachedEntity;
import drzhark.mocreatures.network.message.MoCMessageEntityDive;
import drzhark.mocreatures.network.message.MoCMessageEntityJump;
import drzhark.mocreatures.network.message.MoCMessageExplode;
import drzhark.mocreatures.network.message.MoCMessageHealth;
import drzhark.mocreatures.network.message.MoCMessageHeart;
import drzhark.mocreatures.network.message.MoCMessageInstaSpawn;
import drzhark.mocreatures.network.message.MoCMessageNameGUI;
import drzhark.mocreatures.network.message.MoCMessageShuffle;
import drzhark.mocreatures.network.message.MoCMessageTwoBytes;
import drzhark.mocreatures.network.message.MoCMessageUpdatePetName;
import drzhark.mocreatures.network.message.MoCMessageVanish;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.relauncher.Side;

public class MoCMessageHandler
{
  public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("MoCreatures");

  public static void init() {
    INSTANCE.registerMessage(MoCMessageAnimation.class, MoCMessageAnimation.class, 0, Side.CLIENT);
    INSTANCE.registerMessage(MoCMessageAppear.class, MoCMessageAppear.class, 1, Side.CLIENT);
    INSTANCE.registerMessage(MoCMessageAttachedEntity.class, MoCMessageAttachedEntity.class, 2, Side.CLIENT);
    INSTANCE.registerMessage(MoCMessageEntityDive.class, MoCMessageEntityDive.class, 3, Side.SERVER);
    INSTANCE.registerMessage(MoCMessageEntityJump.class, MoCMessageEntityJump.class, 4, Side.SERVER);
    INSTANCE.registerMessage(MoCMessageExplode.class, MoCMessageExplode.class, 5, Side.CLIENT);
    INSTANCE.registerMessage(MoCMessageHealth.class, MoCMessageHealth.class, 6, Side.CLIENT);
    INSTANCE.registerMessage(MoCMessageHeart.class, MoCMessageHeart.class, 7, Side.CLIENT);
    INSTANCE.registerMessage(MoCMessageInstaSpawn.class, MoCMessageInstaSpawn.class, 8, Side.SERVER);
    INSTANCE.registerMessage(MoCMessageNameGUI.class, MoCMessageNameGUI.class, 9, Side.CLIENT);
    INSTANCE.registerMessage(MoCMessageUpdatePetName.class, MoCMessageUpdatePetName.class, 10, Side.SERVER);
    INSTANCE.registerMessage(MoCMessageShuffle.class, MoCMessageShuffle.class, 11, Side.CLIENT);
    INSTANCE.registerMessage(MoCMessageTwoBytes.class, MoCMessageTwoBytes.class, 12, Side.CLIENT);
    INSTANCE.registerMessage(MoCMessageVanish.class, MoCMessageVanish.class, 13, Side.CLIENT);
  }




  public static void handleMessage(IMessageHandler<? extends IMessage, IMessage> message, MessageContext ctx) {
    if (ctx.side == Side.CLIENT) {
      FMLCommonHandler.instance().getWorldThread(FMLCommonHandler.instance().getClientToServerNetworkManager().getNetHandler()).addScheduledTask(new ClientPacketTask(message, ctx));
    }
  }


  public static class ClientPacketTask
    implements Runnable
  {
    private IMessageHandler<? extends IMessage, IMessage> message;



    public ClientPacketTask(IMessageHandler<? extends IMessage, IMessage> message, MessageContext ctx) {
      this.message = message;
    }


    public void run() {
      if (this.message instanceof MoCMessageAnimation) {
        MoCMessageAnimation message = (MoCMessageAnimation)this.message;
        List<Entity> entList = MoCClientProxy.mc.player.world.loadedEntityList;
        for (Entity ent : entList) {
          if (ent.getEntityId() == message.entityId && ent instanceof IMoCEntity) {
            ((IMoCEntity)ent).performAnimation(message.animationType); break;
          }
        }
        return;
      }
      if (this.message instanceof MoCMessageAppear) {
        MoCMessageAppear message = (MoCMessageAppear)this.message;
        List<Entity> entList = MoCClientProxy.mc.player.world.loadedEntityList;
        for (Entity ent : entList) {
          if (ent.getEntityId() == message.entityId && ent instanceof MoCEntityHorse) {
            ((MoCEntityHorse)ent).MaterializeFX(); break;
          }
        }
        return;
      }
      if (this.message instanceof MoCMessageAttachedEntity) {
        MoCMessageAttachedEntity message = (MoCMessageAttachedEntity)this.message;
        Object var2 = MoCClientProxy.mc.player.world.getEntityByID(message.sourceEntityId);
        Entity var3 = MoCClientProxy.mc.player.world.getEntityByID(message.targetEntityId);

        if (var2 != null)
          ((Entity)var2).startRiding(var3);
        return;
      }
      if (this.message instanceof MoCMessageExplode) {
        MoCMessageExplode message = (MoCMessageExplode)this.message;
        List<Entity> entList = MoCClientProxy.mc.player.world.loadedEntityList;
        for (Entity ent : entList) {
          if (ent.getEntityId() == message.entityId && ent instanceof MoCEntityOgre) {
            ((MoCEntityOgre)ent).performDestroyBlastAttack(); break;
          }
        }
        return;
      }
      if (this.message instanceof MoCMessageHealth) {
        MoCMessageHealth message = (MoCMessageHealth)this.message;
        List<Entity> entList = MoCClientProxy.mc.player.world.loadedEntityList;
        for (Entity ent : entList) {
          if (ent.getEntityId() == message.entityId && ent instanceof EntityLiving) {
            ((EntityLiving)ent).setHealth(message.health); break;
          }
        }
        return;
      }
      if (this.message instanceof MoCMessageHeart) {
        MoCMessageHeart message = (MoCMessageHeart)this.message;
        Entity entity = null;
        while (entity == null) {
          entity = MoCClientProxy.mc.player.world.getEntityByID(message.entityId);
          if (entity != null &&
            entity instanceof IMoCTameable) {
            ((IMoCTameable)entity).spawnHeart();
          }
        }
        return;
      }
      if (this.message instanceof MoCMessageShuffle) {
        MoCMessageShuffle message = (MoCMessageShuffle)this.message;
        List<Entity> entList = MoCClientProxy.mc.player.world.loadedEntityList;
        for (Entity ent : entList) {
          if (ent.getEntityId() == message.entityId && ent instanceof MoCEntityHorse) {
            if (message.flag) {
              break;
            }
            ((MoCEntityHorse)ent).shuffleCounter = 0;
            break;
          }
        }
        return;
      }
      if (this.message instanceof MoCMessageTwoBytes) {
        MoCMessageTwoBytes message = (MoCMessageTwoBytes)this.message;
        Entity ent = MoCClientProxy.mc.player.world.getEntityByID(message.entityId);
        if (ent != null && ent instanceof MoCEntityGolem)
          ((MoCEntityGolem)ent).saveGolemCube(message.slot, message.value);
        return;
      }
      if (this.message instanceof MoCMessageVanish) {
        MoCMessageVanish message = (MoCMessageVanish)this.message;
        List<Entity> entList = MoCClientProxy.mc.player.world.loadedEntityList;
        for (Entity ent : entList) {
          if (ent.getEntityId() == message.entityId && ent instanceof MoCEntityHorse) {
            ((MoCEntityHorse)ent).setVanishC((byte)1); break;
          }
        }
        return;
      }
    }
  }
}


/* Location:              C:\Users\mami\files\games\minecraft\sneakyrp\mocreatures-fix\DrZharks MoCreatures Mod-12.0.5-deobf.jar!\drzhark\mocreatures\network\MoCMessageHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
