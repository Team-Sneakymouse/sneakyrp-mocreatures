package drzhark.mocreatures.item;

import drzhark.mocreatures.MoCTools;
import drzhark.mocreatures.MoCreatures;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemOgreHammer
  extends MoCItem
{
  public ItemOgreHammer(String name) {
    super(name);
    this.maxStackSize = 1;
    setMaxDamage(2048);
  }





  public boolean isFull3D() {
    return true;
  }






  public EnumAction getItemUseAction(ItemStack par1ItemStack) {
    return EnumAction.BLOCK;
  }





  public int getMaxItemUseDuration(ItemStack par1ItemStack) {
    return 72000;
  }






  public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
    ItemStack stack = player.getHeldItem(hand);
    double coordY = player.posY + player.getEyeHeight();
    double coordZ = player.posZ;
    double coordX = player.posX;

    for (int x = 3; x < 128; x++) {
      double newPosY = coordY - Math.cos(((player.rotationPitch - 90.0F) / 57.29578F)) * x;


      double newPosX = coordX + Math.cos((MoCTools.realAngle(player.rotationYaw - 90.0F) / 57.29578F)) * Math.sin(((player.rotationPitch - 90.0F) / 57.29578F)) * x;


      double newPosZ = coordZ + Math.sin((MoCTools.realAngle(player.rotationYaw - 90.0F) / 57.29578F)) * Math.sin(((player.rotationPitch - 90.0F) / 57.29578F)) * x;
      BlockPos pos = new BlockPos(MathHelper.floor(newPosX), MathHelper.floor(newPosY), MathHelper.floor(newPosZ));
      IBlockState blockstate = player.world.getBlockState(pos);

      if (blockstate.getBlock() != Blocks.AIR) {
        newPosY = coordY - Math.cos(((player.rotationPitch - 90.0F) / 57.29578F)) * (x - 1);


        newPosX = coordX + Math.cos((MoCTools.realAngle(player.rotationYaw - 90.0F) / 57.29578F)) * Math.sin(((player.rotationPitch - 90.0F) / 57.29578F)) * (x - 1);


        newPosZ = coordZ + Math.sin((MoCTools.realAngle(player.rotationYaw - 90.0F) / 57.29578F)) * Math.sin(((player.rotationPitch - 90.0F) / 57.29578F)) * (x - 1);
        pos = new BlockPos(MathHelper.floor(newPosX), MathHelper.floor(newPosY), MathHelper.floor(newPosZ));
        if (player.world.getBlockState(pos).getBlock() != Blocks.AIR) {
          return new ActionResult<ItemStack>(EnumActionResult.PASS, stack);
        }

        int[] blockInfo = obtainBlockAndMetadataFromBelt(player, true);
        if (blockInfo[0] != 0) {
          if (!world.isRemote) {
            Block block = Block.getBlockById(blockInfo[0]);
            player.world.setBlockState(pos, block.getDefaultState(), 3);
            player.world.playSound(player, ((float)newPosX + 0.5F), ((float)newPosY + 0.5F), ((float)newPosZ + 0.5F), block
                .getSoundType().getPlaceSound(), SoundCategory.BLOCKS, (block.getSoundType().getVolume() + 1.0F) / 2.0F, block.getSoundType().getPitch() * 0.8F);
          }
          MoCreatures.proxy.hammerFX(player);
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
      }
    }
    return new ActionResult<ItemStack>(EnumActionResult.PASS, stack);
  }








  private int[] obtainBlockAndMetadataFromBelt(EntityPlayer player, boolean remove) {
    for (int y = 0; y < 9; y++) {
      ItemStack slotStack = player.inventory.getStackInSlot(y);
      if (!slotStack.isEmpty()) {


        Item itemTemp = slotStack.getItem();
        int metadata = slotStack.getItemDamage();
        if (itemTemp instanceof net.minecraft.item.ItemBlock) {
          if (remove && !player.capabilities.isCreativeMode) {
            slotStack.shrink(1);
            if (slotStack.isEmpty()) {
              player.inventory.setInventorySlotContents(y, ItemStack.EMPTY);
            } else {
              player.inventory.setInventorySlotContents(y, slotStack);
            }
          }
          return new int[] { Item.getIdFromItem(itemTemp), metadata };
        }
      }
    }  return new int[] { 0, 0 };
  }


  public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    return EnumActionResult.FAIL;
  }
}


/* Location:              C:\Users\mami\files\games\minecraft\sneakyrp\mocreatures-fix\DrZharks MoCreatures Mod-12.0.5-deobf.jar!\drzhark\mocreatures\item\ItemOgreHammer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
