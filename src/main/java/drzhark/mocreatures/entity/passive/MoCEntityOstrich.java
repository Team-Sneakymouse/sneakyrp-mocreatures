package drzhark.mocreatures.entity.passive;

import drzhark.mocreatures.MoCTools;
import drzhark.mocreatures.MoCreatures;
import drzhark.mocreatures.entity.MoCEntityAnimal;
import drzhark.mocreatures.entity.MoCEntityTameableAnimal;
import drzhark.mocreatures.entity.ai.EntityAIFollowAdult;
import drzhark.mocreatures.entity.ai.EntityAIWanderMoC2;
import drzhark.mocreatures.entity.item.MoCEntityEgg;
import drzhark.mocreatures.init.MoCItems;
import drzhark.mocreatures.init.MoCSoundEvents;
import drzhark.mocreatures.inventory.MoCAnimalChest;
import drzhark.mocreatures.network.MoCMessageHandler;
import drzhark.mocreatures.network.message.MoCMessageAnimation;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MoCEntityOstrich
  extends MoCEntityTameableAnimal {
  private int eggCounter;
  private int hidingCounter;
  public int mouthCounter;
  public int wingCounter;
  public int sprintCounter;
  private static final DataParameter<Boolean> RIDEABLE = EntityDataManager.createKey(MoCEntityOstrich.class, DataSerializers.BOOLEAN); public int jumpCounter; public int transformCounter; public int transformType; public boolean canLayEggs; public MoCAnimalChest localchest; public ItemStack localstack;
  private static final DataParameter<Boolean> EGG_WATCH = EntityDataManager.createKey(MoCEntityOstrich.class, DataSerializers.BOOLEAN);
  private static final DataParameter<Boolean> CHESTED = EntityDataManager.createKey(MoCEntityOstrich.class, DataSerializers.BOOLEAN);
  private static final DataParameter<Boolean> IS_HIDING = EntityDataManager.createKey(MoCEntityOstrich.class, DataSerializers.BOOLEAN);
  private static final DataParameter<Integer> HELMET_TYPE = EntityDataManager.createKey(MoCEntityOstrich.class, DataSerializers.VARINT);
  private static final DataParameter<Integer> FLAG_COLOR = EntityDataManager.createKey(MoCEntityOstrich.class, DataSerializers.VARINT);


  public MoCEntityOstrich(World world) {
    super(world);
    setSize(1.0F, 1.6F);
    setEdad(35);
    this.eggCounter = this.rand.nextInt(1000) + 1000;
    this.stepHeight = 1.0F;
    this.canLayEggs = false;
  }


  protected void initEntityAI() {
    this.tasks.addTask(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
    this.tasks.addTask(4, (EntityAIBase)new EntityAIFollowAdult((EntityLiving)this, 1.0D));
    this.tasks.addTask(5, (EntityAIBase)new EntityAIAttackMelee((EntityCreature)this, 1.0D, true));
    this.tasks.addTask(6, (EntityAIBase)new EntityAIWanderMoC2((EntityCreature)this, 1.0D));
    this.tasks.addTask(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 8.0F));
  }


  protected void applyEntityAttributes() {
    super.applyEntityAttributes();
    getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
    getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
    getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
  }


  protected void entityInit() {
    super.entityInit();
    this.dataManager.register(EGG_WATCH, Boolean.valueOf(false));
    this.dataManager.register(CHESTED, Boolean.valueOf(false));
    this.dataManager.register(RIDEABLE, Boolean.valueOf(false));
    this.dataManager.register(IS_HIDING, Boolean.valueOf(false));
    this.dataManager.register(HELMET_TYPE, Integer.valueOf(0));
    this.dataManager.register(FLAG_COLOR, Integer.valueOf(0));
  }


  public boolean getIsRideable() {
    return ((Boolean)this.dataManager.get(RIDEABLE)).booleanValue();
  }


  public void setRideable(boolean flag) {
    this.dataManager.set(RIDEABLE, Boolean.valueOf(flag));
  }

  public boolean getEggWatching() {
    return ((Boolean)this.dataManager.get(EGG_WATCH)).booleanValue();
  }

  public void setEggWatching(boolean flag) {
    this.dataManager.set(EGG_WATCH, Boolean.valueOf(flag));
  }

  public boolean getHiding() {
    return ((Boolean)this.dataManager.get(IS_HIDING)).booleanValue();
  }

  public void setHiding(boolean flag) {
    this.dataManager.set(IS_HIDING, Boolean.valueOf(flag));
  }

  public int getHelmet() {
    return ((Integer)this.dataManager.get(HELMET_TYPE)).intValue();
  }

  public void setHelmet(int i) {
    this.dataManager.set(HELMET_TYPE, Integer.valueOf(i));
  }

  public int getFlagColor() {
    return ((Integer)this.dataManager.get(FLAG_COLOR)).intValue();
  }

  public void setFlagColor(int i) {
    this.dataManager.set(FLAG_COLOR, Integer.valueOf(i));
  }

  public boolean getIsChested() {
    return ((Boolean)this.dataManager.get(CHESTED)).booleanValue();
  }

  public void setIsChested(boolean flag) {
    this.dataManager.set(CHESTED, Boolean.valueOf(flag));
  }


  public boolean isMovementCeased() {
    return (getHiding() || isBeingRidden());
  }


  public boolean isNotScared() {
    return ((getType() == 2 && getAttackTarget() != null) || getType() > 2);
  }



  public boolean attackEntityFrom(DamageSource damagesource, float i) {
    if (getIsTamed() && getHelmet() != 0) {
      int j = 0;
      switch (getHelmet()) {
        case 1:
          j = 1;
          break;
        case 2:
        case 5:
        case 6:
          j = 2;
          break;
        case 3:
        case 7:
          j = 3;
          break;
        case 4:
        case 9:
        case 10:
        case 11:
        case 12:
          j = 4;
          break;
      }
      i -= j;
      if (i <= 0.0F) {
        i = 1.0F;
      }
    }

    if (super.attackEntityFrom(damagesource, i)) {
      Entity entity = damagesource.getTrueSource();

      if (!(entity instanceof EntityLivingBase) || (isBeingRidden() && entity == getRidingEntity()) || (entity instanceof EntityPlayer &&
        getIsTamed())) {
        return false;
      }

      if (entity != this && shouldAttackPlayers() && getType() > 2) {
        setAttackTarget((EntityLivingBase)entity);
        flapWings();
      }
      return true;
    }
    return false;
  }



  public void onDeath(DamageSource damagesource) {
    super.onDeath(damagesource);
    dropMyStuff();
  }


  public boolean attackEntityAsMob(Entity entityIn) {
    if (entityIn instanceof EntityPlayer && !shouldAttackPlayers()) {
      return false;
    }
    openMouth();
    flapWings();
    return super.attackEntityAsMob(entityIn);
  }

  public float calculateMaxHealth() {
    switch (getType()) {
      case 1:
        return 10.0F;
      case 2:
        return 20.0F;
      case 3:
        return 25.0F;
      case 4:
        return 25.0F;
      case 5:
        return 35.0F;
      case 6:
        return 35.0F;
    }
    return 20.0F;
  }



  public boolean canBeCollidedWith() {
    return !isBeingRidden();
  }


  public void selectType() {
    if (getType() == 0) {



      int j = this.rand.nextInt(100);
      if (j <= 20) {
        setType(1);
      } else if (j <= 65) {
        setType(2);
      } else if (j <= 95) {
        setType(3);
      } else {
        setType(4);
      }
    }
    getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(calculateMaxHealth());
    setHealth(getMaxHealth());
  }


  public ResourceLocation getTexture() {
    if (this.transformCounter != 0 && this.transformType > 4) {
      String newText = "ostricha.png";
      if (this.transformType == 5) {
        newText = "ostriche.png";
      }
      if (this.transformType == 6) {
        newText = "ostrichf.png";
      }
      if (this.transformType == 7) {
        newText = "ostrichg.png";
      }
      if (this.transformType == 8) {
        newText = "ostrichh.png";
      }

      if (this.transformCounter % 5 == 0) {
        return MoCreatures.proxy.getTexture(newText);
      }
      if (this.transformCounter > 50 && this.transformCounter % 3 == 0) {
        return MoCreatures.proxy.getTexture(newText);
      }

      if (this.transformCounter > 75 && this.transformCounter % 4 == 0) {
        return MoCreatures.proxy.getTexture(newText);
      }
    }

    switch (getType()) {
      case 1:
        return MoCreatures.proxy.getTexture("ostrichc.png");
      case 2:
        return MoCreatures.proxy.getTexture("ostrichb.png");
      case 3:
        return MoCreatures.proxy.getTexture("ostricha.png");
      case 4:
        return MoCreatures.proxy.getTexture("ostrichd.png");
      case 5:
        return MoCreatures.proxy.getTexture("ostriche.png");
      case 6:
        return MoCreatures.proxy.getTexture("ostrichf.png");
      case 7:
        return MoCreatures.proxy.getTexture("ostrichg.png");
      case 8:
        return MoCreatures.proxy.getTexture("ostrichh.png");
    }
    return MoCreatures.proxy.getTexture("ostricha.png");
  }



  public double getCustomSpeed() {
    double OstrichSpeed = 0.8D;
    if (getType() == 1) {
      OstrichSpeed = 0.8D;
    } else if (getType() == 2) {
      OstrichSpeed = 0.8D;
    } else if (getType() == 3) {
      OstrichSpeed = 1.1D;
    } else if (getType() == 4) {
      OstrichSpeed = 1.3D;
    } else if (getType() == 5) {
      OstrichSpeed = 1.4D;
      this.isImmuneToFire = true;
    }
    if (this.sprintCounter > 0 && this.sprintCounter < 200) {
      OstrichSpeed *= 1.5D;
    }
    if (this.sprintCounter > 200) {
      OstrichSpeed *= 0.5D;
    }
    return OstrichSpeed;
  }


  public boolean rideableEntity() {
    return true;
  }


  public void onUpdate() {
    super.onUpdate();

    if (getHiding()) {
      this.prevRenderYawOffset = this.renderYawOffset = this.rotationYaw = this.prevRotationYaw;
    }

    if (this.mouthCounter > 0 && ++this.mouthCounter > 20) {
      this.mouthCounter = 0;
    }

    if (this.wingCounter > 0 && ++this.wingCounter > 80) {
      this.wingCounter = 0;
    }

    if (this.jumpCounter > 0 && ++this.jumpCounter > 8) {
      this.jumpCounter = 0;
    }

    if (this.sprintCounter > 0 && ++this.sprintCounter > 300) {
      this.sprintCounter = 0;
    }

    if (this.transformCounter > 0) {
      if (this.transformCounter == 40) {
        MoCTools.playCustomSound((Entity)this, MoCSoundEvents.ENTITY_GENERIC_TRANSFORM);
      }

      if (++this.transformCounter > 100) {
        this.transformCounter = 0;
        if (this.transformType != 0) {
          dropArmor();
          setType(this.transformType);
          selectType();
        }
      }
    }
  }

  public void transform(int tType) {
    if (!this.world.isRemote) {
      MoCMessageHandler.INSTANCE.sendToAllAround((IMessage)new MoCMessageAnimation(getEntityId(), tType), new NetworkRegistry.TargetPoint(this.world.provider
            .getDimensionType().getId(), this.posX, this.posY, this.posZ, 64.0D));
    }
    this.transformType = tType;
    if (!isBeingRidden() && this.transformType != 0) {
      dropArmor();
      this.transformCounter = 1;
    }
  }


  public void performAnimation(int animationType) {
    if (animationType >= 5 && animationType < 9) {

      this.transformType = animationType;
      this.transformCounter = 1;
    }
  }



  public void onLivingUpdate() {
    super.onLivingUpdate();

    if (getIsTamed() && !this.world.isRemote && this.rand.nextInt(300) == 0 && getHealth() <= getMaxHealth() && this.deathTime == 0) {
      setHealth(getHealth() + 1.0F);
    }

    if (!this.world.isRemote) {

      if (getType() == 8 && this.sprintCounter > 0 && this.sprintCounter < 150 && isBeingRidden() && this.rand.nextInt(15) == 0) {
        MoCTools.buckleMobs((EntityLiving)this, Double.valueOf(2.0D), this.world);
      }








      if (getHiding())
      {

        if (++this.hidingCounter > 500 && !getIsTamed()) {
          setHiding(false);
          this.hidingCounter = 0;
        }
      }


      if (getType() == 1 && this.rand.nextInt(200) == 0) {

        setEdad(getEdad() + 1);
        if (getEdad() >= 100) {
          setAdult(true);
          setType(0);
          selectType();
        }
      }


      if (this.canLayEggs && getType() == 2 && !getEggWatching() && --this.eggCounter <= 0 && this.rand.nextInt(5) == 0) {

        EntityPlayer entityplayer1 = this.world.getClosestPlayerToEntity((Entity)this, 12.0D);
        if (entityplayer1 != null) {
          double distP = MoCTools.getSqDistanceTo((Entity)entityplayer1, this.posX, this.posY, this.posZ);
          if (distP < 10.0D) {
            int OstrichEggType = 30;
            MoCEntityOstrich maleOstrich = getClosestMaleOstrich((Entity)this, 8.0D);
            if (maleOstrich != null && this.rand.nextInt(100) < MoCreatures.proxy.ostrichEggDropChance) {
              MoCEntityEgg entityegg = new MoCEntityEgg(this.world, OstrichEggType);
              entityegg.setPosition(this.posX, this.posY, this.posZ);
              this.world.spawnEntity((Entity)entityegg);

              if (!getIsTamed()) {
                setEggWatching(true);
                if (maleOstrich != null) {
                  maleOstrich.setEggWatching(true);
                }
                openMouth();
              }


              MoCTools.playCustomSound((Entity)this, SoundEvents.ENTITY_CHICKEN_EGG);


              this.eggCounter = this.rand.nextInt(2000) + 2000;
              this.canLayEggs = false;
            }
          }
        }
      }


      if (getEggWatching()) {

        MoCEntityEgg myEgg = (MoCEntityEgg)getBoogey(8.0D);
        if (myEgg != null && MoCTools.getSqDistanceTo((Entity)myEgg, this.posX, this.posY, this.posZ) > 4.0D) {
          Path pathentity = this.navigator.getPathToPos(myEgg.getPosition());
          this.navigator.setPath(pathentity, 16.0D);
        }
        if (myEgg == null) {

          setEggWatching(false);

          EntityPlayer eggStealer = this.world.getClosestPlayerToEntity((Entity)this, 10.0D);
          if (eggStealer != null) {
            this.world.getDifficulty();
            if (!getIsTamed() && this.world.getDifficulty() != EnumDifficulty.PEACEFUL) {
              setAttackTarget((EntityLivingBase)eggStealer);
              flapWings();
            }
          }
        }
      }
    }
  }

  protected MoCEntityOstrich getClosestMaleOstrich(Entity entity, double d) {
    double d1 = -1.0D;
    MoCEntityOstrich entityliving = null;
    List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(entity, entity.getEntityBoundingBox().expand(d, d, d));
    for (int i = 0; i < list.size(); i++) {
      Entity entity1 = list.get(i);
      if (entity1 instanceof MoCEntityOstrich && (!(entity1 instanceof MoCEntityOstrich) || ((MoCEntityOstrich)entity1).getType() >= 3)) {



        double d2 = entity1.getDistanceSq(entity.posX, entity.posY, entity.posZ);
        if ((d < 0.0D || d2 < d * d) && (d1 == -1.0D || d2 < d1)) {
          d1 = d2;
          entityliving = (MoCEntityOstrich)entity1;
        }
      }
    }
    return entityliving;
  }


  public boolean entitiesToInclude(Entity entity) {
    return (entity instanceof MoCEntityEgg && ((MoCEntityEgg)entity).eggType == 30);
  }




  public boolean processInteract(EntityPlayer player, EnumHand hand) {
    Boolean tameResult = processTameInteract(player, hand);
    if (tameResult != null) {
      return tameResult.booleanValue();
    }

    ItemStack stack = player.getHeldItem(hand);
    if (getIsTamed() && getType() > 1 && !stack.isEmpty() && !getIsRideable() && (stack
      .getItem() == MoCItems.horsesaddle || stack.getItem() == Items.SADDLE)) {
      stack.shrink(1);
      if (stack.isEmpty()) {
        player.setHeldItem(hand, ItemStack.EMPTY);
      }
      MoCTools.playCustomSound((Entity)this, SoundEvents.ENTITY_CHICKEN_EGG);
      setRideable(true);
      return true;
    }

    if (!getIsTamed() && !stack.isEmpty() && getType() == 2 && stack.getItem() == Items.MELON_SEEDS) {
      stack.shrink(1);
      if (stack.isEmpty()) {
        player.setHeldItem(hand, ItemStack.EMPTY);
      }

      openMouth();
      MoCTools.playCustomSound((Entity)this, MoCSoundEvents.ENTITY_GENERIC_EATING);
      this.canLayEggs = true;
      return true;
    }


    if (!stack.isEmpty() && stack.getItem() == MoCItems.whip && getIsTamed() && !isBeingRidden()) {
      setHiding(!getHiding());
      return true;
    }

    if (!stack.isEmpty() && getIsTamed() && getType() > 1 && stack.getItem() == MoCItems.essencedarkness) {
      stack.shrink(1);
      if (stack.isEmpty()) {
        player.setHeldItem(hand, new ItemStack(Items.GLASS_BOTTLE));
      } else {
        player.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
      }
      if (getType() == 6) {
        setHealth(getMaxHealth());
      } else {
        transform(6);
      }
      MoCTools.playCustomSound((Entity)this, MoCSoundEvents.ENTITY_GENERIC_DRINKING);
      return true;
    }

    if (!stack.isEmpty() && getIsTamed() && getType() > 1 && stack.getItem() == MoCItems.essenceundead) {
      stack.shrink(1);
      if (stack.isEmpty()) {
        player.setHeldItem(hand, new ItemStack(Items.GLASS_BOTTLE));
      } else {
        player.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
      }
      if (getType() == 7) {
        setHealth(getMaxHealth());
      } else {
        transform(7);
      }
      MoCTools.playCustomSound((Entity)this, MoCSoundEvents.ENTITY_GENERIC_DRINKING);
      return true;
    }

    if (!stack.isEmpty() && getIsTamed() && getType() > 1 && stack.getItem() == MoCItems.essencelight) {
      stack.shrink(1);
      if (stack.isEmpty()) {
        player.setHeldItem(hand, new ItemStack(Items.GLASS_BOTTLE));
      } else {
        player.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
      }
      if (getType() == 8) {
        setHealth(getMaxHealth());
      } else {
        transform(8);
      }
      MoCTools.playCustomSound((Entity)this, MoCSoundEvents.ENTITY_GENERIC_DRINKING);
      return true;
    }

    if (!stack.isEmpty() && getIsTamed() && getType() > 1 && stack.getItem() == MoCItems.essencefire) {
      stack.shrink(1);
      if (stack.isEmpty()) {
        player.setHeldItem(hand, new ItemStack(Items.GLASS_BOTTLE));
      } else {
        player.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
      }
      if (getType() == 5) {
        setHealth(getMaxHealth());
      } else {
        transform(5);
      }
      MoCTools.playCustomSound((Entity)this, MoCSoundEvents.ENTITY_GENERIC_DRINKING);
      return true;
    }
    if (getIsTamed() && getIsChested() && getType() > 1 && !stack.isEmpty() && stack.getItem() == Item.getItemFromBlock(Blocks.WOOL)) {
      int colorInt = stack.getItemDamage();
      if (colorInt == 0) {
        colorInt = 16;
      }
      stack.shrink(1);
      if (stack.isEmpty()) {
        player.setHeldItem(hand, ItemStack.EMPTY);
      }
      MoCTools.playCustomSound((Entity)this, SoundEvents.ENTITY_CHICKEN_EGG);
      dropFlag();
      setFlagColor((byte)colorInt);
      return true;
    }

    if (!stack.isEmpty() && getType() > 1 && getIsTamed() && !getIsChested() && stack.getItem() == Item.getItemFromBlock((Block)Blocks.CHEST)) {
      stack.shrink(1);
      if (stack.isEmpty()) {
        player.setHeldItem(hand, ItemStack.EMPTY);
      }


      setIsChested(true);
      MoCTools.playCustomSound((Entity)this, SoundEvents.ENTITY_CHICKEN_EGG);
      return true;
    }

    if (player.isSneaking() && getIsChested()) {

      if (this.localchest == null) {
        this.localchest = new MoCAnimalChest("OstrichChest", 9);
      }
      if (!this.world.isRemote) {
        player.displayGUIChest((IInventory)this.localchest);
      }
      return true;
    }

    if (getIsTamed() && getType() > 1 && !stack.isEmpty()) {

      Item item = stack.getItem();
      if (item instanceof ItemArmor && ((ItemArmor)item).armorType == EntityEquipmentSlot.HEAD) {
        ItemArmor itemArmor = (ItemArmor)stack.getItem();
        byte helmetType = 0;
        if (stack.getItem() == Items.LEATHER_HELMET) {
          helmetType = 1;
        } else if (stack.getItem() == Items.IRON_HELMET) {
          helmetType = 2;
        } else if (stack.getItem() == Items.GOLDEN_HELMET) {
          helmetType = 3;
        } else if (stack.getItem() == Items.DIAMOND_HELMET) {
          helmetType = 4;
        } else if (stack.getItem() == MoCItems.helmetHide) {
          helmetType = 5;
        } else if (stack.getItem() == MoCItems.helmetFur) {
          helmetType = 6;
        } else if (stack.getItem() == MoCItems.helmetCroc) {
          helmetType = 7;
        } else if (stack.getItem() == MoCItems.scorpHelmetDirt) {
          helmetType = 9;
        } else if (stack.getItem() == MoCItems.scorpHelmetFrost) {
          helmetType = 10;
        } else if (stack.getItem() == MoCItems.scorpHelmetCave) {
          helmetType = 11;
        } else if (stack.getItem() == MoCItems.scorpHelmetNether) {
          helmetType = 12;
        }

        if (helmetType != 0) {
          player.setHeldItem(hand, ItemStack.EMPTY);
          dropArmor();
          setItemStackToSlot(itemArmor.armorType, stack);
          MoCTools.playCustomSound((Entity)this, MoCSoundEvents.ENTITY_GENERIC_ARMOR_OFF);
          setHelmet(helmetType);
          return true;
        }
      }
    }
    if (getIsRideable() && getIsAdult() && (!getIsChested() || !player.isSneaking()) && !isBeingRidden()) {
      if (!this.world.isRemote && player.startRiding((Entity)this)) {
        player.rotationYaw = this.rotationYaw;
        player.rotationPitch = this.rotationPitch;
        setHiding(false);
      }

      return true;
    }

    return super.processInteract(player, hand);
  }




  private void dropFlag() {
    if (!this.world.isRemote && getFlagColor() != 0) {
      int color = getFlagColor();
      if (color == 16) {
        color = 0;
      }
      EntityItem entityitem = new EntityItem(this.world, this.posX, this.posY, this.posZ, new ItemStack(Blocks.WOOL, 1, color));
      entityitem.setPickupDelay(10);
      this.world.spawnEntity((Entity)entityitem);
      setFlagColor(0);
    }
  }

  private void openMouth() {
    this.mouthCounter = 1;
  }

  private void flapWings() {
    this.wingCounter = 1;
  }


  protected SoundEvent getHurtSound(DamageSource source) {
    openMouth();
    return MoCSoundEvents.ENTITY_OSTRICH_HURT;
  }


  protected SoundEvent getAmbientSound() {
    openMouth();
    if (getType() == 1) {
      return MoCSoundEvents.ENTITY_OSTRICH_AMBIENT_BABY;
    }

    return MoCSoundEvents.ENTITY_OSTRICH_AMBIENT;
  }


  protected SoundEvent getDeathSound() {
    openMouth();
    return MoCSoundEvents.ENTITY_OSTRICH_DEATH;
  }


  protected Item getDropItem() {
    boolean flag = (this.rand.nextInt(100) < MoCreatures.proxy.rareItemDropChance);
    if (flag && getType() == 8)
    {
      return (Item)MoCItems.unicornhorn;
    }
    if (getType() == 5 && flag) {
      return (Item)MoCItems.heartfire;
    }
    if (getType() == 6 && flag)
    {
      return (Item)MoCItems.heartdarkness;
    }
    if (getType() == 7) {
      if (flag) {
        return (Item)MoCItems.heartundead;
      }
      return Items.ROTTEN_FLESH;
    }
    return (Item)MoCItems.ostrichraw;
  }


  public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
    super.readEntityFromNBT(nbttagcompound);
    setRideable(nbttagcompound.getBoolean("Saddle"));
    setEggWatching(nbttagcompound.getBoolean("EggWatch"));
    setHiding(nbttagcompound.getBoolean("Hiding"));
    setHelmet(nbttagcompound.getInteger("Helmet"));
    setFlagColor(nbttagcompound.getInteger("FlagColor"));
    setIsChested(nbttagcompound.getBoolean("Bagged"));
    if (getIsChested()) {
      NBTTagList nbttaglist = nbttagcompound.getTagList("Items", 10);
      this.localchest = new MoCAnimalChest("OstrichChest", 18);
      for (int i = 0; i < nbttaglist.tagCount(); i++) {
        NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
        int j = nbttagcompound1.getByte("Slot") & 0xFF;
        if (j >= 0 && j < this.localchest.getSizeInventory()) {
          this.localchest.setInventorySlotContents(j, new ItemStack(nbttagcompound1));
        }
      }
    }
  }


  public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
    super.writeEntityToNBT(nbttagcompound);
    nbttagcompound.setBoolean("Saddle", getIsRideable());
    nbttagcompound.setBoolean("EggWatch", getEggWatching());
    nbttagcompound.setBoolean("Hiding", getHiding());
    nbttagcompound.setInteger("Helmet", getHelmet());
    nbttagcompound.setInteger("FlagColor", getFlagColor());
    nbttagcompound.setBoolean("Bagged", getIsChested());

    if (getIsChested() && this.localchest != null) {
      NBTTagList nbttaglist = new NBTTagList();
      for (int i = 0; i < this.localchest.getSizeInventory(); i++) {
        this.localstack = this.localchest.getStackInSlot(i);
        if (this.localstack != null && !this.localstack.isEmpty()) {
          NBTTagCompound nbttagcompound1 = new NBTTagCompound();
          nbttagcompound1.setByte("Slot", (byte)i);
          this.localstack.writeToNBT(nbttagcompound1);
          nbttaglist.appendTag((NBTBase)nbttagcompound1);
        }
      }
      nbttagcompound.setTag("Items", (NBTBase)nbttaglist);
    }
  }



  // public boolean getCanSpawnHere() {
  //   return (getCanSpawnHereCreature() && getCanSpawnHereLiving());
  // }


  public int nameYOffset() {
    if (getType() > 1) {
      return -105;
    }
    return -5 - getEdad();
  }













  public boolean isMyHealFood(ItemStack par1ItemStack) {
    return MoCTools.isItemEdible(par1ItemStack.getItem());
  }


  public void dropMyStuff() {
    if (!this.world.isRemote) {
      dropArmor();
      MoCTools.dropSaddle((MoCEntityAnimal)this, this.world);

      if (getIsChested()) {
        MoCTools.dropInventory((Entity)this, this.localchest);
        MoCTools.dropCustomItem((Entity)this, this.world, new ItemStack((Block)Blocks.CHEST, 1));
        setIsChested(false);
      }
    }
  }






  public void dropArmor() {
    if (!this.world.isRemote) {
      ItemStack itemStack = getItemStackFromSlot(EntityEquipmentSlot.HEAD);
      if (!itemStack.isEmpty() && itemStack.getItem() instanceof ItemArmor) {
        EntityItem entityitem = new EntityItem(this.world, this.posX, this.posY, this.posZ, itemStack.copy());
        if (entityitem != null) {
          entityitem.setPickupDelay(10);
          this.world.spawnEntity((Entity)entityitem);
        }
      }
      setHelmet(0);
    }
  }


  public boolean isFlyer() {
    return (isBeingRidden() && (getType() == 5 || getType() == 6));
  }


  public void fall(float f, float f1) {
    if (isFlyer()) {
      return;
    }
    super.fall(f, f1);
  }


  protected double myFallSpeed() {
    return 0.89D;
  }


  protected double flyerThrust() {
    return 0.8D;
  }


  protected float flyerFriction() {
    return 0.96F;
  }


  protected boolean selfPropelledFlyer() {
    return (getType() == 6);
  }


  public void makeEntityJump() {
    if (this.jumpCounter > 5) {
      this.jumpCounter = 1;
    }
    if (this.jumpCounter == 0) {
      MoCTools.playCustomSound((Entity)this, MoCSoundEvents.ENTITY_GENERIC_WINGFLAP);
      this.jumpPending = true;
      this.jumpCounter = 1;
    }
  }



  public EnumCreatureAttribute getCreatureAttribute() {
    if (getType() == 7) {
      return EnumCreatureAttribute.UNDEAD;
    }
    return super.getCreatureAttribute();
  }


  public int getMaxSpawnedInChunk() {
    return 1;
  }








  public int getMaxEdad() {
    return 20;
  }
}


/* Location:              C:\Users\mami\files\games\minecraft\sneakyrp\mocreatures-fix\DrZharks MoCreatures Mod-12.0.5-deobf.jar!\drzhark\mocreatures\entity\passive\MoCEntityOstrich.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
