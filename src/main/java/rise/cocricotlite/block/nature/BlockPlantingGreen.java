package rise.cocricotlite.block.nature;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import rise.cocricotlite.Tabs;
import rise.cocricotlite.block.BaseBlock;
import rise.cocricotlite.item.CommonItemBlock;
import rise.cocricotlite.util.AABBList;
import rise.cocricotlite.util.Helper;
import rise.cocricotlite.util.type.nature.EnumPlantingGreen;
import rise.cocricotlite.util.type.PropertyList;

public class BlockPlantingGreen extends BaseBlock {

    public BlockPlantingGreen()
    {
        super("planting_green", Material.GRASS, Tabs.TAB_NATURE, SoundType.PLANT, 0.15F, 1F);
        this.setCollisionBox(AABBList.AABB_NONE);
        this.setBoundingBox(AABBList.AABB_CUBE_SMALL);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(PropertyList.PLANTING_GREEN_TYPE, EnumPlantingGreen.UMBELLATA));
        this.register(new CommonItemBlock(this, itemStack -> EnumPlantingGreen.byMetadata(itemStack.getMetadata()).getName()));
    }

    @Override
    public void registerModels()
    {
        Helper.forItemModels(this, "nature", EnumPlantingGreen.class, EnumPlantingGreen.values().length);
    }

    public int damageDropped(IBlockState state)
    {
        return state.getValue(PropertyList.PLANTING_GREEN_TYPE).getMetadata();
    }

    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
    {
        Helper.forCreativeTab(this, list, EnumPlantingGreen.values().length);

    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(PropertyList.PLANTING_GREEN_TYPE, EnumPlantingGreen.byMetadata(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(PropertyList.PLANTING_GREEN_TYPE).getMetadata();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, PropertyList.PLANTING_GREEN_TYPE);
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
}