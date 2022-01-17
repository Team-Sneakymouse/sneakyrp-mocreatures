/*    */ package drzhark.mocreatures.entity.ai;
/*    */ 
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.pathfinding.NodeProcessor;
/*    */ import net.minecraft.pathfinding.PathNodeType;
/*    */ import net.minecraft.pathfinding.PathPoint;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.util.math.MathHelper;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ 
/*    */ 
/*    */ public class FlyNodeProcessor
/*    */   extends NodeProcessor
/*    */ {
/*    */   public PathPoint getStart() {
/* 20 */     return openPoint(MathHelper.floor((this.entity.getEntityBoundingBox()).minX), MathHelper.floor((this.entity.getEntityBoundingBox()).minY + 0.5D), MathHelper.floor((this.entity.getEntityBoundingBox()).minZ));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PathPoint getPathPointToCoords(double x, double y, double z) {
/* 28 */     return openPoint(MathHelper.floor(x - (this.entity.width / 2.0F)), MathHelper.floor(y + 0.5D), MathHelper.floor(z - (this.entity.width / 2.0F)));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int findPathOptions(PathPoint[] pathOptions, PathPoint currentPoint, PathPoint targetPoint, float maxDistance) {
/* 34 */     int i = 0;
/*    */     
/* 36 */     for (EnumFacing enumfacing : EnumFacing.values()) {
/*    */       
/* 38 */       PathPoint pathpoint = getSafePoint(currentPoint.x + enumfacing.getXOffset(), currentPoint.y + enumfacing.getYOffset(), currentPoint.z + enumfacing.getZOffset());
/*    */       
/* 40 */       if (pathpoint != null && !pathpoint.visited && pathpoint.distanceTo(targetPoint) < maxDistance)
/*    */       {
/* 42 */         pathOptions[i++] = pathpoint;
/*    */       }
/*    */     } 
/*    */     
/* 46 */     return i;
/*    */   }
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   private PathPoint getSafePoint(int p_186328_1_, int p_186328_2_, int p_186328_3_) {
/* 52 */     PathNodeType pathnodetype = isFree(p_186328_1_, p_186328_2_, p_186328_3_);
/* 53 */     return (pathnodetype == PathNodeType.OPEN) ? openPoint(p_186328_1_, p_186328_2_, p_186328_3_) : null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private PathNodeType isFree(int p_186327_1_, int p_186327_2_, int p_186327_3_) {
/* 59 */     BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
/*    */     
/* 61 */     for (int i = p_186327_1_; i < p_186327_1_ + this.entitySizeX; i++) {
/*    */       
/* 63 */       for (int j = p_186327_2_; j < p_186327_2_ + this.entitySizeY; j++) {
/*    */         
/* 65 */         for (int k = p_186327_3_; k < p_186327_3_ + this.entitySizeZ; k++) {
/*    */           
/* 67 */           IBlockState iblockstate = this.blockaccess.getBlockState((BlockPos)blockpos$mutableblockpos.setPos(i, j, k));
/*    */           
/* 69 */           if (iblockstate.getMaterial() != Material.AIR)
/*    */           {
/* 71 */             return PathNodeType.BLOCKED;
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 77 */     return PathNodeType.OPEN;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public PathNodeType getPathNodeType(IBlockAccess blockaccessIn, int x, int y, int z, EntityLiving entitylivingIn, int xSize, int ySize, int zSize, boolean canBreakDoorsIn, boolean canEnterDoorsIn) {
/* 83 */     return PathNodeType.OPEN;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public PathNodeType getPathNodeType(IBlockAccess x, int y, int z, int p_186330_4_) {
/* 89 */     return PathNodeType.OPEN;
/*    */   }
/*    */ }


/* Location:              C:\Users\mami\files\games\minecraft\sneakyrp\mocreatures-fix\DrZharks MoCreatures Mod-12.0.5-deobf.jar!\drzhark\mocreatures\entity\ai\FlyNodeProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */