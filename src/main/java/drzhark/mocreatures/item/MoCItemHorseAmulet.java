package drzhark.mocreatures.item;

import drzhark.mocreatures.MoCPetData;
import drzhark.mocreatures.MoCTools;
import drzhark.mocreatures.MoCreatures;
import drzhark.mocreatures.entity.IMoCTameable;
import drzhark.mocreatures.entity.MoCEntityTameableAnimal;
import drzhark.mocreatures.entity.passive.MoCEntityBigCat;
import drzhark.mocreatures.entity.passive.MoCEntityHorse;
import drzhark.mocreatures.entity.passive.MoCEntityWyvern;
import drzhark.mocreatures.init.MoCItems;
import drzhark.mocreatures.init.MoCSoundEvents;
import drzhark.mocreatures.network.MoCMessageHandler;
import drzhark.mocreatures.network.message.MoCMessageAppear;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MoCItemHorseAmulet
  extends MoCItem
{
  private int ageCounter;
  private String name;
  private float health;
  private int edad;
  private int creatureType;
  private String spawnClass;
  private boolean rideable;
  private byte armor;
  private boolean adult;
  private UUID ownerUniqueId;
  private String ownerName;
  private int PetId;

  public MoCItemHorseAmulet(String name) {
    super(name);
    this.maxStackSize = 1;
    setHasSubtypes(true);
    this.ageCounter = 0;
  }


  public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand hand) {
    ItemStack stack = player.getHeldItem(hand);
    if (++this.ageCounter < 2) {
      return new ActionResult<ItemStack>(EnumActionResult.PASS, stack);
    }

    if (!worldIn.isRemote) {
      initAndReadNBT(stack);
    }

    double dist = 3.0D;
    double newPosY = player.posY;
    double newPosX = player.posX - dist * Math.cos((MoCTools.realAngle(player.rotationYaw - 90.0F) / 57.29578F));
    double newPosZ = player.posZ - dist * Math.sin((MoCTools.realAngle(player.rotationYaw - 90.0F) / 57.29578F));

    if (!player.world.isRemote) {
      try {
        MoCEntityTameableAnimal storedCreature;
        this.spawnClass = this.spawnClass.replace("mocreatures:", "").toLowerCase();
        if (this.spawnClass.equalsIgnoreCase("Wyvern")) {
          MoCEntityWyvern moCEntityWyvern = new MoCEntityWyvern(worldIn);
          moCEntityWyvern.setIsGhost(true);
                    storedCreature = (MoCEntityTameableAnimal)moCEntityWyvern;
        } else if (this.spawnClass.equalsIgnoreCase("WildHorse")) {
          MoCEntityHorse moCEntityHorse = new MoCEntityHorse(worldIn);
                    storedCreature = (MoCEntityTameableAnimal)moCEntityHorse;
        } else {
          storedCreature = (MoCEntityTameableAnimal)EntityList.createEntityByIDFromName(new ResourceLocation("mocreatures:" + this.spawnClass.toLowerCase()), worldIn);
          if (storedCreature instanceof MoCEntityBigCat) {
            ((MoCEntityBigCat)storedCreature).setIsGhost(true);
          }
        }

        storedCreature.setPosition(newPosX, newPosY, newPosZ);
        storedCreature.setType(this.creatureType);
        storedCreature.setTamed(true);
        storedCreature.setRideable(this.rideable);
        storedCreature.setEdad(this.edad);
        storedCreature.setPetName(this.name);
        storedCreature.setHealth(this.health);
        storedCreature.setAdult(this.adult);
        storedCreature.setArmorType(this.armor);
        storedCreature.setOwnerPetId(this.PetId);
        storedCreature.setOwnerId(player.getUniqueID());
        this.ownerName = player.getName();

        if (this.ownerUniqueId == null) {
          this.ownerUniqueId = player.getUniqueID();
          if (MoCreatures.instance.mapData != null) {
            MoCPetData newOwner = MoCreatures.instance.mapData.getPetData(player.getUniqueID());
            int maxCount = MoCreatures.proxy.maxTamed;
            if (MoCTools.isThisPlayerAnOP(player)) {
              maxCount = MoCreatures.proxy.maxOPTamed;
            }
            if (newOwner == null) {
              if (maxCount > 0 || !MoCreatures.proxy.enableOwnership)
              {
                MoCreatures.instance.mapData.updateOwnerPet((IMoCTameable)storedCreature);

              }
            }
            else if (newOwner.getTamedList().tagCount() < maxCount || !MoCreatures.proxy.enableOwnership) {
              MoCreatures.instance.mapData.updateOwnerPet((IMoCTameable)storedCreature);
            }

          }

        }
        else if (!this.ownerUniqueId.equals(player.getUniqueID()) && MoCreatures.instance.mapData != null) {
          MoCPetData oldOwner = MoCreatures.instance.mapData.getPetData(this.ownerUniqueId);
          MoCPetData newOwner = MoCreatures.instance.mapData.getPetData(player.getUniqueID());
          int maxCount = MoCreatures.proxy.maxTamed;
          if (MoCTools.isThisPlayerAnOP(player)) {
            maxCount = MoCreatures.proxy.maxOPTamed;
          }
          if (newOwner == null) {
            if (maxCount > 0 || !MoCreatures.proxy.enableOwnership)
            {
              MoCreatures.instance.mapData.updateOwnerPet((IMoCTameable)storedCreature);

            }
          }
          else if (newOwner.getTamedList().tagCount() < maxCount || !MoCreatures.proxy.enableOwnership) {
            MoCreatures.instance.mapData.updateOwnerPet((IMoCTameable)storedCreature);
          }


          if (oldOwner != null) {
            for (int j = 0; j < oldOwner.getTamedList().tagCount(); j++) {
              NBTTagCompound petEntry = oldOwner.getTamedList().getCompoundTagAt(j);
              if (petEntry.getInteger("PetId") == this.PetId)
              {
                oldOwner.getTamedList().removeTag(j);
              }
            }
          }
        }


        if (player.world.spawnEntity((Entity)storedCreature)) {
          MoCMessageHandler.INSTANCE.sendToAllAround((IMessage)new MoCMessageAppear(storedCreature.getEntityId()), new NetworkRegistry.TargetPoint(player.world.provider
                .getDimensionType().getId(), player.posX, player.posY, player.posZ, 64.0D));
          MoCTools.playCustomSound((Entity)storedCreature, MoCSoundEvents.ENTITY_GENERIC_MAGIC_APPEAR);

          if (storedCreature instanceof MoCEntityBigCat || storedCreature instanceof MoCEntityWyvern || this.creatureType == 21 || this.creatureType == 22) {
            player.setHeldItem(hand, new ItemStack(MoCItems.amuletghost, 1, 0));
          } else if (this.creatureType == 26 || this.creatureType == 27 || this.creatureType == 28) {
            player.setHeldItem(hand, new ItemStack(MoCItems.amuletbone, 1, 0));
          } else if (this.creatureType > 47 && this.creatureType < 60) {
            player.setHeldItem(hand, new ItemStack(MoCItems.amuletfairy, 1, 0));
          } else if (this.creatureType == 39 || this.creatureType == 40) {
            player.setHeldItem(hand, new ItemStack(MoCItems.amuletpegasus, 1, 0));
          }
          MoCPetData petData = MoCreatures.instance.mapData.getPetData(storedCreature.getOwnerId());
          if (petData != null) {
            petData.setInAmulet(storedCreature.getOwnerPetId(), false);
          }
        }
      } catch (Exception ex) {
        System.out.println("Unable to find class for entity " + this.spawnClass);
        ex.printStackTrace();
      }
    }
    this.ageCounter = 0;

    return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
  }

  public void readFromNBT(NBTTagCompound nbt) {
    this.PetId = nbt.getInteger("PetId");
    this.creatureType = nbt.getInteger("CreatureType");
    this.health = nbt.getFloat("Health");
    this.edad = nbt.getInteger("Edad");
    this.name = nbt.getString("Name");
    int spawnClassOld = nbt.getInteger("SpawnClass");
    if (spawnClassOld > 0) {
      if (spawnClassOld == 100) {
        this.spawnClass = "Wyvern";
      } else {
        this.spawnClass = "WildHorse";
      }
      nbt.removeTag("SpawnClass");
    } else {
      this.spawnClass = nbt.getString("SpawnClass");
    }
    this.rideable = nbt.getBoolean("Rideable");
    this.armor = nbt.getByte("Armor");
    this.adult = nbt.getBoolean("Adult");
    this.ownerName = nbt.getString("OwnerName");
    if (nbt.hasUniqueId("OwnerUUID")) {
      this.ownerUniqueId = nbt.getUniqueId("OwnerUUID");
    }
  }

  public void writeToNBT(NBTTagCompound nbt) {
    nbt.setInteger("PetId", this.PetId);
    nbt.setInteger("CreatureType", this.creatureType);
    nbt.setFloat("Health", this.health);
    nbt.setInteger("Edad", this.edad);
    nbt.setString("Name", this.name);
    nbt.setString("SpawnClass", this.spawnClass);
    nbt.setBoolean("Rideable", this.rideable);
    nbt.setByte("Armor", this.armor);
    nbt.setBoolean("Adult", this.adult);
    nbt.setString("OwnerName", this.ownerName);
    if (this.ownerUniqueId != null) {
      nbt.setUniqueId("OwnerUUID", this.ownerUniqueId);
    }
  }





  @SideOnly(Side.CLIENT)
  public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
    initAndReadNBT(stack);
    tooltip.add(TextFormatting.AQUA + this.spawnClass);
    if (this.name != "") {
      tooltip.add(TextFormatting.BLUE + this.name);
    }
    if (this.ownerName != "") {
      tooltip.add(TextFormatting.DARK_BLUE + "Owned by " + this.ownerName);
    }
  }

  private void initAndReadNBT(ItemStack itemstack) {
    if (itemstack.getTagCompound() == null) {
      itemstack.setTagCompound(new NBTTagCompound());
    }
    NBTTagCompound nbtcompound = itemstack.getTagCompound();
    readFromNBT(nbtcompound);
  }
}


/* Location:              C:\Users\mami\files\games\minecraft\sneakyrp\mocreatures-fix\DrZharks MoCreatures Mod-12.0.5-deobf.jar!\drzhark\mocreatures\item\MoCItemHorseAmulet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
